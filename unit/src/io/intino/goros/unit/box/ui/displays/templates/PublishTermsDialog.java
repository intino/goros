package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.UserMessage;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.util.LayerHelper;
import org.monet.metamodel.SourceDefinition;
import org.monet.space.kernel.model.Source;
import org.monet.space.kernel.model.Term;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class PublishTermsDialog extends AbstractPublishTermsDialog<UnitBox> {
    private Source<SourceDefinition> source;
    private Consumer<Boolean> publishListener;
    private Consumer<Boolean> deleteListener;

    public PublishTermsDialog(UnitBox box) {
        super(box);
    }

    public PublishTermsDialog source(Source<SourceDefinition> source) {
        this.source = source;
        return this;
    }

    public PublishTermsDialog onPublish(Consumer<Boolean> listener) {
        this.publishListener = listener;
        return this;
    }

    public PublishTermsDialog onDelete(Consumer<Boolean> listener) {
        this.deleteListener = listener;
        return this;
    }

    @Override
    public void init() {
        super.init();
        publish.onExecute(e -> publish(newTerms.selection()));
        delete.onExecute(e -> delete(newTerms.selection()));
        publishAll.onExecute(e -> publishAll());
        newTerms.onSelect(e -> refresh());
    }

    @Override
    public void refresh() {
        super.refresh();
        List<Term> terms = loadNewTerms();
        newTerms.clear();
        terms.forEach(t -> newTerms.add(t.getCode()));
        publish.readonly(newTerms.selection().size() <= 0);
        delete.readonly(newTerms.selection().size() <= 0);
        publishAll.readonly(terms.size() <= 0);
    }

    private ArrayList<Term> loadNewTerms() {
        return new ArrayList<>(LayerHelper.sourceLayer().loadSourceNewTerms(source).get().values());
    }

    private void publish(List<String> selection) {
        LayerHelper.sourceLayer().publishSourceTerms(source, selection.toArray(new String[0]));
        notifyUser(translate("Terms published"), UserMessage.Type.Success);
        publishListener.accept(true);
        refresh();
    }

    private void delete(List<String> selection) {
        selection.forEach(s -> LayerHelper.sourceLayer().deleteSourceTerm(source, s));
        notifyUser(translate("Terms deleted"), UserMessage.Type.Success);
        deleteListener.accept(true);
        refresh();
    }

    private void publishAll() {
        publish(loadNewTerms().stream().map(Term::getCode).collect(Collectors.toList()));
    }

}