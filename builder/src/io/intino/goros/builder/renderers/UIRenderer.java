package io.intino.goros.builder.renderers;

import io.intino.goros.builder.Modernization;
import io.intino.itrules.FrameBuilder;
import org.monet.bpi.Exporter;
import org.monet.metamodel.Definition;
import io.intino.goros.builder.renderers.templates.konos.UITemplate;
import org.monet.metamodel.ExporterDefinition;
import org.monet.metamodel.NodeDefinition;
import org.monet.metamodel.RoleDefinition;

import java.io.File;
import java.util.List;

public class UIRenderer extends Renderer {
	private final List<Definition> definitionList;

	public UIRenderer(Modernization modernization, List<Definition> definitionList) {
		super(modernization);
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
		addRootDefinitions();
		return result;
	}

	private void addRootDefinitions() {
		definitionList.forEach(d -> {
			FrameBuilder result = new FrameBuilder("resource");
		});
	}

	private File file() {
		return new File(modernization.sourceUiDirectory() + File.separator + "UI.konos");
	}

}