package org.siani.goros.box.ui.displays.templates;

import io.intino.alexandria.core.Box;
import org.siani.goros.box.ui.displays.notifiers.ViewNotifier;

public class View<DN extends ViewNotifier, B extends Box> extends AbstractView<DN, B> {

    public View(B box) {
        super(box);
    }

}