package org.siani.goros.box.ui.datasources;

import org.siani.goros.box.GorosBox;
import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import io.intino.alexandria.ui.services.push.UISession;
import org.monet.metamodel.NodeViewProperty;
import org.monet.space.kernel.constants.Strings;
import org.monet.space.kernel.model.Node;
import org.monet.space.kernel.model.Task;
import org.monet.space.kernel.model.TaskList;
import org.siani.goros.util.LayerHelper;

import java.util.ArrayList;
import java.util.List;

public class NodeTasksDatasource extends PageDatasource<Task> {
    private final GorosBox box;
    private final UISession session;
    private final Node node;
    private final NodeViewProperty view;

    public NodeTasksDatasource(GorosBox box, UISession session, Node node, NodeViewProperty view) {
        this.box = box;
        this.session = session;
        this.node = node;
        this.view = view;
    }

    @Override
    public List<Task> items(int start, int count, String condition, List<Filter> filters, List<String> sortings) {
        List<Task> result = toList(LayerHelper.taskLayer().loadTasks(node, Strings.ALL, Strings.ALL));
        int from = Math.min(start, result.size());
        int end = Math.min(start + count, result.size());
        return result.subList(from, end);
    }

    @Override
    public long itemCount(String condition, List<Filter> filters) {
        return LayerHelper.taskLayer().loadTasks(node, Strings.ALL, Strings.ALL).getTotalCount();
    }

    @Override
    public List<Group> groups(String key) {
        return null;
    }

    private List<Task> toList(TaskList taskList) {
        List<Task> result = new ArrayList<>();
        for (Task task : taskList) result.add(task);
        return result;
    }
}