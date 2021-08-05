package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.goros.unit.box.UnitBox;
import org.monet.metamodel.LineActionPropertyBase;
import org.monet.space.kernel.model.Language;
import org.monet.space.kernel.model.Task;

import java.util.function.Consumer;

public class TaskPlaceLineStopTemplate extends AbstractTaskPlaceLineStopTemplate<UnitBox> {
    private Task task;
    private LineActionPropertyBase.LineStopProperty property;
    private Consumer<LineActionPropertyBase.LineStopProperty> selectListener;
    private String confirmText;

    public TaskPlaceLineStopTemplate(UnitBox box) {
        super(box);
    }

    public TaskPlaceLineStopTemplate task(Task task) {
        this.task = task;
        return this;
    }

    public TaskPlaceLineStopTemplate stop(LineActionPropertyBase.LineStopProperty property) {
        this.property = property;
        return this;
    }

    public TaskPlaceLineStopTemplate onSelect(Consumer<LineActionPropertyBase.LineStopProperty> listener) {
        this.selectListener = listener;
        return this;
    }

    public TaskPlaceLineStopTemplate confirmText(String text) {
        this.confirmText = text;
        return this;
    }

    @Override
    public void init() {
        super.init();
        label.onExecute(e -> select());
    }

    @Override
    public void refresh() {
        super.refresh();
        label.affirmed(confirmText);
        label.title(Language.getInstance().getModelResource(property.getLabel()));
    }

    private void select() {
        label.readonly(true);
        selectListener.accept(property);
        label.readonly(false);
    }

}