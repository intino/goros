package io.intino.goros.builder.renderers.definition;

import io.intino.goros.builder.Modernization;
import io.intino.goros.builder.monet.Dictionary;
import io.intino.itrules.FrameBuilder;
import org.monet.metamodel.CatalogDefinition;
import org.monet.metamodel.CollectionDefinition;
import org.monet.metamodel.NodeDefinition;
import org.monet.metamodel.internal.Ref;

import java.util.ArrayList;

public class CatalogRenderer extends SetRenderer<CatalogDefinition> {

	public CatalogRenderer(Dictionary dictionary, Modernization modernization, CatalogDefinition definition) {
		super(dictionary, modernization, definition);
	}

}
