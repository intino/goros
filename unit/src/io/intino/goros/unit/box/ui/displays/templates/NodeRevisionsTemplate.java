package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.box.ui.datasources.NodeRevisionsDatasource;
import io.intino.goros.unit.box.ui.displays.rows.NodeRevisionsTableRow;
import io.intino.goros.unit.util.DictionaryHelper;
import io.intino.goros.unit.util.LayerHelper;
import org.monet.metamodel.NodeViewProperty;
import org.monet.space.kernel.model.Node;
import org.monet.space.kernel.model.Revision;

import java.util.function.Consumer;

public class NodeRevisionsTemplate extends AbstractNodeRevisionsTemplate<UnitBox> {
    private Node node;
    private NodeViewProperty view;
    private Consumer<Revision> selectListener;
    private boolean readonly = true;

    public NodeRevisionsTemplate(UnitBox box) {
        super(box);
    }

    public NodeRevisionsTemplate node(Node node) {
        this.node = node;
        return this;
    }

    public NodeRevisionsTemplate view(String view) {
        this.view = view != null ? DictionaryHelper.view(node, view) : null;
        return this;
    }

    public NodeRevisionsTemplate readonly(boolean readonly) {
        this.readonly = readonly;
        return this;
    }

    public NodeRevisionsTemplate onSelect(Consumer<Revision> listener) {
        this.selectListener = listener;
        return this;
    }

    @Override
    public void init() {
        super.init();
        nodeRevisionsTable.onSelect(e -> selectListener.accept((Revision) e.selection().get(0)));
        nodeRevisionsTable.onAddItem(e -> {
            Revision revision = e.item();
            NodeRevisionsTableRow row = e.component();
            row.nodeRevisionsTableLabelItem.label.value(revision.getRevisionDate().toInstant());
            row.nodeRevisionsTableOperationsItem.restore.readonly(readonly);
            row.nodeRevisionsTableOperationsItem.restore.onExecute(e1 -> restore(revision));
        });
    }

    @Override
    public void refresh() {
        super.refresh();
        nodeRevisionsTable.source(new NodeRevisionsDatasource(box(), session(), node, view));
        nodeRevisionsTable.reload();
    }

    private void restore(Revision revision) {
        LayerHelper.nodeLayer().restoreNode(revision);
        notifier.redirect(session().browser().requestUrl());
    }

}