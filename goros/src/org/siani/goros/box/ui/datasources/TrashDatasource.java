package org.siani.goros.box.ui.datasources;

import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import io.intino.alexandria.ui.services.push.UISession;
import org.monet.metamodel.NodeDefinition;
import org.monet.space.kernel.model.DataRequest;
import org.monet.space.kernel.model.Dictionary;
import org.monet.space.kernel.model.Node;
import org.monet.space.kernel.model.NodeList;
import org.siani.goros.box.GorosBox;
import org.siani.goros.util.LayerHelper;
import org.siani.goros.util.NodeHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

public class TrashDatasource extends PageDatasource<Node> {
    private final GorosBox box;
    private final UISession session;

    public TrashDatasource(GorosBox box, UISession session) {
        this.box = box;
        this.session = session;
    }

    @Override
    public List<Node> items(int start, int count, String condition, List<Filter> filters, List<String> sortings) {
        DataRequest request = request(condition, filters);
        request.setStartPos(start);
        request.setLimit(count);
        return new ArrayList<>(load(request).get().values());
    }

    @Override
    public long itemCount(String condition, List<Filter> filters) {
        return load(request(condition, filters)).getTotalCount();
    }

    @Override
    public List<Group> groups(String key) {
        if (key.equalsIgnoreCase("type")) return Dictionary.getInstance().getAllDefinitions().stream().filter(d -> d instanceof NodeDefinition).map(d -> new Group().label(d.getLabelString())).collect(Collectors.toList());
        return emptyList();
    }

    private static NodeList load(DataRequest request) {
        return LayerHelper.nodeLayer().loadNodesFromTrash(request);
    }

    private DataRequest request(String condition, List<Filter> filters) {
        DataRequest request = request();
        request.setCondition(condition);
        request.setGroupsBy(NodeHelper.groupsByOf(filters));
        return request;
    }

    private static DataRequest request() {
        return new DataRequest();
    }

}