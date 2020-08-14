package io.intino.goros.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.Display;
import org.monet.metamodel.EditionActionProperty;
import org.monet.metamodel.FormDefinition;
import org.monet.metamodel.FormDefinitionBase;
import org.monet.space.kernel.components.layers.NodeLayer;
import org.monet.space.kernel.machines.ttm.model.ValidationResult;
import org.monet.space.kernel.model.Dictionary;
import org.monet.space.kernel.model.Node;
import org.monet.space.kernel.model.Task;
import io.intino.goros.box.GorosBox;
import io.intino.goros.box.ui.DisplayProvider;
import io.intino.goros.util.DisplayHelper;
import io.intino.goros.util.LayerHelper;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class TaskPlaceEditionTemplate extends AbstractTaskPlaceEditionTemplate<GorosBox> {
    private Task task;
    private EditionActionProperty property;
    private DisplayProvider displayProvider;

    public TaskPlaceEditionTemplate(GorosBox box) {
        super(box);
    }

    public TaskPlaceEditionTemplate task(Task task) {
        this.task = task;
        return this;
    }

    public TaskPlaceEditionTemplate property(EditionActionProperty property) {
        this.property = property;
        return this;
    }

    public TaskPlaceEditionTemplate displayProvider(DisplayProvider provider) {
        this.displayProvider = provider;
        return this;
    }

    @Override
    public void init() {
        super.init();
        solve.onExecute(e -> solve());
    }

    @Override
    public void refresh() {
        super.refresh();
        Node form = loadForm();
        solve.affirmed(translate(DisplayHelper.requireConfirmationMessage(property)));
        solve.readonly(form == null);
        refreshForm(form);
        refreshNoEditionBlock(form);
    }

    private Node loadForm() {
        String formId = task.getProcess().getEditionFormId();
        NodeLayer nodeLayer = LayerHelper.nodeLayer();
        return formDefined(formId) && nodeLayer.existsNode(formId) ? nodeLayer.loadNode(formId) : null;
    }

    private void refreshForm(Node form) {
        formFrame.clear();
        if (form == null) return;
        EditionActionProperty.UseProperty use = property.getUse();
        FormDefinition definition = Dictionary.getInstance().getFormDefinition(use.getForm().getValue());
        FormDefinitionBase.FormViewProperty view = definition.getViewMap().get(use.getWithView().getValue());
        Display display = displayProvider.displayFor(form, view);
        if (display == null) return;
        formFrame.display(display);
        display.refresh();
    }

    private void refreshNoEditionBlock(Node form) {
        noEditionBlock.visible(form == null);
    }

    private boolean formDefined(String id) {
        return id != null && !id.isEmpty();
    }

    private void solve() {
        ValidationResult validation = task.getProcess().solveEditionAction();
        solveErrorMessageBlock.visible(!validation.isValid());
        if (!validation.isValid()) solveErrorMessage.value(solveErrorMessage(validation));
    }

    private String solveErrorMessage(ValidationResult validation) {
        LinkedHashMap<String, String> errorsMap = validation.getErrors();
        String message = errorsMap.entrySet().stream().map(e -> e.getKey() + ": " + e.getValue()).collect(Collectors.joining(", "));
        return message.isEmpty() ? translate("It could not solve task edition") : message;
    }

}