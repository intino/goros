package io.intino.goros.unit.box;

import org.monet.space.backservice.control.constants.Parameter;

import java.util.List;
import java.util.Map;

import static io.intino.goros.unit.util.LayerHelper.federationLayer;

public class FrontServiceServiceAuthenticator extends GorosAuthenticator {
 	private UnitBox box;

 	public FrontServiceServiceAuthenticator(UnitBox box) {
		this.box = box;
	}

	public boolean isAuthenticated(Map<String, List<String>> parameters) {
		String signature = value(parameters, Parameter.SIGNATURE);
		String timestamp = value(parameters, Parameter.TIMESTAMP);
		if (signature == null || timestamp == null) return false;
		initialize();
		return federationLayer().validateRequest(signature, Long.valueOf(timestamp), toList(parameters)).isValid();
	}

}