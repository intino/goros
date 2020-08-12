package org.siani.goros.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.components.Collection;
import org.monet.space.kernel.model.Task;
import org.siani.goros.box.GorosBox;
import org.siani.goros.box.ui.datasources.TaskListDatasource;
import org.siani.goros.box.ui.datasources.model.task.TaskFolderGrouping;

public class TasksFiltersTemplate extends AbstractTasksFiltersTemplate<GorosBox> {
    private Task task;
    private boolean readonly = true;
    private Collection collection;

    public TasksFiltersTemplate(GorosBox box) {
        super(box);
    }

    public TasksFiltersTemplate task(Task task) {
        this.task = task;
        return this;
    }

    public TasksFiltersTemplate readonly(boolean readonly) {
        this.readonly = readonly;
        return this;
    }

    public TasksFiltersTemplate bindTo(Collection collection) {
        this.collection = collection;
        updateFilters();
        folder.select(TaskFolderGrouping.Alive);
        return this;
    }

    @Override
    public void init() {
        super.init();
        reset.onExecute(e -> resetFilters());
    }

    private void updateFilters() {
        udpateFolder();
        udpateNature();
        udpateUrgent();
    }

    private void resetFilters() {
        folder.clearSelection();
        nature.clearSelection();
        urgent.clearSelection();
        collection.clearFilters();
    }

    private void udpateFolder() {
        folder.label(translate("Folder"));
        folder.attribute(TaskListDatasource.FolderGrouping);
        folder.multipleSelection(false);
        folder.bindTo(collection);
        folder.refresh();
    }

    private void udpateNature() {
        nature.label(translate("Nature"));
        nature.attribute(TaskListDatasource.NatureGrouping);
        nature.multipleSelection(false);
        nature.bindTo(collection);
        nature.refresh();
    }

    private void udpateUrgent() {
        urgent.label(translate("Urgents"));
        urgent.attribute(TaskListDatasource.UrgentGrouping);
        urgent.bindTo(collection);
        urgent.refresh();
    }

}