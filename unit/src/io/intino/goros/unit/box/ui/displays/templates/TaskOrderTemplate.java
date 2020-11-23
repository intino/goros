package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.events.actionable.ToggleEvent;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.box.ui.datasources.FormDatasource;
import io.intino.goros.unit.util.LayerHelper;
import io.intino.goros.unit.util.NodeHelper;
import org.monet.bpi.FieldBoolean;
import org.monet.bpi.FieldDate;
import org.monet.bpi.FieldMemo;
import org.monet.space.kernel.model.Node;

import java.time.Instant;
import java.util.function.Consumer;

public class TaskOrderTemplate extends AbstractTaskOrderTemplate<UnitBox> {
    private Node node;
    private FieldDate suggestedStartDateField;
    private FieldDate suggestedEndDateField;
    private FieldMemo commentsField;
    private FieldBoolean urgentField;

    public TaskOrderTemplate(UnitBox box) {
        super(box);
    }

    public TaskOrderTemplate node(Node node) {
        this.node = node;
        updateFields();
        return this;
    }

    @Override
    public void init() {
        super.init();
        suggestedStartDate.onChange(e -> save(b -> suggestedStartDateField.set(new org.monet.bpi.types.Date(((Instant)e.value()).toEpochMilli()))));
        suggestedEndDate.onChange(e -> save(b -> suggestedEndDateField.set(new org.monet.bpi.types.Date(((Instant)e.value()).toEpochMilli()))));
        comments.onChange(e -> save(b -> commentsField.set(e.value())));
        urgent.onToggle(e -> save(b -> urgentField.set(e.state() == ToggleEvent.State.On)));
    }

    @Override
    public void refresh() {
        super.refresh();
        suggestedStartDate.value(NodeHelper.instantOf(suggestedStartDateField));
        suggestedEndDate.value(NodeHelper.instantOf(suggestedEndDateField));
        comments.value(commentsField.get());
        urgent.state(urgentField.isChecked() ? ToggleEvent.State.On : ToggleEvent.State.Off);
    }

    private void save(Consumer<Boolean> consumer) {
        consumer.accept(true);
        LayerHelper.nodeLayer().saveNode(node);
        updateFields();
    }

    private void updateFields() {
        FormDatasource datasource = new FormDatasource(box(), session(), node);
        suggestedStartDateField = datasource.getField("_vrwtkw");
        suggestedEndDateField = datasource.getField("_7vewhg");
        commentsField = datasource.getField("_y__kmq");
        urgentField = datasource.getField("_ss7omw");
    }

}