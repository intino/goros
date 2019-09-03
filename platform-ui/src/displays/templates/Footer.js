import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractFooter from "../../../gen/displays/templates/AbstractFooter";
import FooterNotifier from "../../../gen/displays/notifiers/FooterNotifier";
import FooterRequester from "../../../gen/displays/requesters/FooterRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class Footer extends AbstractFooter {

	constructor(props) {
		super(props);
		this.notifier = new FooterNotifier(this);
		this.requester = new FooterRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(Footer));
DisplayFactory.register("Footer", withStyles(styles, { withTheme: true })(withSnackbar(Footer)));