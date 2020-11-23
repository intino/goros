package io.intino.goros.unit.box;

import io.intino.alexandria.http.AlexandriaSpark;
import io.intino.goros.unit.box.rest.resources.*;
import io.intino.alexandria.core.Box;

public class FrontserviceService {

	public static AlexandriaSpark setup(AlexandriaSpark server, UnitBox box) {
		server.route("service/source/:source-name/").post(manager -> new PostSourceResource(box, manager).execute());
		server.route("service/mailbox/:address/").post(manager -> new PostMailboxResource(box, manager).execute());
		server.route("service/business/:service-name/").post(manager -> new PostBusinessResource(box, manager).execute());

		return server;
	}
}