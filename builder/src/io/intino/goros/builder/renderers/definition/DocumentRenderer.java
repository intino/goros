package io.intino.goros.builder.renderers.definition;

import io.intino.goros.builder.Modernization;
import io.intino.goros.builder.monet.Dictionary;
import io.intino.goros.builder.renderers.templates.java.ContainerTemplate;
import io.intino.goros.builder.renderers.templates.java.DocumentTemplate;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.Template;
import org.monet.metamodel.*;
import org.monet.metamodel.internal.Ref;

import java.util.ArrayList;

public class DocumentRenderer extends NodeRenderer<DocumentDefinition> {

	public DocumentRenderer(Dictionary dictionary, Modernization modernization, DocumentDefinition definition) {
		super(dictionary, modernization, definition);
	}

	@Override
	public void write() {
		FrameBuilder builder = buildFrame();
		writeJava(builder);
		writeKonos(builder);
		writeEmbeddedTemplate();
	}

	@Override
	protected FrameBuilder buildFrame() {
		return super.buildFrame().add("documentdefinition");
	}

	@Override
	protected FrameBuilder viewFrame(NodeViewProperty viewProperty) {
		FrameBuilder result = baseFrame().add("nodeview");
		result.add(typeOf(viewProperty));
		NodeDefinition definition = definition();
		result.add("definition", nameOf(definition));
		result.add("label", viewProperty.getLabel());
		result.add("name", nameOf(viewProperty));
		result.add("code", viewProperty.getCode());
		return result;
	}

	@Override
	protected boolean isVisibleOnRevision(NodeViewProperty viewProperty) {
		return false;
	}

	@Override
	protected boolean hasTemplate(NodeViewProperty viewProperty) {
		return false;
	}

	@Override
	protected Template konosTemplate() {
		return new io.intino.goros.builder.renderers.templates.konos.DocumentTemplate();
	}

	@Override
	protected Template javaTemplate() {
		return new DocumentTemplate();
	}

}
