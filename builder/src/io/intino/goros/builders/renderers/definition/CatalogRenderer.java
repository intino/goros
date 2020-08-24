package io.intino.goros.builders.renderers.definition;

import io.intino.goros.builders.Modernization;
import io.intino.goros.builders.monet.Dictionary;
import org.monet.metamodel.CatalogDefinition;

public class CatalogRenderer extends SetRenderer<CatalogDefinition> {

	public CatalogRenderer(Dictionary dictionary, Modernization modernization, CatalogDefinition definition) {
		super(dictionary, modernization, definition);
	}

}
