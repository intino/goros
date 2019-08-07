import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractView from "../../../gen/displays/templates/AbstractView";
import ViewNotifier from "../../../gen/displays/notifiers/ViewNotifier";
import ViewRequester from "../../../gen/displays/requesters/ViewRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class View extends AbstractView {

	constructor(props) {
		super(props);
		this.notifier = new ViewNotifier(this);
		this.requester = new ViewRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(View));
DisplayFactory.register("View", withStyles(styles, { withTheme: true })(withSnackbar(View)));