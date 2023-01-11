package io.intino.goros.unit.box;

public class FmsServiceServiceAuthenticator {
 	private UnitBox box;

 	public FmsServiceServiceAuthenticator(UnitBox box) {
		this.box = box;
	}

	public boolean isAuthenticated(String token) {
		return box.authenticationValidator().validate(token);
	}
}