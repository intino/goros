package io.intino.goros.builder.renderers.definition;

import io.intino.goros.builder.Modernization;
import io.intino.goros.builder.monet.Dictionary;
import io.intino.goros.builder.renderers.DefinitionRenderer;
import io.intino.goros.builder.renderers.templates.java.ContainerTemplate;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.Template;
import org.monet.metamodel.*;
import org.monet.metamodel.internal.Ref;

import java.util.ArrayList;

public abstract class SetRenderer<D extends SetDefinition> extends NodeRenderer<D> {

	public SetRenderer(Dictionary dictionary, Modernization modernization, D definition) {
		super(dictionary, modernization, definition);
	}

	@Override
	protected boolean isVisibleOnRevision(NodeViewProperty viewProperty) {
		return false;
	}

	@Override
	protected boolean hasTemplate(NodeViewProperty viewProperty) {
		SetDefinitionBase.SetViewPropertyBase.ShowProperty showProperty = ((SetDefinition.SetViewProperty)viewProperty).getShow();
		if (showProperty.getItems() != null) return true;
		if (showProperty.getIndex() != null) return true;
		return showProperty.getLocations() != null;
	}

}
