import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractRoleEmbeddedTemplate from "../../../gen/displays/templates/AbstractRoleEmbeddedTemplate";
import RoleEmbeddedTemplateNotifier from "../../../gen/displays/notifiers/RoleEmbeddedTemplateNotifier";
import RoleEmbeddedTemplateRequester from "../../../gen/displays/requesters/RoleEmbeddedTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class RoleEmbeddedTemplate extends AbstractRoleEmbeddedTemplate {

	constructor(props) {
		super(props);
		this.notifier = new RoleEmbeddedTemplateNotifier(this);
		this.requester = new RoleEmbeddedTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(RoleEmbeddedTemplate));
DisplayFactory.register("RoleEmbeddedTemplate", withStyles(styles, { withTheme: true })(withSnackbar(RoleEmbeddedTemplate)));