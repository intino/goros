package io.intino.goros.modernizing.monet.renderers.definition;

import io.intino.goros.modernizing.Modernization;
import io.intino.goros.modernizing.monet.Dictionary;
import io.intino.goros.modernizing.monet.renderers.templates.konos.DefaultTemplate;
import io.intino.goros.modernizing.monet.renderers.DefinitionRenderer;
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
		return new DefaultTemplate();
	}

	@Override
	protected Template javaTemplate() {
		return new io.intino.goros.modernizing.monet.renderers.templates.java.DefaultTemplate();
	}
}
