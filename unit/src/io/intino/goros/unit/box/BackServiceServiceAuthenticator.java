package io.intino.goros.unit.box;

public class BackServiceServiceAuthenticator {
 	private UnitBox box;

 	public BackServiceServiceAuthenticator(UnitBox box) {
		this.box = box;
	}

	public boolean isAuthenticated(String token) {
		return box.authenticationValidator().validate(token);
	}
}