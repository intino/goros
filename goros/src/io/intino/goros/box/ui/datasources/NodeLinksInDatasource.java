package io.intino.goros.box.ui.datasources;

import io.intino.alexandria.ui.services.push.UISession;
import org.monet.metamodel.NodeViewProperty;
import org.monet.space.kernel.model.Node;
import io.intino.goros.box.GorosBox;

public class NodeLinksInDatasource extends NodeDatasource {

    public NodeLinksInDatasource(GorosBox box, UISession session, Node node, NodeViewProperty viewProperty) {
        super(box, session, node, viewProperty, "linksin");
    }

}