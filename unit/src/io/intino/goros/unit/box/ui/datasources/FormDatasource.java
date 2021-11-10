package io.intino.goros.unit.box.ui.datasources;

import io.intino.alexandria.ui.services.push.UISession;
import io.intino.goros.unit.box.UnitBox;
import org.monet.bpi.Field;
import org.monet.bpi.NodeForm;
import org.monet.bpi.NodeService;
import org.monet.bpi.java.NodeFormImpl;
import org.monet.metamodel.NodeDefinition;
import org.monet.metamodel.internal.TaskOrderDefinition;
import org.monet.space.kernel.model.Node;

public class FormDatasource {
    private final UnitBox box;
    private final UISession session;
    private final NodeForm nodeForm;

    public FormDatasource(UnitBox box, UISession session, Node node) {
        this.box = box;
        this.session = session;
        this.nodeForm = locateForm(node);
    }

    private NodeForm locateForm(Node node) {
        boolean isTaskOrderDefinition = node.getDefinition().getCode().equals(TaskOrderDefinition.CODE);
        if (!isTaskOrderDefinition) return (NodeForm) NodeService.get(node.getId());
        NodeFormImpl result = new NodeFormImpl() {
            @Override
            public void transform() {
            }
        };
        result.injectNode(node);
        return result;
    }

    public <T, F extends Field<V>, V> T getField(String code) {
        return nodeForm.getField(code);
    }

}