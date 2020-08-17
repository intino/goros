package io.intino.goros.builder.renderers;

import io.intino.goros.builder.Modernization;
import io.intino.goros.builder.monet.Dictionary;
import io.intino.goros.builder.renderers.templates.konos.UITemplate;
import io.intino.itrules.FrameBuilder;
import org.monet.metamodel.Definition;

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
		writeFrame(file(), new UITemplate().render(builder.toFrame()));
	}

	private FrameBuilder buildFrame() {
		FrameBuilder result = baseFrame();
		result.add("ui");
		addRootDefinitions(result);
		return result;
	}

	private void addRootDefinitions(FrameBuilder builder) {
		definitionList.forEach(d -> builder.add("definition", definitionFrame(d)));
	}

	private FrameBuilder definitionFrame(Definition definition) {
		FrameBuilder result = new FrameBuilder("definition");
		result.add("name", nameOf(definition));
		return result;
	}

	private File file() {
		return new File(modernization.sourceUiDirectory() + File.separator + "UI.konos");
	}

}