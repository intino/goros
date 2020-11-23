package io.intino.goros.unit.box.ui.datasources;

import io.intino.alexandria.ui.services.push.UISession;
import io.intino.goros.unit.box.UnitBox;
import org.monet.metamodel.NodeViewProperty;
import org.monet.space.kernel.model.Node;

public class NodeOwnedPrototypesDatasource extends NodeDatasource {

    public NodeOwnedPrototypesDatasource(UnitBox box, UISession session, Node node, NodeViewProperty view) {
        super(box, session, node, view,"ownedprototypes");
    }

}