package org.monet.bpi.java;

import org.monet.bpi.Role;
import org.monet.bpi.RoleService;
import org.monet.bpi.types.Date;

import java.util.List;

public class RoleServiceImpl extends RoleService {
	@Override
	protected List<Role> getNonExpiredRolesImpl(String name) {
		return null;
	}

	@Override
	protected Role getRoleImpl(String id) {
		return null;
	}

	@Override
	protected Role assignRoleToUserImpl(String name, String username, Date from, Date to) {
		return null;
	}

	@Override
	protected Role assignRoleToServiceImpl(String name, String serviceName, String serviceUrl, Date from, Date to) {
		return null;
	}
}
