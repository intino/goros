package io.intino.goros.unit.box.ui.datasources;

import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import io.intino.alexandria.ui.services.push.UISession;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.util.LayerHelper;
import org.monet.bpi.*;
import org.monet.metamodel.FieldProperty;
import org.monet.metamodel.FormDefinition;
import org.monet.metamodel.IndexDefinition;
import org.monet.metamodel.LinkFieldProperty;
import org.monet.metamodel.LinkFieldProperty.SourceProperty.FilterProperty;
import org.monet.metamodel.internal.Ref;
import org.monet.space.kernel.model.Context;
import org.monet.space.kernel.model.Node;
import org.monet.space.kernel.model.NodeDataRequest;
import org.monet.space.kernel.model.NodeItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonMap;
import static org.monet.space.kernel.model.DataRequest.OPERATOR_SEPARATOR;

public class FieldLinkDatasource extends PageDatasource<NodeItem> {
    private final UnitBox box;
    private final UISession session;
    private final Node form;
    private final LinkFieldProperty definition;
    private final IndexDefinition indexDefinition;

    public FieldLinkDatasource(UnitBox box, UISession session, String fieldCode, Node<?> form, IndexDefinition indexDefinition) {
        this.box = box;
        this.session = session;
        this.form = form;
        this.definition = (LinkFieldProperty) ((FormDefinition)form.getDefinition()).getField(fieldCode);
        this.indexDefinition = indexDefinition;
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
        addFilters(request);
        return request;
    }

    private void addFilters(NodeDataRequest request) {
        if (definition.getSource() == null) return;
        LinkFieldProperty.SourceProperty source = definition.getSource();
        List<FilterProperty> filterList = source.getFilterList();
        Map<String, String> filters = new HashMap<>();

        for (FilterProperty filterDefinition : filterList) {
            Object value = filterDefinition.getValue();
            String attributeName = filterDefinition.getAttribute().getValue();
            String operator = filterDefinition.getOperator() != null ? filterDefinition.getOperator().toString() : FilterProperty.OperatorEnumeration.EQUALS.toString();
            String filterValue = "";

            if (value instanceof String) filterValue = (String) value;
            else if (value instanceof Ref) filterValue = form.getFieldValue(fieldDefinition(((Ref) value).getValue()).getCode());

            if (filterValue == null || filterValue.isEmpty()) continue;

            filters.put(indexDefinition.getAttribute(attributeName).getCode(), filterValue + OPERATOR_SEPARATOR + operator);
        }

        if (filters.isEmpty()) return;
        request.setParameters(new HashMap<>() {{
            put("filters", serialize(filters));
        }});
    }

    private String serialize(Map<String, String> filters) {
        return filters.entrySet().stream().map(f -> f.getKey() + "=" + f.getValue()).collect(Collectors.joining("#"));
    }

    private FieldProperty fieldDefinition(String key) {
        return ((FormDefinition) form.getDefinition()).getField(key);
    }

    private static NodeDataRequest request() {
        return new NodeDataRequest();
    }



}