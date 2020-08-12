import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractCheckFilterTemplate from "../../../gen/displays/templates/AbstractCheckFilterTemplate";
import CheckFilterTemplateNotifier from "../../../gen/displays/notifiers/CheckFilterTemplateNotifier";
import CheckFilterTemplateRequester from "../../../gen/displays/requesters/CheckFilterTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class CheckFilterTemplate extends AbstractCheckFilterTemplate {

	constructor(props) {
		super(props);
		this.notifier = new CheckFilterTemplateNotifier(this);
		this.requester = new CheckFilterTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(CheckFilterTemplate));
DisplayFactory.register("CheckFilterTemplate", withStyles(styles, { withTheme: true })(withSnackbar(CheckFilterTemplate)));