package io.intino.goros.unit.box.ui.datasources;

import io.intino.goros.unit.box.UnitBox;
import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.services.push.UISession;
import io.intino.goros.unit.util.LayerHelper;
import org.monet.metamodel.NodeViewProperty;
import org.monet.space.kernel.constants.Strings;
import org.monet.space.kernel.model.Node;
import org.monet.space.kernel.model.Task;
import org.monet.space.kernel.model.TaskList;

import java.util.ArrayList;
import java.util.List;

public class NodeTasksDatasource extends TaskListDatasource {
    private final Node node;
    private final NodeViewProperty view;

    public NodeTasksDatasource(UnitBox box, UISession session, Node node, NodeViewProperty view) {
        super(box, session);
        this.node = node;
        this.view = view;
    }

    @Override
    public List<Task> items(int start, int count, String condition, List<Filter> filters, List<String> sortings) {
        List<Task> result = toList(load(node));
        int from = Math.min(start, result.size());
        int end = Math.min(start + count, result.size());
        return result.subList(from, end);
    }

    @Override
    public long itemCount(String condition, List<Filter> filters) {
        return load(node).get().size();
    }

    private TaskList load(Node node) {
        box.linkSession(session);
        return node.getLinkedTasks();
    }

    @Override
    public List<Group> groups(String key) {
        return null;
    }

    private List<Task> toList(TaskList taskList) {
        return new ArrayList<>(taskList.get().values());
    }
}