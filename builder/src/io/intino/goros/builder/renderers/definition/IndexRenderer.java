package io.intino.goros.builder.renderers.definition;

import io.intino.goros.builder.Modernization;
import io.intino.goros.builder.monet.Dictionary;
import io.intino.goros.builder.renderers.DefinitionRenderer;
import io.intino.goros.builder.renderers.RendererHelper;
import io.intino.goros.builder.renderers.templates.java.IndexTemplate;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.Template;
import org.monet.metamodel.AttributeProperty;
import org.monet.metamodel.IndexDefinition;
import org.monet.metamodel.IndexDefinitionBase;
import org.monet.metamodel.NodeViewProperty;
import org.monet.metamodel.internal.Ref;

import java.io.File;

public class IndexRenderer extends DefinitionRenderer<IndexDefinition> {

	public IndexRenderer(Dictionary dictionary, Modernization modernization, IndexDefinition definition) {
		super(dictionary, modernization, definition);
	}

	@Override
	public void write() {
		FrameBuilder builder = buildFrame();
		writeKonos(builder);
		writeViewsTemplate();
	}

	@Override
	protected FrameBuilder buildFrame() {
		FrameBuilder result = baseFrame().add("indexdefinition");
		addViews(result);
		return result;
	}

	private void addViews(FrameBuilder builder) {
		definition().getViewList().forEach(view -> addView(view, builder));
	}

	private void addView(IndexDefinitionBase.IndexViewProperty viewProperty, FrameBuilder builder) {
		builder.add("view", viewFrame(viewProperty));
	}

	private void addAttributes(IndexDefinitionBase.IndexViewProperty viewProperty, FrameBuilder builder) {
		IndexDefinitionBase.IndexViewProperty.ShowProperty show = viewProperty.getShow();
		int countAttributes = RendererHelper.countAttributes(viewProperty);
		if (show.getTitle() != null) addAttribute("title", attributeFrame(viewProperty, show.getTitle(), countAttributes).add("value", "Cargando..."), builder);
		if (show.getPicture() != null) addAttribute("picture", attributeFrame(viewProperty, show.getPicture(), countAttributes), builder);
		if (show.getIcon() != null) addAttribute("icon", attributeFrame(viewProperty, show.getIcon(), countAttributes), builder);
		show.getHighlight().forEach(h -> addAttribute("highlight", attributeFrame(viewProperty, h, countAttributes), builder));
		show.getLine().forEach(l -> addAttribute("line", attributeFrame(viewProperty, l, countAttributes), builder));
		show.getLineBelow().forEach(lb -> addAttribute("lineBelow", attributeFrame(viewProperty, lb, countAttributes), builder));
		show.getFooter().forEach(f -> addAttribute("footer", attributeFrame(viewProperty, f, countAttributes), builder));
	}

	private void addAttribute(String section, FrameBuilder attributeFrame, FrameBuilder builder) {
		builder.add(section, attributeFrame);
		builder.add("attribute", attributeFrame);
	}

	private FrameBuilder attributeFrame(IndexDefinitionBase.IndexViewProperty viewProperty, Ref attribute, int countAttributes) {
		AttributeProperty attributeProperty = definition().getAttribute(attribute.getValue());
		FrameBuilder result = baseFrame().add("attribute");
		result.add(attributeProperty.getType().name().toLowerCase());
		result.add("definition", nameOf(definition()));
		result.add("view", nameOf(viewProperty));
		result.add("name", normalize(attributeProperty.getName()));
		result.add("code", attributeProperty.getCode());
		result.add("label", attributeProperty.getLabel());
		result.add("type", RendererHelper.attributeTypeOf(attributeProperty));
		result.add("width", countAttributes > 0 ? Math.round(100.0/countAttributes) : 0);
		return result;
	}

	@Override
	protected Template konosTemplate() {
		return new io.intino.goros.builder.renderers.templates.konos.IndexTemplate();
	}

	@Override
	protected Template javaTemplate() {
		return new IndexTemplate();
	}

	private void writeViewsTemplate() {
		definition().getViewList().forEach(this::writeViewTemplate);
	}

	private void writeViewTemplate(IndexDefinitionBase.IndexViewProperty view) {
		resetAddedDisplays();
		FrameBuilder viewFrame = viewFrame(view);
		File file = new File(javaPackage() + nameOf(definition()) + nameOf(view) + "Table.java");
		writeFrame(file, javaTemplate().render(viewFrame.toFrame()));
	}

	private FrameBuilder viewFrame(IndexDefinitionBase.IndexViewProperty viewProperty) {
		FrameBuilder result = baseFrame().add("view");
		result.add("definition", RendererHelper.nameOf(definition()));
		result.add("name", RendererHelper.nameOf(viewProperty));
		result.add("code", viewProperty.getCode());
		result.add("label", viewProperty.getName());
		addAttributes(viewProperty, result);
		return result;
	}

	protected String javaPackage() {
		return modernization.sourceUiDirectory() + File.separator + "displays" + File.separator + "tables" + File.separator;
	}
}
