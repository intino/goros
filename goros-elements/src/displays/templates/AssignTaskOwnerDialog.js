import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractAssignTaskOwnerDialog from "../../../gen/displays/templates/AbstractAssignTaskOwnerDialog";
import AssignTaskOwnerDialogNotifier from "../../../gen/displays/notifiers/AssignTaskOwnerDialogNotifier";
import AssignTaskOwnerDialogRequester from "../../../gen/displays/requesters/AssignTaskOwnerDialogRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class AssignTaskOwnerDialog extends AbstractAssignTaskOwnerDialog {

	constructor(props) {
		super(props);
		this.notifier = new AssignTaskOwnerDialogNotifier(this);
		this.requester = new AssignTaskOwnerDialogRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(AssignTaskOwnerDialog));
DisplayFactory.register("AssignTaskOwnerDialog", withStyles(styles, { withTheme: true })(withSnackbar(AssignTaskOwnerDialog)));