package io.intino.goros.builders.renderers.definition;

import io.intino.goros.builders.Modernization;
import io.intino.goros.builders.monet.Dictionary;
import io.intino.goros.builders.renderers.DefinitionRenderer;
import io.intino.goros.builders.renderers.templates.java.DefaultTemplate;
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
		return new io.intino.goros.builders.renderers.templates.konos.DefaultTemplate();
	}

	@Override
	protected Template javaTemplate() {
		return new DefaultTemplate();
	}
}
