package io.intino.goros.modernizing.monet.renderers.definition;

import io.intino.goros.modernizing.Modernization;
import io.intino.goros.modernizing.monet.Dictionary;
import org.monet.metamodel.ServiceDefinition;

public class ServiceRenderer extends ProcessRenderer<ServiceDefinition> {

	public ServiceRenderer(Dictionary dictionary, Modernization modernization, ServiceDefinition definition) {
		super(dictionary, modernization, definition);
	}

}
