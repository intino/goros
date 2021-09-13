package io.intino.goros.unit.box.ui.datasources;

import io.intino.alexandria.ui.services.push.UISession;
import io.intino.goros.unit.box.UnitBox;
import org.monet.metamodel.NodeViewProperty;
import org.monet.space.kernel.model.Node;

public class NodeLinksOutDatasource extends NodeDatasource {

    public NodeLinksOutDatasource(UnitBox box, UISession session, Node node, String view) {
        this(box, session, node, node.getDefinition().getNodeView(view));
    }

    public NodeLinksOutDatasource(UnitBox box, UISession session, Node node, NodeViewProperty view) {
        super(box, session, node, view, "linksout");
    }

}