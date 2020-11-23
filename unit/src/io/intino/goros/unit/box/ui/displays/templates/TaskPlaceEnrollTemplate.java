package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.goros.unit.box.UnitBox;
import org.monet.metamodel.EnrollActionProperty;
import org.monet.space.kernel.model.Task;

public class TaskPlaceEnrollTemplate extends AbstractTaskPlaceEnrollTemplate<UnitBox> {
    private Task task;
    private EnrollActionProperty property;

    public TaskPlaceEnrollTemplate(UnitBox box) {
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