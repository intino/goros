package io.intino.goros.box.ui.displays.templates;

import org.monet.space.kernel.model.Node;
import io.intino.goros.box.GorosBox;
import io.intino.goros.box.ui.datasources.TrashDatasource;
import io.intino.goros.box.ui.displays.rows.TrashTableRow;
import io.intino.goros.util.LayerHelper;
import io.intino.goros.util.NodeHelper;

public class TrashTableCatalog extends AbstractTrashTableCatalog<GorosBox> {

    public TrashTableCatalog(GorosBox box) {
        super(box);
    }

    @Override
    public void init() {
        super.init();
        trashTable.source(new TrashDatasource(box(), session()));
        trashTable.onAddItem(e -> {
            Node node = e.item();
            TrashTableRow row = e.component();
            row.trashTableLabelItem.label.value(node.getLabel() != null && !node.getLabel().isEmpty() ? node.getLabel() : "-");
            row.trashTableTypeItem.type.value(node.getDefinition().getLabelString());
            row.trashTableDeleteDateItem.deleteDate.value(NodeHelper.instantOf(node.getReference().getDeleteDate()));
            row.trashTableOperationsItem.restore.onExecute(e1 -> restore(node));
        });
    }

    @Override
    public void refresh() {
        super.refresh();
        trashTable.reload();
    }

    private void restore(Node node) {
        LayerHelper.nodeLayer().recoverNodeFromTrash(node.getId());
        refresh();
    }

}