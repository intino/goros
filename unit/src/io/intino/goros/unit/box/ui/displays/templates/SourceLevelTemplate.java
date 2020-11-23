package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.alexandria.ui.utils.DelayerUtil;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.box.ui.datasources.SourceDatasource;
import io.intino.goros.unit.box.ui.displays.items.SourceLevelListItem;
import io.intino.goros.unit.util.SourceHelper;
import org.monet.metamodel.SourceDefinition;
import org.monet.space.kernel.model.Source;
import org.monet.space.kernel.model.Term;

import java.util.List;
import java.util.function.BiConsumer;

public class SourceLevelTemplate extends AbstractSourceLevelTemplate<UnitBox> {
    private Source<SourceDefinition> source;
    private Term term;
    private BiConsumer<Term, Integer> selectListener;
    private int level = -1;

    public SourceLevelTemplate(UnitBox box) {
        super(box);
    }

    public SourceLevelTemplate source(Source<SourceDefinition> source) {
        this.source = source;
        if (sourceLevelList != null) sourceLevelList.source(null);
        return this;
    }

    public SourceLevelTemplate term(Term term) {
        this.term = term;
        if (sourceLevelList != null) sourceLevelList.source(null);
        return this;
    }

    public int level() {
        return level;
    }

    public SourceLevelTemplate level(int level) {
        this.level = level;
        return this;
    }

    public SourceLevelTemplate onSelect(BiConsumer<Term, Integer> listener) {
        this.selectListener = listener;
        return this;
    }

    public void select(Term term) {
        DelayerUtil.execute(this, (e) -> sourceLevelList.select(sourceLevelList.findItem(i -> ((Term)i).getCode().equals(term.getCode()))), 300);
    }

    @Override
    public void init() {
        super.init();
        sourceLevelList.onSelect(e -> selectTerm(e.selection()));
        sourceLevelList.onAddItem(e -> {
            Term term = e.item();
            SourceLevelListItem item = e.component();
            item.label.value(term.getLabel());
            item.code.value(term.getCode());
            item.type.value(translate(SourceHelper.typeLabel(term)));
            item.type.backgroundColor(SourceHelper.typeColor(term));
            item.tagsCount.value(term.getTags().size());
            item.groupFlag.visible(term.isCategory() || term.isSuperTerm());
        });
    }

    private void selectTerm(List<Term> selection) {
        if (selectListener == null) return;
        selectListener.accept(selection.size() > 0 ? selection.get(0) : null, level);
    }

    public long childrenCount() {
        return sourceLevelList.source() != null ? sourceLevelList.itemCount() : 0;
    }

    @Override
    public void refresh() {
        super.refresh();
        if (sourceLevelList.source() == null) sourceLevelList.source(new SourceDatasource(box(), session(), source, term));
        sourceLevelList.reload();
    }

    public void refresh(Term term) {
        sourceLevelList.refresh(sourceLevelList.findItem(t -> ((Term)t).getCode().equals(term.getCode())), term);
    }

}