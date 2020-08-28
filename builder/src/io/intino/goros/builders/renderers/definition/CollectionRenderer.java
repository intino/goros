package io.intino.goros.builders.renderers.definition;

import io.intino.goros.builders.Modernization;
import io.intino.goros.builders.monet.Dictionary;
import io.intino.itrules.FrameBuilder;
import org.monet.metamodel.*;
import org.monet.metamodel.internal.Ref;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

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
		FrameBuilder result = new FrameBuilder("addList");
		Collection<Ref> addList = definition().getAdd().getNode().stream().collect(Collectors.toMap(Ref::getValue, a -> a, (a1, a2) -> a1)).values();
		if (addList.size() > 0) result.add("defaultAdd", addFrame(dictionary.getNodeDefinition(addList.iterator().next().getValue())));
		result.add("addVisibility", addVisibilityFrame(addList.size() == 1));
		result.add("addSplitVisibility", addVisibilityFrame(addList.size() > 1));
		addList.forEach(ref -> {
			addRefAdd(ref, result);
			addRefAdd(ref, builder);
		});
		builder.add("addList", result);
	}

	private FrameBuilder addVisibilityFrame(boolean visible) {
		FrameBuilder result = baseFrame().add("addVisibility");
		if (visible) result.add("visible");
		return result;
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
