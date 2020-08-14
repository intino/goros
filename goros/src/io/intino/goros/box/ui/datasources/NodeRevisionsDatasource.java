package io.intino.goros.box.ui.datasources;

import io.intino.goros.box.GorosBox;
import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import io.intino.alexandria.ui.services.push.UISession;
import org.monet.metamodel.NodeViewProperty;
import org.monet.space.kernel.model.*;
import io.intino.goros.util.LayerHelper;

import java.util.ArrayList;
import java.util.List;

public class NodeRevisionsDatasource extends PageDatasource<Revision> {
    private final GorosBox box;
    private final UISession session;
    private final Node node;
    private final NodeViewProperty view;

    public NodeRevisionsDatasource(GorosBox box, UISession session, Node node, NodeViewProperty view) {
        this.box = box;
        this.session = session;
        this.node = node;
        this.view = view;
    }

    @Override
    public List<Revision> items(int start, int count, String condition, List<Filter> filters, List<String> sortings) {
        DataRequest request = request(condition, filters);
        request.setStartPos(start);
        request.setLimit(count);
        return new ArrayList<>(LayerHelper.nodeLayer().requestRevisionListItems(node.getId(), request).values());
    }

    @Override
    public long itemCount(String condition, List<Filter> filters) {
        return LayerHelper.nodeLayer().requestRevisionListItemsCount(node.getId(), request(condition, filters));
    }

    @Override
    public List<Group> groups(String key) {
        return null;
    }

    private DataRequest request(String condition, List<Filter> filters) {
        DataRequest request = new DataRequest();
        request.setCondition(condition);
        return request;
    }
}