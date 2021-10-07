package io.intino.goros.unit.box.ui.datasources;

import io.intino.alexandria.ui.services.push.UISession;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.util.LayerHelper;
import io.intino.goros.unit.util.NodeHelper;
import org.monet.bpi.FieldMultiple;
import org.monet.bpi.FieldSelect;
import org.monet.bpi.types.Term;
import org.monet.bpi.types.TermList;
import org.monet.metamodel.SelectFieldProperty;
import org.monet.metamodel.SelectFieldPropertyBase;
import org.monet.metamodel.internal.Ref;
import org.monet.space.kernel.components.layers.NodeLayer;
import org.monet.space.kernel.components.layers.SourceLayer;
import org.monet.space.kernel.model.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FieldSelectDatasource extends TermDatasource {
    private final String source;
    private final SelectFieldProperty definition;

    public FieldSelectDatasource(UnitBox box, UISession session, Node node, FieldMultiple<?, ?> field) {
        this(box, session, node, sourceOf(field), (SelectFieldProperty) Dictionary.getInstance().getFieldDefinition(field.getCode()));
    }

    public FieldSelectDatasource(UnitBox box, UISession session, Node node, FieldSelect field) {
        this(box, session, node, field.getSource(), (SelectFieldProperty) field.getDefinition());
    }

    public FieldSelectDatasource(UnitBox box, UISession session, Node node, String source, SelectFieldProperty definition) {
        super(box, session, node);
        this.source = source;
        this.definition = definition;
    }

    public List<Term> items() {
        Collection<Term> result;
        if (definition.getTerms() != null) result = loadFromTerms();
        else result = loadFromSource();
        return new ArrayList<>(result);
    }

    public Term item(String key) {
        return items().stream().filter(i -> i.getLabel().equals(key)).findFirst().orElse(null);
    }

    private Collection<Term> loadFromTerms() {
        return new TermList(definition.getTerms().getTermPropertyList()).getAll();
    }

    private Collection<Term> loadFromSource() {
        SourceLayer sourceLayer = LayerHelper.sourceLayer();
        Ref sourceRef = definition.getSource();
        String source = this.source != null && !this.source.isEmpty() ? this.source : locateSourceIdFromContext(sourceRef.getValue(), definition.getSelect());
        String sourceId = locateSourceId(sourceRef.getValue(), source);
        TermList result = new TermList();

        if (sourceId != null && !sourceId.isEmpty()) result = new TermList(sourceLayer.loadSourceTerms(sourceLayer.loadSource(sourceId), request(), true));

        return result.getAll();
    }

    private DataRequest request() {
        SelectFieldProperty.SelectProperty selectDefinition = definition.getSelect();
        SelectFieldPropertyBase.SelectProperty.FlattenEnumeration flatten = selectDefinition != null ? selectDefinition.getFlatten() : null;
        Long depth = selectDefinition != null ? selectDefinition.getDepth() : null;
        Object root = selectDefinition != null ? selectDefinition.getRoot() : null;
        DataRequest result = new DataRequest();
        result.addParameter(DataRequest.MODE, (flatten != null && flatten.equals(SelectFieldPropertyBase.SelectProperty.FlattenEnumeration.ALL)) ? DataRequest.Mode.FLATTEN : DataRequest.Mode.TREE);
        result.addParameter(DataRequest.FLATTEN, (flatten != null) ? flatten.toString() : SelectFieldPropertyBase.SelectProperty.FlattenEnumeration.NONE.toString());
        result.addParameter(DataRequest.DEPTH, (depth != null) ? String.valueOf(depth) : null);
        result.addParameter(DataRequest.FROM, getSourceFrom(node, root));
        result.addParameter(DataRequest.FILTERS, SerializerData.serializeSet(NodeHelper.getFieldFilters(node, definition, false)));
        return result;
    }

    private static String sourceOf(FieldMultiple<?, ?> field) {
        return field.getCount() > 0 ? ((FieldSelect) field.getAllFields().get(0)).getSource() : null;
    }

}