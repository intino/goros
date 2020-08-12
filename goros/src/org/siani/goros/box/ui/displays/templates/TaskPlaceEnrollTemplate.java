package org.siani.goros.box.ui.displays.templates;

import org.monet.metamodel.EnrollActionProperty;
import org.monet.space.kernel.model.Task;
import org.siani.goros.box.GorosBox;

public class TaskPlaceEnrollTemplate extends AbstractTaskPlaceEnrollTemplate<GorosBox> {
    private Task task;
    private EnrollActionProperty property;

    public TaskPlaceEnrollTemplate(GorosBox box) {
        super(box);
    }

    public TaskPlaceEnrollTemplate task(Task task) {
        this.task = task;
        return this;
    }

    public TaskPlaceEnrollTemplate property(EnrollActionProperty property) {
        this.property = property;
        return this;
    }

    @Override
    public void refresh() {
        super.refresh();
    }

}