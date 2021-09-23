package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.goros.unit.box.UnitBox;
import org.monet.space.kernel.model.Role;

import java.util.function.Consumer;

public class TaskPlaceRoleTemplate extends AbstractTaskPlaceRoleTemplate<UnitBox> {
    private Role role;
    private String confirmText;
    private Consumer<Role> selectListener;

    public TaskPlaceRoleTemplate(UnitBox box) {
        super(box);
    }

    public TaskPlaceRoleTemplate role(Role role) {
        this.role = role;
        return this;
    }

    public TaskPlaceRoleTemplate confirmText(String confirmText) {
        this.confirmText = confirmText;
        return this;
    }

    public TaskPlaceRoleTemplate onSelect(Consumer<Role> listener) {
        this.selectListener = listener;
        return this;
    }

    public void readonly(boolean value) {
        label.readonly(value);
    }

    @Override
    public void init() {
        super.init();
        label.onExecute(e -> selectListener.accept(role));
    }

    @Override
    public void refresh() {
        super.refresh();
        label.title(role.getLabel());
        label.affirmed(confirmText);
    }
}