package io.intino.goros.unit.box;

import io.intino.alexandria.http.AlexandriaSpark;
import io.intino.goros.unit.box.rest.resources.*;
import io.intino.alexandria.core.Box;

public class SetupserviceService {

	public static AlexandriaSpark setup(AlexandriaSpark server, UnitBox box) {
		server.route("setupservice/showapi").post(manager -> new PostShowApiResource(box, manager).execute());
		server.route("setupservice/getmajorversion").post(manager -> new PostGetMajorVersionResource(box, manager).execute());
		server.route("setupservice/getstatus").post(manager -> new PostGetStatusResource(box, manager).execute());
		server.route("setupservice/run").post(manager -> new PostRunResource(box, manager).execute());
		server.route("setupservice/putlabel").post(manager -> new PostPutLabelResource(box, manager).execute());
		server.route("setupservice/putlogo").post(manager -> new PostPutLogoResource(box, manager).execute());
		server.route("setupservice/stop").post(manager -> new PostStopResource(box, manager).execute());
		server.route("setupservice/updatemodel").post(manager -> new PostUpdateModelResource(box, manager).execute());
		server.route("setupservice/executeconstructor").post(manager -> new PostExecuteConstructorResource(box, manager).execute());

		return server;
	}
}