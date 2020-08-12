import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractRolesToolbarTemplate from "../../../gen/displays/templates/AbstractRolesToolbarTemplate";
import RolesToolbarTemplateNotifier from "../../../gen/displays/notifiers/RolesToolbarTemplateNotifier";
import RolesToolbarTemplateRequester from "../../../gen/displays/requesters/RolesToolbarTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class RolesToolbarTemplate extends AbstractRolesToolbarTemplate {

	constructor(props) {
		super(props);
		this.notifier = new RolesToolbarTemplateNotifier(this);
		this.requester = new RolesToolbarTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(RolesToolbarTemplate));
DisplayFactory.register("RolesToolbarTemplate", withStyles(styles, { withTheme: true })(withSnackbar(RolesToolbarTemplate)));