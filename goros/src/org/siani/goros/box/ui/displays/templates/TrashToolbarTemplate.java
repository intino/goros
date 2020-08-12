package org.siani.goros.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.events.ActionListener;
import io.intino.alexandria.ui.displays.events.Event;
import org.siani.goros.box.GorosBox;

public class TrashToolbarTemplate extends AbstractTrashToolbarTemplate<GorosBox> {
    private ActionListener emptyTrashListener;

    public TrashToolbarTemplate(GorosBox box) {
        super(box);
    }

    public TrashToolbarTemplate onEmptyTrash(ActionListener listener) {
        this.emptyTrashListener = listener;
        return this;
    }

    @Override
    public void init() {
        super.init();
        emptyTrash.onExecute(e -> emptyTrashListener.accept(new Event(this)));
    }

}