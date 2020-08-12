import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTaskOrderTemplate from "../../../gen/displays/templates/AbstractTaskOrderTemplate";
import TaskOrderTemplateNotifier from "../../../gen/displays/notifiers/TaskOrderTemplateNotifier";
import TaskOrderTemplateRequester from "../../../gen/displays/requesters/TaskOrderTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskOrderTemplate extends AbstractTaskOrderTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskOrderTemplateNotifier(this);
		this.requester = new TaskOrderTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskOrderTemplate));
DisplayFactory.register("TaskOrderTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskOrderTemplate)));