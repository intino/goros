package io.intino.goros.unit.util;

import io.intino.alexandria.ui.services.push.UISession;
import org.monet.metamodel.*;
import org.monet.metamodel.internal.Ref;
import org.monet.space.kernel.components.layers.RoleLayer;
import org.monet.space.kernel.model.*;
import org.monet.space.kernel.model.Dictionary;

import java.util.List;

public class AccountHelper {

	public static boolean hasRoles(NodeDefinition definition, UISession session) {
		if (definition instanceof DesktopDefinition) return hasRoles((DesktopDefinition) definition, session);
		if (definition instanceof ContainerDefinition) return hasRoles((ContainerDefinition)definition, session);
		return true;
	}

	public static boolean hasRoles(DesktopDefinition definition, UISession session) {
		if (definition.getFor() == null) return true;
		return hasRoles(definition.getFor().getRole(), session);
	}

	public static boolean hasRoles(ContainerDefinition definition, UISession session) {
		if (definition.getFor() == null) return true;
		return hasRoles(definition.getFor().getRole(), session);
	}

	public static boolean hasRoles(List<Ref> roles, UISession session) {
		return hasRoles(roles, account(session));
	}

	public static boolean hasRoles(List<Ref> roles, Account account) {
		Dictionary dictionary = Dictionary.getInstance();
		RoleLayer roleLayer = LayerHelper.roleLayer();
		if (roles == null) return false;
		if (roles.isEmpty()) return true;
		return roles.stream().anyMatch(role -> {
			String roleCode = dictionary.getDefinitionCode(role.getValue());
			return roleLayer.existsNonExpiredUserRole(roleCode, account.getUser());
		});
	}

	public static RoleList loadNonExpiredRoleList(String codeRole, Role.Nature nature) {
		DataRequest dataRequest = new DataRequest();
		dataRequest.setCode(codeRole);
		dataRequest.setStartPos(0);
		dataRequest.setLimit(-1);
		dataRequest.addParameter(DataRequest.NATURE, nature.toString());
		dataRequest.addParameter(DataRequest.NON_EXPIRED, "true");
		return LayerHelper.roleLayer().loadRoleList(dataRequest);
	}

	public static Account account(UISession session) {
		return LayerHelper.federationLayer(session).loadAccount();
	}
}
