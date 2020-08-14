package io.intino.goros.box.ui.datasources;

import io.intino.alexandria.ui.services.push.UISession;
import org.monet.bpi.types.Term;
import org.monet.metamodel.SourceDefinition;
import org.monet.metamodel.internal.Ref;
import org.monet.space.kernel.model.Dictionary;
import org.monet.space.kernel.model.Node;
import org.monet.space.kernel.model.Source;
import io.intino.goros.box.GorosBox;
import io.intino.goros.util.LayerHelper;

import java.util.List;

public abstract class TermDatasource {
    protected final GorosBox box;
    protected final UISession session;
    protected final Node node;

    public TermDatasource(GorosBox box, UISession session, Node node) {
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