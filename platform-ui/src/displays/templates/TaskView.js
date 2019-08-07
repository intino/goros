import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTaskView from "../../../gen/displays/templates/AbstractTaskView";
import TaskViewNotifier from "../../../gen/displays/notifiers/TaskViewNotifier";
import TaskViewRequester from "../../../gen/displays/requesters/TaskViewRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskView extends AbstractTaskView {

	constructor(props) {
		super(props);
		this.notifier = new TaskViewNotifier(this);
		this.requester = new TaskViewRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskView));
DisplayFactory.register("TaskView", withStyles(styles, { withTheme: true })(withSnackbar(TaskView)));