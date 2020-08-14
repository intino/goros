package io.intino.goros.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.UserMessage;
import io.intino.goros.box.GorosBox;

import java.util.function.BiConsumer;

public class SourceTermTagTemplate extends AbstractSourceTermTagTemplate<GorosBox> {
    private String _name;
    private String _value;
    private BiConsumer<String, String> changeListener;
    private BiConsumer<String, String> deleteListener;

    public SourceTermTagTemplate(GorosBox box) {
        super(box);
    }

    public SourceTermTagTemplate name(String tag) {
        this._name = tag;
        return this;
    }

    public SourceTermTagTemplate value(String value) {
        this._value = value;
        return this;
    }

    public SourceTermTagTemplate onChange(BiConsumer<String, String> listener) {
        this.changeListener = listener;
        return this;
    }

    public SourceTermTagTemplate onDelete(BiConsumer<String, String> listener) {
        this.deleteListener = listener;
        return this;
    }

    @Override
    public void init() {
        super.init();
        name.onChange(e -> {
            String value = e.value();
            if (value.isEmpty()) {
                name.value(_name);
                notifyUser(translate("Name cannot be empty"), UserMessage.Type.Error);
                return;
            }
            notifyChange();
        });
        value.onChange(e -> notifyChange());
        delete.onExecute(e -> notifyDelete());
    }

    @Override
    public void refresh() {
        super.refresh();
        this.name.value(_name);
        this.value.value(_value);
    }

    private void notifyChange() {
        changeListener.accept(name.value(), value.value());
    }

    private void notifyDelete() {
        deleteListener.accept(name.value(), value.value());
    }

}