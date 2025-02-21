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
import org.monet.space.kernel.agents.AgentLogger;
import org.monet.space.kernel.agents.AgentNotifier;
import org.monet.space.kernel.agents.AgentUserClient;
import org.monet.space.kernel.components.ComponentDocuments;
import org.monet.space.kernel.components.layers.NodeLayer;
import org.monet.space.kernel.constants.LabelCode;
import org.monet.space.kernel.constants.Strings;
import org.monet.space.kernel.model.Dictionary;
import org.monet.space.kernel.model.*;
import org.monet.space.kernel.utils.MimeTypes;
import org.monet.space.kernel.utils.StreamHelper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Dimension;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static io.intino.goros.unit.util.LayerHelper.nodeLayer;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;

public class NodeHelper {
    private static final SimpleDateFormat InternalFormat = new SimpleDateFormat("dd/MM/yyyy/HH:mm:ss");
    private static final SimpleDateFormat Format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static final String OperationShowNode = "shownode";
    public static final String OperationShowNodeView = "shownodeview";
    public static final String OperationShowTask = "showtask";
    public static final String OperationParamId = "Id";
    public static final String OperationParamIdView = "IdView";

    public static Node singleton(String code) {
        return nodeLayer().locateNode(code);
    }

    public static String nameOf(Node node) {
        return PathHelper.nameOf(node.getDefinition());
    }

    public static int countItems(Node node, NodeDataRequest request) {
        IndexDefinition index = Dictionary.getInstance().getIndexDefinition(((SetDefinition)node.getDefinition()).getIndex().getValue());
        request.setCodeReference(index.getCode());
        return LayerHelper.nodeLayer().requestNodeListItemsCount(node.getId(), request);
    }

	public static InputStream download(UnitBox box, Node node, NodeDataRequest request, String format, List<String> columns, String language) {
        return new SetPrinter(box, node, request, format, columns).print(language);
    }

    public static boolean isEnvironment(Node node) {
        NodeDefinition definition = node.getDefinition();
        if (definition instanceof ContainerDefinition) return node.getDefinition().isEnvironment();
        return false;
    }

    public static String getEnvironmentNodeId(Account account, String key) {
        Node result = getEnvironmentNode(account, key);
        return result != null ? result.getId() : null;
    }

