package io.intino.goros.unit.util;

import io.intino.alexandria.Resource;
import io.intino.alexandria.logger.Logger;
import io.intino.alexandria.ui.Soul;
import io.intino.alexandria.ui.displays.DisplayRouteDispatcher;
import io.intino.alexandria.ui.displays.UserMessage;
import io.intino.alexandria.ui.displays.components.Actionable;
import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.filters.GroupFilter;
import io.intino.alexandria.ui.model.datasource.filters.RangeFilter;
import io.intino.alexandria.ui.services.push.UISession;
import io.intino.alexandria.ui.spark.UIFile;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.box.ui.datasources.FieldSelectDatasource;
import io.intino.goros.unit.box.ui.datasources.model.Column;
import io.intino.goros.unit.printers.SetPrinter;
import org.monet.bpi.FieldDate;
import org.monet.bpi.FieldFile;
import org.monet.bpi.FieldLink;
import org.monet.bpi.FieldPicture;
import org.monet.bpi.types.Date;
import org.monet.bpi.types.Number;
import org.monet.bpi.types.Term;
import org.monet.bpi.types.*;
import org.monet.metamodel.*;
import org.monet.metamodel.FormDefinitionBase.FormViewProperty;
import org.monet.metamodel.internal.Ref;
import org.monet.space.kernel.agents.AgentNotifier;
import org.monet.space.kernel.agents.AgentUserClient;
import org.monet.space.kernel.components.ComponentDocuments;
import org.monet.space.kernel.model.Dictionary;
import org.monet.space.kernel.model.*;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;

public class NodeHelper {
    private static final SimpleDateFormat InternalFormat = new SimpleDateFormat("dd/MM/yyyy/HH:mm:ss");
    private static final SimpleDateFormat Format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static Node singleton(String code) {
        return LayerHelper.nodeLayer().locateNode(code);
    }

    public static String nameOf(Node node) {
        return PathHelper.nameOf(node.getDefinition());
    }

	public static InputStream download(UnitBox box, Node node, NodeDataRequest request, String format, List<String> columns, String language) {
        return new SetPrinter(box, node, request, format, columns).print(language);
    }

	public static List<Column> downloadColumns(Node node, String view) {
        if (!node.isSet()) return Collections.emptyList();
        SetDefinition.SetViewProperty setViewProperty = (SetDefinition.SetViewProperty) node.getDefinition().getNodeView(view);
        if (setViewProperty.getShow().getIndex() == null) return emptyList();

        IndexDefinition indexDefinition = Dictionary.getInstance().getIndexDefinition(((SetDefinition) node.getDefinition()).getIndex().getValue());
        SetDefinitionBase.SetViewPropertyBase.ShowProperty showDefinition = setViewProperty.getShow();
        String nameReferenceView = showDefinition.getIndex().getWithView().getValue();
        IndexDefinitionBase.IndexViewProperty referenceViewDefinition = indexDefinition.getView(nameReferenceView);

        return indexDefinition.getAttributes(referenceViewDefinition).stream().map(NodeHelper::columnOf).collect(toList());
    }

    private static Column columnOf(AttributeProperty attributeProperty) {
        return new Column().code(attributeProperty.getCode()).label((String)attributeProperty.getLabel()).isDate(attributeProperty.getType() == AttributeProperty.TypeEnumeration.DATE);
    }

    public static String internalValueOf(Instant instant) {
        if (instant == null) return null;
        return InternalFormat.format(java.util.Date.from(instant));
    }

    public static UIFile downloadOperation(Actionable actionable, Node node, String operation) {
        actionable.readonly(true);
        Node current = LayerHelper.nodeLayer().loadNode(node.getId());
        MonetEvent event = new MonetEvent(MonetEvent.NODE_EXECUTE_COMMAND, null, current);
        event.addParameter(MonetEvent.PARAMETER_COMMAND, operation);
        AgentNotifier.getInstance().notify(event);
        File fileForUser = AgentUserClient.getInstance().getFileForUser(Thread.currentThread().getId());
        actionable.readonly(false);
        return new UIFile() {
            @Override
            public String label() {
                return fileForUser.getFilename();
            }

            @Override
            public InputStream content() {
                return fileForUser.getContentAsStream();
            }
        };
    }

