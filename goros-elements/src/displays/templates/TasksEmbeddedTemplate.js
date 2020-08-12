import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTasksEmbeddedTemplate from "../../../gen/displays/templates/AbstractTasksEmbeddedTemplate";
import TasksEmbeddedTemplateNotifier from "../../../gen/displays/notifiers/TasksEmbeddedTemplateNotifier";
import TasksEmbeddedTemplateRequester from "../../../gen/displays/requesters/TasksEmbeddedTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TasksEmbeddedTemplate extends AbstractTasksEmbeddedTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TasksEmbeddedTemplateNotifier(this);
		this.requester = new TasksEmbeddedTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TasksEmbeddedTemplate));
DisplayFactory.register("TasksEmbeddedTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TasksEmbeddedTemplate)));