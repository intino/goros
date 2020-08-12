package org.siani.goros.box.ui.datasources;

import io.intino.alexandria.ui.services.push.UISession;
import org.monet.bpi.Field;
import org.monet.bpi.NodeForm;
import org.monet.bpi.NodeService;
import org.monet.space.kernel.model.Node;
import org.siani.goros.box.GorosBox;

public class FormDatasource {
    private final GorosBox box;
    private final UISession session;
    private final NodeForm nodeForm;

    public FormDatasource(GorosBox box, UISession session, Node node) {
        this.box = box;
        this.session = session;
        this.nodeForm = (NodeForm) NodeService.get(node.getId());
    }

    public <T, F extends Field<V>, V> T getField(String code) {
        return nodeForm.getField(code);
    }

}