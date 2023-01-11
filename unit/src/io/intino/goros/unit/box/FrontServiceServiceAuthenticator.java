package io.intino.goros.unit.box;

public class FrontServiceServiceAuthenticator {
 	private UnitBox box;

 	public FrontServiceServiceAuthenticator(UnitBox box) {
		this.box = box;
	}

	public boolean isAuthenticated(String token) {
		return box.authenticationValidator().validate(token);
	}
}