import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTaskPage from "../../../gen/displays/templates/AbstractTaskPage";
import TaskPageNotifier from "../../../gen/displays/notifiers/TaskPageNotifier";
import TaskPageRequester from "../../../gen/displays/requesters/TaskPageRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskPage extends AbstractTaskPage {

	constructor(props) {
		super(props);
		this.notifier = new TaskPageNotifier(this);
		this.requester = new TaskPageRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskPage));
DisplayFactory.register("TaskPage", withStyles(styles, { withTheme: true })(withSnackbar(TaskPage)));