    public static void executeOperation(DisplayRouteDispatcher dispatcher, UISession session, Actionable actionable, Node node, String operation, String successMessage) {
        actionable.readonly(true);
        Node current = LayerHelper.nodeLayer().loadNode(node.getId());
        MonetEvent event = new MonetEvent(MonetEvent.NODE_EXECUTE_COMMAND, null, current);
        event.addParameter(MonetEvent.PARAMETER_COMMAND, operation);
        AgentNotifier.getInstance().notify(event);
        actionable.readonly(false);
        ClientOperation clientOperation = AgentUserClient.getInstance().getOperationForUser(Thread.currentThread().getId());
        String message = AgentUserClient.getInstance().getMessageForUser(Thread.currentThread().getId());

        if (clientOperation != null) {
            dispatchOperation(dispatcher, session, clientOperation);
            if (message != null) actionable.notifyUser(successMessage, UserMessage.Type.Info);
        }
        else {
            if (message != null) actionable.notifyUser(message, UserMessage.Type.Error);
        }
    }

    private static void dispatchOperation(DisplayRouteDispatcher dispatcher, UISession session, ClientOperation operation) {
        String name = operation.getName().toLowerCase();
        String id = operation.getData().get("Id").toString();
        Soul soul = session.client().soul();

        if (name.equals("shownode") || name.equalsIgnoreCase("shownodeview")) {
            Node node = LayerHelper.nodeLayer().loadNode(id);
            dispatcher.dispatch(soul, PathHelper.pathOf(node));
        }
        else if (name.equals("showtask")) {
            Task task = LayerHelper.taskLayer().loadTask(operation.getData().get("Id").toString());
            dispatcher.dispatch(soul, PathHelper.pathOf(task));
        }
    }

    public static Task recentTask(Node node, String view) {
        return recentTask(node, node.getDefinition().getNodeView(view));
    }

    public static Task recentTask(Node node, NodeViewProperty view) {
        List<Task> taskList = new ArrayList<>(node.getLinkedTasks().get().values());
        if (taskList.size() <= 0) return null;
        List<String> taskTypes = recentTaskTypes(node, view);
        return taskTypes.size() > 0 ? taskList.stream().filter(task -> taskTypes.contains(task.getDefinition().getName())).findFirst().orElse(null) : taskList.get(0);
    }

    public static String valueOf(Node node, String attribute) {
        Attribute attributeObject = node.getAttribute(attribute);
        return attributeObject != null ? attributeObject.getIndicatorValue(Indicator.VALUE) : null;
    }

    public static String valueOf(NodeItem node, String attribute) {
        return node.getAttribute(attribute);
    }

    public static Double numberOf(Reference reference, String attribute) {
        Object value = reference.getAttribute(attribute).getValue();
        if (value instanceof Double) return (Double)value;
        if (value instanceof Number) return ((Number)value).doubleValue();
        return null;
    }

    public static Double numberOf(NodeItem node, String attribute) {

        String value = node.getAttribute(attribute);
        if (value == null || value.isEmpty()) return null;
        return Double.valueOf(value);
    }

    public static Node nodeOf(Link link) {
        if (link == null) return null;
        return LayerHelper.nodeLayer().loadNode(link.getId());
    }

    public static NodeItem nodeItemOf(Link link) {
        NodeItem result = new NodeItem();
        result.addAttribute("id_node", link.getId());
        result.addAttribute("label", link.getLabel());
        return result;
    }

    public static List<NodeItem> nodeItemsOf(List<Link> links) {
        return links.stream().map(NodeHelper::nodeItemOf).collect(Collectors.toList());
    }

    public static CheckList checkListOf(CheckList checkList, List<String> selection) {
        checkList.getAll().forEach(check -> check.setChecked(selection.contains(check.getLabel())));
        return checkList;
    }

    public static List<String> selectionOf(CheckList checkList) {
        return checkList.getAll().stream().filter(Check::isChecked).map(Check::getLabel).collect(toList());
    }

    public static List<String> selectionOf(List<Term> terms) {
        return terms.stream().map(Term::getLabel).collect(toList());
    }

    public static List<String> selectionOf(Term term) {
        return term != null ? singletonList(term.getLabel()) : Collections.emptyList();
    }

    public static String getContainerContain(Node node, String code) {
        Dictionary dictionary = Dictionary.getInstance();
        ContainerDefinition definition = (ContainerDefinition) node.getDefinition();
        NodeDefinition nodeDefinition = definition.getContain().getNode().stream().map(n -> dictionary.getNodeDefinition(n.getValue())).filter(d -> d.getCode().equals(code)).findFirst().orElse(null);
        if (nodeDefinition == null) return null;
        return NodeHelper.valueOf(node, nodeDefinition.getCode());
    }

    public static String valueOf(Reference reference, String attributeKey) {
        ReferenceAttribute<?> attribute = reference.getAttribute(attributeKey);
        return attribute != null ? attribute.getValueAsString() : null;
    }

