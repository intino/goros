import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractPlatformTemplate from "../../../gen/displays/templates/AbstractPlatformTemplate";
import PlatformTemplateNotifier from "../../../gen/displays/notifiers/PlatformTemplateNotifier";
import PlatformTemplateRequester from "../../../gen/displays/requesters/PlatformTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class PlatformTemplate extends AbstractPlatformTemplate {

	constructor(props) {
		super(props);
		this.notifier = new PlatformTemplateNotifier(this);
		this.requester = new PlatformTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(PlatformTemplate));
DisplayFactory.register("PlatformTemplate", withStyles(styles, { withTheme: true })(withSnackbar(PlatformTemplate)));