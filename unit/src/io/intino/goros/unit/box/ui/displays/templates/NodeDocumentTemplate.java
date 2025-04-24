package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.alexandria.MimeTypes;
import io.intino.alexandria.Resource;
import io.intino.alexandria.logger.Logger;
import io.intino.alexandria.ui.displays.UserMessage;
import io.intino.alexandria.ui.server.UIFile;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.util.NodeHelper;
import org.monet.space.kernel.components.ComponentDocuments;
import org.monet.space.kernel.exceptions.SystemException;
import org.monet.space.kernel.model.Node;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class NodeDocumentTemplate extends AbstractNodeDocumentTemplate<UnitBox> {
    private Node node;
    private boolean readonly;
    private Resource newDocumentResource = null;

    public NodeDocumentTemplate(UnitBox box) {
        super(box);
    }

    public NodeDocumentTemplate node(Node node) {
        this.node = node;
        return this;
    }

    public NodeDocumentTemplate readonly(boolean readonly) {
        this.readonly = readonly;
        return this;
    }

    @Override
    public void init() {
        super.init();
        editDocumentDialog.onOpen(e -> {
            stepper.select(0);
            save.readonly(true);
            newDocumentResource = null;
        });
        editingStep.canNext(step -> newDocumentResource != null);
        downloadDocument.onExecute(e -> downloadDocument());
        newDocument.onChange(e -> updateNewDocument(e.value()));
        save.onExecute(e -> replaceDocument());
    }

    @Override
    public void refresh() {
        super.refresh();
        edit.visible(!readonly);
        toggleDocumentDialog();
        refreshPreview();
    }

    private void toggleDocumentDialog() {
        if (readonly && editDocumentDialog.isVisible()) editDocumentDialog.close();
        else if (!readonly && !editDocumentDialog.isVisible()) editDocumentDialog.open();
    }

    private UIFile downloadDocument() {
        stepper.next();
        return new UIFile() {
            @Override
            public String label() {
                return node.getLabel() + MimeTypes.extensionOf(ComponentDocuments.getInstance().getDocumentContentType(node.getId()));
            }

            @Override
            public InputStream content() {
                try {
                    return ComponentDocuments.getInstance().getDocumentContent(node.getId());
                }
                catch (SystemException ex) {
                    return new ByteArrayInputStream(new byte[0]);
                }
            }
        };
    }

    private void updateNewDocument(Resource value) {
        this.newDocumentResource = value;
        save.readonly(false);
        stepper.next();
    }

    private void replaceDocument() {
        try {
            ComponentDocuments.getInstance().uploadDocument(node.getId(), newDocumentResource.stream(), newDocumentResource.metadata().contentType(), true);
            editDocumentDialog.close();
            editDocumentDialog.notifyUser(translate("Document saved successfully"), UserMessage.Type.Success);
            refreshPreview();
        } catch (IOException e) {
            Logger.error(e);
		}
	}

    private void refreshPreview() {
        preview.value(file());
    }

    private io.intino.alexandria.ui.File file() {
        io.intino.alexandria.ui.File result = new io.intino.alexandria.ui.File();
        result.filename(node.getLabel() + MimeTypes.extensionOf(ComponentDocuments.getInstance().getDocumentContentType(node.getId())));
        result.value(NodeHelper.urlOf(node));
        result.mimeType(NodeHelper.contentTypeOf(node));
        return result;
    }

}