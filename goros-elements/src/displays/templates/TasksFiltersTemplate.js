import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTasksFiltersTemplate from "../../../gen/displays/templates/AbstractTasksFiltersTemplate";
import TasksFiltersTemplateNotifier from "../../../gen/displays/notifiers/TasksFiltersTemplateNotifier";
import TasksFiltersTemplateRequester from "../../../gen/displays/requesters/TasksFiltersTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TasksFiltersTemplate extends AbstractTasksFiltersTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TasksFiltersTemplateNotifier(this);
		this.requester = new TasksFiltersTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TasksFiltersTemplate));
DisplayFactory.register("TasksFiltersTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TasksFiltersTemplate)));