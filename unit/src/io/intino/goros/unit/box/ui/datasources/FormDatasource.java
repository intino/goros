package io.intino.goros.unit.box.ui.datasources;

import io.intino.alexandria.ui.services.push.UISession;
import io.intino.goros.unit.box.UnitBox;
import org.monet.bpi.Field;
import org.monet.bpi.NodeForm;
import org.monet.bpi.NodeService;
import org.monet.space.kernel.model.Node;

public class FormDatasource {
    private final UnitBox box;
    private final UISession session;
    private final NodeForm nodeForm;

    public FormDatasource(UnitBox box, UISession session, Node node) {
        this.box = box;
        this.session = session;
        this.nodeForm = (NodeForm) NodeService.get(node.getId());
    }

    public <T, F extends Field<V>, V> T getField(String code) {
        return nodeForm.getField(code);
    }

}