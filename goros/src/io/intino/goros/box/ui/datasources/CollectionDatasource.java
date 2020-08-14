package io.intino.goros.box.ui.datasources;

import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import io.intino.alexandria.ui.services.push.UISession;
import org.monet.metamodel.SetDefinition;
import org.monet.space.kernel.model.Node;
import org.monet.space.kernel.model.NodeDataRequest;
import io.intino.goros.box.GorosBox;
import io.intino.goros.util.LayerHelper;
import io.intino.goros.util.NodeHelper;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class CollectionDatasource extends PageDatasource<Node> {
    private final GorosBox box;
    private final UISession session;
    private final Node set;

    public CollectionDatasource(GorosBox box, UISession session, Node set) {
        this.box = box;
        this.session = session;
        this.set = set;
    }

    @Override
    public List<Node> items(int start, int count, String condition, List<Filter> filters, List<String> sortings) {
        NodeDataRequest request = request(condition, filters);
        request.setStartPos(start);
        request.setLimit(count);
        return new ArrayList<>(LayerHelper.nodeLayer().requestNodeListItems(set.getId(), request).values());
    }

    @Override
    public long itemCount(String condition, List<Filter> filters) {
        return LayerHelper.nodeLayer().requestNodeListItemsCount(set.getId(), request(condition, filters));
    }

    @Override
    public List<Group> groups(String key) {
        List<String> groups = set.getGroupOptions(key, emptyList(), emptyList());
        return groups.stream().map(o -> new Group().label(o)).collect(toList());
    }

    public static long itemCount(Node set) {
        return LayerHelper.nodeLayer().requestNodeListItemsCount(set.getId(), request(set));
    }

    private NodeDataRequest request(String condition, List<Filter> filters) {
        NodeDataRequest request = request(set);
        request.setCondition(condition);
        request.setGroupsBy(NodeHelper.groupsByOf(filters));
        return request;
    }

    private static NodeDataRequest request(Node set) {
        NodeDataRequest request = new NodeDataRequest();
        request.setCodeReference(((SetDefinition)set.getDefinition()).getIndex().getValue());
        return request;
    }

}