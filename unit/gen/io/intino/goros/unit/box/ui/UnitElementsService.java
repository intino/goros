package io.intino.goros.unit.box.ui;
import io.intino.goros.unit.box.ui.displays.*;
import io.intino.goros.unit.box.ui.resources.*;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.box.UnitConfiguration;

import io.intino.alexandria.ui.UISpark;
import io.intino.alexandria.ui.displays.notifiers.DisplayNotifier;
import io.intino.alexandria.ui.displays.notifiers.DisplayNotifierProvider;
import io.intino.alexandria.ui.displays.DisplayRouteDispatcher;
import io.intino.alexandria.ui.resources.AssetResourceLoader;
import io.intino.alexandria.ui.services.push.PushService;
import io.intino.alexandria.ui.spark.resources.AfterDisplayRequest;
import io.intino.alexandria.ui.spark.resources.AssetResource;
import io.intino.alexandria.ui.spark.resources.AuthenticateCallbackResource;
import io.intino.alexandria.ui.spark.resources.BeforeDisplayRequest;

import java.net.MalformedURLException;
import java.net.URL;

public class UnitElementsService extends io.intino.alexandria.ui.UI {

	public static void init(UISpark spark, UnitBox box, PushService pushService, DisplayRouteDispatcher routeDispatcher) {
		UnitConfiguration configuration = (UnitConfiguration) box.configuration();
		box.routeManager(routeManager(spark, routeDispatcher));
		spark.route("/push").push(pushService);
		spark.route("/authenticate-callback").get(manager -> new AuthenticateCallbackResource(manager, notifierProvider()).execute());
		spark.route("/asset/:name").get(manager -> new AssetResource(name -> new AssetResourceLoader(box).load(name), manager, notifierProvider()).execute());
		spark.route("/alexandria/user").get(manager -> new HomeResource(box, manager, notifierProvider()).execute());
		spark.route("/goros-home").get(manager -> new HomeResource(box, manager, notifierProvider()).execute());
		spark.route("/roles").get(manager -> new RolesResource(box, manager, notifierProvider()).execute());
		initDisplays(spark, pushService);
	}

