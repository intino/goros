package io.intino.goros.builders.renderers.definition;

import io.intino.goros.builders.Modernization;
import io.intino.goros.builders.monet.Dictionary;
import io.intino.itrules.FrameBuilder;
import org.monet.metamodel.EditionActionProperty;
import org.monet.metamodel.NodeDefinition;
import org.monet.metamodel.ServiceDefinition;
import org.monet.metamodel.internal.Ref;

public class ServiceRenderer extends ProcessRenderer<ServiceDefinition> {

	public ServiceRenderer(Dictionary dictionary, Modernization modernization, ServiceDefinition definition) {
		super(dictionary, modernization, definition);
	}

}
