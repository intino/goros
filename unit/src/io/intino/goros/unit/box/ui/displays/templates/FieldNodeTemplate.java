package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.Display;
import io.intino.alexandria.ui.displays.components.editable.Editable;
import io.intino.alexandria.ui.displays.events.ChangeEvent;
import io.intino.alexandria.ui.displays.events.ChangeListener;
import io.intino.alexandria.ui.displays.notifiers.TemplateNotifier;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.util.DisplayHelper;
import io.intino.goros.unit.util.LayerHelper;
import io.intino.goros.unit.util.NodeHelper;
import org.monet.bpi.FieldNode;
import org.monet.bpi.types.Link;
import org.monet.metamodel.NodeDefinition;
import org.monet.metamodel.NodeFieldProperty;
import org.monet.metamodel.NodeFieldPropertyBase;
import org.monet.metamodel.NodeViewProperty;
import org.monet.space.kernel.model.Dictionary;
import org.monet.space.kernel.model.Language;
import org.monet.space.kernel.model.Node;
import io.intino.goros.unit.box.ui.DisplayProvider;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FieldNodeTemplate extends AbstractFieldNodeTemplate<UnitBox> implements Editable<TemplateNotifier, UnitBox> {
    private Node node;
    private FieldNode field;
    private boolean readonly;
    private DisplayProvider displayProvider;
    private ChangeListener changeListener;

    public FieldNodeTemplate(UnitBox box) {
        super(box);
    }

    public FieldNodeTemplate node(Node node) {
        this.node = node;
        return this;
    }

    public FieldNodeTemplate field(FieldNode field) {
        this.field = field;
        return this;
    }

    @Override
    public boolean readonly() {
        return readonly;
    }

    @Override
    public void reload() {
        refresh();
    }

    public FieldNodeTemplate readonly(boolean readonly) {
        this.readonly = readonly;
        return this;
    }

    public FieldNodeTemplate onChange(ChangeListener changeListener) {
        this.changeListener = changeListener;
        return this;
    }

    public FieldNodeTemplate displayProvider(DisplayProvider provider) {
        this.displayProvider = provider;
        return this;
    }

    @Override
    public void init() {
        super.init();
        initToolbar();
    }

    private void initToolbar() {
        addType.onExecute(e -> addNode());
        selectNodeTypeDialog.onSelect(e -> {
            if (e.selection().size() <= 0) return;
            addNode((String) e.selection().get(0));
        });
    }

    @Override
    public void refresh() {
        super.refresh();
        Node node = loadNode();
        title.value(Language.getInstance().getModelResource(field.getDefinition().getLabel()));
        refreshToolbar(node);
        refreshSelectNodeTypeDialog();
        refreshNode(node);
        refreshEmptyBlock(node);
    }

    private Node loadNode() {
        Link link = field.get();
        if (link == null || link.getId().isEmpty()) return null;
        return LayerHelper.nodeLayer().loadNode(link.getId());
    }

    private void refreshToolbar(Node node) {
        List<NodeDefinition> types = types();
        addType.visible(node == null && types.size() == 1);
        addType.readonly(readonly);
        selectType.visible(node == null && types.size() > 1);
        selectType.readonly(readonly);
    }

    private void refreshSelectNodeTypeDialog() {
        selectNodeTypeDialog.onOpen(e -> {
            nodeTypeSeletor.clear();
            types().forEach(type -> nodeTypeSeletor.add(type.getLabelString()));
        });
    }

    private void refreshNode(Node node) {
        nodeFrame.clear();
        if (node == null) return;
        NodeViewProperty viewProperty = DisplayHelper.defaultEmbeddedView(node);
        Display display = displayProvider.displayFor(node, viewProperty != null ? viewProperty.getCode() : null);
        if (display == null) return;
        nodeFrame.display(display);
        display.refresh();
    }

    private void refreshEmptyBlock(Node node) {
        emptyBlock.visible(node == null);
    }

    private void addNode() {
        addNode(types().get(0).getLabelString());
    }

    private void addNode(String type) {
        NodeDefinition nodeDefinition = types().stream().filter(t -> t.getLabelString().equals(type)).findFirst().orElse(null);
        Node node = LayerHelper.nodeLayer().addNode(nodeDefinition.getCode());
        field.set(NodeHelper.linkOf(node));
        refresh();
        changeListener.accept(new ChangeEvent(this, field));
    }

    private List<NodeDefinition> types() {
        Dictionary dictionary = Dictionary.getInstance();
        NodeFieldPropertyBase.AddProperty add = ((NodeFieldProperty) field.getDefinition()).getAdd();
        if (add == null) return Collections.emptyList();
        return add.getNode().stream().map(ref -> dictionary.getNodeDefinition(ref.getValue())).collect(toList());
    }

}