package io.intino.goros.unit.box;

public class SetupServiceServiceAuthenticator {
 	private UnitBox box;

 	public SetupServiceServiceAuthenticator(UnitBox box) {
		this.box = box;
	}

	public boolean isAuthenticated(String token) {
		return box.authenticationValidator().validate(token);
	}
}