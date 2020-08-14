package io.intino.goros.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.UserMessage;
import org.monet.metamodel.NodeViewProperty;
import org.monet.space.kernel.model.Node;
import io.intino.goros.box.GorosBox;
import io.intino.goros.box.ui.datasources.NodeNotesDatasource;
import io.intino.goros.box.ui.datasources.model.Note;
import io.intino.goros.box.ui.displays.rows.NodeNotesTableRow;
import io.intino.goros.util.LayerHelper;

public class NodeNotesTemplate extends AbstractNodeNotesTemplate<GorosBox> {
    private Node node;
    private NodeViewProperty view;
    private boolean readonly = true;

    public NodeNotesTemplate(GorosBox box) {
        super(box);
    }

    public NodeNotesTemplate node(Node node) {
        this.node = node;
        return this;
    }

    public NodeNotesTemplate view(NodeViewProperty view) {
        this.view = view;
        return this;
    }

    public NodeNotesTemplate readonly(boolean readonly) {
        this.readonly = readonly;
        return this;
    }

    @Override
    public void init() {
        super.init();
        initDialog();
        nodeNotesTable.onAddItem(e -> {
            Note note = e.item();
            NodeNotesTableRow row = e.component();
            row.nodeNotesTableNameItem.name.value(note.name());
            row.nodeNotesTableValueItem.value.value(note.value());
            row.nodeNotesTableOperationsItem.remove.readonly(readonly);
            row.nodeNotesTableOperationsItem.remove.onExecute(e1 -> removeNote(note));
        });
    }

    @Override
    public void refresh() {
        super.refresh();
        nodeNotesTable.source(new NodeNotesDatasource(box(), session(), node, view));
        nodeNotesTable.reload();
        nodeNotesDialog.visible(!readonly);
    }

    private void initDialog() {
        valueField.onEnterPress(e -> addNote());
        add.onExecute(e -> addNote());
    }

    private void addNote() {
        String name = nameField.value();
        String value = valueField.value();
        if (name == null || name.isEmpty()) {
            notifyUser("Para poder añadir una nota, debe indicar al menos un nombre", UserMessage.Type.Error);
            return;
        }
        node.addNote(name, value);
        LayerHelper.nodeLayer().saveNodeNotes(node);
        refresh();
    }

    private void removeNote(Note note) {
        node.deleteNote(note.name());
        LayerHelper.nodeLayer().saveNodeNotes(node);
        refresh();
    }

}