package io.intino.goros.builder.renderers.definition;

import io.intino.goros.builder.Modernization;
import io.intino.goros.builder.monet.Dictionary;
import io.intino.goros.builder.renderers.templates.java.SetTemplate;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.Template;
import org.monet.metamodel.*;
import org.monet.metamodel.internal.Ref;

import java.util.ArrayList;

public class CollectionRenderer extends SetRenderer<CollectionDefinition> {

	public CollectionRenderer(Dictionary dictionary, Modernization modernization, CollectionDefinition definition) {
		super(dictionary, modernization, definition);
	}

	@Override
	protected FrameBuilder buildFrame() {
		FrameBuilder result = super.buildFrame();
		addRefAddList(result);
		return result;
	}

	private void addRefAddList(FrameBuilder builder) {
		ArrayList<Ref> addList = definition().getAdd().getNode();
		if (addList.size() > 0) builder.add("defaultAdd", addFrame(dictionary.getNodeDefinition(addList.get(0).getValue())));
		addList.forEach(ref -> addRefAdd(ref, builder));
	}

	private void addRefAdd(Ref ref, FrameBuilder builder) {
		NodeDefinition nodeDefinition = dictionary.getNodeDefinition(ref.getValue());
		builder.add("add", addFrame(nodeDefinition));
	}

	private FrameBuilder addFrame(NodeDefinition nodeDefinition) {
		FrameBuilder result = baseFrame().add("add");
		result.add("name", nameOf(nodeDefinition));
		result.add("code", nodeDefinition.getCode());
		result.add("label", nodeDefinition.getLabel());
		return result;
	}

}
