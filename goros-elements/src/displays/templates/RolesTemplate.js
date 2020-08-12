import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractRolesTemplate from "../../../gen/displays/templates/AbstractRolesTemplate";
import RolesTemplateNotifier from "../../../gen/displays/notifiers/RolesTemplateNotifier";
import RolesTemplateRequester from "../../../gen/displays/requesters/RolesTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class RolesTemplate extends AbstractRolesTemplate {

	constructor(props) {
		super(props);
		this.notifier = new RolesTemplateNotifier(this);
		this.requester = new RolesTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(RolesTemplate));
DisplayFactory.register("RolesTemplate", withStyles(styles, { withTheme: true })(withSnackbar(RolesTemplate)));