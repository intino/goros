package io.intino.goros.modernizing.monet.renderers.definition;

import io.intino.goros.modernizing.Modernization;
import io.intino.goros.modernizing.monet.Dictionary;
import io.intino.goros.modernizing.monet.renderers.templates.konos.DocumentTemplate;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.template.Template;
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
		return baseViewFrame(viewProperty);
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
		return new DocumentTemplate();
	}

	@Override
	protected Template javaTemplate() {
		return new io.intino.goros.modernizing.monet.renderers.templates.java.DocumentTemplate();
	}

}
