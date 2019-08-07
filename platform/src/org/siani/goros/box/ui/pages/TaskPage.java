package org.siani.goros.box.ui.pages;

public class TaskPage extends AbstractTaskPage {
	public String id;

	public io.intino.alexandria.ui.Soul prepareSoul(io.intino.alexandria.ui.services.push.UIClient client) {
	    return new io.intino.alexandria.ui.Soul(session) {
			@Override
			public void personify() {
				org.siani.goros.box.ui.displays.templates.TaskPage component = new org.siani.goros.box.ui.displays.templates.TaskPage(box);
				register(component);
				component.init();
			}
		};
	}
}