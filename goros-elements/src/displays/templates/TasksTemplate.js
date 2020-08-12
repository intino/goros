import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTasksTemplate from "../../../gen/displays/templates/AbstractTasksTemplate";
import TasksTemplateNotifier from "../../../gen/displays/notifiers/TasksTemplateNotifier";
import TasksTemplateRequester from "../../../gen/displays/requesters/TasksTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TasksTemplate extends AbstractTasksTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TasksTemplateNotifier(this);
		this.requester = new TasksTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TasksTemplate));
DisplayFactory.register("TasksTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TasksTemplate)));