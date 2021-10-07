package io.intino.goros.unit.box.ui.datasources;

import io.intino.alexandria.ui.services.push.UISession;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.util.LayerHelper;
import org.monet.bpi.types.Term;
import org.monet.metamodel.CheckFieldProperty;
import org.monet.metamodel.FieldPropertyBase;
import org.monet.metamodel.SelectFieldPropertyBase;
import org.monet.metamodel.SourceDefinition;
import org.monet.metamodel.internal.Ref;
import org.monet.space.kernel.model.Dictionary;
import org.monet.space.kernel.model.Node;
import org.monet.space.kernel.model.Source;
import org.monet.space.kernel.model.SourceList;

import java.util.List;

public abstract class TermDatasource {
    protected final UnitBox box;
    protected final UISession session;
    protected final Node node;

    public TermDatasource(UnitBox box, UISession session, Node node) {
        this.box = box;
        this.session = session;
        this.node = node;
    }

    public abstract List<Term> items();

    protected String locateSourceId(String sourceKey, String sourceId) {
        if (sourceId != null && !sourceId.isEmpty()) return sourceId;
        if (sourceKey == null) return null;
        String codeSource = Dictionary.getInstance().getDefinitionCode(sourceKey);
        Source<SourceDefinition> source = LayerHelper.sourceLayer().locateSource(codeSource, null);
        return source != null ? source.getId() : null;
    }

    protected String locateSourceIdFromContext(String sourceKey, SelectFieldPropertyBase.SelectProperty select) {
        if (select == null || select.getContext() == null) return null;
        Object ref = select.getContext();
        if (!(ref instanceof Ref)) return null;
        String sourceCode = Dictionary.getInstance().getDefinitionCode(sourceKey);
        String field = ((Ref) ref).getValue();
        String context = LayerHelper.nodeLayer().loadNode(node.getFieldValue(field)).getPartnerContext();
        SourceList sources = locateSources(sourceCode, context);
        return sources.get().size() > 0 ? sources.get().values().iterator().next().getId() : null;
    }

    protected SourceList locateSources(String sourceKey, String context) {
        return LayerHelper.sourceLayer().loadSourceList(sourceKey, context);
    }

    protected String getSourceFrom(Node node, Object from) {
        String fromParameter = "";

        if (from == null)
            return fromParameter;

        if (from instanceof String)
            fromParameter = (String) from;
        else if (from instanceof Ref) {
            String fieldName = ((Ref) from).getValue();
            fromParameter = node.getFieldValue(fieldName);
        }

        return fromParameter;
    }

}