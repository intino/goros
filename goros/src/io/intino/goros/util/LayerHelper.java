package io.intino.goros.util;

import io.intino.alexandria.ui.services.push.UISession;
import org.monet.http.Request;
import org.monet.space.kernel.components.ComponentFederation;
import org.monet.space.kernel.components.ComponentPersistence;
import org.monet.space.kernel.components.layers.*;
import org.monet.space.office.configuration.Configuration;

public class LayerHelper {

	public static NodeLayer nodeLayer() {
		return ComponentPersistence.getInstance().getNodeLayer();
	}

	public static SourceLayer sourceLayer() {
		return ComponentPersistence.getInstance().getSourceLayer();
	}

	public static TaskLayer taskLayer() {
		return ComponentPersistence.getInstance().getTaskLayer();
	}

	public static RoleLayer roleLayer() {
		return ComponentFederation.getInstance().getRoleLayer();
	}

	public static FederationLayer federationLayer(UISession session) {
		return ComponentFederation.getInstance().getLayer(new FederationLayer.Configuration() {
			@Override
			public String getSessionId() {
				return session.id();
			}

			@Override
			public String getCallbackUrl() {
				return session.browser().baseUrl();
			}

			@Override
			public String getLogoUrl() {
				return Configuration.getInstance().getFederationLogoUrl();
			}

			@Override
			public Request getRequest() {
				return null;
			}
		});
	}
}
