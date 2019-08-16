package org.siani.goros.box.ui;
import org.siani.goros.box.ui.displays.*;
import org.siani.goros.box.ui.displays.notifiers.*;
import org.siani.goros.box.ui.displays.requesters.*;
import org.siani.goros.box.ui.resources.*;
import org.siani.goros.box.GorosBox;
import org.siani.goros.box.GorosConfiguration;

import io.intino.alexandria.ui.UISpark;
import io.intino.alexandria.ui.displays.notifiers.DisplayNotifier;
import io.intino.alexandria.ui.displays.notifiers.DisplayNotifierProvider;
import io.intino.alexandria.ui.resources.AssetResourceLoader;
import io.intino.alexandria.ui.services.push.PushService;
import io.intino.alexandria.ui.spark.resources.AfterDisplayRequest;
import io.intino.alexandria.ui.spark.resources.AssetResource;
import io.intino.alexandria.ui.spark.resources.AuthenticateCallbackResource;
import io.intino.alexandria.ui.spark.resources.BeforeDisplayRequest;

import java.net.MalformedURLException;
import java.net.URL;

public class PlatformUiService extends io.intino.alexandria.ui.UI {

	public static void init(UISpark spark, GorosBox box, PushService pushService) {
		GorosConfiguration configuration = (GorosConfiguration) box.configuration();
		box.routeManager(routeManager(spark));
		spark.route("/push").push(pushService);
		spark.route("/authenticate-callback").get(manager -> new AuthenticateCallbackResource(manager, notifierProvider()).execute());
		spark.route("/asset/:name").get(manager -> new AssetResource(name -> new AssetResourceLoader(box).load(name), manager, notifierProvider()).execute());
		spark.route("/").get(manager -> new HomeResource(box, manager, notifierProvider()).execute());
		spark.route("/node/:id").get(manager -> new NodeResource(box, manager, notifierProvider()).execute());
		spark.route("/task/:id").get(manager -> new TaskResource(box, manager, notifierProvider()).execute());
		initDisplays(spark, pushService);
	}

