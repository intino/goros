package org.siani.goros.util;

import org.monet.space.kernel.model.FeederRole;
import org.monet.space.kernel.model.Role;
import org.monet.space.kernel.model.ServiceRole;
import org.monet.space.kernel.model.UserRole;
import org.siani.goros.box.ui.datasources.model.role.RoleExpiredGrouping;
import org.siani.goros.box.ui.datasources.model.role.RoleNatureGrouping;

public class RoleHelper {

	public static String userOf(Role role) {
		if (role instanceof UserRole) return ((UserRole)role).getUser().getInfo().getFullname();
		else if (role instanceof ServiceRole) return ((ServiceRole)role).getPartner().getLabel();
		else if (role instanceof FeederRole) return ((FeederRole)role).getPartner().getLabel();
		return null;
	}

	public static String definitionLabelOf(Role role) {
		return role.getDefinition().getLabelString();
	}

	public static String natureOf(Role role) {
		if (role instanceof UserRole) return RoleNatureGrouping.Internal.title();
		return RoleNatureGrouping.External.title();
	}

	public static String stateLabel(Role role) {
		return RoleHelper.isExpired(role) ? RoleExpiredGrouping.Expired.title() : RoleExpiredGrouping.NonExpired.title();
	}

	public static String stateColor(Role role) {
		return RoleHelper.isExpired(role) ? "#272C34" : "#4CAF50";
	}

	public static boolean isExpired(Role role) {
		if (role.getInternalExpireDate() == null) return false;
		return role.getInternalBeginDate().after(role.getInternalExpireDate()) || role.getInternalBeginDate().equals(role.getInternalExpireDate());
	}
}
