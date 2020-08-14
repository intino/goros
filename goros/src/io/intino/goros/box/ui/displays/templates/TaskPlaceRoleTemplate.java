package io.intino.goros.box.ui.displays.templates;

import org.monet.space.kernel.model.Role;
import io.intino.goros.box.GorosBox;

import java.util.function.Consumer;

public class TaskPlaceRoleTemplate extends AbstractTaskPlaceRoleTemplate<GorosBox> {
    private Role role;
    private String confirmText;
    private Consumer<Role> selectListener;

    public TaskPlaceRoleTemplate(GorosBox box) {
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