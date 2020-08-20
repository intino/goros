package io.intino.goros.box.ui;

import io.intino.alexandria.ui.displays.Display;
import org.monet.metamodel.FormDefinitionBase;
import org.monet.metamodel.NodeViewProperty;
import org.monet.space.kernel.model.Node;

public interface DisplayProvider {
	Display displayFor(Node form, String view);
}
