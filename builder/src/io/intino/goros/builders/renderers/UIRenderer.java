package io.intino.goros.builders.renderers;

import io.intino.goros.builders.Modernization;
import io.intino.goros.builders.monet.Dictionary;
import io.intino.goros.builders.renderers.templates.konos.UITemplate;
import io.intino.itrules.FrameBuilder;
import org.monet.metamodel.Definition;
import org.monet.metamodel.DesktopDefinition;
import org.monet.metamodel.NodeDefinition;

import java.io.File;
import java.util.List;

public class UIRenderer extends Renderer {
	private final List<Definition> definitionList;

	public UIRenderer(Dictionary dictionary, Modernization modernization, List<Definition> definitionList) {
		super(dictionary, modernization);
		this.definitionList = definitionList;
	}

	@Override
	public void write() {
		FrameBuilder builder = buildFrame();
		writeAppTemplate();
		writeRouteDispatcherTemplate();
		writeHeaderTemplate();
		writeFrame(file(), new UITemplate().render(builder.toFrame()));
	}

	private FrameBuilder buildFrame() {
		FrameBuilder result = baseFrame();
		result.add("ui");
		Definition desktopDefinition = definitionList.stream().filter(d -> d instanceof DesktopDefinition).findFirst().orElse(null);
		if (desktopDefinition != null) result.add("defaultDesktop", nameOf(desktopDefinition));
		addRootDefinitions(result);
		return result;
	}

	private void addRootDefinitions(FrameBuilder builder) {
		definitionList.forEach(d -> builder.add("definition", definitionFrame(d)));
	}

	private FrameBuilder definitionFrame(Definition definition) {
		FrameBuilder result = baseFrame().add("definition");
		result.add(definition.getType().name().toLowerCase());
		if (definition instanceof NodeDefinition && ((NodeDefinition)definition).isSingleton()) result.add("singleton");
		result.add("name", nameOf(definition));
		result.add("code", definition.getCode());
		result.add("label", definition.getLabel());
		return result;
	}

	private File file() {
		return new File(modernization.sourceUiDirectory() + File.separator + "UI.konos");
	}

	private void writeAppTemplate() {
		FrameBuilder builder = buildFrame().add("app");
		File file = new File(modernization.sourceUiDirectory() + File.separator + "displays" + File.separator + "templates" + File.separator + "AppTemplate.java");
		writeFrame(file, new io.intino.goros.builders.renderers.templates.java.UITemplate().render(builder.toFrame()));
	}

	private void writeRouteDispatcherTemplate() {
		FrameBuilder builder = buildFrame().add("routedispatcher");
		File file = new File(modernization.sourceUiDirectory() + File.separator + "displays" + File.separator + "RouteDispatcher.java");
		writeFrame(file, new io.intino.goros.builders.renderers.templates.java.UITemplate().render(builder.toFrame()));
	}

	private void writeHeaderTemplate() {
		FrameBuilder builder = buildFrame().add("header");
		File file = new File(modernization.sourceUiDirectory() + File.separator + "displays" + File.separator + "templates" + File.separator + "HeaderTemplate.java");
		writeFrame(file, new io.intino.goros.builders.renderers.templates.java.UITemplate().render(builder.toFrame()));
	}

}