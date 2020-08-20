package io.intino.goros.builder.renderers.definition;

import io.intino.goros.builder.Modernization;
import io.intino.goros.builder.monet.Dictionary;
import io.intino.goros.builder.renderers.templates.java.DesktopTemplate;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.Template;
import org.monet.metamodel.*;
import org.monet.metamodel.internal.Ref;

import java.util.ArrayList;

public class DesktopRenderer extends NodeRenderer<DesktopDefinition> {

	public DesktopRenderer(Dictionary dictionary, Modernization modernization, DesktopDefinition definition) {
		super(dictionary, modernization, definition);
	}

	@Override
	public void write() {
		FrameBuilder builder = buildFrame();
		writeJava(builder);
		writeKonos(builder);
	}

	@Override
	protected FrameBuilder buildFrame() {
		return super.buildFrame().add("desktopdefinition");
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
		addShow((DesktopDefinition.ViewProperty)viewProperty, result);
		return result;
	}

	private void addShow(DesktopDefinition.ViewProperty viewProperty, FrameBuilder builder) {
		FrameBuilder result = baseFrame().add("show");
		addItems(viewProperty.getShow().getLink(), result);
		addItems(viewProperty.getShow().getDashboard(), result);
		builder.add("show", result);
	}

	private void addItems(ArrayList<Ref> itemList, FrameBuilder builder) {
		itemList.forEach(item -> addItem(item, builder));
	}

	private void addItem(Ref item, FrameBuilder builder) {
		Definition definition = dictionary.getDefinition(item.getValue());
		FrameBuilder result = baseFrame().add("item");
		result.add(definition.getType().name().toLowerCase());
		result.add("name", nameOf(definition));
		result.add("code", definition.getCode());
		result.add("label", definition.getLabel());
		result.add("description", definition.getDescription());
		builder.add("item", result);
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
		return new io.intino.goros.builder.renderers.templates.konos.DesktopTemplate();
	}

	@Override
	protected Template javaTemplate() {
		return new DesktopTemplate();
	}

}
