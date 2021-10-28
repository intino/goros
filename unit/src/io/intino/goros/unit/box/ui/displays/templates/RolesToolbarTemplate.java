package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.UserMessage;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.box.ui.datasources.FederationUnitFeederListDatasource;
import io.intino.goros.unit.box.ui.datasources.FederationUnitServiceListDatasource;
import io.intino.goros.unit.box.ui.datasources.UserListDatasource;
import io.intino.goros.unit.box.ui.datasources.model.role.RoleTypeGrouping;
import io.intino.goros.unit.box.ui.displays.rows.AddRoleFeederTableRow;
import io.intino.goros.unit.box.ui.displays.rows.AddRoleServiceTableRow;
import io.intino.goros.unit.box.ui.displays.rows.AddRoleUserTableRow;
import io.intino.goros.unit.util.AccountHelper;
import io.intino.goros.unit.util.LayerHelper;
import org.monet.metamodel.RoleDefinition;
import org.monet.space.kernel.components.layers.FederationLayer;
import org.monet.space.kernel.components.layers.RoleLayer;
import org.monet.space.kernel.model.*;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.function.Consumer;

public class RolesToolbarTemplate extends AbstractRolesToolbarTemplate<UnitBox> {
    private Consumer<Role> addListener;
    private User selectedUser = null;
    private FederationUnitService selectedService = null;
    private FederationUnitFeeder selectedFeeder = null;

    public RolesToolbarTemplate(UnitBox box) {
        super(box);
    }

    public RolesToolbarTemplate onAdd(Consumer<Role> listener) {
        this.addListener = listener;
        return this;
    }

    @Override
    public void init() {
        super.init();
        initAddDialog();
    }

    private void initAddDialog() {
        accept.onExecute(e -> addRole());
        type.onSelect(e -> {
            if (e.selection().size() <= 0) return;
            updateDefinitions(RoleTypeGrouping.from((String) e.selection().get(0)));
        });
        definition.onSelect(e -> {
            if (e.selection().size() <= 0) return;
            clearSelection();
            showRoleView();
        });
        addRoleDialog.onOpen(e -> refreshAddDialog());
        initAddUserRole();
        initAddServiceRole();
        initAddFeederRole();
    }

    private void initAddUserRole() {
        userRoleBlock.onInit(e -> {
            userRoleBlock.addRoleUserTable.onSelect(e1 -> selectedUser = e1.selection().size() > 0 ? (User) e1.selection().get(0) : null);
            userRoleBlock.addRoleUserTable.onAddItem(e1 -> {
                User user = e1.item();
                AddRoleUserTableRow row = e1.component();
                row.addRoleUserTableFullnameItem.fullName.value(user.getInfo().getFullname());
                row.addRoleUserTableEmailItem.email.value(user.getInfo().getEmail());
            });
        });
        userRoleBlock.onShow(e -> {
            userRoleBlock.addRoleUserTable.source(new UserListDatasource(box(), session(), true));
            userRoleBlock.addRoleUserTable.reload();
        });
    }

    private void initAddServiceRole() {
        serviceRoleBlock.onInit(e -> {
            serviceRoleBlock.addRoleServiceTable.onSelect(e1 -> selectedService = e1.selection().size() > 0 ? (FederationUnitService) e1.selection().get(0) : null);
            serviceRoleBlock.addRoleServiceTable.onAddItem(e1 -> {
                FederationUnitService service = e1.item();
                AddRoleServiceTableRow row = e1.component();
                row.addRoleServiceTableLabelItem.label.value(service.getLabel());
                row.addRoleServiceTablePartnerItem.partner.value(partnerLabel(service.getPartnerId()));
            });
        });
        serviceRoleBlock.onShow(e -> {
            serviceRoleBlock.addRoleServiceTable.source(new FederationUnitServiceListDatasource(box(), session(), roleDefinition()));
            serviceRoleBlock.addRoleServiceTable.reload();
        });
    }

    private void initAddFeederRole() {
        feederRoleBlock.onInit(e -> {
            feederRoleBlock.addRoleFeederTable.onSelect(e1 -> selectedFeeder = e1.selection().size() > 0 ? (FederationUnitFeeder) e1.selection().get(0) : null);
            feederRoleBlock.addRoleFeederTable.onAddItem(e1 -> {
                FederationUnitFeeder feeder = e1.item();
                AddRoleFeederTableRow row = e1.component();
                row.addRoleFeederTableLabelItem.label.value(feeder.getLabel());
                row.addRoleFeederTablePartnerItem.partner.value(partnerLabel(feeder.getPartnerId()));
            });
        });
        feederRoleBlock.onShow(e -> {
            feederRoleBlock.addRoleFeederTable.source(new FederationUnitFeederListDatasource(box(), session(), roleDefinition()));
            feederRoleBlock.addRoleFeederTable.reload();
        });
    }

    private void showRoleView() {
        RoleTypeGrouping role = RoleTypeGrouping.from(type.selection().get(0));
        if (role == RoleTypeGrouping.User) showUserView();
        else if (role == RoleTypeGrouping.Service) showServiceView();
        else if (role == RoleTypeGrouping.Feeder) showFeederView();
    }

    private void updateDefinitions(RoleTypeGrouping role) {
        definition.clear();
        definition.select();
        clearSelection();
        Dictionary.getInstance().getRoleDefinitionList().stream().filter(rd -> conforms(rd, role)).forEach(rd -> definition.add(rd.getLabelString()));
        hideViews();
    }

    private boolean conforms(RoleDefinition definition, RoleTypeGrouping role) {
        if (role == RoleTypeGrouping.User && definition.getDisableUsers() == null) return true;
        if (role == RoleTypeGrouping.Service && definition.getEnableServices() != null) return true;
        if (role == RoleTypeGrouping.Feeder && definition.getEnableFeeders() != null) return true;
        return false;
    }

