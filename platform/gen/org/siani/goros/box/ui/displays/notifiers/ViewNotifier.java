package org.siani.goros.box.ui.displays.notifiers;

import io.intino.alexandria.exceptions.*;
import org.siani.goros.box.*;


public class ViewNotifier extends io.intino.alexandria.ui.displays.notifiers.TemplateNotifier {

    public ViewNotifier(io.intino.alexandria.ui.displays.Display display, io.intino.alexandria.rest.pushservice.MessageCarrier carrier) {
        super(display, carrier);
    }

}