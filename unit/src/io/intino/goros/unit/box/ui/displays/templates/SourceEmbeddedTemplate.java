package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.util.LayerHelper;
import org.monet.metamodel.SourceDefinition;
import org.monet.space.kernel.model.Source;
import org.monet.space.kernel.model.Term;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class SourceEmbeddedTemplate extends AbstractSourceEmbeddedTemplate<UnitBox> {
    private Source<SourceDefinition> source;
    private Consumer<Long> termsCountListener;
    private int currentLevel = 0;
    private Map<Integer, Term> selectedTerms = new HashMap<>();
    private int selectedLevel = 0;

    public SourceEmbeddedTemplate(UnitBox box) {
        super(box);
    }

    public SourceEmbeddedTemplate source(Source<SourceDefinition> source) {
        this.source = source;
        return this;
    }

    public SourceEmbeddedTemplate onTermsCountChange(Consumer<Long> listener) {
        this.termsCountListener = listener;
        return this;
    }

    @Override
    public void init() {
        super.init();
        termView.onInit(e -> {
            termView.termDialog.onTermAdded(term -> {
                Term parent = termView.termDialog.term();
                SourceLevelTemplate view = addOrGet(parent != null ? selectedLevel+1 : selectedLevel);
                if (parent != null) view.term(parent);
                view.refresh();
                view.selectDelayed(term);
                save(term, source);
                refreshPublishTermsDialog();
            });
            termView.termDialog.onTermModified(term -> {
                addOrGet(selectedLevel).refresh(term);
                if (term.isTerm()) hideLevels(selectedLevel+1);
                else showLevel(selectedLevel+1, term);
                save(term, source);
            });
            termView.termDialog.onTermDeleted(term -> {
                refreshAfterDeleting();
                save(term, source);
            });
        });
        termView.onShow(e -> {
            Term selected = selectedTerms.getOrDefault(selectedLevel, null);
            refreshCount(selected != null && selected.isTerm() ? 0 : addOrGet(selected != null ? selectedLevel+1 : selectedLevel).childrenCount());
            refreshPublishTermsDialog();
            refreshTermDialog();
        });
    }

    private void refreshAfterDeleting() {
        refreshPublishTermsDialog();
        addOrGet(selectedLevel).refresh();
        selectedLevel--;
        refreshTermDialog();
    }

    @Override
    public void refresh() {
        super.refresh();
        resetLevels();
        termView.show();
    }

    private void resetLevels() {
        levels.clear();
        addLevel();
    }

    private void addLevel() {
        addLevel(null, 0);
    }

    private void addLevel(Term term, int level) {
        SourceLevelTemplate view = addOrGet(level);
        view.source(source);
        view.term(term);
        view.level(level);
        //view.onRefreshTermCount(this::refreshCount);
        view.onSelect(this::select);
        view.show();
        view.refresh();
        currentLevel = level+1;
    }

    private SourceLevelTemplate addOrGet(int level) {
        List<SourceLevelTemplate> children = levels.children(SourceLevelTemplate.class);
        int size = children.size();
        return level < size ? children.get(level) : levels.add().source(source);
    }

    private void select(Term term, int level) {
        Term parent = selectedTerms.getOrDefault(level-1, null);
        hideLevels(level+1);
        if (term == null && parent != null) {
            select(parent, level-1);
            return;
        }
        if (term != null && !term.isTerm()) addLevel(term, level+1);
        selectedTerms.put(level, term);
        selectedLevel = level;
        termView.show();
    }

    private void refreshCount(long count) {
        if (termsCountListener != null) termsCountListener.accept(count);
    }

    private void hideLevels(int level) {
        List<SourceLevelTemplate> children = levels.children(SourceLevelTemplate.class);
        for (SourceLevelTemplate child : children) {
            if (child.level() >= level) child.hide();
        }
    }

    private void showLevel(int level, Term term) {
        List<SourceLevelTemplate> children = levels.children(SourceLevelTemplate.class);
        for (SourceLevelTemplate child : children) {
            if (child.level() == level) {
                child.show();
                child.term(term);
                child.refresh();
            }
        }
    }

    private void save(Term term, Source<SourceDefinition> source) {
        source.setUpdateDate(new Date());
        LayerHelper.sourceLayer().saveSource(source);
    }

    private void refreshPublishTermsDialog() {
        int count = LayerHelper.sourceLayer().loadSourceNewTerms(source).getCount();
        termView.publishTermsDialog.source(source);
        termView.publishTermsDialog.onPublish(e -> refreshPublishTermsDialog());
        termView.publishTermsDialog.onDelete(e -> refreshAfterDeleting());
        termView.publishTermsDialog.visible(count > 0);
        if (count <= 0) return;
        termView.publishTermsDialog.refresh();
    }

    private void refreshTermDialog() {
        termView.termDialog.source(source);
        termView.termDialog.term(selectedTerms.getOrDefault(selectedLevel, null));
        termView.termDialog.refresh();
    }

}