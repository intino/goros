import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTrashTemplate from "../../../gen/displays/templates/AbstractTrashTemplate";
import TrashTemplateNotifier from "../../../gen/displays/notifiers/TrashTemplateNotifier";
import TrashTemplateRequester from "../../../gen/displays/requesters/TrashTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TrashTemplate extends AbstractTrashTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TrashTemplateNotifier(this);
		this.requester = new TrashTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TrashTemplate));
DisplayFactory.register("TrashTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TrashTemplate)));