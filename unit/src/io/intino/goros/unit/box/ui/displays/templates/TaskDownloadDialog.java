package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.UserMessage;
import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.filters.GroupFilter;
import io.intino.alexandria.ui.spark.UIFile;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.box.ui.datasources.model.Column;
import io.intino.goros.unit.box.ui.datasources.model.task.TaskFolderGrouping;
import io.intino.goros.unit.box.ui.datasources.model.task.TaskNatureGrouping;
import io.intino.goros.unit.box.ui.datasources.model.task.TaskUrgentGrouping;
import io.intino.goros.unit.util.Formatters;
import io.intino.goros.unit.util.LayerHelper;
import io.intino.goros.unit.util.TaskHelper;
import org.monet.space.kernel.model.Task;
import org.monet.space.kernel.model.TaskFilters;
import org.monet.space.kernel.model.TaskSearchRequest;
import org.monet.space.kernel.model.TaskType;

import java.io.InputStream;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static io.intino.goros.unit.util.NodeHelper.sortingOf;
import static io.intino.goros.unit.util.NodeHelper.sortsByOf;
import static java.util.Collections.singletonList;

public class TaskDownloadDialog extends AbstractTaskDownloadDialog<UnitBox> {
    private String inbox;
    private Consumer<Boolean> terminateListener;
    private String condition;
    private List<Filter> filters;
    private String sorting;
    private String sortingMode;
    private List<Column> columns = new ArrayList<>();

    public TaskDownloadDialog(UnitBox box) {
        super(box);
    }

    public TaskDownloadDialog onTerminate(Consumer<Boolean> listener) {
        this.terminateListener = listener;
        return this;
    }

    public TaskDownloadDialog inbox(String inbox) {
        this.inbox = inbox;
        return this;
    }

    public TaskDownloadDialog condition(String condition) {
        this.condition = condition;
        return this;
    }

    public TaskDownloadDialog filters(List<Filter> filters) {
        this.filters = filters;
        return this;
    }

    public TaskDownloadDialog sorting(String sorting, String mode) {
        this.sorting = sorting;
        this.sortingMode = mode;
        return this;
    }

    public TaskDownloadDialog columns(List<Column> columns) {
        this.columns = columns;
        return this;
    }

    @Override
    public void init() {
        super.init();
        format.onSelect(e -> refreshToolbar());
        downloadCancel.onExecute(e -> terminateListener.accept(true));
        downloadAccept.onExecute(e -> accept());
        columnModeSelector.onSelect(e -> updateMode());
    }

    @Override
    public void refresh() {
        super.refresh();
        format.select("pdf");
        columnModeSelector.select("allColumns");
        refreshColumns();
        refreshToolbar();
    }

    private boolean check() {
        if (format.selection().size() <= 0) return false;
        if (allColumnsMode()) return true;
        return options.children(DownloadDialogOption.class).stream().anyMatch(c -> c.selectedColumn() != null);
    }

    private UIFile accept() {
        terminateListener.accept(true);
        notifyUser(translate("Downloading data..."), UserMessage.Type.Info);
        String format = this.format.selection().get(0);
        List<String> selection = selectedColumns();
        InputStream result = TaskHelper.download(box(), request(), format, language(), selection, session());
        notifyUser(translate("Download finished"), UserMessage.Type.Success);
        return new UIFile() {
            @Override
            public String label() {
                return "Tareas_" + Formatters.downloadDate(Instant.now()) + "." + format.toLowerCase();
            }

            @Override
            public InputStream content() {
                return result;
            }
        };
    }

    private TaskSearchRequest request() {
        TaskSearchRequest request = new TaskSearchRequest();
        request.setCondition(condition);
        request.addParameter(Task.Parameter.TYPE, taskType());
        request.addParameter(Task.Parameter.STATE, filterValue("state"));
        request.addParameter(Task.Parameter.INBOX, inbox);
        request.addParameter(Task.Parameter.SITUATION, folder());
        request.addParameter(Task.Parameter.BACKGROUND, filterValue("nature") != null ? TaskNatureGrouping.from(filterValue("nature")).value() + "": null);
        request.addParameter(Task.Parameter.ROLE, filterValue("role"));
        request.addParameter(Task.Parameter.URGENT, filterValue("urgent") != null ? "" + TaskUrgentGrouping.Urgent.value() : null);
        request.addParameter(Task.Parameter.OWNER, filterValue("owner"));
        if (sorting != null) request.setSortsBy(sortsByOf(singletonList(sortingOf(sorting, sortingMode))));
        if (request.getParameter(Task.Parameter.SITUATION) == null)
            request.addParameter(Task.Parameter.SITUATION, TaskFolderGrouping.Active.name().toLowerCase());
        request.setStartPos(0);
        request.setLimit(-1);
        return request;
    }

    private String folder() {
        String folder = filterValue("folder");
        TaskFolderGrouping grouping = folder != null ? TaskFolderGrouping.from(folder) : TaskFolderGrouping.Active;
        return grouping.name().toLowerCase();
    }

    private String taskType() {
        String type = filterValue("type");
        if (type == null) return null;
        TaskFilters taskFilters = LayerHelper.taskLayer().loadTasksFilters(language());
        TaskType taskType = taskFilters.types.stream().filter(t -> t.getLabel().equals(type)).findFirst().orElse(null);
        return taskType != null ? taskType.getCode() : null;
    }

    private String filterValue(String name) {
        Filter filter = filters.stream().filter(f -> f.grouping().equals(name)).findFirst().orElse(null);
        return filter != null ? firstGroup(filter) : null;
    }

    private String firstGroup(Filter filter) {
        GroupFilter groupFilter = (GroupFilter) filter;
        return groupFilter.groups().size() > 0 ? groupFilter.groups().iterator().next() : null;
    }

    private List<String> selectedColumns() {
        if (allColumnsMode()) return columns.stream().map(Column::code).collect(Collectors.toList());
        List<DownloadDialogOption> children = options.children(DownloadDialogOption.class);
        return children.stream().map(DownloadDialogOption::selectedColumn).filter(Objects::nonNull).map(Column::code).collect(Collectors.toList());
    }

    private List<Column> availableColumns(Column current) {
        List<String> selection = selectedColumns();
        return columns.stream().filter(c -> (current != null && current.code().equals(c.code())) || !selection.contains(c.code())).collect(Collectors.toList());
    }

    private void refreshAvailableColumns() {
        List<DownloadDialogOption> children = options.children(DownloadDialogOption.class);
        children.forEach(c -> c.columns(availableColumns(c.selectedColumn())).refresh());
    }

    private void refreshColumns() {
        customColumnsBlock.visible(!allColumnsMode());
        columnsBlock.hide();
        options.clear();
        for (int i=0; i<columns.size(); i++) fill(i, this.options.add());
        columnsBlock.show();
    }

    private void fill(int pos, DownloadDialogOption view) {
        view.index(pos);
        view.columns(columns);
        view.onSelect(e -> {
            refreshToolbar();
            refreshAvailableColumns();
        });
        view.refresh();
    }

    private void refreshToolbar() {
        downloadAccept.readonly(!check());
    }

    private boolean allColumnsMode() {
        String mode = columnModeSelector.selection().size() > 0 ? columnModeSelector.selection().get(0) : null;
        return mode == null || mode.equalsIgnoreCase("allColumns");
    }

    private void updateMode() {
        customColumnsBlock.visible(!allColumnsMode());
        refreshToolbar();
    }

}