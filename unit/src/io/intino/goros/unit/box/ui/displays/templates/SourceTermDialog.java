package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.UserMessage;
import io.intino.alexandria.ui.displays.events.actionable.ToggleEvent;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.util.LayerHelper;
import org.monet.metamodel.SourceDefinition;
import org.monet.space.kernel.model.Source;
import org.monet.space.kernel.model.Term;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class SourceTermDialog extends AbstractSourceTermDialog<UnitBox> {
    private Source<SourceDefinition> source;
    private Term term;
    private Consumer<Term> termAddedListener;
    private Consumer<Term> termModifiedListener;
    private Consumer<Term> termDeletedListener;
    private boolean refreshing = false;

    public SourceTermDialog(UnitBox box) {
        super(box);
    }

    public SourceTermDialog source(Source<SourceDefinition> source) {
        this.source = source;
        return this;
    }

    public Term term() {
        return term;
    }

    public SourceTermDialog term(Term term) {
        this.term = term;
        return this;
    }

    public SourceTermDialog onTermAdded(Consumer<Term> listener) {
        this.termAddedListener = listener;
        return this;
    }

    public SourceTermDialog onTermModified(Consumer<Term> listener) {
        this.termModifiedListener = listener;
        return this;
    }

    public SourceTermDialog onTermDeleted(Consumer<Term> listener) {
        this.termDeletedListener = listener;
        return this;
    }

    @Override
    public void init() {
        super.init();
        add.onExecute(e -> addChild());
        childLabel.onEnterPress(e -> addChild());
        label.onChange(e -> save(t -> {
            if (term.getLabel().equals(e.value())) return false;
            term.setLabel(e.value());
            return true;
        }));
        type.onSelect(e -> save(t -> updateType()));
        containOtherTerms.onToggle(e -> save(t -> updateType()));
        childCode.onChange(e -> checkChildCode());
        initToolbar();
    }

    @Override
    public void refresh() {
        super.refresh();
        refreshGeneralView();
        refreshChildrenView();
    }

    private void initToolbar() {
        enable.onExecute(e -> enable());
        disable.onExecute(e -> disable());
        delete.onExecute(e -> delete());
    }

    private void refreshGeneralView() {
        refreshing = true;
        title.visible(term != null);
        generalView.visible(term != null);
        if (term == null) return;
        title.value(term.getLabel());
        code.value(term.getCode());
        label.value(term.getLabel());
        type.selection(term.isTerm() || term.isSuperTerm() ? "termType" : "categoryType");
        containOtherTerms.state(term.isSuperTerm() ? ToggleEvent.State.On : ToggleEvent.State.Off);
        refreshTags();
        refreshToolbar();
        refreshing = false;
    }

    private void refreshTags() {
        tags.clear();
        term.getTagsMap().forEach((name, value) -> fill(name, value, tags.add()));
        fill("", "", tags.add());
    }

    private void refreshToolbar() {
        enableBlock.visible(!term.isEnabled() && !term.isNew());
        disableBlock.visible(term.isEnabled() && !term.isNew());
        deleteBlock.visible(term.isNew());
    }

    private void refreshChildrenView() {
        addTitle.visible(term == null || term.isSuperTerm() || term.isCategory());
        childrenView.visible(term == null || term.isSuperTerm() || term.isCategory());
        String title = term != null ? translate("Add to") + " " + term.getLabel() : translate("Add term");
        addTitle.value(title);
    }

    private void addChild() {
        if (!checkChild()) return;
        Term child = new Term();
        child.setCode(childCode());
        child.setLabel(childLabel.value());
        child.setType(Term.TERM);
        child.setEnabled(true);
        child.setNew(true);
        LayerHelper.sourceLayer().addSourceTerm(source, child, term != null ? term.getCode() : null);
        termAddedListener.accept(child);
    }

    private boolean checkChild() {
        if (childCode.value() == null || childCode.value().isEmpty() || childLabel.value() == null || childLabel.value().isEmpty()) {
            notifyUser(translate("Fill name and label"), UserMessage.Type.Warning);
            return false;
        }
        if (!checkChildCode()) {
            notifyUser(translate("Term already exists, select other code"), UserMessage.Type.Error);
            return false;
        }
        return true;
    }

    private void fill(String name, String value, SourceTermTagTemplate view) {
        view.name(name);
        view.value(value);
        view.onChange((n, v) -> save(t -> {
            Map<String, String> tags = term.getTagsMap();
            boolean contains = tags.containsKey(n);
            tags.put(n, v);
            term.setTags(tags);
            if (!contains && !n.isEmpty()) refreshTags();
            return true;
        }));
        view.onDelete((n, v) -> save(t -> {
            Map<String, String> tags = term.getTagsMap();
            tags.remove(n);
            term.setTags(tags);
            refreshTags();
            return true;
        }));
        view.refresh();
    }

    private boolean updateType() {
        int type = termType();
        if (type == -1 || type == term.getType()) return false;
        term.setType(type);
        refreshChildrenView();
        return true;
    }

    private int termType() {
        List<String> selection = type.selection();
        if (selection.size() <= 0) return -1;
        String value = selection.get(0);
        if (value.equalsIgnoreCase("TermType")) {
            boolean superTerm = containOtherTerms.state() == ToggleEvent.State.On;
            return superTerm ? Term.SUPER_TERM : Term.TERM;
        }
        return Term.CATEGORY;
    }

    private void enable() {
        saveEnabled(true);
        refresh();
    }

    private void disable() {
        saveEnabled(false);
        refresh();
    }

    private void delete() {
        LayerHelper.sourceLayer().deleteSourceTerm(source, term.getCode());
        notifyUser(translate("Term deleted"), UserMessage.Type.Success);
        termDeletedListener.accept(term);
    }

    private void saveEnabled(boolean value) {
        save(t -> {
            term.setEnabled(value);
            return true;
        });
    }

    private void save(Function<Term, Boolean> consumer) {
        Boolean modified = consumer.apply(term);
        if (!modified) return;
        LayerHelper.sourceLayer().updateSourceTerm(source, term);
        termModifiedListener.accept(term);
    }

    private boolean checkChildCode() {
        boolean exists = LayerHelper.sourceLayer().existsSourceTerm(source, childCode());
        childCode.error(exists ? translate("Term already exists") : null);
        return !exists;
    }

    private String childCode() {
        return term.getCode() + "." + childCode.value();
    }

}