    public static Node getEnvironmentNode(Account account, String key) {
        Dictionary dictionary = Dictionary.getInstance();
        NodeDefinition definition = dictionary.getNodeDefinition(key);
        String code = definition.getCode();
        Node result = null;

        if (definition.isDesktop())
            result = LayerHelper.nodeLayer().locateNode(code);
        else if (definition.isEnvironment()) {
            ArrayList<Node> environmentNodes = account.getEnvironmentNodes();
            for (Node environmentNode : environmentNodes) {
                if (environmentNode.getDefinition().getCode().equals(code))
                    return environmentNode;
            }
        }

        return result;
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

    public static ClientOperation clientOperationOf(Revision revision) {
        return clientOperationOf(revision.getIdNode(), null);
    }

    public static ClientOperation clientOperationOf(Node<?> node) {
        return clientOperationOf(node.getId(), null);
    }

    public static ClientOperation clientOperationOf(String node, String view) {
        Map<String, String> data = new HashMap<>() {{ put("Id", node); put("IdView", view); }};
        return new ClientOperation(view != null ? OperationShowNodeView : OperationShowNode, new net.minidev.json.JSONObject(data));
    }

    public static String internalValueOf(Instant instant) {
        if (instant == null) return null;
        return InternalFormat.format(java.util.Date.from(instant));
    }

    public static Node copyNode(Node node, String languageCode) {
        Language language = Language.getInstance();
        NodeLayer nodeLayer = nodeLayer();
        Node newNode = node.isPrototype() ? nodeLayer.addPrototype(node.getCode(), node.getParent()) : nodeLayer.addNode(node.getCode(), node.getParent());
        String date = Formatters.shortDate(java.time.Instant.now());
        String label = node.isPrototype() ? language.getLabel(LabelCode.CLONE_FROM, languageCode) + Strings.SPACE + node.getLabel() : node.getLabel();
        String description = node.isPrototype() ? node.getDescription() + Strings.SPACE + language.getLabel(LabelCode.CLONE_AT, languageCode) + Strings.SPACE + date + Strings.DOT : node.getDescription();
        nodeLayer.copyNode(newNode, node, label, description);
        return newNode;
    }

    public static UIFile downloadOperation(Actionable actionable, Node node, String operation) {
        actionable.readonly(true);
        Node current = nodeLayer().loadNode(node.getId());
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

    public static boolean isOperationConfirmationRequired(Node node, String operation) {
        OperationConfirmation confirmation = new OperationConfirmation();
        Node current = nodeLayer().loadNode(node.getId());
        MonetEvent event = new MonetEvent(MonetEvent.NODE_EXECUTE_COMMAND_CONFIRMATION_WHEN, null, current);
        event.addParameter(MonetEvent.PARAMETER_COMMAND, operation);
        event.addParameter(MonetEvent.PARAMETER_COMMAND_CONFIRMATION_REQUIRED, confirmation);
        AgentNotifier.getInstance().notify(event);
        return confirmation.isRequired();
    }

    public static NodeDefinitionBase.OperationProperty operation(Node node, String name) {
        return node.getDefinition().getOperationMap().getOrDefault(name, null);
    }

    public static void executeOperation(UISession session, Actionable<?, ?> actionable, Node<?> node, String operation, String successMessage, DisplayRouteDispatcher dispatcher) {
        executeOperation(session, actionable, node, operation, successMessage, clientOperation -> dispatchOperation(dispatcher, session, clientOperation));
    }

    public static void executeOperation(UISession session, Actionable actionable, Node node, String operation, String successMessage, Consumer<ClientOperation> dispatcher) {
        actionable.readonly(true);
        Node current = nodeLayer().loadNode(node.getId());
        MonetEvent event = new MonetEvent(MonetEvent.NODE_EXECUTE_COMMAND, null, current);
        event.addParameter(MonetEvent.PARAMETER_COMMAND, operation);
        AgentNotifier.getInstance().notify(event);
        actionable.readonly(false);
        ClientOperation clientOperation = AgentUserClient.getInstance().getOperationForUser(Thread.currentThread().getId());
        String message = agentUserClientMessage();

        if (dispatcher != null) dispatcher.accept(clientOperation);

        if (clientOperation != null) {
            if (message != null) actionable.notifyUser(successMessage, UserMessage.Type.Info);
        }
        else {
            if (message != null) actionable.notifyUser(message, UserMessage.Type.Error);
        }
    }

    public static void cancelOperation(UISession session, Actionable actionable, Node node, String operation, String successMessage, DisplayRouteDispatcher dispatcher) {
        cancelOperation(session, actionable, node, operation, successMessage, clientOperation -> {});
    }

    public static void cancelOperation(UISession session, Actionable actionable, Node node, String operation, String successMessage, Consumer<ClientOperation> dispatcher) {
        actionable.readonly(true);
        Node current = nodeLayer().loadNode(node.getId());
        MonetEvent event = new MonetEvent(MonetEvent.NODE_EXECUTE_COMMAND_CONFIRMATION_ON_CANCEL, null, current);
        event.addParameter(MonetEvent.PARAMETER_COMMAND, operation);
        AgentNotifier.getInstance().notify(event);
        actionable.readonly(false);
        String message = agentUserClientMessage();
        if (message == null) return;
        actionable.notifyUser(successMessage, UserMessage.Type.Info);
    }

    public static String valueOrDefault(FieldDate field) {
        if (field == null || field.get() == null) return "Sin definir";
        return field.get().getFormattedValue();
    }

    public static String valueOrDefault(FieldLink field) {
        if (field == null || field.get() == null) return "Sin definir";
        return field.get().getLabel();
    }

    private static String agentUserClientMessage() {
        String message = AgentUserClient.getInstance().getMessageForUser(Thread.currentThread().getId());
        AgentUserClient.getInstance().clear(Thread.currentThread().getId());
        return message;
    }

    public static Entity<?> operationEntity(ClientOperation operation) {
        String name = operation.getName().toLowerCase();
        String id = operation.getData().get(OperationParamId).toString();
        if (OperationShowNode.equals(name) || OperationShowNodeView.equals(name)) return nodeLayer().loadNode(id);
        else if (OperationShowTask.equals(name)) return LayerHelper.taskLayer().loadTask(operation.getData().get(OperationParamId).toString());
        return null;
    }

    public static String operationPath(ClientOperation operation) {
        Entity<?> entity = operationEntity(operation);
        String name = operation.getName().toLowerCase();
        String mode = operation.getData().get("Mode") != null ? operation.getData().get("Mode").toString() : null;
        boolean readonly = mode == null || !mode.contains("edit.html");
        if (OperationShowNode.equals(name)) return PathHelper.pathOf((Node<?>) entity, null, readonly ? "default" : "edit");
        else if (OperationShowNodeView.equals(name)) return PathHelper.pathOf((Node<?>) entity, operation.getData().get(OperationParamIdView).toString(), readonly ? "default" : "edit");
        else if (OperationShowTask.equals(name)) return PathHelper.pathOf((Task<?>) entity);
        return null;
    }

    public static void dispatchOperation(DisplayRouteDispatcher dispatcher, UISession session, ClientOperation operation) {
        if (operation == null) return;
        Soul soul = session.client().soul();
        dispatcher.dispatch(soul, operationPath(operation));
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

    public static Node nodeOf(MonetLink link) {
        if (link == null) return null;
        return nodeLayer().loadNode(link.getId());
    }

    public static Node nodeOf(Link link) {
        if (link == null) return null;
        return nodeLayer().loadNode(link.getId());
    }

    public static NodeItem nodeItemOf(Link link) {
        if (link == null) return null;
        NodeItem result = new NodeItem();
        result.addAttribute("id_node", link.getId());
        result.addAttribute("label", link.getLabel());
        return result;
    }

    public static List<NodeItem> nodeItemsOf(List<Link> links) {
        return links.stream().map(NodeHelper::nodeItemOf).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public static CheckList checkListOf(CheckList checkList, List<String> selection) {
        checkList.getAll().forEach(check -> check.setChecked(selection.contains(check.getLabel())));
        return checkList;
    }

    public static List<String> selectionOf(List<Term> termList, CheckList checkList) {
        return checkList.getAll().stream().filter(Check::isChecked).map(c -> {
            Term term = termOf(termList, c);
            return term != null ? term.getLabel() : null;
        }).filter(Objects::nonNull).collect(toList());
    }

    private static Term termOf(List<Term> source, Check check) {
        return source.stream().filter(t -> t.getKey().equals(check.getCode())).findFirst().orElse(null);
    }

    public static List<String> selectionOf(CheckList checkList) {
        return checkList.getAll().stream().filter(Check::isChecked).map(Check::getLabel).collect(toList());
    }

    public static List<String> selectionOf(List<Term> source, List<Term> terms) {
        return terms.stream().map(t -> {
            Term term = findTerm(t, source);
            return term != null ? term.getLabel() : null;
        }).filter(Objects::nonNull).collect(toList());
    }

    public static List<String> selectionOf(List<Term> terms) {
        return terms.stream().map(Term::getLabel).collect(toList());
    }

    public static List<String> selectionOf(List<Term> source, Term term) {
        if (term == null) return emptyList();
        Term selected = findTerm(term, source);
        return singletonList(selected != null ? selected.getLabel() : term.getLabel());
    }

    public static List<String> selectionOf(Term term) {
        return term != null ? singletonList(term.getLabel()) : Collections.emptyList();
    }

    private static Term findTerm(Term term, List<Term> source) {
        if (term == null) return null;
        return source.stream().filter(t -> t.getKey().equals(term.getKey())).findFirst().orElse(term);
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
        ReferenceAttribute<?> referenceAttribute = reference.getAttribute(attribute);
        if (referenceAttribute == null) return null;
        return instantOf((Date) referenceAttribute.getValue());
    }

    public static Instant instantOf(FieldDate field) {
        return instantOf(field.get());
    }

    public static Instant instantOf(Date date) {
        if (date == null) return null;
        return date.getValue().toInstant();
    }

    public static URL urlOf(Reference reference, String attribute, boolean preview) {
        ReferenceAttribute<?> picture = reference.getAttribute(attribute);
        if (picture == null) return null;
        return urlOf((Picture) picture.getValue(), preview);
    }

    public static URL urlOf(FieldPicture field, boolean preview) {
        return urlOf(field.get(), preview);
    }

    public static URL urlOf(FieldPicture field) {
        return urlOf(field.get(), false);
    }

    public static URL urlOf(Picture picture, boolean preview) {
        if (picture == null || picture.getFilename() == null) return null;
        return urlOf(URLEncoder.encode(picture.getFilename(), StandardCharsets.UTF_8), preview ? "1" : "0");
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
            params.put("id", URLEncoder.encode(file.getFilename(), StandardCharsets.UTF_8));
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

    public static Picture pictureOf(Resource value, int width, int height) {
        if (value == null) return null;
        InputStream sourceStream = value.stream();
        try {
            String contentType = value.metadata().contentType();
            BufferedImage image = imageOf(sourceStream);
            ComponentDocuments.getInstance().uploadImage(value.name(), image == null || isSmaller(image, width, height) ? sourceStream : reduce(image, value.metadata().contentType(), width, height), contentType, width, height);
        } catch (Exception e) {
            Logger.error(e);
        } finally {
            StreamHelper.close(sourceStream);
        }
        return new Picture(value.name());
    }

    public static Picture pictureOf(Resource value) {
        if (value == null) return null;
        return Picture.fromInputStream(value.name(), value.metadata().contentType(), value.stream());
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
        return resource != null ? File.fromInputStream(resource.name(), resource.metadata().contentType(), resource.stream()) : null;
    }

    public static io.intino.alexandria.ui.File alexandriaFileOf(FieldFile file) {
        return alexandriaFileOf(file.get());
    }

    public static io.intino.alexandria.ui.File alexandriaFileOf(FieldPicture file) {
        return alexandriaFileOf(file.get());
    }

    public static io.intino.alexandria.ui.File alexandriaFileOf(File file) {
        if (file == null) return null;
        String filename = file.getFilename();
        if (!filename.contains(".")) filename += "." + org.monet.space.kernel.utils.MimeTypes.getInstance().getExtension(contentTypeOf(file));
        return new io.intino.alexandria.ui.File().value(urlOf(file)).mimeType(contentTypeOf(file)).filename(filename);
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

    public static String filtersMessage(Node node, List<Filter> filters) {
        IndexDefinition definition = Dictionary.getInstance().getIndexDefinition(((SetDefinition)node.getDefinition()).getIndex().getValue());
        return filters.stream().map(f -> filterMessage(definition, f)).filter(Objects::nonNull).collect(Collectors.joining(", "));
    }

    private static String filterMessage(IndexDefinition definition, Filter filter) {
        if (filter instanceof GroupFilter) return groupFilterMessage(definition, filter);
        else if (filter instanceof RangeFilter) return rangeFilterMessage(definition, filter);
        return null;
    }

    private static String groupFilterMessage(IndexDefinition definition, Filter f) {
        GroupFilter filter = (GroupFilter) f;
        if (filter.groups().isEmpty()) return "";
        AttributeProperty attributeDefinition = definition.getAttribute(filter.grouping());
        if (attributeDefinition == null) return "";
        return attributeDefinition.getLabel() + "(" + String.join(", ", filter.groups()) + ")";
    }

    private static String rangeFilterMessage(IndexDefinition definition, Filter f) {
        AttributeProperty attributeDefinition = definition.getAttribute(f.grouping());
        if (attributeDefinition == null) return "";
        RangeFilter rangeFilter = (RangeFilter)f;
        if (rangeFilter.from() == null || rangeFilter.to() == null) return null;
        String from = Formatters.shortDate(rangeFilter.from());
        String to = Formatters.shortDate(rangeFilter.to());
        return attributeDefinition.getLabel() + "(" + from + " - " + to + ")";
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

    public static List<DataRequest.SortBy> sortsByOf(List<String> sortings) {
        if (sortings == null) return emptyList();
        return sortings.stream().map(NodeHelper::sortByOf).collect(Collectors.toList());
    }

    public static String sortingOf(String attribute, String mode) {
        return attribute + "#" + (mode.toLowerCase().startsWith("asc") ? "ASC" : "DESC");
    }

    private static DataRequest.SortBy sortByOf(String sorting) {
        String[] split = sorting.split("#");
        return new DataRequest.SortBy() {
            @Override
            public String attribute() {
                return split[0];
            }

            @Override
            public String mode() {
                return split.length > 1 ? split[1] : "ASC";
            }
        };
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

    private static BufferedImage imageOf(InputStream imageStream) {
        try {
            byte[] imageBytes = StreamHelper.readBytes(imageStream);
            return ImageIO.read(new ByteArrayInputStream(imageBytes));
        } catch (IOException e) {
            AgentLogger.getInstance().error(e);
            return null;
        }
    }

    private static boolean isSmaller(BufferedImage image, int width, int height) {
        return image.getWidth() <= width && image.getHeight() <= height;
    }

    private static InputStream reduce(BufferedImage image, String contentType, int width, int height) throws IOException {
        ByteArrayOutputStream imageTempOutput = new ByteArrayOutputStream();
        boolean alpha = hasAlpha(image, contentType);
        BufferedImage bdest = new BufferedImage(width, height, alpha ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bdest.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        Transform transform = getScaleFactor(image.getWidth(), image.getHeight(), width, height);

        if (transform == null) {
            g.drawImage(image, 0, 0, null);
        }
        else if (transform.type == Transform.Type.SCALE) {
            AffineTransform affineTransform = AffineTransform.getScaleInstance(transform.width, transform.height);
            g.translate((width - (image.getWidth()*transform.width)) / 2, 0);
            g.drawRenderedImage(image, affineTransform);
        }
        else if (transform.type == Transform.Type.TRANSLATE) {
            g.drawImage(image, Double.valueOf(transform.width).intValue(), Double.valueOf(transform.height).intValue(), null);
        }

        g.dispose();
        ImageIO.write(bdest, MimeTypes.getInstance().getExtension(contentType), imageTempOutput);

        return new ByteArrayInputStream(imageTempOutput.toByteArray());
    }

    private static boolean hasAlpha(Image image, String contentType) {
        PixelGrabber pg = new PixelGrabber(image, 0, 0, 1, 1, false);
        boolean alpha;
        String extension = MimeTypes.getInstance().getExtension(contentType);

        if (extension.equalsIgnoreCase("jpeg") || extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("jpe"))
            return false;

        try {
            pg.grabPixels();
            alpha = pg.getColorModel().hasAlpha();
        }
        catch(InterruptedException e) {
            alpha = false;
        }

        return alpha;
    }

    private static Transform getScaleFactor(int width, int height, int boundaryWidth, int boundaryHeight) {
        Dimension scaledDimension = getScaledDimension(width, height, boundaryWidth, boundaryHeight);
        return new Transform(Transform.Type.SCALE, (double)scaledDimension.width/width, (double)scaledDimension.height/height);
    }

    public static Dimension getScaledDimension(int width, int height, int boundaryWidth, int boundaryHeight) {
        int new_width = width;
        int new_height = height;

        if (width > boundaryWidth) {
            new_width = boundaryWidth;
            new_height = (new_width * height) / width;
        }

        if (new_height > boundaryHeight) {
            new_height = boundaryHeight;
            new_width = (new_height * width) / height;
        }

        return new Dimension(new_width, new_height);
    }

    private static class Transform {
        enum Type { SCALE, TRANSLATE }

        Transform.Type type;
        double width;
        double height;

        public Transform(Transform.Type type, double width, double height) {
            this.type = type;
            this.width = width;
            this.height = height;
        }
    }

}
