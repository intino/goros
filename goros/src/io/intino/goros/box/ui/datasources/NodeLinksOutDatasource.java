package io.intino.goros.box.ui.datasources;

import io.intino.alexandria.ui.services.push.UISession;
import org.monet.metamodel.NodeViewProperty;
import org.monet.space.kernel.model.Node;
import io.intino.goros.box.GorosBox;

public class NodeLinksOutDatasource extends NodeDatasource {

    public NodeLinksOutDatasource(GorosBox box, UISession session, Node node, NodeViewProperty view) {
        super(box, session, node, view, "linksout");
    }

}