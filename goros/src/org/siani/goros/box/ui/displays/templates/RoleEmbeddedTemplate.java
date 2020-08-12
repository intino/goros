package org.siani.goros.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.components.Collection;
import org.monet.space.kernel.model.Role;
import org.siani.goros.box.GorosBox;
import org.siani.goros.box.ui.datasources.model.role.RoleTypeGrouping;
import org.siani.goros.util.Formatters;
import org.siani.goros.util.LayerHelper;
import org.siani.goros.util.RoleHelper;

import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.function.Consumer;

public class RoleEmbeddedTemplate extends AbstractRoleEmbeddedTemplate<GorosBox> {
    private Role role;
    private boolean readonly = true;
    private Consumer<Role> finishEditionListener;

    public RoleEmbeddedTemplate(GorosBox box) {
        super(box);
    }

    public RoleEmbeddedTemplate role(Role role) {
        this.role = role;
        return this;
    }

    public RoleEmbeddedTemplate readonly(boolean readonly) {
        this.readonly = readonly;
        return this;
    }

    public RoleEmbeddedTemplate onChange(Consumer<Role> listener) {
        this.finishEditionListener = listener;
        return this;
    }

    public void bindTo(Collection collection) {
        previous.bindTo(collection);
        previous.visible(collection != null);
        next.bindTo(collection);
        next.visible(collection != null);
    }

    @Override
    public void init() {
        super.init();
        edit.onExecute(e -> toggleEdition());
        revoke.onExecute(e -> revoke());
        endDate.onChange(e -> save(e.value()));
    }

    @Override
    public void refresh() {
        super.refresh();
        edit.title(translate(readonly ? "Edit" : "Finish edition"));
        user.value(RoleHelper.userOf(role));
        message.value(message());
        state.value(translate(RoleHelper.stateLabel(role)));
        state.backgroundColor(translate(RoleHelper.stateColor(role)));
        definition.value(RoleHelper.definitionLabelOf(role));
        type.value(RoleTypeGrouping.from(role.getType().name()).title());
        nature.value(RoleHelper.natureOf(role));
        startDate.value(role.getInternalBeginDate().toInstant());
        endDate.value(role.getInternalExpireDate() != null ? role.getInternalExpireDate().toInstant() : null);
        endDate.readonly(readonly);
        revoke.visible(readonly);
        revoke.readonly(RoleHelper.isExpired(role));
    }

    private String message() {
        String message;
        if (RoleHelper.isExpired(role)) message = "Role is expired since ::endDate::";
        else message = role.getInternalExpireDate() == null ? "Role is active since ::startDate:: and no expires" : "Role is active since ::startDate:: and expires at ::endDate::";
        message = translate(message);
        message = message.replaceAll("::startDate::", Formatters.shortDate(role.getInternalBeginDate().toInstant()));
        if (role.getInternalExpireDate() != null) message = message.replaceAll("::endDate::", Formatters.shortDate(role.getInternalExpireDate().toInstant()));
        return message;
    }

    private void revoke() {
        Instant startDate = Instant.ofEpochMilli(role.getInternalBeginDate().toInstant().toEpochMilli());
        startDate = startDate.minus(1, ChronoUnit.DAYS);
        role.setExpireDate(Date.from(startDate));
        LayerHelper.roleLayer().saveRole(role);
        finishEditionListener.accept(role);
        refresh();
    }

    private void save(Instant endDate) {
        role.setExpireDate(endDate != null ? Date.from(endDate) : null);
        LayerHelper.roleLayer().saveRole(role);
        if (finishEditionListener != null) finishEditionListener.accept(role);
        refresh();
    }

    private void toggleEdition() {
        readonly(!readonly);
        refresh();
    }

}