package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.components.Layer;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.util.LayerHelper;
import io.intino.goros.unit.util.PathHelper;
import org.monet.space.kernel.model.MonetLink;
import org.monet.space.kernel.model.Node;

import java.util.function.BiConsumer;

public class TaskHistoryEntryLinkTemplate extends AbstractTaskHistoryEntryLinkTemplate<UnitBox> {
	private MonetLink monetLink;
	private BiConsumer<String, Layer<?, ?>> openLayerListener;

	public TaskHistoryEntryLinkTemplate(UnitBox box) {
        super(box);
    }

	public TaskHistoryEntryLinkTemplate monetLink(MonetLink link) {
		this.monetLink = link;
		return this;
	}

	public TaskHistoryEntryLinkTemplate onOpenLayer(BiConsumer<String, Layer<?, ?>> listener) {
		this.openLayerListener = listener;
		return this;
	}

	@Override
	public void init() {
		super.init();
		link.onOpen(e -> openLayerListener.accept(monetLink.getLabel(), e.layer()));
		documentDialog.onOpen(e -> refreshDocumentDialog());
	}

	@Override
	public void refresh() {
		super.refresh();
		boolean isDocument = isDocument();
		documentLink.title(monetLink.getLabel());
		documentLink.visible(isDocument);
		link.title(monetLink.getLabel());
		link.address(path -> PathHelper.pathOf(monetLink));
		link.visible(!isDocument);
	}

	private void refreshDocumentDialog() {
		documentDialog.title(monetLink.getLabel());
		documentDialog.documentStamp.node(node());
		documentDialog.documentStamp.readonly(true);
		documentDialog.documentStamp.refresh();
	}

	private boolean isDocument() {
		if (monetLink.getType() != MonetLink.Type.Node) return false;
		return node().isDocument();
	}

	private Node node() {
		return LayerHelper.nodeLayer().loadNode(monetLink.getId());
	}

}