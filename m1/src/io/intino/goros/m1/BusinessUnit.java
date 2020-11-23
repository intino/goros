package io.intino.goros.m1;

import io.intino.goros.m1.layers.NodeLayer;
import io.intino.goros.m1.layers.SourceLayer;
import io.intino.goros.m1.layers.TaskLayer;

public interface BusinessUnit {
	NodeLayer nodeLayer();
	SourceLayer sourceLayer();
	TaskLayer taskLayer();
}
