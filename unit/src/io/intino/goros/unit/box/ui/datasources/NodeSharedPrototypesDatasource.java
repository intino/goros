package io.intino.goros.unit.box.ui.datasources;

import io.intino.alexandria.ui.services.push.UISession;
import io.intino.goros.unit.box.UnitBox;
import org.monet.metamodel.NodeViewProperty;
import org.monet.space.kernel.model.Node;

public class NodeSharedPrototypesDatasource extends NodeDatasource {

    public NodeSharedPrototypesDatasource(UnitBox box, UISession session, Node node, NodeViewProperty view) {
        super(box, session, node, view,"sharedprototypes");
    }

}