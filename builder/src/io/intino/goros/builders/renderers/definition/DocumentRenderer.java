package io.intino.goros.builders.renderers.definition;

import io.intino.goros.builders.Modernization;
import io.intino.goros.builders.monet.Dictionary;
import io.intino.goros.builders.renderers.templates.java.DocumentTemplate;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.Template;
import org.monet.metamodel.*;

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
		result.add("code", viewProperty.getCode());
		result.add("name", nameOf(viewProperty));
		result.add("label", labelOf(viewProperty));
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
		return new io.intino.goros.builders.renderers.templates.konos.DocumentTemplate();
	}

	@Override
	protected Template javaTemplate() {
		return new DocumentTemplate();
	}

}