	public static void initDisplays(UISpark spark, PushService pushService) {
		spark.route("/page/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/page/:displayId").post(manager -> new PageRequester(manager, notifierProvider()).execute());
		spark.route("/page/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("page", new PagePushRequester());

		spark.route("/header/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/header/:displayId").post(manager -> new HeaderRequester(manager, notifierProvider()).execute());
		spark.route("/header/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("header", new HeaderPushRequester());

		spark.route("/footer/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/footer/:displayId").post(manager -> new FooterRequester(manager, notifierProvider()).execute());
		spark.route("/footer/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("footer", new FooterPushRequester());

		spark.route("/nodepage/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/nodepage/:displayId").post(manager -> new NodePageRequester(manager, notifierProvider()).execute());
		spark.route("/nodepage/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("nodepage", new NodePagePushRequester());

		spark.route("/desktoppage/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/desktoppage/:displayId").post(manager -> new DesktopPageRequester(manager, notifierProvider()).execute());
		spark.route("/desktoppage/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("desktoppage", new DesktopPagePushRequester());

		spark.route("/containerpage/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/containerpage/:displayId").post(manager -> new ContainerPageRequester(manager, notifierProvider()).execute());
		spark.route("/containerpage/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("containerpage", new ContainerPagePushRequester());

		spark.route("/collectionpage/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/collectionpage/:displayId").post(manager -> new CollectionPageRequester(manager, notifierProvider()).execute());
		spark.route("/collectionpage/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("collectionpage", new CollectionPagePushRequester());

		spark.route("/catalogpage/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/catalogpage/:displayId").post(manager -> new CatalogPageRequester(manager, notifierProvider()).execute());
		spark.route("/catalogpage/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("catalogpage", new CatalogPagePushRequester());

		spark.route("/documentpage/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/documentpage/:displayId").post(manager -> new DocumentPageRequester(manager, notifierProvider()).execute());
		spark.route("/documentpage/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("documentpage", new DocumentPagePushRequester());

		spark.route("/formpage/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/formpage/:displayId").post(manager -> new FormPageRequester(manager, notifierProvider()).execute());
		spark.route("/formpage/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("formpage", new FormPagePushRequester());

		spark.route("/taskpage/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/taskpage/:displayId").post(manager -> new TaskPageRequester(manager, notifierProvider()).execute());
		spark.route("/taskpage/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("taskpage", new TaskPagePushRequester());

		spark.route("/view/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/view/:displayId").post(manager -> new ViewRequester(manager, notifierProvider()).execute());
		spark.route("/view/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("view", new ViewPushRequester());

		spark.route("/nodeview/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/nodeview/:displayId").post(manager -> new NodeViewRequester(manager, notifierProvider()).execute());
		spark.route("/nodeview/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("nodeview", new NodeViewPushRequester());

		spark.route("/desktopview/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/desktopview/:displayId").post(manager -> new DesktopViewRequester(manager, notifierProvider()).execute());
		spark.route("/desktopview/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("desktopview", new DesktopViewPushRequester());

		spark.route("/collectionview/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/collectionview/:displayId").post(manager -> new CollectionViewRequester(manager, notifierProvider()).execute());
		spark.route("/collectionview/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("collectionview", new CollectionViewPushRequester());

		spark.route("/catalogview/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/catalogview/:displayId").post(manager -> new CatalogViewRequester(manager, notifierProvider()).execute());
		spark.route("/catalogview/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("catalogview", new CatalogViewPushRequester());

		spark.route("/formview/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/formview/:displayId").post(manager -> new FormViewRequester(manager, notifierProvider()).execute());
		spark.route("/formview/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("formview", new FormViewPushRequester());

		spark.route("/taskview/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/taskview/:displayId").post(manager -> new TaskViewRequester(manager, notifierProvider()).execute());
		spark.route("/taskview/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("taskview", new TaskViewPushRequester());

		spark.route("/stateview/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/stateview/:displayId").post(manager -> new StateViewRequester(manager, notifierProvider()).execute());
		spark.route("/stateview/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("stateview", new StateViewPushRequester());

		spark.route("/fieldview/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/fieldview/:displayId").post(manager -> new FieldViewRequester(manager, notifierProvider()).execute());
		spark.route("/fieldview/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("fieldview", new FieldViewPushRequester());

		spark.route("/textview/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/textview/:displayId").post(manager -> new TextViewRequester(manager, notifierProvider()).execute());
		spark.route("/textview/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("textview", new TextViewPushRequester());

		spark.route("/numberview/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/numberview/:displayId").post(manager -> new NumberViewRequester(manager, notifierProvider()).execute());
		spark.route("/numberview/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("numberview", new NumberViewPushRequester());

		registerNotifiers();
	}

	private static void registerNotifiers() {
		register(PageNotifier.class).forDisplay(org.siani.goros.box.ui.displays.templates.Page.class);
		register(HeaderNotifier.class).forDisplay(org.siani.goros.box.ui.displays.templates.Header.class);
		register(FooterNotifier.class).forDisplay(org.siani.goros.box.ui.displays.templates.Footer.class);
		register(NodePageNotifier.class).forDisplay(org.siani.goros.box.ui.displays.templates.NodePage.class);
		register(DesktopPageNotifier.class).forDisplay(org.siani.goros.box.ui.displays.templates.DesktopPage.class);
		register(ContainerPageNotifier.class).forDisplay(org.siani.goros.box.ui.displays.templates.ContainerPage.class);
		register(CollectionPageNotifier.class).forDisplay(org.siani.goros.box.ui.displays.templates.CollectionPage.class);
		register(CatalogPageNotifier.class).forDisplay(org.siani.goros.box.ui.displays.templates.CatalogPage.class);
		register(DocumentPageNotifier.class).forDisplay(org.siani.goros.box.ui.displays.templates.DocumentPage.class);
		register(FormPageNotifier.class).forDisplay(org.siani.goros.box.ui.displays.templates.FormPage.class);
		register(TaskPageNotifier.class).forDisplay(org.siani.goros.box.ui.displays.templates.TaskPage.class);
		register(ViewNotifier.class).forDisplay(org.siani.goros.box.ui.displays.templates.View.class);
		register(NodeViewNotifier.class).forDisplay(org.siani.goros.box.ui.displays.templates.NodeView.class);
		register(DesktopViewNotifier.class).forDisplay(org.siani.goros.box.ui.displays.templates.DesktopView.class);
		register(CollectionViewNotifier.class).forDisplay(org.siani.goros.box.ui.displays.templates.CollectionView.class);
		register(CatalogViewNotifier.class).forDisplay(org.siani.goros.box.ui.displays.templates.CatalogView.class);
		register(FormViewNotifier.class).forDisplay(org.siani.goros.box.ui.displays.templates.FormView.class);
		register(TaskViewNotifier.class).forDisplay(org.siani.goros.box.ui.displays.templates.TaskView.class);
		register(StateViewNotifier.class).forDisplay(org.siani.goros.box.ui.displays.templates.StateView.class);
		register(FieldViewNotifier.class).forDisplay(org.siani.goros.box.ui.displays.templates.FieldView.class);
		register(TextViewNotifier.class).forDisplay(org.siani.goros.box.ui.displays.templates.TextView.class);
		register(NumberViewNotifier.class).forDisplay(org.siani.goros.box.ui.displays.templates.NumberView.class);
	}
}