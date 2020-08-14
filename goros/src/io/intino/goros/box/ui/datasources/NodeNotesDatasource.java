package io.intino.goros.box.ui.datasources;

import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import io.intino.alexandria.ui.services.push.UISession;
import org.monet.metamodel.NodeViewProperty;
import org.monet.space.kernel.model.Node;
import io.intino.goros.box.GorosBox;
import io.intino.goros.box.ui.datasources.model.Note;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NodeNotesDatasource extends PageDatasource<Note> {
    private final GorosBox box;
    private final UISession session;
    private final Node node;
    private final NodeViewProperty view;

    public NodeNotesDatasource(GorosBox box, UISession session, Node node, NodeViewProperty view) {
        this.box = box;
        this.session = session;
        this.node = node;
        this.view = view;
    }

    @Override
    public List<Note> items(int start, int count, String condition, List<Filter> filters, List<String> sortings) {
        List<Note> result = toNotes(node.getNotes());
        int from = Math.min(start, result.size());
        int end = Math.min(start + count, result.size());
        return result.subList(from, end);
    }

    @Override
    public long itemCount(String condition, List<Filter> filters) {
        return node.getNotes().size();
    }

    @Override
    public List<Group> groups(String key) {
        return null;
    }

    private List<Note> toNotes(Map<String, String> notes) {
        return notes.entrySet().stream().map(this::toNote).collect(Collectors.toList());
    }

    private Note toNote(Map.Entry<String, String> entry) {
        return new Note().name(entry.getKey()).value(entry.getValue());
    }

}