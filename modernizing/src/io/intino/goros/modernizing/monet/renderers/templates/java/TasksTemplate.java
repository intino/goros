package io.intino.goros.modernizing.monet.renderers.templates.java;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class TasksTemplate extends Template {

	public RuleSet ruleSet() {
		return new RuleSet().add(
			rule().condition((allTypes("tasks","nodetasks"))).output(literal("package ")).output(mark("package")).output(literal(".")).output(mark("module", "lowerCase")).output(literal(".box.ui.displays.templates;\n\nimport ")).output(mark("package")).output(literal(".")).output(mark("module", "lowerCase")).output(literal(".box.")).output(mark("module", "firstUpperCase")).output(literal("Box;\nimport org.monet.space.kernel.model.Node;\nimport io.intino.goros.unit.box.ui.datasources.TaskListDatasource;\n\npublic class NodeTasksTemplate extends AbstractNodeTasksTemplate<")).output(mark("module", "firstUpperCase")).output(literal("Box> {\n    private Node node;\n    private boolean readonly = true;\n    private String view;\n\n    public NodeTasksTemplate(")).output(mark("module", "firstUpperCase")).output(literal("Box box) {\n        super(box);\n    }\n\n    public NodeTasksTemplate node(Node node) {\n        this.node = node;\n        return this;\n    }\n\n    public NodeTasksTemplate view(String view) {\n        this.view = view;\n        return this;\n    }\n\n    public NodeTasksTemplate readonly(boolean readonly) {\n        this.readonly = readonly;\n        return this;\n    }\n\n    @Override\n    public void init() {\n        super.init();\n        tasks.inbox(io.intino.goros.unit.box.ui.datasources.TaskListDatasource.Inbox.TaskBoard);\n    }\n\n    @Override\n    public void refresh() {\n        super.refresh();\n        tasks.refresh();\n    }\n\n}")),
			rule().condition((allTypes("tasks","inbox"))).output(literal("package ")).output(mark("package")).output(literal(".")).output(mark("module", "lowerCase")).output(literal(".box.ui.displays.templates;\n\nimport ")).output(mark("package")).output(literal(".")).output(mark("module", "lowerCase")).output(literal(".box.")).output(mark("module", "firstUpperCase")).output(literal("Box;\nimport io.intino.goros.unit.box.ui.datasources.TaskListDatasource;\n\npublic class ")).output(mark("inboxType", "firstUpperCase")).output(literal("Template extends Abstract")).output(mark("inboxType", "firstUpperCase")).output(literal("Template<")).output(mark("module", "firstUpperCase")).output(literal("Box> {\n    private String folder;\n\n    public ")).output(mark("inboxType", "firstUpperCase")).output(literal("Template(")).output(mark("module", "firstUpperCase")).output(literal("Box box) {\n        super(box);\n    }\n\n    public ")).output(mark("inboxType", "firstUpperCase")).output(literal("Template folder(String folder) {\n        this.folder = folder;\n        return this;\n    }\n\n    @Override\n    public void init() {\n        super.init();\n        tasks.inbox(io.intino.goros.unit.box.ui.datasources.TaskListDatasource.Inbox.")).output(mark("inboxType", "firstUpperCase")).output(literal(");\n    }\n\n    @Override\n    public void refresh() {\n        super.refresh();\n        tasks.folder(folder);\n        tasks.readonly(false);\n        tasks.refresh();\n    }\n\n}")),
			rule().condition((allTypes("tasks","embedded"))).output(literal("package ")).output(mark("package")).output(literal(".")).output(mark("module", "lowerCase")).output(literal(".box.ui.displays.templates;\n\nimport ")).output(mark("package")).output(literal(".")).output(mark("module", "lowerCase")).output(literal(".box.")).output(mark("module", "firstUpperCase")).output(literal("Box;\nimport io.intino.alexandria.ui.displays.components.BlockConditional;\nimport io.intino.alexandria.ui.displays.components.Collection;\nimport io.intino.alexandria.ui.displays.components.SearchBox;\nimport io.intino.alexandria.ui.displays.events.SelectionEvent;\nimport io.intino.alexandria.ui.displays.events.actionable.ToggleEvent;\nimport io.intino.alexandria.ui.displays.events.collection.RefreshCountEvent;\nimport org.monet.space.kernel.components.ComponentPersistence;\nimport org.monet.space.kernel.model.Task;\nimport io.intino.goros.unit.box.ui.datasources.TaskListDatasource;\n\nimport java.util.List;\nimport java.util.function.Consumer;\n\npublic class TasksEmbeddedTemplate extends AbstractTasksEmbeddedTemplate<")).output(mark("module", "firstUpperCase")).output(literal("Box> {\n    private String view;\n    private TaskListDatasource.Inbox inbox;\n    private Task selectedTask;\n    private boolean readonly = true;\n    private java.util.function.Consumer<Long> itemsCountListener;\n    private java.util.function.Consumer<io.intino.alexandria.ui.displays.events.actionable.ToggleEvent.State> toggleFiltersListener;\n    private SearchBox searchBox;\n\n    public TasksEmbeddedTemplate(")).output(mark("module", "firstUpperCase")).output(literal("Box box) {\n        super(box);\n    }\n\n    public TasksEmbeddedTemplate view(String view) {\n        this.view = view;\n        return this;\n    }\n\n    public TasksEmbeddedTemplate inbox(TaskListDatasource.Inbox inbox) {\n        this.inbox = inbox;\n        return this;\n    }\n\n    public TasksEmbeddedTemplate readonly(boolean readonly) {\n        this.readonly = readonly;\n        return this;\n    }\n\n    public TasksEmbeddedTemplate bindTo(SearchBox search) {\n        this.searchBox = search;\n        return this;\n    }\n\n    public TasksEmbeddedTemplate toggleFilters(io.intino.alexandria.ui.displays.events.actionable.ToggleEvent.State state) {\n        toggleFiltersViewVisibility(state);\n        return this;\n    }\n\n    public TasksEmbeddedTemplate onToggleFilters(java.util.function.Consumer<io.intino.alexandria.ui.displays.events.actionable.ToggleEvent.State> listener) {\n        this.toggleFiltersListener = listener;\n        return this;\n    }\n\n    public TasksEmbeddedTemplate onItemsCountChange(java.util.function.Consumer<Long> listener) {\n        this.itemsCountListener = listener;\n        return this;\n    }\n\n    @Override\n    public void init() {\n        super.init();\n        box().notifier().onTaskCreated(this, task -> refresh());\n        initViews();\n    }\n\n    @Override\n    public void remove() {\n        super.remove();\n        box().notifier().unTaskCreated(this);\n    }\n\n    @Override\n    public void refresh() {\n        super.refresh();\n        refreshView();\n    }\n\n    private void initViews() {\n        tableView.onInit(e -> {\n            tableView.tableViewStamp.tasksTable.onRefreshItemCount(this::refreshCount);\n            tableView.tableViewStamp.tasksTable.onSelect(this::open);\n        });\n        tableView.onShow(e -> {\n            bindCurrentViewTo(tableView.tableViewStamp.tasksTable);\n            if (searchBox != null) searchBox.bindTo(tableView.tableViewStamp.tasksTable);\n            tableView.tableViewStamp.inbox(inbox);\n            tableView.tableViewStamp.readonly(readonly);\n            tableView.tableViewStamp.refresh();\n        });\n        listView.onInit(e -> {\n            listView.listViewStamp.tasksList.onRefreshItemCount(this::refreshCount);\n            listView.listViewStamp.tasksList.onSelect(this::open);\n        });\n        listView.onShow(e -> {\n            bindCurrentViewTo(listView.listViewStamp.tasksList);\n            if (searchBox != null) searchBox.bindTo(listView.listViewStamp.tasksList);\n            listView.listViewStamp.inbox(inbox);\n            listView.listViewStamp.readonly(readonly);\n            listView.listViewStamp.refresh();\n        });\n        filtersView.onInit(e -> initFilters());\n        ")).output(expression().output(mark("process", "init").multiple("\n"))).output(literal("\n    }\n\n    private void refreshView() {\n        if (view == null) view = \"list\";\n        if (view.equals(\"table\")) {\n            listView.hide();\n            tableView.show();\n        }\n        else if (view.equals(\"list\")) {\n            tableView.hide();\n            listView.show();\n        }\n        selectedTask = null;\n    }\n\n    private void refresh(Task task) {\n        if (tableView.isVisible()) tableView.tableViewStamp.refresh(task);\n        if (listView.isVisible()) listView.listViewStamp.refresh(task);\n    }\n\n    private void refreshCount(RefreshCountEvent event) {\n        if (itemsCountListener != null) itemsCountListener.accept(event.count());\n    }\n\n    private void toggleFiltersViewVisibility(io.intino.alexandria.ui.displays.events.actionable.ToggleEvent.State state) {\n        hideChildViews();\n        if (state == io.intino.alexandria.ui.displays.events.actionable.ToggleEvent.State.On) filtersView.show();\n        else filtersView.hide();\n    }\n\n    private void bindCurrentViewTo(io.intino.alexandria.ui.displays.components.Collection collection) {\n        ")).output(expression().output(mark("process", "bind").multiple("\n"))).output(literal("\n    }\n\n    private void initFilters() {\n        filtersView.tasksFiltersStamp.readonly(readonly);\n        filtersView.tasksFiltersStamp.bindTo(currentCollection());\n        filtersView.tasksFiltersStamp.refresh();\n    }\n\n    private Collection currentCollection() {\n        if (tableView.isVisible()) return tableView.tableViewStamp.tasksTable;\n        return listView.listViewStamp.tasksList;\n    }\n\n    private Task reloadSelected() {\n        if (selectedTask == null) return null;\n        return ComponentPersistence.getInstance().getTaskLayer().loadTask(selectedTask.getId());\n    }\n\n    private void open(SelectionEvent event) {\n        List<Task> selection = event.selection();\n        open(selection.size() > 0 ? selection.get(0) : null);\n    }\n\n    private void open(Task task) {\n        io.intino.alexandria.ui.displays.components.BlockConditional selectedView = selectedTaskView();\n        selectedTask = selectedView != null && selectedView.isVisible() && task == null ? null : task;\n        updateSelectedTaskViewVisibility(selectedTask != null);\n    }\n\n    private BlockConditional selectedTaskView() {\n        if (selectedTask == null) return null;\n        ")).output(expression().output(mark("process", "selectedView").multiple("\n"))).output(literal("\n        return null;\n    }\n\n    private void close() {\n        selectedTask = null;\n        updateSelectedTaskViewVisibility(false);\n    }\n\n    private void updateSelectedTaskViewVisibility(boolean visible) {\n        if (visible) {\n            if (filtersView.isVisible()) {\n                toggleFiltersViewVisibility(io.intino.alexandria.ui.displays.events.actionable.ToggleEvent.State.Off);\n                if (toggleFiltersListener != null) toggleFiltersListener.accept(io.intino.alexandria.ui.displays.events.actionable.ToggleEvent.State.Off);\n            }\n            showSelectedTaskView();\n        }\n        else hideChildViews();\n    }\n\n    private void showFilters() {\n        if (!filtersView.isVisible()) return;\n        filtersView.show();\n        filtersView.refresh();\n    }\n\n    private void showSelectedTaskView() {\n        if (selectedTask == null) return;\n        BlockConditional selectedView = selectedTaskView();\n        if (selectedView == null) return;\n        if (!selectedView.isVisible()) hideChildViews();\n        selectedView.show();\n    }\n\n    private void hideChildViews() {\n        ")).output(expression().output(mark("process", "hide").multiple("\n"))).output(literal("\n    }\n\n}")),
			rule().condition((type("tasks"))).output(literal("package ")).output(mark("package")).output(literal(".")).output(mark("module", "lowerCase")).output(literal(".box.ui.displays.templates;\n\nimport ")).output(mark("package")).output(literal(".")).output(mark("module", "lowerCase")).output(literal(".box.")).output(mark("module", "firstUpperCase")).output(literal("Box;\nimport io.intino.alexandria.ui.displays.events.SelectionEvent;\nimport io.intino.alexandria.ui.displays.events.actionable.ToggleEvent;\nimport io.intino.goros.unit.box.ui.datasources.TaskListDatasource;\nimport io.intino.goros.unit.util.Formatters;\n\npublic class TasksTemplate extends AbstractTasksTemplate<")).output(mark("module", "firstUpperCase")).output(literal("Box> {\n    private String view;\n    private String folder;\n    private TaskListDatasource.Inbox inbox;\n    private boolean readonly = true;\n\n    public TasksTemplate(")).output(mark("module", "firstUpperCase")).output(literal("Box box) {\n        super(box);\n    }\n\n    public TasksTemplate folder(String folder) {\n        this.folder = folder;\n        return this;\n    }\n\n    public TasksTemplate inbox(TaskListDatasource.Inbox inbox) {\n        this.inbox = inbox;\n        return this;\n    }\n\n    public TasksTemplate readonly(boolean readonly) {\n        this.readonly = readonly;\n        return this;\n    }\n\n    @Override\n    public void init() {\n        super.init();\n        initToolbar();\n        initContent();\n    }\n\n    @Override\n    public void refresh() {\n        super.refresh();\n        label.value(translate(inbox == io.intino.goros.unit.box.ui.datasources.TaskListDatasource.Inbox.TaskBoard ? \"Tasks\" : \"My tasks\"));\n        refreshContent();\n        viewSelector.select(view);\n    }\n\n    private void initToolbar() {\n        if (view == null) view = \"list\";\n        viewSelector.onSelect(this::selectView);\n        filters.onToggle(e -> toggleFilters(e.state()));\n    }\n\n    private void initContent() {\n        content.onItemsCountChange(this::refreshCount);\n        content.onToggleFilters(this::refreshToggleFiltersButton);\n        content.bindTo(search);\n    }\n\n    private void refreshCount(long countValue) {\n        count.value(Formatters.countMessage(countValue, translate(\"Task\").toLowerCase(), translate(\"Tasks\").toLowerCase()));\n    }\n\n    private void refreshContent() {\n        content.view(view);\n        content.inbox(inbox);\n        content.readonly(readonly);\n        content.refresh();\n    }\n\n    private void selectView(SelectionEvent e) {\n        content.view((String) e.selection().get(0));\n        content.refresh();\n    }\n\n    private void toggleFilters(io.intino.alexandria.ui.displays.events.actionable.ToggleEvent.State state) {\n        content.toggleFilters(state);\n    }\n\n    private void refreshToggleFiltersButton(io.intino.alexandria.ui.displays.events.actionable.ToggleEvent.State state) {\n        filters.state(state);\n    }\n\n}")),
			rule().condition((type("process")), (trigger("init"))).output(mark("name", "firstLowerCase")).output(literal("View.onShow(e -> {\n    bindCurrentViewTo(currentCollection());\n    ")).output(mark("name", "firstLowerCase")).output(literal("View.")).output(mark("name", "firstLowerCase")).output(literal("Stamp.task(reloadSelected());\n    ")).output(mark("name", "firstLowerCase")).output(literal("View.")).output(mark("name", "firstLowerCase")).output(literal("Stamp.inbox(inbox);\n    ")).output(mark("name", "firstLowerCase")).output(literal("View.")).output(mark("name", "firstLowerCase")).output(literal("Stamp.readonly(readonly);\n    ")).output(mark("name", "firstLowerCase")).output(literal("View.")).output(mark("name", "firstLowerCase")).output(literal("Stamp.onChange(this::refresh);\n    ")).output(mark("name", "firstLowerCase")).output(literal("View.")).output(mark("name", "firstLowerCase")).output(literal("Stamp.onAbort(e1 -> {\n        close();\n        refresh();\n    });\n    ")).output(mark("name", "firstLowerCase")).output(literal("View.")).output(mark("name", "firstLowerCase")).output(literal("Stamp.refresh();\n    if (")).output(mark("name", "firstLowerCase")).output(literal("View.")).output(mark("name", "firstLowerCase")).output(literal("Stamp.selectedView() == null) ")).output(mark("name", "firstLowerCase")).output(literal("View.")).output(mark("name", "firstLowerCase")).output(literal("Stamp.selectDefaultView();\n});")),
			rule().condition((type("process")), (trigger("hide"))).output(mark("name", "firstLowerCase")).output(literal("View.hide();")),
			rule().condition((type("process")), (trigger("bind"))).output(literal("if (")).output(mark("name", "firstLowerCase")).output(literal("View.isVisible()) ")).output(mark("name", "firstLowerCase")).output(literal("View.")).output(mark("name", "firstLowerCase")).output(literal("Stamp.bindTo(collection);")),
			rule().condition((type("process")), (trigger("selectedview"))).output(literal("if (selectedTask.getCode().equals(\"")).output(mark("code")).output(literal("\")) return ")).output(mark("name", "firstLowerCase")).output(literal("View;"))
		);
	}
}