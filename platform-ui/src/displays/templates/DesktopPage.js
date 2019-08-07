import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractDesktopPage from "../../../gen/displays/templates/AbstractDesktopPage";
import DesktopPageNotifier from "../../../gen/displays/notifiers/DesktopPageNotifier";
import DesktopPageRequester from "../../../gen/displays/requesters/DesktopPageRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class DesktopPage extends AbstractDesktopPage {

	constructor(props) {
		super(props);
		this.notifier = new DesktopPageNotifier(this);
		this.requester = new DesktopPageRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(DesktopPage));
DisplayFactory.register("DesktopPage", withStyles(styles, { withTheme: true })(withSnackbar(DesktopPage)));