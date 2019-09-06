import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractDrawerOption from "../../../gen/displays/templates/AbstractDrawerOption";
import DrawerOptionNotifier from "../../../gen/displays/notifiers/DrawerOptionNotifier";
import DrawerOptionRequester from "../../../gen/displays/requesters/DrawerOptionRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class DrawerOption extends AbstractDrawerOption {

	constructor(props) {
		super(props);
		this.notifier = new DrawerOptionNotifier(this);
		this.requester = new DrawerOptionRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(DrawerOption));
DisplayFactory.register("DrawerOption", withStyles(styles, { withTheme: true })(withSnackbar(DrawerOption)));