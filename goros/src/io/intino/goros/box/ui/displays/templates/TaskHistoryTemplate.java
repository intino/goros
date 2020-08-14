package io.intino.goros.box.ui.displays.templates;

import org.monet.space.kernel.model.Fact;
import org.monet.space.kernel.model.Task;
import io.intino.goros.box.GorosBox;
import io.intino.goros.util.LayerHelper;

import java.util.List;

public class TaskHistoryTemplate extends AbstractTaskHistoryTemplate<GorosBox> {
    private Task task;
    private int page = 0;

    private static final int PageSize = 5;

    public TaskHistoryTemplate(GorosBox box) {
        super(box);
    }

    public TaskHistoryTemplate task(Task task) {
        this.task = task;
        this.page = 0;
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