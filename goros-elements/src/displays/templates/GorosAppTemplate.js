import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractGorosAppTemplate from "../../../gen/displays/templates/AbstractGorosAppTemplate";
import GorosAppTemplateNotifier from "../../../gen/displays/notifiers/GorosAppTemplateNotifier";
import GorosAppTemplateRequester from "../../../gen/displays/requesters/GorosAppTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class GorosAppTemplate extends AbstractGorosAppTemplate {

	constructor(props) {
		super(props);
		this.notifier = new GorosAppTemplateNotifier(this);
		this.requester = new GorosAppTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(GorosAppTemplate));
DisplayFactory.register("GorosAppTemplate", withStyles(styles, { withTheme: true })(withSnackbar(GorosAppTemplate)));