package io.intino.goros.box.ui.datasources;

import io.intino.alexandria.ui.services.push.UISession;
import org.monet.bpi.FieldCheck;
import org.monet.bpi.types.Term;
import org.monet.bpi.types.TermList;
import org.monet.metamodel.CheckFieldProperty;
import org.monet.metamodel.FormDefinition;
import org.monet.metamodel.internal.Ref;
import org.monet.space.kernel.components.layers.SourceLayer;
import org.monet.space.kernel.model.DataRequest;
import org.monet.space.kernel.model.Node;
import org.monet.space.kernel.model.SerializerData;
import io.intino.goros.box.GorosBox;
import io.intino.goros.util.LayerHelper;
import io.intino.goros.util.NodeHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FieldCheckDatasource extends TermDatasource {
    private final FieldCheck field;
    private final CheckFieldProperty definition;

    public FieldCheckDatasource(GorosBox box, UISession session, Node node, FieldCheck field) {
        super(box, session, node);
        this.field = field;
        this.definition = (CheckFieldProperty) ((FormDefinition)node.getDefinition()).getField(field.getCode());
    }

    public List<Term> items() {
        Collection<Term> result;
        if (definition.getTerms() != null) result = loadFromTerms();
        else if (definition.getSource() != null) result = loadFromSource();
        else result = loadFromCheckList();
        return new ArrayList<>(result);
    }

    private Collection<Term> loadFromTerms() {
        TermList termList = new TermList(definition.getTerms().getTermPropertyList());
        if (termList.getAll().size() == 0) termList = field.get().toTermList();
        return termList.getAll();
    }

    private Collection<Term> loadFromSource() {
        SourceLayer sourceLayer = LayerHelper.sourceLayer();
        Ref sourceRef = definition.getSource();
        CheckFieldProperty.SelectProperty checkDefinition = definition.getSelect();
        String sourceId = locateSourceId(sourceRef.getValue(), field.getSource());
        TermList result = new TermList();

        String from = field.getFrom();
        if (from.isEmpty()) from = getSourceFrom(node, checkDefinition != null ? checkDefinition.getRoot() : null);
        if (sourceId != null && !sourceId.isEmpty()) result = new TermList(sourceLayer.loadSourceTerms(sourceLayer.loadSource(sourceId), request(from), true));

        return result.getAll();
    }

    private Collection<Term> loadFromCheckList() {
        return field.get().toTermList().getAll();
    }

    private DataRequest request(String from) {
        CheckFieldProperty.SelectProperty selectDefinition = definition.getSelect();
        DataRequest result = new DataRequest();
        result.addParameter(DataRequest.MODE, (selectDefinition != null && selectDefinition.getFlatten() != null && selectDefinition.getFlatten().equals(CheckFieldProperty.SelectProperty.FlattenEnumeration.ALL)) ? DataRequest.Mode.FLATTEN : DataRequest.Mode.TREE);
        result.addParameter(DataRequest.FLATTEN, (selectDefinition != null && selectDefinition.getFlatten() != null) ? selectDefinition.getFlatten().toString() : CheckFieldProperty.SelectProperty.FlattenEnumeration.NONE.toString());
        result.addParameter(DataRequest.DEPTH, (selectDefinition != null && selectDefinition.getDepth() != null) ? String.valueOf(selectDefinition.getDepth()) : null);
        result.addParameter(DataRequest.FROM, from);
        result.addParameter(DataRequest.FILTERS, SerializerData.serializeSet(NodeHelper.getFieldFilters(node, definition, false)));
        return result;
    }

}