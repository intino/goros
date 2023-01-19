package io.intino.goros.unit.box;

import org.monet.encrypt.CertificateVerifier;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static io.intino.goros.unit.util.LayerHelper.federationLayer;

public class FrontServiceServiceAuthenticator {
 	private UnitBox box;

 	public FrontServiceServiceAuthenticator(UnitBox box) {
		this.box = box;
	}

	public boolean isAuthenticated(Map<String, String> parameters) {
		String signature = parameters.get(Parameter.SIGNATURE);
		String timestamp = parameters.get(Parameter.TIMESTAMP);
		if (signature == null || timestamp == null) return false;
		return federationLayer().validateRequest(signature, Long.valueOf(timestamp), toList(parameters)).isValid();
	}

	private ArrayList<Map.Entry<String, Object>> toList(Map<String, String> params) {
		Map<String, Object> result = new HashMap<>(params);
		return new ArrayList<>(result.entrySet());
	}

}