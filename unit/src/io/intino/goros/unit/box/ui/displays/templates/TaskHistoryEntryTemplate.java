package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.components.Layer;
import io.intino.goros.unit.box.UnitBox;
import org.monet.space.kernel.model.Fact;
import org.monet.space.kernel.model.MonetLink;

import java.util.function.BiConsumer;

public class TaskHistoryEntryTemplate extends AbstractTaskHistoryEntryTemplate<UnitBox> {
    private Fact entry;
    private BiConsumer<String, Layer<?, ?>> openLayerListener;

    public TaskHistoryEntryTemplate(UnitBox box) {
        super(box);
    }

    public TaskHistoryEntryTemplate entry(Fact entry) {
        this.entry = entry;
        return this;
    }

    public TaskHistoryEntryTemplate onOpenLayer(BiConsumer<String, Layer<?, ?>> listener) {
        this.openLayerListener = listener;
        return this;
    }

    @Override
    public void refresh() {
        super.refresh();
        String userId = entry.getUserId();
        String authorMessage = userId != null && !userId.isEmpty() && !userId.contains("|") ? translate("by") + " " + userId : "";
        date.value(entry.getInternalCreateDate().toInstant());
        title.value(entry.getTitle());
        subtitle.value(entry.getSubTitle());
        author.value(authorMessage);
        linksBlock.clear();
        entry.getLinks().forEach(link -> fill(link, linksBlock.add()));
    }

    private void fill(MonetLink link, TaskHistoryEntryLinkTemplate display) {
        display.monetLink(link);
        display.onOpenLayer((title, layer) -> openLayerListener.accept(title, layer));
        display.refresh();
    }

}