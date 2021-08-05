package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.util.PathHelper;
import org.monet.space.kernel.model.MonetLink;

public class TaskHistoryEntryLinkTemplate extends AbstractTaskHistoryEntryLinkTemplate<UnitBox> {
	private MonetLink monetLink;

	public TaskHistoryEntryLinkTemplate(UnitBox box) {
        super(box);
    }

	public TaskHistoryEntryLinkTemplate monetLink(MonetLink link) {
		this.monetLink = link;
		return this;
	}

	@Override
	public void refresh() {
		super.refresh();
		link.address(path -> PathHelper.pathOf(monetLink));
		link.title(monetLink.getLabel());
	}

}