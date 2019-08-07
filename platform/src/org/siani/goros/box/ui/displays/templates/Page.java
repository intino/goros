package org.siani.goros.box.ui.displays.templates;

import io.intino.alexandria.core.Box;
import org.siani.goros.box.ui.displays.notifiers.PageNotifier;

public class Page<DN extends PageNotifier, B extends Box> extends AbstractPage<DN, B> {

    public Page(B box) {
        super(box);
    }
    
}