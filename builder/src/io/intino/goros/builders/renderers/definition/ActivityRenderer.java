package io.intino.goros.builders.renderers.definition;

import io.intino.goros.builders.Modernization;
import io.intino.goros.builders.monet.Dictionary;
import io.intino.itrules.FrameBuilder;
import org.monet.metamodel.ActivityDefinition;
import org.monet.metamodel.EditionActionProperty;
import org.monet.metamodel.NodeDefinition;
import org.monet.metamodel.internal.Ref;

import java.util.HashSet;
import java.util.Set;

public class ActivityRenderer extends ProcessRenderer<ActivityDefinition> {

	public ActivityRenderer(Dictionary dictionary, Modernization modernization, ActivityDefinition definition) {
		super(dictionary, modernization, definition);
	}

	@Override
	protected void addDisplayList(FrameBuilder builder) {
		super.addDisplayList(builder);
		definition().getPlaceList().stream().filter(p -> p.getEditionActionProperty() != null).forEach(p -> {
			EditionActionProperty editionProperty = p.getEditionActionProperty();
			NodeDefinition definition = dictionary.getNodeDefinition(editionProperty.getUse().getForm().getValue());
			Ref withView = editionProperty.getUse().getWithView();
			addDisplayFor(definition, withView != null ? withView.getValue() : null, builder);
		});
	}

}
