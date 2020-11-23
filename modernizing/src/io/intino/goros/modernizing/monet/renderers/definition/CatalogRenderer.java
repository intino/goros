package io.intino.goros.modernizing.monet.renderers.definition;

import io.intino.goros.modernizing.Modernization;
import io.intino.goros.modernizing.monet.Dictionary;
import org.monet.metamodel.CatalogDefinition;

public class CatalogRenderer extends SetRenderer<CatalogDefinition> {

	public CatalogRenderer(Dictionary dictionary, Modernization modernization, CatalogDefinition definition) {
		super(dictionary, modernization, definition);
	}

}
