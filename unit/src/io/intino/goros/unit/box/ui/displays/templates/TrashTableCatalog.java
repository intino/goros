package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.box.ui.datasources.TrashDatasource;
import io.intino.goros.unit.box.ui.displays.rows.TrashTableRow;
import io.intino.goros.unit.util.LayerHelper;
import io.intino.goros.unit.util.NodeHelper;
import org.monet.space.kernel.model.Node;

public class TrashTableCatalog extends AbstractTrashTableCatalog<UnitBox> {

    public TrashTableCatalog(UnitBox box) {
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