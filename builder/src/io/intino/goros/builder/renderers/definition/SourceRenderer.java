package io.intino.goros.builder.renderers.definition;

import io.intino.goros.builder.Modernization;
import io.intino.goros.builder.monet.Dictionary;
import io.intino.goros.builder.renderers.DefinitionRenderer;
import io.intino.goros.builder.renderers.templates.java.SourceDefinitionTemplate;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.Template;
import org.monet.metamodel.SourceDefinition;

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
		return result;
	}

	@Override
	protected Template konosTemplate() {
		return new io.intino.goros.builder.renderers.templates.konos.SourceDefinitionTemplate();
	}

	@Override
	protected Template javaTemplate() {
		return new SourceDefinitionTemplate();
	}

}
