package io.intino.goros.unit.box.ui.datasources;

import io.intino.goros.unit.box.UnitBox;
import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import io.intino.alexandria.ui.services.push.UISession;
import io.intino.goros.unit.util.LayerHelper;
import org.monet.metamodel.NodeViewProperty;
import org.monet.metamodel.internal.DescriptorDefinition;
import org.monet.space.kernel.model.Node;
import org.monet.space.kernel.model.NodeDataRequest;

import java.util.ArrayList;
import java.util.List;

public abstract class NodeDatasource extends PageDatasource<Node> {
    private final UnitBox box;
    private final UISession session;
    private Node node;
    private NodeViewProperty view;
    private final String type;

    public NodeDatasource(UnitBox box, UISession session, Node node, NodeViewProperty view, String type) {
        this.box = box;
        this.session = session;
        this.node = node;
        this.view = view;
        this.type = type;
    }

    public void node(Node node) {
        this.node = node;
    }

    public void view(String view) {
        this.view = node.getDefinition().getNodeView(view);
    }

    @Override
    public List<Node> items(int start, int count, String condition, List<Filter> filters, List<String> sortings) {
        NodeDataRequest request = request(condition, filters, view);
        request.setStartPos(start);
        request.setLimit(count);
        box.linkSession(session);
        return new ArrayList<>(LayerHelper.nodeLayer().requestNodeSetItems(node.getId(), type, request).values());
    }

    @Override
    public long itemCount(String condition, List<Filter> filters) {
        box.linkSession(session);
        return LayerHelper.nodeLayer().requestNodeSetItemsCount(node.getId(), type, request(condition, filters, view));
    }

    public static long itemCount(Node set, NodeViewProperty view, String type) {
        return LayerHelper.nodeLayer().requestNodeSetItemsCount(set.getId(), type, request(set, view));
    }

    private NodeDataRequest request(String condition, List<Filter> filters, NodeViewProperty view) {
        return request(node, view);
    }

    private static NodeDataRequest request(Node set, NodeViewProperty view) {
        NodeDataRequest request = new NodeDataRequest();
        request.setCodeReference(new DescriptorDefinition().getCode());
        request.setCodeView(view.getCode());
//        request.setSortsBy(getSortsBy(parameters.get(Parameter.SORTS_BY)));
//        request.setGroupsBy(getGroupsBy(parameters.get(Parameter.GROUPS_BY)));
//        request.setParameters(parameters);
        return request;
    }

    @Override
    public List<Group> groups(String key) {
        return null;
    }
}