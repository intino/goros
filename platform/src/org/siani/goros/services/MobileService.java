package org.siani.goros.services;

import org.monet.mobile.model.ChatItem;
import org.monet.mobile.model.TaskMetadata;
import org.monet.mobile.service.results.*;
import org.monet.space.kernel.machines.ttm.model.Message;

import java.io.InputStream;
import java.util.List;

public interface MobileService {
	AckResult assignTask(String task);
	InputStream downloadGlossary(String code, String context, long syncMark);
	InputStream downloadTaskPacked(String task);
	HeloResult helo();
	DownloadTasksToDeleteResult loadAssignedTasksToDelete(List<String> ids);
	DownloadTasksToDeleteResult loadFinishedTasksToDelete(List<String> ids);
	DownloadTasksResult loadNewAssignedTasks(long syncMark);
	DownloadTasksResult loadNewAvailableTasks(long syncMark);
	DownloadDefinitionsResult loadNewDefinitions(long syncMark);
	DownloadGlossariesResult loadNewGlossaries(long syncMark);
	DownloadTasksToDeleteResult loadUnassignedTasksToDelete(List<String> ids);
	PrepareUploadTaskResult prepareUploadTask(TaskMetadata metadata);
	AckResult register(String registrationId);
	SyncChatsResult syncChats(long syncMark, List<ChatItem> items);
	AckResult unassignTask(String taskId);
	AckResult unregister(String registrationId);
	AckResult uploadTaskFile(String task, String fileId, InputStream content);
	AckResult uploadTaskPacked(Message message);
	AckResult uploadTaskSchema(String task, InputStream schema);
}
