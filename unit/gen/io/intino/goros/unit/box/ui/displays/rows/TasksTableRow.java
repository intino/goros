package io.intino.goros.unit.box.ui.displays.rows;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import io.intino.goros.unit.box.ui.*;

import io.intino.goros.unit.box.UnitBox;

import io.intino.goros.unit.box.ui.displays.templates.*;






import io.intino.goros.unit.box.ui.displays.items.*;
import io.intino.goros.unit.box.ui.displays.rows.*;
import io.intino.alexandria.ui.displays.notifiers.RowNotifier;

public class TasksTableRow extends io.intino.alexandria.ui.displays.components.Row<RowNotifier, org.monet.space.kernel.model.Task, UnitBox> {
	public TasksTableLabelItem tasksTableLabelItem;
	public TasksTableDescriptionItem tasksTableDescriptionItem;
	public TasksTableOwnerItem tasksTableOwnerItem;
	public TasksTableCreateDateItem tasksTableCreateDateItem;
	public TasksTableUpdateDateItem tasksTableUpdateDateItem;
	public TasksTableCountMessagesItem tasksTableCountMessagesItem;
	public TasksTableOperationsItem tasksTableOperationsItem;

    public TasksTableRow(UnitBox box) {
        super(box);
        id("a1059402881");
    }

    @Override
	public void init() {
		super.init();
		if (tasksTableLabelItem == null) tasksTableLabelItem = register(new TasksTableLabelItem((UnitBox)box()).<TasksTableLabelItem>id("a2000043949").<TasksTableLabelItem>item(TasksTableRow.this.item()).owner(TasksTableRow.this));
		if (tasksTableDescriptionItem == null) tasksTableDescriptionItem = register(new TasksTableDescriptionItem((UnitBox)box()).<TasksTableDescriptionItem>id("a688437946").<TasksTableDescriptionItem>item(TasksTableRow.this.item()).owner(TasksTableRow.this));
		if (tasksTableOwnerItem == null) tasksTableOwnerItem = register(new TasksTableOwnerItem((UnitBox)box()).<TasksTableOwnerItem>id("a68884553").<TasksTableOwnerItem>item(TasksTableRow.this.item()).owner(TasksTableRow.this));
		if (tasksTableCreateDateItem == null) tasksTableCreateDateItem = register(new TasksTableCreateDateItem((UnitBox)box()).<TasksTableCreateDateItem>id("a_1540070121").<TasksTableCreateDateItem>item(TasksTableRow.this.item()).owner(TasksTableRow.this));
		if (tasksTableUpdateDateItem == null) tasksTableUpdateDateItem = register(new TasksTableUpdateDateItem((UnitBox)box()).<TasksTableUpdateDateItem>id("a1938290177").<TasksTableUpdateDateItem>item(TasksTableRow.this.item()).owner(TasksTableRow.this));
		if (tasksTableCountMessagesItem == null) tasksTableCountMessagesItem = register(new TasksTableCountMessagesItem((UnitBox)box()).<TasksTableCountMessagesItem>id("a675688538").<TasksTableCountMessagesItem>item(TasksTableRow.this.item()).owner(TasksTableRow.this));
		if (tasksTableOperationsItem == null) tasksTableOperationsItem = register(new TasksTableOperationsItem((UnitBox)box()).<TasksTableOperationsItem>id("a_428043685").<TasksTableOperationsItem>item(TasksTableRow.this.item()).owner(TasksTableRow.this));
	}
}