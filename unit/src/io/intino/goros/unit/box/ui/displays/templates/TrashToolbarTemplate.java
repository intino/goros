package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.events.ActionListener;
import io.intino.alexandria.ui.displays.events.Event;
import io.intino.goros.unit.box.UnitBox;

public class TrashToolbarTemplate extends AbstractTrashToolbarTemplate<UnitBox> {
    private ActionListener emptyTrashListener;

    public TrashToolbarTemplate(UnitBox box) {
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