    public static Instant instantOf(Node node, String attribute) {
        try {
            String value = node.getAttribute(attribute).getIndicatorValue(Indicator.INTERNAL);
            if (value == null || value.isEmpty()) return null;
            return InternalFormat.parse(value).toInstant();
        } catch (ParseException e) {
            return null;
        }
    }

    public static Instant instantOf(NodeItem node, String attribute) {
        try {
            String value = node.getAttribute(attribute);
            if (value == null || value.isEmpty()) return null;
            return Format.parse(value).toInstant();
        } catch (ParseException e) {
            return null;
        }
    }

    public static Instant instantOf(Reference reference, String attribute) {
        return instantOf((Date) reference.getAttribute(attribute).getValue());
    }

    public static Instant instantOf(FieldDate field) {
        return instantOf(field.get());
    }

    public static Instant instantOf(Date date) {
        if (date == null) return null;
        return date.getValue().toInstant();
    }

    public static URL urlOf(Reference reference, String attribute, boolean preview) {
        return urlOf((Picture) reference.getAttribute(attribute).getValue(), preview);
    }

    public static URL urlOf(FieldPicture field, boolean preview) {
        return urlOf(field.get(), preview);
    }

    public static URL urlOf(FieldPicture field) {
        return urlOf(field.get(), false);
    }

    public static URL urlOf(Picture picture, boolean preview) {
        if (picture == null || picture.getFilename() == null) return null;
        return urlOf(picture.getFilename(), preview ? "1" : "0");
    }

    public static URL urlOf(Node node) {
        if (node == null) return null;
        return urlOf(node.getId(), "0");
    }

    public static URL urlOf(String id, String preview) {
        try {
            Map<String, String> params = new HashMap<>();
            params.put("id", id);
            if (preview.equals("1")) params.put("thumb", preview);
            String downloadUrl = ComponentDocuments.getInstance().getDownloadUrl(params);
            return new URL(downloadUrl + ((downloadUrl.contains("?") ? "&" : "?") + "r=" + Math.random()));
        } catch (MalformedURLException e) {
            Logger.error(e);
            return null;
        }
    }

    public static URL urlOf(FieldFile field) {
        return urlOf(field.get());
    }

    public static String contentTypeOf(FieldFile field) {
        return contentTypeOf(field.get());
    }

    public static String contentTypeOf(FieldPicture field) {
        return contentTypeOf(field.get());
    }

    public static String contentTypeOf(Node node) {
        if (node == null) return null;
        return contentTypeOf(node.getId());
    }

    public static URL urlOf(File file) {
        try {
            if (file == null || file.getFilename() == null) return null;
            Map<String, String> params = new HashMap<>();
            params.put("id", file.getFilename());
            return new URL(ComponentDocuments.getInstance().getDownloadUrl(params));
        } catch (MalformedURLException e) {
            Logger.error(e);
            return null;
        }
    }

    public static String contentTypeOf(File file) {
        if (file == null || file.getFilename() == null) return null;
        return contentTypeOf(file.getFilename());
    }

    public static String contentTypeOf(String id) {
        try {
            return ComponentDocuments.getInstance().getDocumentContentType(id);
        }
        catch (Throwable ex) {
            Logger.error(ex);
            return null;
        }
    }

    public static Picture pictureOf(Resource value) {
        if (value == null) return null;
        return Picture.fromInputStream(value.metadata().contentType(), value.stream());
    }

    public static Link linkOf(Node node, String attribute) {
        Attribute attributeObject = node.getAttribute(attribute);
        return attributeObject != null ? linkOf(attributeObject.getIndicatorValue(Indicator.NODE_LINK), attributeObject.getIndicatorValue(Indicator.VALUE)) : null;
    }

    public static List<Link> linksOf(List<NodeItem> links) {
        return links.stream().map(NodeHelper::linkOf).collect(Collectors.toList());
    }

    public static Link linkOf(List<NodeItem> selection) {
        return selection.size() > 0 ? linkOf(selection.get(0)) : null;
    }

    public static Link linkOf(NodeItem node) {
        return linkOf(node.getAttribute("id_node"), node.getAttribute("label"));
    }

    public static Link linkOf(Node node) {
        return linkOf(node.getId(), node.getLabel());
    }

    public static Link linkOf(String id, String label) {
        Link result = new Link();
        result.setId(id);
        result.setLabel(label);
        return result;
    }

    public static List<Term> termsOf(FieldSelectDatasource source, List<String> selection) {
        return selection.stream().map(source::item).collect(Collectors.toList());
    }

    public static Term termOf(FieldSelectDatasource source, List<String> selection) {
        return selection.size() > 0 ? source.item(selection.get(0)) : null;
    }

    public static Date dateOf(Instant value) {
        return value != null ? new Date(java.util.Date.from(value)) : null;
    }

