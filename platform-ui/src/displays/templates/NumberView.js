import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractNumberView from "../../../gen/displays/templates/AbstractNumberView";
import NumberViewNotifier from "../../../gen/displays/notifiers/NumberViewNotifier";
import NumberViewRequester from "../../../gen/displays/requesters/NumberViewRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class NumberView extends AbstractNumberView {

	constructor(props) {
		super(props);
		this.notifier = new NumberViewNotifier(this);
		this.requester = new NumberViewRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(NumberView));
DisplayFactory.register("NumberView", withStyles(styles, { withTheme: true })(withSnackbar(NumberView)));