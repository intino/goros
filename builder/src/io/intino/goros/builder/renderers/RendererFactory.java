package io.intino.goros.builder.renderers;

import io.intino.goros.builder.Modernization;
import io.intino.goros.builder.renderers.definition.DefaultRenderer;
import io.intino.goros.builder.renderers.definition.FormRenderer;
import org.monet.metamodel.Definition;
import org.monet.metamodel.FormDefinition;
import org.monet.space.kernel.model.DefinitionType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class RendererFactory {
	private static Map<DefinitionType, BiFunction<Modernization, Definition, DefinitionRenderer<? extends Definition>>> renderers = new HashMap<>();

	static {
		renderers.put(DefinitionType.form, (settings, definition) -> new FormRenderer(settings, (FormDefinition) definition));
	}

	public DefinitionRenderer renderer(Modernization modernization, Definition definition) {
		if (definition.getType() == null) return null;
		return renderers.getOrDefault(definition.getType(), DefaultRenderer::new).apply(modernization, definition);
	}

}
