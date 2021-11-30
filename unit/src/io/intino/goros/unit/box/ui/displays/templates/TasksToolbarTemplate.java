package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.goros.unit.box.UnitBox;

import java.util.function.Consumer;

public class TasksToolbarTemplate extends AbstractTasksToolbarTemplate<UnitBox> {
    private Consumer<Boolean> refreshListener;
    private boolean refreshToolbarVisible = false;

    public TasksToolbarTemplate(UnitBox box) {
        super(box);
    }

    public TasksToolbarTemplate onRefresh(Consumer<Boolean> listener) {
        this.refreshListener = listener;
        return this;
    }

    @Override
    public void init() {
        super.init();
        refresh.onExecute(e -> refreshAndHide());
        box().notifier().onTaskCreated(this, task -> showRefreshToolbar());
    }

    @Override
    public void remove() {
        super.remove();
        box().notifier().unTaskCreated(this);
    }

    private void showRefreshToolbar() {
        if (refreshToolbarVisible) return;
        refreshToolbar.visible(true);
        refreshToolbarVisible = true;
    }

    private void refreshAndHide() {
        refreshToolbar.visible(false);
        refreshToolbarVisible = false;
        if (refreshListener != null) refreshListener.accept(true);
    }
}