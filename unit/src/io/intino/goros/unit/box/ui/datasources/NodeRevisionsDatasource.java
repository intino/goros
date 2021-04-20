package io.intino.goros.unit.box.ui.datasources;

import io.intino.goros.unit.box.UnitBox;
import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import io.intino.alexandria.ui.services.push.UISession;
import io.intino.goros.unit.util.LayerHelper;
import org.monet.metamodel.NodeViewProperty;
import org.monet.space.kernel.model.*;

import java.util.ArrayList;
import java.util.List;

public class NodeRevisionsDatasource extends PageDatasource<Revision> {
    private final UnitBox box;
    private final UISession session;
    private final Node node;
    private final NodeViewProperty view;

    public NodeRevisionsDatasource(UnitBox box, UISession session, Node node, NodeViewProperty view) {
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
        box.linkSession(session);
        return new ArrayList<>(LayerHelper.nodeLayer().requestRevisionListItems(node.getId(), request).values());
    }

    @Override
    public long itemCount(String condition, List<Filter> filters) {
        box.linkSession(session);
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