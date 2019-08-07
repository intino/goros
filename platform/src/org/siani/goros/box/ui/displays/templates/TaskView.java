package org.siani.goros.box.ui.displays.templates;

import io.intino.alexandria.core.Box;
import org.siani.goros.box.ui.displays.notifiers.TaskViewNotifier;

public class TaskView<DN extends TaskViewNotifier, B extends Box> extends AbstractTaskView<DN, B> {

    public TaskView(B box) {
        super(box);
    }
    
}