package io.intino.goros.builder.renderers.definition;

import io.intino.goros.builder.Modernization;
import io.intino.goros.builder.renderers.DefinitionRenderer;
import io.intino.goros.builder.renderers.templates.java.DefaultTemplate;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.Template;
import org.monet.metamodel.Definition;

public class DefaultRenderer extends DefinitionRenderer<Definition> {

	public DefaultRenderer(Modernization modernization, Definition definition) {
		super(modernization, definition);
	}

	@Override
	protected FrameBuilder buildFrame() {
		return baseFrame();
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
