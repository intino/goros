package io.intino.goros.unit.util;

import org.monet.metamodel.*;
import org.monet.metamodel.FormDefinitionBase.FormViewProperty;
import org.monet.metamodel.SetDefinition.SetViewProperty;
import org.monet.space.kernel.model.BusinessUnit;
import org.monet.space.kernel.model.Dictionary;
import org.monet.space.kernel.model.Node;
import org.monet.space.kernel.model.Task;

public class DictionaryHelper {

    public static AbstractManifestBase.DefaultLocationProperty defaultLocation() {
        BusinessUnit businessUnit = BusinessUnit.getInstance();
        AbstractManifestBase.DefaultLocationProperty defaultLocation = businessUnit.getDistribution().getDefaultLocation();
        if (defaultLocation == null) defaultLocation = businessUnit.getBusinessModel().getProject().getDefaultLocation();
        return defaultLocation;
    }

    public static NodeViewProperty view(Node node, String code) {
        return node.getDefinition().getViewDefinitionList().stream().filter(v -> v.getCode().equals(code)).findFirst().orElse(null);
    }

    public static boolean isSystemView(NodeViewProperty view) {
        if (view instanceof ContainerDefinition.ViewProperty) {
            ContainerDefinition.ViewProperty.ShowProperty showDefinition = ((ContainerDefinition.ViewProperty) view).getShow();
            return showDefinition.getLinksIn() != null || showDefinition.getLinksOut() != null ||
                    showDefinition.getNotes() != null || showDefinition.getRevisions() != null ||
                    showDefinition.getTasks() != null || showDefinition.getLocation() != null || showDefinition.getRecentTask() != null;
        }

        if (view instanceof SetViewProperty) {
            SetViewProperty.ShowProperty showDefinition = ((SetViewProperty) view).getShow();
            return (showDefinition.getOwnedPrototypes() != null || showDefinition.getSharedPrototypes() != null);
        }

        if (view instanceof FormViewProperty) {
            FormViewProperty.ShowProperty showDefinition = ((FormViewProperty) view).getShow();

            return showDefinition.getLinksIn() != null || showDefinition.getLinksOut() != null ||
                    showDefinition.getNotes() != null || showDefinition.getRevisions() != null || showDefinition.getTasks() != null ||
                    showDefinition.getAttachments() != null || showDefinition.getLocation() != null || showDefinition.getRecentTask() != null;
        }

        return false;
    }

    public static String referenceLabel(Node node) {
        NodeDefinition definition = node.getDefinition();
        if (!definition.isSet()) return "";
        IndexDefinition indexDefinition = Dictionary.getInstance().getIndexDefinition(((SetDefinition) definition).getIndex().getValue());
        return indexDefinition != null ? indexDefinition.getLabelString().toLowerCase() : "";
    }

}