	public static void initDisplays(UISpark spark, PushService pushService) {
		spark.route("/tasktoolbartemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/tasktoolbartemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/tasktoolbartemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("tasktoolbartemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/sourcetemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/sourcetemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/sourcetemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("sourcetemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/sourceembeddedtemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/sourceembeddedtemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/sourceembeddedtemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("sourceembeddedtemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/sourceleveltemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/sourceleveltemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/sourceleveltemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("sourceleveltemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/sourcelegendtemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/sourcelegendtemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/sourcelegendtemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("sourcelegendtemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/publishtermsdialog/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/publishtermsdialog/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/publishtermsdialog/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("publishtermsdialog", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/sourcetermdialog/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/sourcetermdialog/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/sourcetermdialog/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("sourcetermdialog", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/sourcetermtagtemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/sourcetermtagtemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/sourcetermtagtemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("sourcetermtagtemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/trashtemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/trashtemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/trashtemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("trashtemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/trashtoolbartemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/trashtoolbartemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/trashtoolbartemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("trashtoolbartemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/trashtablecatalog/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/trashtablecatalog/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/trashtablecatalog/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("trashtablecatalog", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/trashtablefilters/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/trashtablefilters/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/trashtablefilters/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("trashtablefilters", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/nodedownloaddialog/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/nodedownloaddialog/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/nodedownloaddialog/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("nodedownloaddialog", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/nodedownloaddialogoption/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/nodedownloaddialogoption/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/nodedownloaddialogoption/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("nodedownloaddialogoption", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/rolestemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/rolestemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/rolestemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("rolestemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/rolestablecatalog/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/rolestablecatalog/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/rolestablecatalog/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("rolestablecatalog", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/rolestoolbartemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/rolestoolbartemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/rolestoolbartemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("rolestoolbartemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/rolesfilterstemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/rolesfilterstemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/rolesfilterstemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("rolesfilterstemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/roleembeddedtemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/roleembeddedtemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/roleembeddedtemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("roleembeddedtemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/searchfiltertemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/searchfiltertemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/searchfiltertemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("searchfiltertemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/listfiltertemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/listfiltertemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/listfiltertemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("listfiltertemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/combofiltertemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/combofiltertemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/combofiltertemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("combofiltertemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/checkfiltertemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/checkfiltertemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/checkfiltertemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("checkfiltertemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/daterangefiltertemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/daterangefiltertemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/daterangefiltertemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("daterangefiltertemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/taskstateviewtemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/taskstateviewtemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/taskstateviewtemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("taskstateviewtemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/taskplacedelegationtemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/taskplacedelegationtemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/taskplacedelegationtemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("taskplacedelegationtemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/taskplaceroletemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/taskplaceroletemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/taskplaceroletemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("taskplaceroletemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/taskplacesendjobtemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/taskplacesendjobtemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/taskplacesendjobtemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("taskplacesendjobtemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/taskplacelinetemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/taskplacelinetemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/taskplacelinetemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("taskplacelinetemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/taskplacelinestoptemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/taskplacelinestoptemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/taskplacelinestoptemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("taskplacelinestoptemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/taskplaceeditiontemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/taskplaceeditiontemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/taskplaceeditiontemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("taskplaceeditiontemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/taskplaceenrolltemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/taskplaceenrolltemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/taskplaceenrolltemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("taskplaceenrolltemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/taskplacewaittemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/taskplacewaittemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/taskplacewaittemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("taskplacewaittemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/taskplacesendrequesttemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/taskplacesendrequesttemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/taskplacesendrequesttemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("taskplacesendrequesttemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/taskplacesendresponsetemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/taskplacesendresponsetemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/taskplacesendresponsetemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("taskplacesendresponsetemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/taskhistorytemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/taskhistorytemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/taskhistorytemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("taskhistorytemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/taskhistoryentrytemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/taskhistoryentrytemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/taskhistoryentrytemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("taskhistoryentrytemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/taskorderstemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/taskorderstemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/taskorderstemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("taskorderstemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/taskembeddednodetemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/taskembeddednodetemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/taskembeddednodetemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("taskembeddednodetemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/taskordertemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/taskordertemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/taskordertemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("taskordertemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/nodelinksintemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/nodelinksintemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/nodelinksintemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("nodelinksintemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/nodelinksouttemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/nodelinksouttemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/nodelinksouttemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("nodelinksouttemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/noderevisionstemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/noderevisionstemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/noderevisionstemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("noderevisionstemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/nodenotestemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/nodenotestemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/nodenotestemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("nodenotestemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/nodelocationtemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/nodelocationtemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/nodelocationtemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("nodelocationtemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/nodedocumenttemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/nodedocumenttemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/nodedocumenttemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("nodedocumenttemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/fieldnodetemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/fieldnodetemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/fieldnodetemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("fieldnodetemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/taskstablecatalog/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/taskstablecatalog/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/taskstablecatalog/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("taskstablecatalog", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/taskslistcatalog/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/taskslistcatalog/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/taskslistcatalog/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("taskslistcatalog", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/taskstoolbartemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/taskstoolbartemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/taskstoolbartemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("taskstoolbartemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/tasksfilterstemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/tasksfilterstemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/tasksfilterstemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("tasksfilterstemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/gorosapptemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/gorosapptemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/gorosapptemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("gorosapptemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/businessunitstemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/businessunitstemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/businessunitstemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("businessunitstemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/businessunittemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/businessunittemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/businessunittemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("businessunittemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/newstemplate/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/newstemplate/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.TemplateRequester(manager, notifierProvider()).execute());
		spark.route("/newstemplate/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("newstemplate", new io.intino.alexandria.ui.displays.requesters.TemplatePushRequester());

		spark.route("/assigntaskdialogtablefullnameitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/assigntaskdialogtablefullnameitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/assigntaskdialogtablefullnameitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("assigntaskdialogtablefullnameitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/assigntaskdialogtableemailitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/assigntaskdialogtableemailitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/assigntaskdialogtableemailitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("assigntaskdialogtableemailitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/sourcelevellistitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/sourcelevellistitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/sourcelevellistitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("sourcelevellistitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/trashtabletypeitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/trashtabletypeitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/trashtabletypeitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("trashtabletypeitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/trashtablelabelitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/trashtablelabelitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/trashtablelabelitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("trashtablelabelitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/trashtabledeletedateitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/trashtabledeletedateitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/trashtabledeletedateitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("trashtabledeletedateitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/trashtableoperationsitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/trashtableoperationsitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/trashtableoperationsitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("trashtableoperationsitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/rolestableuseritem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/rolestableuseritem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/rolestableuseritem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("rolestableuseritem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/rolestabledefinitionitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/rolestabledefinitionitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/rolestabledefinitionitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("rolestabledefinitionitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/rolestabletypeitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/rolestabletypeitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/rolestabletypeitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("rolestabletypeitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/rolestablenatureitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/rolestablenatureitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/rolestablenatureitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("rolestablenatureitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/rolestablestartdateitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/rolestablestartdateitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/rolestablestartdateitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("rolestablestartdateitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/rolestableenddateitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/rolestableenddateitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/rolestableenddateitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("rolestableenddateitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/rolestableoperationsitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/rolestableoperationsitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/rolestableoperationsitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("rolestableoperationsitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/addroleusertablefullnameitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/addroleusertablefullnameitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/addroleusertablefullnameitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("addroleusertablefullnameitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/addroleusertableemailitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/addroleusertableemailitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/addroleusertableemailitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("addroleusertableemailitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/addroleservicetablelabelitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/addroleservicetablelabelitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/addroleservicetablelabelitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("addroleservicetablelabelitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/addroleservicetablepartneritem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/addroleservicetablepartneritem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/addroleservicetablepartneritem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("addroleservicetablepartneritem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/addrolefeedertablelabelitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/addrolefeedertablelabelitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/addrolefeedertablelabelitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("addrolefeedertablelabelitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/addrolefeedertablepartneritem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/addrolefeedertablepartneritem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/addrolefeedertablepartneritem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("addrolefeedertablepartneritem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/linksintablelabelitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/linksintablelabelitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/linksintablelabelitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("linksintablelabelitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/linksintabledescriptionitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/linksintabledescriptionitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/linksintabledescriptionitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("linksintabledescriptionitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/linksouttablelabelitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/linksouttablelabelitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/linksouttablelabelitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("linksouttablelabelitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/linksouttabledescriptionitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/linksouttabledescriptionitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/linksouttabledescriptionitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("linksouttabledescriptionitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/noderevisionstablelabelitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/noderevisionstablelabelitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/noderevisionstablelabelitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("noderevisionstablelabelitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/noderevisionstableoperationsitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/noderevisionstableoperationsitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/noderevisionstableoperationsitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("noderevisionstableoperationsitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/nodenotestablenameitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/nodenotestablenameitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/nodenotestablenameitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("nodenotestablenameitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/nodenotestablevalueitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/nodenotestablevalueitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/nodenotestablevalueitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("nodenotestablevalueitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/nodenotestableoperationsitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/nodenotestableoperationsitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/nodenotestableoperationsitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("nodenotestableoperationsitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/taskstablelabelitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/taskstablelabelitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/taskstablelabelitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("taskstablelabelitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/taskstabledescriptionitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/taskstabledescriptionitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/taskstabledescriptionitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("taskstabledescriptionitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/taskstableowneritem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/taskstableowneritem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/taskstableowneritem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("taskstableowneritem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/taskstablecreatedateitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/taskstablecreatedateitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/taskstablecreatedateitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("taskstablecreatedateitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/taskstableupdatedateitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/taskstableupdatedateitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/taskstableupdatedateitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("taskstableupdatedateitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/taskstablecountmessagesitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/taskstablecountmessagesitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/taskstablecountmessagesitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("taskstablecountmessagesitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/taskstableoperationsitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/taskstableoperationsitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/taskstableoperationsitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("taskstableoperationsitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/taskslistitem/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/taskslistitem/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.ItemRequester(manager, notifierProvider()).execute());
		spark.route("/taskslistitem/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("taskslistitem", new io.intino.alexandria.ui.displays.requesters.ItemPushRequester());

		spark.route("/assigntaskdialogtablerow/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/assigntaskdialogtablerow/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.RowRequester(manager, notifierProvider()).execute());
		spark.route("/assigntaskdialogtablerow/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("assigntaskdialogtablerow", new io.intino.alexandria.ui.displays.requesters.RowPushRequester());

		spark.route("/trashtablerow/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/trashtablerow/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.RowRequester(manager, notifierProvider()).execute());
		spark.route("/trashtablerow/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("trashtablerow", new io.intino.alexandria.ui.displays.requesters.RowPushRequester());

		spark.route("/rolestablerow/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/rolestablerow/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.RowRequester(manager, notifierProvider()).execute());
		spark.route("/rolestablerow/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("rolestablerow", new io.intino.alexandria.ui.displays.requesters.RowPushRequester());

		spark.route("/addroleusertablerow/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/addroleusertablerow/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.RowRequester(manager, notifierProvider()).execute());
		spark.route("/addroleusertablerow/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("addroleusertablerow", new io.intino.alexandria.ui.displays.requesters.RowPushRequester());

		spark.route("/addroleservicetablerow/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/addroleservicetablerow/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.RowRequester(manager, notifierProvider()).execute());
		spark.route("/addroleservicetablerow/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("addroleservicetablerow", new io.intino.alexandria.ui.displays.requesters.RowPushRequester());

		spark.route("/addrolefeedertablerow/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/addrolefeedertablerow/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.RowRequester(manager, notifierProvider()).execute());
		spark.route("/addrolefeedertablerow/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("addrolefeedertablerow", new io.intino.alexandria.ui.displays.requesters.RowPushRequester());

		spark.route("/linksintablerow/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/linksintablerow/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.RowRequester(manager, notifierProvider()).execute());
		spark.route("/linksintablerow/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("linksintablerow", new io.intino.alexandria.ui.displays.requesters.RowPushRequester());

		spark.route("/linksouttablerow/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/linksouttablerow/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.RowRequester(manager, notifierProvider()).execute());
		spark.route("/linksouttablerow/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("linksouttablerow", new io.intino.alexandria.ui.displays.requesters.RowPushRequester());

		spark.route("/noderevisionstablerow/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/noderevisionstablerow/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.RowRequester(manager, notifierProvider()).execute());
		spark.route("/noderevisionstablerow/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("noderevisionstablerow", new io.intino.alexandria.ui.displays.requesters.RowPushRequester());

		spark.route("/nodenotestablerow/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/nodenotestablerow/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.RowRequester(manager, notifierProvider()).execute());
		spark.route("/nodenotestablerow/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("nodenotestablerow", new io.intino.alexandria.ui.displays.requesters.RowPushRequester());

		spark.route("/taskstablerow/:displayId").before(manager -> new BeforeDisplayRequest(manager).execute());
		spark.route("/taskstablerow/:displayId").post(manager -> new io.intino.alexandria.ui.displays.requesters.RowRequester(manager, notifierProvider()).execute());
		spark.route("/taskstablerow/:displayId").after(manager -> new AfterDisplayRequest(manager).execute());
		pushService.register("taskstablerow", new io.intino.alexandria.ui.displays.requesters.RowPushRequester());

		registerNotifiers();
	}

	private static void registerNotifiers() {
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.TaskToolbarTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.SourceTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.SourceEmbeddedTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.SourceLevelTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.SourceLegendTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.PublishTermsDialog.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.SourceTermDialog.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.SourceTermTagTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.TrashTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.TrashToolbarTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.TrashTableCatalog.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.TrashTableFilters.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.NodeDownloadDialog.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.NodeDownloadDialogOption.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.RolesTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.RolesTableCatalog.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.RolesToolbarTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.RolesFiltersTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.RoleEmbeddedTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.SearchFilterTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.ListFilterTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.ComboFilterTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.CheckFilterTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.DateRangeFilterTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.TaskStateViewTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.TaskPlaceDelegationTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.TaskPlaceRoleTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.TaskPlaceSendJobTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.TaskPlaceLineTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.TaskPlaceLineStopTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.TaskPlaceEditionTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.TaskPlaceEnrollTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.TaskPlaceWaitTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.TaskPlaceSendRequestTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.TaskPlaceSendResponseTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.TaskHistoryTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.TaskHistoryEntryTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.TaskOrdersTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.TaskEmbeddedNodeTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.TaskOrderTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.NodeLinksInTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.NodeLinksOutTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.NodeRevisionsTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.NodeNotesTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.NodeLocationTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.NodeDocumentTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.FieldNodeTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.TasksTableCatalog.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.TasksListCatalog.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.TasksToolbarTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.TasksFiltersTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.GorosAppTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.BusinessUnitsTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.BusinessUnitTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.TemplateNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.templates.NewsTemplate.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.AssignTaskDialogTableFullnameItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.AssignTaskDialogTableEmailItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.SourceLevelListItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.TrashTableTypeItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.TrashTableLabelItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.TrashTableDeleteDateItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.TrashTableOperationsItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.RolesTableUserItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.RolesTableDefinitionItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.RolesTableTypeItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.RolesTableNatureItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.RolesTableStartDateItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.RolesTableEndDateItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.RolesTableOperationsItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.AddRoleUserTableFullnameItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.AddRoleUserTableEmailItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.AddRoleServiceTableLabelItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.AddRoleServiceTablePartnerItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.AddRoleFeederTableLabelItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.AddRoleFeederTablePartnerItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.LinksInTableLabelItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.LinksInTableDescriptionItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.LinksOutTableLabelItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.LinksOutTableDescriptionItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.NodeRevisionsTableLabelItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.NodeRevisionsTableOperationsItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.NodeNotesTableNameItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.NodeNotesTableValueItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.NodeNotesTableOperationsItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.TasksTableLabelItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.TasksTableDescriptionItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.TasksTableOwnerItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.TasksTableCreateDateItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.TasksTableUpdateDateItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.TasksTableCountMessagesItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.TasksTableOperationsItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.ItemNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.items.TasksListItem.class);
		register(io.intino.alexandria.ui.displays.notifiers.RowNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.rows.AssignTaskDialogTableRow.class);
		register(io.intino.alexandria.ui.displays.notifiers.RowNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.rows.TrashTableRow.class);
		register(io.intino.alexandria.ui.displays.notifiers.RowNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.rows.RolesTableRow.class);
		register(io.intino.alexandria.ui.displays.notifiers.RowNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.rows.AddRoleUserTableRow.class);
		register(io.intino.alexandria.ui.displays.notifiers.RowNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.rows.AddRoleServiceTableRow.class);
		register(io.intino.alexandria.ui.displays.notifiers.RowNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.rows.AddRoleFeederTableRow.class);
		register(io.intino.alexandria.ui.displays.notifiers.RowNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.rows.LinksInTableRow.class);
		register(io.intino.alexandria.ui.displays.notifiers.RowNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.rows.LinksOutTableRow.class);
		register(io.intino.alexandria.ui.displays.notifiers.RowNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.rows.NodeRevisionsTableRow.class);
		register(io.intino.alexandria.ui.displays.notifiers.RowNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.rows.NodeNotesTableRow.class);
		register(io.intino.alexandria.ui.displays.notifiers.RowNotifier.class).forDisplay(io.intino.goros.unit.box.ui.displays.rows.TasksTableRow.class);
	}
}