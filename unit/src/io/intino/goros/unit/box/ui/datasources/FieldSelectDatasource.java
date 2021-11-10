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
import org.monet.metamodel.TermProperty;
import org.monet.metamodel.internal.Ref;
import org.monet.space.kernel.components.layers.SourceLayer;
import org.monet.space.kernel.model.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

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

    public List<Term> allItems() {
        return items(true);
    }

    public List<Term> items() {
        return items(false);
    }

    public List<Term> items(boolean all) {
        TermList result;
        if (definition.getTerms() != null) result = loadFromTerms();
        else result = loadFromSource(all);
        return sorted(result);
    }

    public Term item(String key) {
        return items().stream().filter(i -> i.getLabel().equals(key)).findFirst().orElse(null);
    }

    private TermList loadFromTerms() {
        return new TermList(definition.getTerms().getTermPropertyList());
    }

    private TermList loadFromSource(boolean all) {
        SourceLayer sourceLayer = LayerHelper.sourceLayer();
        Ref sourceRef = definition.getSource();
        String source = this.source != null && !this.source.isEmpty() ? this.source : locateSourceIdFromContext(sourceRef.getValue(), definition.getSelect());
        String sourceId = locateSourceId(sourceRef.getValue(), source);
        TermList result = new TermList();
        if (sourceId != null && !sourceId.isEmpty()) result = terms(sourceLayer.loadSourceTerms(sourceLayer.loadSource(sourceId), request(), !all));
        return result;
    }

    private TermList terms(org.monet.space.kernel.model.TermList monetTermList) {
        TermList result = new TermList();
        monetTermList.forEach(term -> result.add(termOf(term)));
        return result;
    }

    private Term termOf(org.monet.space.kernel.model.Term term) {
        return new Term(term.getCode(), labelOf(term));
    }

    private String labelOf(org.monet.space.kernel.model.Term term) {
        return mode().equals(DataRequest.Mode.FLATTEN) ? term.getFlattenLabel() : term.getLabel();
    }

    private DataRequest request() {
        SelectFieldProperty.SelectProperty selectDefinition = definition.getSelect();
        SelectFieldPropertyBase.SelectProperty.FlattenEnumeration flatten = selectDefinition != null ? selectDefinition.getFlatten() : null;
        Long depth = selectDefinition != null ? selectDefinition.getDepth() : null;
        Object root = selectDefinition != null ? selectDefinition.getRoot() : null;
        DataRequest result = new DataRequest();
        result.setStartPos(0);
        result.setLimit(-1);
        result.addParameter(DataRequest.MODE, mode());
        result.addParameter(DataRequest.FLATTEN, (flatten != null) ? flatten.toString() : SelectFieldPropertyBase.SelectProperty.FlattenEnumeration.ALL.toString());
        result.addParameter(DataRequest.DEPTH, (depth != null) ? String.valueOf(depth) : null);
        result.addParameter(DataRequest.FROM, getSourceFrom(node, root));
        result.addParameter(DataRequest.FILTERS, SerializerData.serializeSet(NodeHelper.getFieldFilters(node, definition, false)));
        return result;
    }

    private String mode() {
        SelectFieldProperty.SelectProperty selectDefinition = definition.getSelect();
        SelectFieldPropertyBase.SelectProperty.FlattenEnumeration flatten = selectDefinition != null ? selectDefinition.getFlatten() : null;
        return flatten == null || flatten.equals(SelectFieldPropertyBase.SelectProperty.FlattenEnumeration.ALL) ? DataRequest.Mode.FLATTEN : DataRequest.Mode.TREE;
    }

    private static String sourceOf(FieldMultiple<?, ?> field) {
        return field.getCount() > 0 ? ((FieldSelect) field.getAllFields().get(0)).getSource() : null;
    }

}