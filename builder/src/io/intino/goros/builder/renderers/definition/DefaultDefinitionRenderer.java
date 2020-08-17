package io.intino.goros.builder.renderers.definition;

import io.intino.goros.builder.Modernization;
import io.intino.goros.builder.monet.Dictionary;
import io.intino.goros.builder.renderers.DefinitionRenderer;
import io.intino.goros.builder.renderers.templates.java.DefaultTemplate;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.Template;
import org.monet.metamodel.Definition;

public class DefaultDefinitionRenderer extends DefinitionRenderer<Definition> {

	public DefaultDefinitionRenderer(Dictionary dictionary, Modernization modernization, Definition definition) {
		super(dictionary, modernization, definition);
	}

	@Override
	protected FrameBuilder buildFrame() {
		return baseDefinitionFrame();
	}

	@Override
	protected Template konosTemplate() {
		return new io.intino.goros.builder.renderers.templates.konos.DefaultTemplate();
	}

	@Override
	protected Template javaTemplate() {
		return new DefaultTemplate();
	}
}
