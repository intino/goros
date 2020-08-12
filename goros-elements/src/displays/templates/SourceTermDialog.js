import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractSourceTermDialog from "../../../gen/displays/templates/AbstractSourceTermDialog";
import SourceTermDialogNotifier from "../../../gen/displays/notifiers/SourceTermDialogNotifier";
import SourceTermDialogRequester from "../../../gen/displays/requesters/SourceTermDialogRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class SourceTermDialog extends AbstractSourceTermDialog {

	constructor(props) {
		super(props);
		this.notifier = new SourceTermDialogNotifier(this);
		this.requester = new SourceTermDialogRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(SourceTermDialog));
DisplayFactory.register("SourceTermDialog", withStyles(styles, { withTheme: true })(withSnackbar(SourceTermDialog)));