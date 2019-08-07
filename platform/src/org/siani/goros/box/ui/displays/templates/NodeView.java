package org.siani.goros.box.ui.displays.templates;

import io.intino.alexandria.core.Box;
import org.siani.goros.box.ui.displays.notifiers.NodeViewNotifier;

public class NodeView<DN extends NodeViewNotifier, B extends Box> extends AbstractNodeView<DN, B> {

    public NodeView(B box) {
        super(box);
    }

}