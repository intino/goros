package io.intino.goros.unit.box.ui.datasources;

import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.filters.GroupFilter;
import io.intino.alexandria.ui.services.push.UISession;
import io.intino.goros.unit.box.I18n;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.box.ui.datasources.model.task.TaskFolderGrouping;
import io.intino.goros.unit.box.ui.datasources.model.task.TaskNatureGrouping;
import io.intino.goros.unit.box.ui.datasources.model.task.TaskUrgentGrouping;
import io.intino.goros.unit.util.LayerHelper;
import io.intino.goros.unit.util.TaskHelper;
import org.monet.space.kernel.model.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

public class TaskInboxDatasource extends TaskListDatasource {
    private final Inbox inbox;

    public static final String FolderGrouping = "folder";
    public static final String UrgentGrouping = "urgent";
    public static final String NatureGrouping = "nature";
    public static final String TypeGrouping = "type";

    public TaskInboxDatasource(UnitBox box, UISession session, Inbox inbox) {
        super(box, session);
        this.inbox = inbox;
    }

    @Override
    public List<Task> items(int start, int count, String condition, List<Filter> filters, List<String> sortings) {
        TaskSearchRequest request = request(condition, filters, sortings);
        request.setStartPos(start);
        request.setLimit(count);
        box.linkSession(session);
        return new ArrayList<>(LayerHelper.taskLayer().searchTasks(account, request).get().values());
    }

    @Override
    public long itemCount(String condition, List<Filter> filters) {
        box.linkSession(session);
        return LayerHelper.taskLayer().searchTasksCount(account, request(condition, filters, emptyList()));
    }

    @Override
    public List<Group> groups(String key) {
        if (key.equalsIgnoreCase(FolderGrouping)) return Arrays.stream(TaskFolderGrouping.values()).map(f -> new Group().label(f.title())).collect(Collectors.toList());
        else if (key.equalsIgnoreCase(UrgentGrouping)) return Arrays.stream(TaskUrgentGrouping.values()).map(f -> new Group().label(f.title())).collect(Collectors.toList());
        else if (key.equalsIgnoreCase(NatureGrouping)) return Arrays.stream(TaskNatureGrouping.values()).map(f -> new Group().label(f.title())).collect(Collectors.toList());
        else if (key.equalsIgnoreCase(TypeGrouping)) return taskTypes();
        return emptyList();
    }

    public static long itemCount(Account account, Inbox inbox) {
        return LayerHelper.taskLayer().searchTasksCount(account, request(inbox));
    }

    private TaskSearchRequest request(String condition, List<Filter> filters, List<String> sortings) {
        TaskSearchRequest request = request(inbox);
        request.setCondition(condition);
        addParameter(request, filters, FolderGrouping, Task.Parameter.SITUATION, value -> TaskFolderGrouping.from(value).name().toLowerCase());
        addParameter(request, filters, UrgentGrouping, Task.Parameter.URGENT, value -> "" + TaskUrgentGrouping.Urgent.value());
        addParameter(request, filters, NatureGrouping, Task.Parameter.BACKGROUND, value -> "" + TaskNatureGrouping.from(value).value());
        addParameter(request, filters, TypeGrouping, Task.Parameter.TYPE, this::taskType);
        if (request.getParameter(Task.Parameter.SITUATION) == null)
            request.addParameter(Task.Parameter.SITUATION, TaskFolderGrouping.Active.name().toLowerCase());
        if (sortings.size() <= 0) sortings = singletonList("update_date#DESC");
        request.setSortsBy(TaskHelper.sortsByOf(sortings));
        return request;
    }

    private void addParameter(TaskSearchRequest request, List<Filter> filters, String name, String parameter, Function<String, String> value) {
        GroupFilter filter = (GroupFilter) filters.stream().filter(f -> f.grouping().equals(name)).findFirst().orElse(null);
        if (filter == null || filter.groups().size() <= 0) return;
        String label = new ArrayList<>(filter.groups()).get(0);
        if (label.equalsIgnoreCase(allTypesLabel())) return;
        request.addParameter(parameter, value.apply(new ArrayList<>(filter.groups()).get(0)));
    }

    private static TaskSearchRequest request(Inbox inbox) {
        TaskSearchRequest request = new TaskSearchRequest();
        request.addParameter(Task.Parameter.INBOX, inbox.name().toLowerCase());
        return request;
    }

    private List<Group> taskTypes() {
        TaskFilters taskFilters = LayerHelper.taskLayer().loadTasksFilters(session.discoverLanguage());
        List<Group> result = taskFilters.types.stream().map(t -> new Group().label(t.getLabel()).name(t.getCode())).collect(Collectors.toList());
        result.add(0, new Group().label(allTypesLabel()).name("all"));
        return result;
    }

    private String taskType(String value) {
        Group result = taskTypes().stream().filter(t -> t.label().equals(value)).findFirst().orElse(null);
        return result != null ? result.name() : null;
    }

    private String allTypesLabel() {
        return I18n.translate("All types", session.discoverLanguage());
    }
}