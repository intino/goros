package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.UserMessage;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.util.LayerHelper;
import io.intino.goros.unit.util.PathHelper;
import org.monet.space.kernel.model.Fact;
import org.monet.space.kernel.model.MonetLink;

public class TaskHistoryEntryTemplate extends AbstractTaskHistoryEntryTemplate<UnitBox> {
    private Fact entry;

    public TaskHistoryEntryTemplate(UnitBox box) {
        super(box);
    }

    public TaskHistoryEntryTemplate entry(Fact entry) {
        this.entry = entry;
        return this;
    }

    @Override
    public void refresh() {
        super.refresh();
        String userId = entry.getUserId();
        date.value(entry.getInternalCreateDate().toInstant());
        title.value(entry.getTitle());
        subtitle.value(entry.getSubTitle());
        author.value(userId != null && !userId.isEmpty() ? translate("by") + " " + LayerHelper.federationLayer(session()).loadUserByUsername(entry.getUserId()).getInfo().getFullname() : null);
        linksBlock.clear();
        entry.getLinks().forEach(link -> fill(link, linksBlock.add()));
    }

    private void fill(MonetLink link, TaskHistoryEntryLinkTemplate display) {
        display.monetLink(link);
        display.refresh();
    }

}