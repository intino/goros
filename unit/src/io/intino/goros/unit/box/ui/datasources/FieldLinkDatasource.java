package io.intino.goros.unit.box.ui.datasources;

import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import io.intino.alexandria.ui.services.push.UISession;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.util.LayerHelper;
import org.monet.metamodel.IndexDefinition;
import org.monet.space.kernel.model.Context;
import org.monet.space.kernel.model.NodeDataRequest;
import org.monet.space.kernel.model.NodeItem;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

public class FieldLinkDatasource extends PageDatasource<NodeItem> {
    private final UnitBox box;
    private final UISession session;
    private final IndexDefinition indexDefinition;

    public FieldLinkDatasource(UnitBox box, UISession session, IndexDefinition definition) {
        this.box = box;
        this.session = session;
        this.indexDefinition = definition;
    }

    @Override
    public List<NodeItem> items(int start, int count, String condition, List<Filter> filters, List<String> sortings) {
        NodeDataRequest request = request(condition, filters);
        request.setStartPos(start);
        request.setLimit(count);
        box.linkSession(session);
        return new ArrayList<>(LayerHelper.nodeLayer().searchLinkNodeItems(request).get().values());
    }

    @Override
    public long itemCount(String condition, List<Filter> filters) {
        box.linkSession(session);
        return LayerHelper.nodeLayer().searchLinkNodeItems(request(condition, filters)).getTotalCount();
    }

    @Override
    public List<Group> groups(String key) {
        return emptyList();
    }

    private NodeDataRequest request(String condition, List<Filter> filters) {
        NodeDataRequest request = request();
        request.setCondition(condition);
        request.setCodeDomainNode(indexDefinition.getCode());
        return request;
    }

    private static NodeDataRequest request() {
        return new NodeDataRequest();
    }

}