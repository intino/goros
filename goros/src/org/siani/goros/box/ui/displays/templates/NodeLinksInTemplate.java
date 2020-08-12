package org.siani.goros.box.ui.displays.templates;

import org.monet.metamodel.NodeViewProperty;
import org.monet.space.kernel.model.Node;
import org.siani.goros.box.GorosBox;
import org.siani.goros.box.ui.datasources.NodeLinksInDatasource;
import org.siani.goros.box.ui.displays.rows.LinksInTableRow;
import org.siani.goros.util.PathHelper;

public class NodeLinksInTemplate extends AbstractNodeLinksInTemplate<GorosBox> {
    private Node node;
    private NodeViewProperty view;
    private boolean readonly = true;

    public NodeLinksInTemplate(GorosBox box) {
        super(box);
    }

    public NodeLinksInTemplate node(Node node) {
        this.node = node;
        return this;
    }

    public NodeLinksInTemplate view(NodeViewProperty view) {
        this.view = view;
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