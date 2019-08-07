package org.siani.goros.box.ui.displays.templates;

import io.intino.alexandria.core.Box;
import org.siani.goros.box.ui.displays.notifiers.NodePageNotifier;

public class NodePage<DN extends NodePageNotifier, B extends Box> extends AbstractNodePage<DN, B> {

    public NodePage(B box) {
        super(box);
    }

}