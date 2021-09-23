package io.intino.goros.unit.box.ui.datasources;

import io.intino.alexandria.ui.services.push.UISession;
import io.intino.goros.unit.util.LayerHelper;
import org.monet.space.kernel.model.FederationUnit;
import org.monet.space.kernel.model.FederationUnitFeeder;
import org.monet.space.kernel.model.FederationUnitService;

import java.text.Normalizer;
import java.util.Arrays;

public class DatasourceHelper {

	public static String partnerLabel(UISession session, FederationUnitFeeder feeder) {
		return partnerLabel(session, feeder.getLabel());
	}

	public static String partnerLabel(UISession session, FederationUnitService service) {
		return partnerLabel(session, service.getPartnerId());
	}

	public static String partnerLabel(UISession session, String partnerId) {
		return partner(session, partnerId).getLabel();
	}

	public static FederationUnit partner(UISession session, String partnerId) {
		return LayerHelper.federationLayer(session).loadPartner(partnerId);
	}

	public static boolean matches(String value, String[] conditions) {
		if (value == null) return false;
		final String cleanedValue = clean(value.toLowerCase());
		return Arrays.stream(conditions).allMatch(c -> cleanedValue.contains(clean(c)));
	}

	private static String clean(String value) {
		value = Normalizer.normalize(value, Normalizer.Form.NFD);
		value = value.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
		return value;
	}

}
