package io.intino.goros.builder.renderers;

import io.intino.goros.builder.Modernization;
import io.intino.goros.builder.monet.Dictionary;
import io.intino.goros.builder.renderers.definition.*;
import org.monet.metamodel.*;
import org.monet.space.kernel.model.DefinitionType;

import java.util.HashMap;
import java.util.Map;

public class DefinitionRendererFactory {
	private static Map<DefinitionType, DefinitionRendererBuilder<? extends DefinitionRenderer<?>>> renderers = new HashMap<>();

	static {
		renderers.put(DefinitionType.activity, (dictionary, modernization, definition) -> new ActivityRenderer(dictionary, modernization, (ActivityDefinition)definition));
		renderers.put(DefinitionType.form, (dictionary, modernization, definition) -> new FormRenderer(dictionary, modernization, (FormDefinition)definition));
		renderers.put(DefinitionType.container, (dictionary, modernization, definition) -> new ContainerRenderer(dictionary, modernization, (ContainerDefinition) definition));
		renderers.put(DefinitionType.collection, (dictionary, modernization, definition) -> new CollectionRenderer(dictionary, modernization, (CollectionDefinition) definition));
	}

	public DefinitionRenderer renderer(Dictionary dictionary, Modernization modernization, Definition definition) {
		if (definition.getType() == null) return null;
		return renderers.getOrDefault(definition.getType(), DefaultDefinitionRenderer::new).build(dictionary, modernization, definition);
	}

	private interface DefinitionRendererBuilder<R extends DefinitionRenderer<?>> {
		R build(Dictionary dictionary, Modernization modernization, Definition definition);
	}

}