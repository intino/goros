package io.intino.goros.builder.renderers.definition;

import io.intino.goros.builder.Modernization;
import io.intino.goros.builder.monet.Dictionary;
import io.intino.goros.builder.renderers.DefinitionRenderer;
import io.intino.goros.builder.renderers.templates.java.ActivityDefinitionTemplate;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.Template;
import org.monet.metamodel.ActivityDefinition;
import org.monet.metamodel.EditionActionProperty;
import org.monet.metamodel.NodeDefinition;
import org.monet.metamodel.internal.Ref;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class ActivityRenderer extends DefinitionRenderer<ActivityDefinition> {
	private Set<String> addedDisplays = new HashSet<>();

	public ActivityRenderer(Dictionary dictionary, Modernization modernization, ActivityDefinition definition) {
		super(dictionary, modernization, definition);
	}

	@Override
	public void write() {
		super.write();
		writeEmbeddedTemplate();
		writeStateView();
	}

	@Override
	protected FrameBuilder buildFrame() {
		return baseDefinitionFrame().add("activity");
	}

	@Override
	protected Template konosTemplate() {
		return new io.intino.goros.builder.renderers.templates.konos.ActivityDefinitionTemplate();
	}

	@Override
	protected Template javaTemplate() {
		return new io.intino.goros.builder.renderers.templates.java.ActivityDefinitionTemplate();
	}

	private void writeEmbeddedTemplate() {
		FrameBuilder builder = baseDefinitionFrame().add("embedded");
		File file = new File(javaPackage() + nameOf(definition()) + "EmbeddedTemplate.java");
		writeFrame(file, new ActivityDefinitionTemplate().render(builder.toFrame()));
	}

	private void writeStateView() {
		FrameBuilder builder = baseDefinitionFrame().add("stateview");
		addDisplayList(builder);
		File file = new File(javaPackage() + nameOf(definition()) + "StateViewTemplate.java");
		writeFrame(file, new ActivityDefinitionTemplate().render(builder.toFrame()));
	}

	private void addDisplayList(FrameBuilder builder) {
		definition().getViewList().stream().filter(v -> v.getShow() != null && v.getShow().getTarget() != null).forEach(v -> {
			Ref target = v.getShow().getTarget();
			NodeDefinition definition = dictionary.getNodeDefinition(target.getDefinition());
			addDisplayFor(definition, target.getValue(), builder);
		});
		definition().getPlaceList().stream().filter(p -> p.getEditionActionProperty() != null).forEach(p -> {
			EditionActionProperty editionProperty = p.getEditionActionProperty();
			NodeDefinition definition = dictionary.getNodeDefinition(editionProperty.getUse().getForm().getValue());
			Ref withView = editionProperty.getUse().getWithView();
			addDisplayFor(definition, withView != null ? withView.getValue() : null, builder);
		});
	}

}
