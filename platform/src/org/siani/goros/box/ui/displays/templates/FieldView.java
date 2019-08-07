package org.siani.goros.box.ui.displays.templates;

import io.intino.alexandria.core.Box;
import org.siani.goros.box.ui.displays.notifiers.FieldViewNotifier;

public class FieldView<DN extends FieldViewNotifier, B extends Box> extends AbstractFieldView<DN, B> {

    public FieldView(B box) {
        super(box);
    }

}