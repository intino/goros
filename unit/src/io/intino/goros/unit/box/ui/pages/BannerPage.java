package io.intino.goros.unit.box.ui.pages;

import io.intino.goros.unit.box.I18n;
import io.intino.goros.unit.box.ui.displays.templates.GorosAppTemplate;
import io.intino.goros.unit.util.Formatters;
import org.monet.space.kernel.components.ComponentFederation;
import org.monet.space.kernel.model.Banner;
import spark.utils.IOUtils;

import java.io.IOException;

public class BannerPage extends AbstractBannerPage {

	private static final String NoInfo = "<html><head><link type=\"text/css\" rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Roboto:300\"></head><body><div>No information available</div></body></html>";

	@Override
	public String execute() {
		try {
			String content = IOUtils.toString(BannerPage.class.getResourceAsStream("/banner.tpl"));
			return replaceMarks(content);
		} catch (IOException e) {
			return NoInfo;
		}
	}

	private String replaceMarks(String content) {
		Banner banner = ComponentFederation.getInstance().getDefaultLayer().loadBanner();
		String language = session.discoverLanguage();
		String activeTasksMessage = Formatters.countMessage(banner.getCountActiveTasks(), I18n.translate("active task", language), I18n.translate("active tasks", language));
		String pendingTasksMessage = Formatters.countMessage(banner.getCountAliveTasks(), I18n.translate("pending task", language), I18n.translate("pending tasks", language));
		String noPermissionsMessage = I18n.translate("Restricted information", language);
		content = content.replace("::title::", banner.getTitle());
		content = content.replace("::activeTasksMessage::", activeTasksMessage);
		content = content.replace("::pendingTasksMessage::", pendingTasksMessage);
		content = content.replace("::noPermissionsMessage::", noPermissionsMessage);
		content = content.replace("::hasPermissions::", String.valueOf(banner.hasPermissions()));
		content = content.replace("::noHasPermissions::", String.valueOf(!banner.hasPermissions()));
		return content;
	}

	public io.intino.alexandria.ui.Soul prepareSoul(io.intino.alexandria.ui.services.push.UIClient client) {
		return new io.intino.alexandria.ui.Soul(session) {
			@Override
			public void personify() {
				GorosAppTemplate component = new GorosAppTemplate(box);
				register(component);
				component.init();
			}
		};
	}

}