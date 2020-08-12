import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTrashToolbarTemplate from "../../../gen/displays/templates/AbstractTrashToolbarTemplate";
import TrashToolbarTemplateNotifier from "../../../gen/displays/notifiers/TrashToolbarTemplateNotifier";
import TrashToolbarTemplateRequester from "../../../gen/displays/requesters/TrashToolbarTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TrashToolbarTemplate extends AbstractTrashToolbarTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TrashToolbarTemplateNotifier(this);
		this.requester = new TrashToolbarTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TrashToolbarTemplate));
DisplayFactory.register("TrashToolbarTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TrashToolbarTemplate)));