    public static File fileOf(Resource resource) {
        return resource != null ? File.fromInputStream(resource.metadata().contentType(), resource.stream()) : null;
    }

    public static io.intino.alexandria.ui.File alexandriaFileOf(FieldFile file) {
        return alexandriaFileOf(file.get());
    }

    public static io.intino.alexandria.ui.File alexandriaFileOf(FieldPicture file) {
        return alexandriaFileOf(file.get());
    }

    public static io.intino.alexandria.ui.File alexandriaFileOf(File file) {
        return file != null ? new io.intino.alexandria.ui.File().value(urlOf(file)).mimeType(contentTypeOf(file)) : null;
    }

    public static String linkIdOf(FieldLink field) {
        Link link = field.get();
        return link != null ? link.getId() : null;
    }

    public static String canRemove(Node node) {
        if (node.isSingleton()) return "No se puede eliminar. El elemento está marcado como singleton.";
        if (node.isLinked()) return "No se puede eliminar. El elemento tiene relaciones con otros elementos.";
        return null;
    }

    public static Set<String> getFieldFilters(Node node, FieldProperty fieldDefinition, boolean mask) {
        Set<String> filtersSet = new LinkedHashSet<>();
        ArrayList<Object> tagList = null;

        if (fieldDefinition.isCheck()) {
            CheckFieldProperty.SelectProperty selectDefinition = ((CheckFieldProperty) fieldDefinition).getSelect();
            if (selectDefinition != null && selectDefinition.getFilter() != null)
                tagList = selectDefinition.getFilter().getTag();
        } else if (fieldDefinition.isSelect()) {
            SelectFieldProperty.SelectProperty selectDefinition = ((SelectFieldProperty) fieldDefinition).getSelect();
            if (selectDefinition != null && selectDefinition.getFilter() != null)
                tagList = selectDefinition.getFilter().getTag();
        }

        if (tagList == null)
            return filtersSet;

        for (Object tag : tagList) {
            String filterValue = "";

            if (tag instanceof String)
                filterValue = (String) tag;
            else if (tag instanceof Ref) {
                String fieldName = ((Ref) tag).getValue();
                filterValue = (mask) ? "_field:" + ((FormDefinition) node.getDefinition()).getField(fieldName).getCode() : node.getFieldValue(fieldName);
            }

            if (filterValue.isEmpty()) continue;

            filtersSet.add(filterValue);
        }

        return filtersSet;
    }

    public static List<DataRequest.GroupBy> groupsByOf(List<Filter> filters) {
        if (filters == null) return emptyList();
        return filters.stream().map(NodeHelper::groupByOf).flatMap(Collection::stream).filter(Objects::nonNull).collect(Collectors.toList());
    }

    private static List<DataRequest.GroupBy> groupByOf(Filter filter) {
        if (filter == null) return emptyList();
        else if (filter instanceof GroupFilter) return singletonList(groupByOf(filter.grouping(), ((GroupFilter) filter).groups()));
        else if (filter instanceof RangeFilter) {
            return Arrays.asList(groupByOf(filter.grouping(), ((RangeFilter) filter).from(), DataRequest.GroupBy.Operator.Gt),
                    groupByOf(filter.grouping(), ((RangeFilter) filter).to(), DataRequest.GroupBy.Operator.Lt));
        }
        return emptyList();
    }

    private static DataRequest.GroupBy groupByOf(String grouping, Set<String> groups) {
        return new DataRequest.GroupBy() {
            @Override
            public String attribute() {
                return grouping;
            }

            @Override
            public List<Object> values() {
                return new ArrayList<>(groups);
            }

            @Override
            public <T> T value(int i) {
                return null;
            }

            @Override
            public Operator operator() {
                return Operator.Eq;
            }
        };
    }

    private static DataRequest.GroupBy groupByOf(String grouping, Instant instant, DataRequest.GroupBy.Operator operator) {
        if (instant == null) return null;
        return new DataRequest.GroupBy() {
            @Override
            public String attribute() {
                return grouping;
            }

            @Override
            public List<Object> values() {
                return singletonList(java.util.Date.from(instant));
            }

            @Override
            public <T> T value(int i) {
                return null;
            }

            @Override
            public Operator operator() {
                return operator;
            }
        };
    }

    private static List<String> recentTaskTypes(Node node, NodeViewProperty view) {
        List<String> taskTypes = new ArrayList<>();
        if (view instanceof FormViewProperty) {
            FormViewProperty.ShowProperty showDefinition = ((FormViewProperty) view).getShow();
            for (Ref ref : showDefinition.getRecentTask().getTask()) {
                taskTypes.add(ref.getValue());
            }
        }
        return taskTypes;
    }

}