package io.intino.goros.unit.util;

import org.monet.metamodel.ContainerDefinition;
import org.monet.metamodel.DesktopDefinition;
import org.monet.metamodel.Distribution;
import org.monet.metamodel.NodeDefinition;
import org.monet.metamodel.internal.Ref;
import org.monet.space.kernel.model.FeederRole;
import org.monet.space.kernel.model.Role;
import org.monet.space.kernel.model.ServiceRole;
import org.monet.space.kernel.model.UserRole;
import io.intino.goros.unit.box.ui.datasources.model.role.RoleExpiredGrouping;
import io.intino.goros.unit.box.ui.datasources.model.role.RoleNatureGrouping;

import java.util.List;

import static java.util.Collections.emptyList;

public class RoleHelper {

	public static List<Ref> nodeDefinitionRoles(Distribution.ShowProperty showProperty, String code) {
		NodeDefinition definition = showProperty.getTabEnvironment().stream().map(te -> org.monet.space.kernel.model.Dictionary.getInstance().getNodeDefinition(te.getValue())).filter(d -> d.getCode().equals(code)).findFirst().orElse(null);
		if (definition == null) return null;
		if (!definition.isEnvironment()) return null;

		if (definition.isDesktop()) {
			DesktopDefinition desktopDefinition = (DesktopDefinition) definition;
			return desktopDefinition.getFor() != null ? desktopDefinition.getFor().getRole() : emptyList();
		} else if (definition.isContainer() && definition.isEnvironment()) {
			ContainerDefinition containerDefinition = (ContainerDefinition) definition;
			return containerDefinition.getFor() != null ? containerDefinition.getFor().getRole() : emptyList();
		}

		return null;
	}

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
