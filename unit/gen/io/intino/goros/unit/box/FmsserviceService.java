package io.intino.goros.unit.box;

import io.intino.alexandria.http.AlexandriaSpark;
import io.intino.goros.unit.box.rest.resources.*;
import io.intino.alexandria.core.Box;

public class FmsserviceService {

	public static AlexandriaSpark setup(AlexandriaSpark server, UnitBox box) {
		server.route("mobileservice/Helo").post(manager -> new PostHeloResource(box, manager).execute());
		server.route("mobileservice/Register").post(manager -> new PostRegisterResource(box, manager).execute());
		server.route("mobileservice/Unregister").post(manager -> new PostUnregisterResource(box, manager).execute());
		server.route("mobileservice/LoadNewDefinitions").post(manager -> new PostLoadNewDefinitionsResource(box, manager).execute());
		server.route("mobileservice/LoadNewGlossaries").post(manager -> new PostLoadNewGlossariesResource(box, manager).execute());
		server.route("mobileservice/DownloadGlossary").post(manager -> new PostDownloadGlossaryResource(box, manager).execute());
		server.route("mobileservice/LoadNewAssignedTasks").post(manager -> new PostLoadNewAssignedTasksResource(box, manager).execute());
		server.route("mobileservice/LoadNewAvailableTasks").post(manager -> new PostLoadNewAvailableTasksResource(box, manager).execute());
		server.route("mobileservice/LoadAssignedTasksToDelete").post(manager -> new PostLoadAssignedTasksToDeleteResource(box, manager).execute());
		server.route("mobileservice/LoadFinishedTasksToDelete").post(manager -> new PostLoadFinishedTasksToDeleteResource(box, manager).execute());
		server.route("mobileservice/LoadUnassignedTasksToDelete").post(manager -> new PostLoadUnassignedTasksToDeleteResource(box, manager).execute());
		server.route("mobileservice/AssignTask").post(manager -> new PostAssignTaskResource(box, manager).execute());
		server.route("mobileservice/UnassignTask").post(manager -> new PostUnassignTaskResource(box, manager).execute());
		server.route("mobileservice/DownloadTaskPacked").post(manager -> new PostDownloadTaskPackedResource(box, manager).execute());
		server.route("mobileservice/UploadTaskPacked").post(manager -> new PostUploadTaskPackedResource(box, manager).execute());
		server.route("mobileservice/PrepareUploadTask").post(manager -> new PostPrepareUploadTaskResource(box, manager).execute());
		server.route("mobileservice/UploadTaskFile").post(manager -> new PostUploadTaskFileResource(box, manager).execute());
		server.route("mobileservice/UploadTaskSchema").post(manager -> new PostUploadTaskSchemaResource(box, manager).execute());
		server.route("mobileservice/SyncChats").post(manager -> new PostSyncChatsResource(box, manager).execute());

		return server;
	}
}