    private void refreshAddDialog() {
        definition.clear();
        definition.select();
        type.clear();
        type.select();
        endDate.value(null);
        hideViews();
        Arrays.stream(RoleTypeGrouping.values()).forEach(v -> type.add(v.title()));
    }

    private void addRole() {
        if (!check()) return;
        String definitionValue = definition.selection().get(0);
        RoleDefinition roleDefinition = findDefinitionCode(definition.selection().get(0));
        RoleTypeGrouping typeValue = RoleTypeGrouping.from(type.selection().get(0));
        Date beginValue = Date.from(beginDate.value() != null ? beginDate.value() : Instant.now());
        Date expireValue = endDate.value() != null ? Date.from(endDate.value()) : null;

        if (existNonExpiredRole(definitionValue, roleDefinition)) return;
        addRoleDialog.close();

        Account account = registerAccount(typeValue);
        RoleLayer roleLayer = LayerHelper.roleLayer();
        Role role;
        if (typeValue == RoleTypeGrouping.User) role = roleLayer.addUserRole(roleDefinition.getCode(), selectedUser, beginValue, expireValue);
        else if (typeValue == RoleTypeGrouping.Service) role = roleLayer.addServiceRole(roleDefinition.getCode(), partner(selectedService), selectedService, beginValue, expireValue);
        else role = roleLayer.addFeederRole(roleDefinition.getCode(), partner(selectedFeeder), selectedFeeder, beginValue, expireValue);

        LayerHelper.federationLayer(session()).createOrUpdateAccount(account);
        addListener.accept(role);
    }

    private Account registerAccount(RoleTypeGrouping typeValue) {
        if (typeValue != RoleTypeGrouping.User) return AccountHelper.account(session());
        FederationLayer federationLayer = LayerHelper.federationLayer(session());
        Account account = federationLayer.locateAccount(selectedUser.getName());
        if (account == null) {
            UserInfo userInfo = new UserInfo();
            userInfo.setFullname(selectedUser.getName());
            account = federationLayer.createAccount(null, selectedUser.getName(), userInfo);
        }
        return account;
    }

    private boolean existNonExpiredRole(String definitionValue, RoleDefinition roleDefinition) {
        RoleLayer roleLayer = LayerHelper.roleLayer();

        if (selectedUser != null && roleLayer.existsNonExpiredUserRole(roleDefinition.getCode(), selectedUser.getId())) {
            String message = translate("Role ::role:: is already active for ::user::").replace("::role::", definitionValue).replace("::user::", selectedUser.getInfo().getFullname());
            notifyUser(message, UserMessage.Type.Error);
            return true;
        }

        if (selectedService != null && roleLayer.existsNonExpiredServiceRole(roleDefinition.getCode(), partner(selectedService), selectedService)) {
            String message = translate("Role ::role:: is already active for ::service::").replace("::role::", definitionValue).replace("::service::", selectedService.getLabel());
            notifyUser(message, UserMessage.Type.Error);
            return true;
        }

        if (selectedFeeder != null && roleLayer.existsNonExpiredFeederRole(roleDefinition.getCode(), partner(selectedFeeder), selectedFeeder)) {
            String message = translate("Role ::role:: is already active for ::feeder::").replace("::role::", definitionValue).replace("::feeder::", selectedFeeder.getLabel());
            notifyUser(message, UserMessage.Type.Error);
            return true;
        }

        return false;
    }

    private RoleDefinition findDefinitionCode(String label) {
        return Dictionary.getInstance().getRoleDefinitionList().stream().filter(d -> d.getLabelString().equals(label)).findFirst().orElse(null);
    }

    private boolean check() {
        if (definition.selection().size() <= 0) {
            notifyUser(translate("Select class to add role"), UserMessage.Type.Error);
            return false;
        }
        if (type.selection().size() <= 0) {
            notifyUser(translate("Select type to add role"), UserMessage.Type.Error);
            return false;
        }
        RoleTypeGrouping typeValue = RoleTypeGrouping.from(type.selection().get(0));
        if (typeValue == RoleTypeGrouping.User && selectedUser == null) {
            notifyUser(translate("Select user to add role"), UserMessage.Type.Error);
            return false;
        }
        if (typeValue == RoleTypeGrouping.Service && selectedService == null) {
            notifyUser(translate("Select service partner to add role"), UserMessage.Type.Error);
            return false;
        }
        if (typeValue == RoleTypeGrouping.Feeder && selectedFeeder == null) {
            notifyUser(translate("Select feeder partner to add role"), UserMessage.Type.Error);
            return false;
        }
        return true;
    }

    private void hideViews() {
        serviceRoleBlock.hide();
        feederRoleBlock.hide();
        userRoleBlock.hide();
    }

    private void showUserView() {
        hideViews();
        userRoleBlock.show();
    }

    private void showServiceView() {
        hideViews();
        serviceRoleBlock.show();
    }

    private void showFeederView() {
        hideViews();
        feederRoleBlock.show();
    }

    private RoleDefinition roleDefinition() {
        return definition.selection().size() > 0 ? findDefinitionCode(definition.selection().get(0)) : null;
    }

    private String partnerLabel(String partnerId) {
        return partner(partnerId).getLabel();
    }

    private FederationUnit partner(FederationUnitService service) {
        return partner(service.getPartnerId());
    }

    private FederationUnit partner(FederationUnitFeeder feeder) {
        return partner(feeder.getPartnerId());
    }

    private FederationUnit partner(String partnerId) {
        return LayerHelper.federationLayer(session()).loadPartner(partnerId);
    }

    private void clearSelection() {
        selectedUser = null;
        selectedService = null;
        selectedFeeder = null;
    }

}