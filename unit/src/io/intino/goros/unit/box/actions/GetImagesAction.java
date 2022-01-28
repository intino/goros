package io.intino.goros.unit.box.actions;

import io.intino.alexandria.Resource;
import io.intino.goros.unit.box.UnitBox;
import io.intino.alexandria.exceptions.*;

import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Path;
import java.util.HashMap;
import java.time.*;
import java.util.*;
import io.intino.goros.unit.box.schemas.*;
import io.intino.goros.unit.box.services.Response;
import io.intino.goros.unit.util.NodeHelper;
import oracle.spatial.geometry.DataException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;
import org.monet.bpi.exceptions.NodeAccessException;
import org.monet.bpi.types.File;
import org.monet.space.fms.configuration.Configuration;
import org.monet.space.fms.control.constants.Actions;
import org.monet.space.fms.control.constants.Parameter;
import org.monet.space.fms.core.constants.ErrorCode;
import org.monet.space.kernel.agents.AgentFilesystem;
import org.monet.space.kernel.components.ComponentDocuments;
import org.monet.space.kernel.components.ComponentPersistence;
import org.monet.space.kernel.components.ComponentSecurity;
import org.monet.space.kernel.components.layers.NodeLayer;
import org.monet.space.kernel.exceptions.SystemException;
import org.monet.space.kernel.library.LibraryFile;
import org.monet.space.kernel.model.Node;
import org.monet.space.kernel.utils.MimeTypes;

public class GetImagesAction {
	public UnitBox box;
	public io.intino.alexandria.http.spark.SparkContext context;
	public String path;
	public String id;

	public io.intino.alexandria.Resource execute() {
		HttpClient oHttpClient = new HttpClient();
		GetMethod method;
		Integer iStatus;
		Boolean bDownload;
		InputStream input;

		if (id == null) return null;
		ComponentDocuments componentDocuments = ComponentDocuments.getInstance();

		bDownload = componentDocuments.getSupportedFeatures().get(ComponentDocuments.Feature.DOWNLOAD);
		if ((bDownload == null) || (!bDownload)) throw new SystemException(ErrorCode.DOWNLOAD_NOT_SUPPORTED, id);

		HashMap<String, String> parameters = new HashMap<String, String>();
		String fileId = path;
		String contentType;

		try {
			parameters.put(Parameter.ID, URLEncoder.encode(fileId, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}

		method = new GetMethod(componentDocuments.getDownloadUrl(parameters));
		try {
			iStatus = oHttpClient.executeMethod(method);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		if (iStatus == HttpStatus.SC_NOT_FOUND || method.getResponseHeader("Content-Type") == null) {
			input = AgentFilesystem.getInputStream(Configuration.getInstance().getNoPictureImageFile());
			contentType = MimeTypes.getInstance().get("jpg");
		} else {
			try {
				input = method.getResponseBodyAsStream();
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
			contentType = method.getResponseHeader("Content-Type").getValue();
		}

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
			IOUtils.copy(input, output);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new Resource(LibraryFile.getFilename(fileId),contentType,output.toByteArray());
	}
}