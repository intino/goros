package org.monet.bpi.java;

import org.monet.bpi.Role;
import org.monet.bpi.RoleChooser;

import java.util.ArrayList;
import java.util.List;

public class RoleChooserImpl implements RoleChooser {

	@Override
	public List<Role> getCandidates() {
		return null;
	}

	@Override
	public Role findByPartnerName(String partnerName) {
		return null;
	}

	@Override
	public void choose(Role role) {
	}

	@Override
	public void chooseNone() {
	}

}
