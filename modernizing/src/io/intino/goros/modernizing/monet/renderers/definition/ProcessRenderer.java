package io.intino.goros.modernizing.monet.renderers.definition;

import io.intino.goros.modernizing.Modernization;
import io.intino.goros.modernizing.monet.Dictionary;
import io.intino.goros.modernizing.monet.renderers.DefinitionRenderer;
import io.intino.goros.modernizing.monet.renderers.templates.konos.ProcessDefinitionTemplate;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.Template;
import org.monet.metamodel.NodeDefinition;
import org.monet.metamodel.ProcessDefinition;
import org.monet.metamodel.internal.Ref;

import java.io.File;

public abstract class ProcessRenderer<D extends ProcessDefinition> extends DefinitionRenderer<D> {

	public ProcessRenderer(Dictionary dictionary, Modernization modernization, D definition) {
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
		return baseDefinitionFrame().add("process");
	}

	@Override
	protected Template konosTemplate() {
		return new ProcessDefinitionTemplate();
	}

	@Override
	protected Template javaTemplate() {
		return new io.intino.goros.modernizing.monet.renderers.templates.java.ProcessDefinitionTemplate();
	}

	protected void addDisplayList(FrameBuilder builder) {
		definition().getViewList().stream().filter(v -> v.getShow() != null && v.getShow().getTarget() != null).forEach(v -> {
			Ref target = v.getShow().getTarget();
			NodeDefinition definition = dictionary.getNodeDefinition(target.getDefinition());
			addDisplayFor(definition, target.getValue(), builder);
		});
	}

	private void writeEmbeddedTemplate() {
		FrameBuilder builder = baseDefinitionFrame().add("embedded");
		File file = new File(javaPackage() + nameOf(definition()) + "EmbeddedTemplate.java");
		writeFrame(file, new io.intino.goros.modernizing.monet.renderers.templates.java.ProcessDefinitionTemplate().render(builder.toFrame()));
	}

	private void writeStateView() {
		FrameBuilder builder = baseDefinitionFrame().add("stateview");
		addDisplayList(builder);
		File file = new File(javaPackage() + nameOf(definition()) + "StateViewTemplate.java");
		writeFrame(file, new io.intino.goros.modernizing.monet.renderers.templates.java.ProcessDefinitionTemplate().render(builder.toFrame()));
	}

}
