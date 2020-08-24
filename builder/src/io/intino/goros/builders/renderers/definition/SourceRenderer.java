package io.intino.goros.builders.renderers.definition;

import io.intino.goros.builders.Modernization;
import io.intino.goros.builders.monet.Dictionary;
import io.intino.goros.builders.renderers.DefinitionRenderer;
import io.intino.goros.builders.renderers.templates.java.SourceDefinitionTemplate;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.Template;
import org.monet.metamodel.DesktopDefinition;
import org.monet.metamodel.DesktopDefinitionBase;
import org.monet.metamodel.SourceDefinition;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class SourceRenderer extends DefinitionRenderer<SourceDefinition> {

	public SourceRenderer(Dictionary dictionary, Modernization modernization, SourceDefinition definition) {
		super(dictionary, modernization, definition);
	}

	@Override
	protected FrameBuilder buildFrame() {
		FrameBuilder result = baseFrame().add("source");
		SourceDefinition definition = definition();
		result.add("name", nameOf(definition));
		result.add("code", definition.getCode());
		result.add("label", definition.getLabel());
		addDesktop(result);
		return result;
	}

	@Override
	protected Template konosTemplate() {
		return new io.intino.goros.builders.renderers.templates.konos.SourceDefinitionTemplate();
	}

	@Override
	protected Template javaTemplate() {
		return new SourceDefinitionTemplate();
	}

}
