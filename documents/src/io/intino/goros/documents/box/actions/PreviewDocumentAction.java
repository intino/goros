package io.intino.goros.documents.box.actions;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import io.intino.goros.documents.box.services.Response;
import net.sf.json.JSONSerializer;
import org.monet.docservice.core.Key;
import org.monet.docservice.core.exceptions.ApplicationException;
import org.monet.docservice.core.log.Logger;
import org.monet.docservice.core.util.Resources;
import org.monet.docservice.docprocessor.data.Repository;
import org.monet.docservice.docprocessor.model.Document;
import org.monet.docservice.docprocessor.model.DocumentMetadata;
import org.monet.docservice.docprocessor.model.PreviewType;
import org.monet.docservice.docprocessor.operations.Operation;
import org.monet.docservice.docprocessor.worker.WorkQueue;
import org.monet.docservice.docprocessor.worker.WorkQueueItem;
import org.monet.docservice.guice.InjectorFactory;
import org.monet.filesystem.StreamHelper;

import java.io.IOException;
import java.io.InputStream;

/*
 * Document Metadata => "/documents/preview/?id=d23df45adfdft324" --> &type= (XML | JSON)
 *
 * Page URI => "/documents/preview/?id=d23df45adfdft324&page=1"
 *
 * Page Thumbnail URI => "/documents/preview/?id=d23df45adfdft324&thumb=1"
 *
 */

public abstract class PreviewDocumentAction extends Action {
	public String thumb;
	public String space;
	public String id;
	public String page;
	private Logger logger;
	private Provider<Repository> repositoryProvider;
	private WorkQueue workQueue;

	private static final String JSON_MIMETYPE = "application/json";

	public PreviewDocumentAction() {
		Injector injector = InjectorFactory.get();
		this.logger = injector.getInstance(Logger.class);
		this.repositoryProvider = injector.getProvider(Repository.class);
		this.workQueue = injector.getInstance(WorkQueue.class);
	}

	public io.intino.alexandria.Resource execute() {
		int pageNumber = -1;
		boolean isThumb = false;
		Key documentKey = new Key(space, id);

		generateDocumentPreviewIfNotExists(documentKey);
		response = new Response(context);

		if (page != null) {
			try {
				pageNumber = Integer.parseInt(page);
			} catch (NumberFormatException e) {
			}
		}

		if (thumb != null) {
			try {
				pageNumber = Integer.parseInt(thumb);
				isThumb = true;
			} catch (NumberFormatException e) {
			}
		}

		if (documentKey.getId().length() != 0) {
			if (pageNumber > 0) {
				getPagePreviewData(response, documentKey, pageNumber, isThumb);
			} else {
				getDocumentMetadata(response, documentKey);
			}
		} else {
			response.getWriter().println("Invalid query string");
			return null;
		}

		return resource();
	}

	private void generateDocumentPreviewIfNotExists(Key documentKey) {
		Repository repository = repositoryProvider.get();

		if (repository.existsDocumentPreview(documentKey))
			return;

		if (this.workQueue.documentHasPendingOperationsOfType(documentKey, Operation.OPERATION_GENERATE_DOCUMENT_PREVIEW))
			return;

		WorkQueueItem item = new WorkQueueItem(-1);
		item.setDocumentKey(documentKey);
		item.setOperation(Operation.OPERATION_GENERATE_DOCUMENT_PREVIEW);
		this.workQueue.queueNewWorkItem(item);
	}

	private void getDocumentMetadata(Response resp, Key documentKey) {
		Repository repository = repositoryProvider.get();
		try {
			Document document = repository.getDocument(documentKey);
			DocumentMetadata metadata = repository.getDocumentMetadata(document);

			resp.setContentType(JSON_MIMETYPE);
			resp.getWriter().print(JSONSerializer.toJSON(metadata).toString());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ApplicationException("Error");
		}
	}

	private void getPagePreviewData(Response resp, Key documentKey, int iPage, boolean isThumb) {
		Repository repository = repositoryProvider.get();
		try {
			int type = isThumb ? PreviewType.THUMBNAIL : PreviewType.PAGE;

			String sContentType = repository.getDocumentPreviewDataContentType(documentKey, iPage, type);

			resp.setContentType(sContentType);
			resp.setHeader("Content-Disposition", String.format("attachment; filename=%s_%s.png",
					documentKey.toString(),
					iPage));
			repository.readDocumentPreviewData(documentKey, iPage, resp.getOutputStream(), type);
		} catch (Exception e) {
			resp.setContentType("image/png");
			resp.setHeader("Content-Disposition", String.format("attachment; filename=%s_%s.png",
					documentKey.toString(),
					iPage));
			InputStream img;
			if (isThumb) img = Resources.getAsStream("/images/defaultThumb.png");
			else img = Resources.getAsStream("/images/default.png");
			try {
				StreamHelper.copy(img, resp.getOutputStream());
			} catch (IOException ioe) {
				logger.error(e.getMessage(), ioe);
			}

		}
	}

}
