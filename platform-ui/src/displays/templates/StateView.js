import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractStateView from "../../../gen/displays/templates/AbstractStateView";
import StateViewNotifier from "../../../gen/displays/notifiers/StateViewNotifier";
import StateViewRequester from "../../../gen/displays/requesters/StateViewRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class StateView extends AbstractStateView {

	constructor(props) {
		super(props);
		this.notifier = new StateViewNotifier(this);
		this.requester = new StateViewRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(StateView));
DisplayFactory.register("StateView", withStyles(styles, { withTheme: true })(withSnackbar(StateView)));