package org.siani.goros.box.ui.resources;

import org.siani.goros.box.GorosBox;
import org.siani.goros.box.ui.pages.HomePage;
import io.intino.alexandria.exceptions.AlexandriaException;
import io.intino.alexandria.ui.displays.notifiers.DisplayNotifierProvider;

import java.util.Base64;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;

public class HomeResource extends io.intino.alexandria.ui.spark.resources.Resource {
	private final GorosBox box;

	public HomeResource(GorosBox box, io.intino.alexandria.ui.spark.UISparkManager manager, DisplayNotifierProvider notifierProvider) {
		super(manager, notifierProvider);
		this.box = box;
	}

	@Override
	public void execute() throws AlexandriaException {
		super.execute();
		fillDeviceParameter();
		render();
	}

	private void render() {
		String clientId = UUID.randomUUID().toString();
		HomePage page = new HomePage();
		page.session = manager.currentSession();
		page.session.browser().onRedirect(location -> manager.redirect(location));
		page.session.browser().requestUrl(manager.requestUrl());
		page.session.whenLogin(new Function<String, String>() {
			@Override
			public String apply(String baseUrl) {
				return HomeResource.this.authenticate(baseUrl);
			}
		});
		page.session.whenLogout(b -> logout());
		page.box = box;
		page.clientId = clientId;
		page.device = parameterValue("device");
		page.token = parameterValue("token");

        if (!page.hasPermissions()) {
            manager.redirect(page.redirectUrl());
            return;
        }

		manager.pushService().onOpen(client -> {
			if (!client.id().equals(page.clientId))
				return false;

			if (client.soul() != null)
				return false;

			io.intino.alexandria.ui.Soul soul = page.prepareSoul(client);
			soul.onRedirect((location) -> manager.redirect(location));
			soul.addRegisterDisplayListener(display -> {
				display.inject(notifier(page.session, client, display));
				display.inject(page.session);
				display.inject(soul);
				display.inject(() -> soul);
			});
			client.soul(soul);

			box.registerSoul(clientId, soul);

			return true;
		});

		manager.pushService().onClose(clientId).execute(new Consumer<io.intino.alexandria.ui.services.push.UIClient>() {
			@Override
			public void accept(io.intino.alexandria.ui.services.push.UIClient client) {
				box.soul(client.id()).ifPresent(s -> s.destroy());
				box.unRegisterSoul(client.id());
				manager.unRegister(client);
			}
		});

		manager.write(page.execute());
	}

}