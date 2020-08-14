package io.intino.goros.builder.renderers.definition;

import io.intino.goros.builder.Modernization;
import io.intino.goros.builder.renderers.DefinitionRenderer;
import io.intino.goros.builder.renderers.templates.java.FormTemplate;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.Template;
import org.monet.metamodel.FormDefinition;

public class FormRenderer extends DefinitionRenderer<FormDefinition> {

	public FormRenderer(Modernization modernization, FormDefinition definition) {
		super(modernization, definition);
	}

	@Override
	protected FrameBuilder buildFrame() {
		return baseFrame();
	}

	@Override
	protected Template konosTemplate() {
		return new io.intino.goros.builder.renderers.templates.konos.FormTemplate();
	}

	@Override
	protected Template javaTemplate() {
		return new FormTemplate();
	}
}
