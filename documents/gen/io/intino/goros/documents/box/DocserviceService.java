package io.intino.goros.documents.box;

import io.intino.alexandria.http.AlexandriaSpark;
import io.intino.goros.documents.box.rest.resources.*;
import io.intino.alexandria.core.Box;

public class DocserviceService {

	public static AlexandriaSpark setup(AlexandriaSpark server, DocumentsBox box) {
		server.route("/document/").get(manager -> new GetDocumentResource(box, manager).execute());
		server.route("/document/").post(manager -> new PostDocumentResource(box, manager).execute());
		server.route("/preview/").get(manager -> new GetPreviewDocumentResource(box, manager).execute());
		server.route("/preview/").post(manager -> new PostPreviewDocumentResource(box, manager).execute());
		server.route("/download/").get(manager -> new GetDownloadDocumentResource(box, manager).execute());
		server.route("/download/").post(manager -> new PostDownloadDocumentResource(box, manager).execute());

		return server;
	}
}