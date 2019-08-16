package org.siani.goros.box.ui.displays.notifiers;

import io.intino.alexandria.exceptions.*;
import org.siani.goros.box.*;


public class PageNotifier extends io.intino.alexandria.ui.displays.notifiers.TemplateNotifier {

    public PageNotifier(io.intino.alexandria.ui.displays.Display display, io.intino.alexandria.rest.pushservice.MessageCarrier carrier) {
        super(display, carrier);
    }

}