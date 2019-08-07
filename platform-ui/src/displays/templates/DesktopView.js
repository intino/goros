import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractDesktopView from "../../../gen/displays/templates/AbstractDesktopView";
import DesktopViewNotifier from "../../../gen/displays/notifiers/DesktopViewNotifier";
import DesktopViewRequester from "../../../gen/displays/requesters/DesktopViewRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class DesktopView extends AbstractDesktopView {

	constructor(props) {
		super(props);
		this.notifier = new DesktopViewNotifier(this);
		this.requester = new DesktopViewRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(DesktopView));
DisplayFactory.register("DesktopView", withStyles(styles, { withTheme: true })(withSnackbar(DesktopView)));