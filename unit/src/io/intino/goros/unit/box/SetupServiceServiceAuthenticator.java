package io.intino.goros.unit.box;

import io.intino.alexandria.logger.Logger;
import org.apache.commons.codec.binary.Base64;
import org.monet.encrypt.CertificateVerifier;
import org.monet.encrypt.extractor.CertificateExtractor;
import org.monet.encrypt.extractor.ExtractorUser;
import org.monet.space.backservice.control.constants.Parameter;
import org.monet.space.kernel.components.ComponentFederation;
import org.monet.space.kernel.components.layers.MasterLayer;
import org.monet.space.kernel.model.BusinessUnit;
import org.monet.space.kernel.model.UserInfo;

import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;

public class SetupServiceServiceAuthenticator extends GorosAuthenticator {
 	private UnitBox box;

 	public SetupServiceServiceAuthenticator(UnitBox box) {
		this.box = box;
	}

	public boolean isAuthenticated(Map<String, List<String>> parameters) {
		try {
			String signature = value(parameters, Parameter.SIGNATURE);
			if (signature == null) return false;
			MasterLayer masterLayer = ComponentFederation.getMasterLayer();
			byte[] signatureBytes = Base64.decodeBase64(signature);
			X509Certificate certificate = CertificateVerifier.getCertificateFromSignature(signatureBytes);
			CertificateExtractor extractor = new CertificateExtractor();
			ExtractorUser user = extractor.extractUser(certificate);
			String authority = extractor.extractAuthorityName(certificate);

			if (!BusinessUnit.getInstance().isInstalled()) {
				UserInfo info = new UserInfo();

				info.setFullname(user.getFullname());
				info.setEmail(user.getEmail());

				masterLayer.addMaster(user.getUsername(), authority, true, info);
				return true;
			}

			return masterLayer.exists(user.getUsername(), authority);
		} catch (Exception e) {
			Logger.error(e);
			return false;
		}
	}
}