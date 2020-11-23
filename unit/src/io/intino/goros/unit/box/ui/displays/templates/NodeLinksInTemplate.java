package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.box.ui.datasources.NodeLinksInDatasource;
import io.intino.goros.unit.box.ui.displays.rows.LinksInTableRow;
import io.intino.goros.unit.util.DictionaryHelper;
import io.intino.goros.unit.util.PathHelper;
import org.monet.metamodel.NodeViewProperty;
import org.monet.space.kernel.model.Node;

public class NodeLinksInTemplate extends AbstractNodeLinksInTemplate<UnitBox> {
    private Node node;
    private NodeViewProperty view;
    private boolean readonly = true;

    public NodeLinksInTemplate(UnitBox box) {
        super(box);
    }

    public NodeLinksInTemplate node(Node node) {
        this.node = node;
        return this;
    }

    public NodeLinksInTemplate view(String view) {
        this.view = view != null ? DictionaryHelper.view(node, view) : null;
        return this;
    }

    public NodeLinksInTemplate readonly(boolean readonly) {
        this.readonly = readonly;
        return this;
    }

    @Override
    public void init() {
        super.init();
        linksInTable.onAddItem(e -> {
            Node node = e.item();
            LinksInTableRow row = e.component();
            row.linksInTableLabelItem.label.address(path -> PathHelper.pathOf(node));
            row.linksInTableLabelItem.label.title(node.getLabel());
            row.linksInTableDescriptionItem.description.value(node.getDescription());
        });
    }

    @Override
    public void refresh() {
        super.refresh();
        linksInTable.source(new NodeLinksInDatasource(box(), session(), node, view));
        linksInTable.reload();
    }

}