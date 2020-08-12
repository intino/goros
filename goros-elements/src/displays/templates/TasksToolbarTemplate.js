import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTasksToolbarTemplate from "../../../gen/displays/templates/AbstractTasksToolbarTemplate";
import TasksToolbarTemplateNotifier from "../../../gen/displays/notifiers/TasksToolbarTemplateNotifier";
import TasksToolbarTemplateRequester from "../../../gen/displays/requesters/TasksToolbarTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TasksToolbarTemplate extends AbstractTasksToolbarTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TasksToolbarTemplateNotifier(this);
		this.requester = new TasksToolbarTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TasksToolbarTemplate));
DisplayFactory.register("TasksToolbarTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TasksToolbarTemplate)));