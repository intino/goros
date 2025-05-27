package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.goros.unit.box.UnitBox;

import java.util.HashMap;

public class DashboardTemplate extends AbstractDashboardTemplate<UnitBox> {

	public DashboardTemplate(UnitBox box) {
		super(box);
	}

	@Override
	public void init() {
		super.init();
		dashboardStamp.url(box().configuration().metabaseUrl());
		dashboardStamp.secretKey(box().configuration().metabaseDashboardSecretKey());
		dashboardStamp.dashboard(Integer.parseInt(box().configuration().metabaseDashboardId()));
		dashboardStamp.parameters(new HashMap<>());
	}

	@Override
	public void refresh() {
		super.refresh();
		dashboardStamp.refresh();
	}

}