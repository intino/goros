package io.intino.goros.modernizing.monet.renderers.definition;

import io.intino.goros.modernizing.Modernization;
import io.intino.goros.modernizing.monet.Dictionary;
import io.intino.goros.modernizing.monet.renderers.DefinitionRenderer;
import io.intino.goros.modernizing.monet.renderers.RendererHelper;
import io.intino.goros.modernizing.monet.renderers.templates.konos.IndexTemplate;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.Template;
import io.intino.itrules.formatters.StringFormatters;
import org.monet.metamodel.*;
import org.monet.metamodel.internal.Ref;

import java.io.File;

public class IndexRenderer extends DefinitionRenderer<IndexDefinition> {

	public IndexRenderer(Dictionary dictionary, Modernization modernization, IndexDefinition definition) {
		super(dictionary, modernization, definition);
	}

	@Override
	public void write() {
		if (definition().getViewList().size() <= 0) return;
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
		if (RendererHelper.countAttributes(viewProperty) == 0) return;
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
		result.add("label", clean(attributeProperty.getLabel()));
		result.add("type", RendererHelper.attributeTypeOf(attributeProperty));
		result.add("width", countAttributes > 0 ? Math.round(100.0/countAttributes) : 0);
		return result;
	}

	@Override
	protected Template konosTemplate() {
		return new IndexTemplate();
	}

	@Override
	protected Template javaTemplate() {
		return new io.intino.goros.modernizing.monet.renderers.templates.java.IndexTemplate();
	}

	private void writeViewsTemplate() {
		definition().getViewList().stream().filter(this::hasTemplate).forEach(this::writeViewTemplate);
	}

	protected boolean hasTemplate(IndexDefinitionBase.IndexViewProperty viewProperty) {
		IndexDefinitionBase.IndexViewProperty.ShowProperty showProperty = ((IndexDefinitionBase.IndexViewProperty)viewProperty).getShow();
		return RendererHelper.countAttributes(viewProperty) > 0;
	}

	private void writeViewTemplate(IndexDefinitionBase.IndexViewProperty view) {
		resetAddedDisplays();
		FrameBuilder viewFrame = viewFrame(view);
		File file = new File(javaPackage() + nameOf(definition()) + StringFormatters.firstUpperCase().format(nameOf(view)) + "Table.java");
		writeFrame(file, javaTemplate().render(viewFrame.toFrame()));
	}

	private FrameBuilder viewFrame(IndexDefinitionBase.IndexViewProperty viewProperty) {
		FrameBuilder result = baseFrame().add("view");
		result.add("definition", RendererHelper.nameOf(definition(), dictionary.basePackage()));
		result.add("name", RendererHelper.nameOf(viewProperty));
		result.add("code", viewProperty.getCode());
		result.add("label", clean(viewProperty.getName()));
		addAttributes(viewProperty, result);
		return result;
	}

	protected String javaPackage() {
		return modernization.sourceUiDirectory() + File.separator + "displays" + File.separator + "tables" + File.separator;
	}
}
