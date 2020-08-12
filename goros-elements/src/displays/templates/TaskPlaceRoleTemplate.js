import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTaskPlaceRoleTemplate from "../../../gen/displays/templates/AbstractTaskPlaceRoleTemplate";
import TaskPlaceRoleTemplateNotifier from "../../../gen/displays/notifiers/TaskPlaceRoleTemplateNotifier";
import TaskPlaceRoleTemplateRequester from "../../../gen/displays/requesters/TaskPlaceRoleTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskPlaceRoleTemplate extends AbstractTaskPlaceRoleTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskPlaceRoleTemplateNotifier(this);
		this.requester = new TaskPlaceRoleTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceRoleTemplate));
DisplayFactory.register("TaskPlaceRoleTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceRoleTemplate)));