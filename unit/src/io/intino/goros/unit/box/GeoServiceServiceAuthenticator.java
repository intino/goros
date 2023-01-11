package io.intino.goros.unit.box;

public class GeoServiceServiceAuthenticator {
 	private UnitBox box;

 	public GeoServiceServiceAuthenticator(UnitBox box) {
		this.box = box;
	}

	public boolean isAuthenticated(String token) {
		return box.authenticationValidator().validate(token);
	}
}