package io.intino.goros.unit.box;

public class MobileServiceServiceAuthenticator {
 	private UnitBox box;

 	public MobileServiceServiceAuthenticator(UnitBox box) {
		this.box = box;
	}

	public boolean isAuthenticated(String token) {
		return box.authenticationValidator().validate(token);
	}
}