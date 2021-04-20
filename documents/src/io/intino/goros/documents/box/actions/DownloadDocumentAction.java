package io.intino.goros.documents.box.actions;

import com.google.inject.Injector;
import com.google.inject.Provider;
import io.intino.goros.documents.box.services.Response;
import org.apache.commons.io.IOUtils;
import org.monet.docservice.core.exceptions.ApplicationException;
import org.monet.docservice.core.library.LibraryFile;
import org.monet.docservice.core.log.Logger;
import org.monet.docservice.core.util.MimeTypes;
import org.monet.docservice.core.util.Resources;
import org.monet.docservice.docprocessor.data.Repository;
import org.monet.docservice.docprocessor.operations.Operation;
import org.monet.docservice.docprocessor.worker.WorkQueue;
import org.monet.docservice.docprocessor.worker.WorkQueueItem;
import org.monet.docservice.guice.InjectorFactory;
import org.monet.filesystem.StreamHelper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

public class DownloadDocumentAction extends Action {
	public String thumb;
	public String id;

	private Logger logger;
	private LibraryFile libraryFile;
	private Provider<Repository> repositoryProvider;
	private WorkQueue workQueue;
	private MimeTypes mimeTypes;

	public DownloadDocumentAction() {
		Injector injector = InjectorFactory.get();
		this.logger = injector.getInstance(Logger.class);
		this.libraryFile = injector.getInstance(LibraryFile.class);
		this.repositoryProvider = injector.getProvider(Repository.class);
		this.workQueue = injector.getInstance(WorkQueue.class);
		this.mimeTypes = injector.getInstance(MimeTypes.class);
	}

	public io.intino.alexandria.Resource execute() {
		int page = -1;
		boolean isThumbnail = thumb != null;

		response = new Response(context);

		if (id != null && id.length() != 0) {
			getDownloadData(response, id, page, isThumbnail);
		} else {
			response.getWriter().println("Invalid query string");
			return null;
		}

		return resource();
	}

	private void getDownloadData(Response response, String documentId, int page, boolean isThumb) {
		Repository repository = repositoryProvider.get();
		InputStream documentData = null;

		try {

			if (!repository.existsDocument(documentId)) {
				response.setStatus(404);
				response.setContentType("image/png");

				InputStream imageStream = Resources.getAsStream("/not_found.gif");
				response.setContentLength(imageStream.available());
				copyData(imageStream, response.getOutputStream());
				return;
			}

			String contentType = repository.getDocumentDataContentType(documentId);
			String extension = this.libraryFile.getExtension(documentId);
			if (extension == null) extension = mimeTypes.getExtension(contentType);

			documentData = repository.getDocumentData(documentId);
			String fileContentType = libraryFile.getContentType(documentData);
			StreamHelper.close(documentData);

			response.setContentType(contentType);
			response.setHeader("Content-Disposition", String.format("attachment; filename=%s.%s", URLEncoder.encode(this.libraryFile.getFilenameWithoutExtension(documentId), "UTF-8"), extension));

			if (isThumb && !mimeTypes.isImage(fileContentType)) {
				this.generateDocumentPreviewIfNotExists(documentId);
				repository.readDocumentPreviewData(documentId, 1, response.getOutputStream(), 2);
			}
			else {
				documentData = repository.getDocumentData(documentId);
				IOUtils.copy(documentData, response.getOutputStream());
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ApplicationException("Error");
		}
		finally {
			StreamHelper.close(documentData);
		}
	}

	private void generateDocumentPreviewIfNotExists(String documentId) {
		Repository repository = repositoryProvider.get();

		if (repository.existsDocumentPreview(documentId))
			return;

		if (this.workQueue.documentHasPendingOperationsOfType(documentId, Operation.OPERATION_GENERATE_DOCUMENT_PREVIEW))
			return;

		WorkQueueItem item = new WorkQueueItem(-1);
		item.setDocumentId(documentId);
		item.setOperation(Operation.OPERATION_GENERATE_DOCUMENT_PREVIEW);
		this.workQueue.queueNewWorkItem(item);
	}

	private void copyData(InputStream input, OutputStream output) throws IOException {
		logger.debug("copyData(%s, %s)", input, output);

		int len;
		byte[] buff = new byte[4096];
		while ((len = input.read(buff)) > 0)
			output.write(buff, 0, len);
	}

}
