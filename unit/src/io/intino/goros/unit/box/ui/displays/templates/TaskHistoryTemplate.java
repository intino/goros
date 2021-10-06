package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.components.Layer;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.util.LayerHelper;
import org.monet.space.kernel.model.Fact;
import org.monet.space.kernel.model.Task;

import java.util.List;
import java.util.function.BiConsumer;

public class TaskHistoryTemplate extends AbstractTaskHistoryTemplate<UnitBox> {
    private Task task;
    private int page = 0;
    private BiConsumer<String, Layer<?, ?>> openLayerListener;

    private static final int PageSize = 5;

    public TaskHistoryTemplate(UnitBox box) {
        super(box);
    }

    public TaskHistoryTemplate task(Task task) {
        this.task = task;
        this.page = 0;
        return this;
    }

    public TaskHistoryTemplate onOpenLayer(BiConsumer<String, Layer<?, ?>> listener) {
        this.openLayerListener = listener;
        return this;
    }

    @Override
    public void init() {
        super.init();
        moreEntries.onExecute(e -> nextPage());
    }

    @Override
    public void refresh() {
        super.refresh();
        refreshEntries();
        refreshMore();
    }

    private void refreshEntries() {
        List<Fact> entryList = LayerHelper.taskLayer().loadTaskFactEntries(task.getId(), start(page), PageSize);
        if (page == 0) {
            entriesBlock.visible(false);
            entries.clear();
        }
        entryList.forEach(e -> fill(e, entries.add()));
        if (page == 0) entriesBlock.visible(true);
    }

    private void fill(Fact entry, TaskHistoryEntryTemplate view) {
        view.entry(entry);
        view.onOpenLayer((title, layer) -> openLayerListener.accept(title, layer));
        view.refresh();
    }

    private void refreshMore() {
        moreEntries.visible(entriesCount() > 0 && page < pageCount() - 1);
    }

    private void nextPage() {
        page++;
        if (page >= pageCount()) page = pageCount() - 1;
        refresh();
    }

    public int start(int page) {
        return page * PageSize;
    }

    public int pageCount() {
        return pageOf(entriesCount());
    }

    public int entriesCount() {
        return LayerHelper.taskLayer().getTaskFactEntriesCount(task.getId());
    }

    public int pageOf(long index) {
        return (int) (Math.floor(index / PageSize) + (index % PageSize > 0 ? 1 : 0));
    }

}