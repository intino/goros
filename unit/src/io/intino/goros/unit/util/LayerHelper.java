package io.intino.goros.unit.util;

import io.intino.alexandria.ui.services.push.UISession;
import org.monet.http.Request;
import org.monet.space.kernel.components.ComponentFederation;
import org.monet.space.kernel.components.ComponentPersistence;
import org.monet.space.kernel.components.layers.*;
import org.monet.space.office.configuration.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

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

	public static NotificationLayer notificationLayer() {
		return ComponentPersistence.getInstance().getNotificationLayer();
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
				return defaultRequest();
			}
		});
	}

	public static FederationLayer federationLayer() {
		return ComponentFederation.getInstance().getLayer(new FederationLayer.Configuration() {
			@Override
			public String getSessionId() {
				return null;
			}

			@Override
			public String getCallbackUrl() {
				return null;
			}

			@Override
			public String getLogoUrl() {
				return Configuration.getInstance().getFederationLogoUrl();
			}

			@Override
			public Request getRequest() {
				return defaultRequest();
			}
		});
	}

	public static Request defaultRequest() {
		return new Request() {
			@Override
			public Locale getLocale() {
				return null;
			}

			@Override
			public String getSessionId() {
				return null;
			}

			@Override
			public String getRequestURL() {
				return null;
			}

			@Override
			public String getContextPath() {
				return null;
			}

			@Override
			public String getHeader(String s) {
				return "";
			}

			@Override
			public Object getAttribute(String s) {
				return null;
			}

			@Override
			public String getParameter(String s) {
				return null;
			}

			@Override
			public String getRemoteAddr() {
				return null;
			}

			@Override
			public InputStream getInputStream() throws IOException {
				return null;
			}

			@Override
			public int getContentLength() {
				return 0;
			}

			@Override
			public String getContentType() {
				return null;
			}

			@Override
			public String getCharacterEncoding() {
				return null;
			}
		};
	}

}
