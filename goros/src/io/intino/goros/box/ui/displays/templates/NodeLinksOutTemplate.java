package io.intino.goros.box.ui.displays.templates;

import io.intino.goros.util.DictionaryHelper;
import org.monet.metamodel.NodeViewProperty;
import org.monet.space.kernel.model.Node;
import io.intino.goros.box.GorosBox;
import io.intino.goros.box.ui.datasources.NodeLinksOutDatasource;
import io.intino.goros.box.ui.displays.rows.LinksOutTableRow;
import io.intino.goros.util.PathHelper;

public class NodeLinksOutTemplate extends AbstractNodeLinksOutTemplate<GorosBox> {
    private Node node;
    private NodeViewProperty view;
    private boolean readonly = true;

    public NodeLinksOutTemplate(GorosBox box) {
        super(box);
    }

    public NodeLinksOutTemplate node(Node node) {
        this.node = node;
        return this;
    }

    public NodeLinksOutTemplate view(String view) {
        this.view = view != null ? DictionaryHelper.view(node, view) : null;
        return this;
    }

    public NodeLinksOutTemplate readonly(boolean readonly) {
        this.readonly = readonly;
        return this;
    }

    @Override
    public void init() {
        super.init();
        linksOutTable.onAddItem(e -> {
            Node node = e.item();
            LinksOutTableRow row = e.component();
            row.linksOutTableLabelItem.label.address(path -> PathHelper.pathOf(node));
            row.linksOutTableLabelItem.label.title(node.getLabel());
            row.linksOutTableDescriptionItem.description.value(node.getDescription());
        });
    }

    @Override
    public void refresh() {
        super.refresh();
        linksOutTable.source(new NodeLinksOutDatasource(box(), session(), node, view));
        linksOutTable.reload();
    }

}