import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTaskBoardTemplate from "../../../gen/displays/templates/AbstractTaskBoardTemplate";
import TaskBoardTemplateNotifier from "../../../gen/displays/notifiers/TaskBoardTemplateNotifier";
import TaskBoardTemplateRequester from "../../../gen/displays/requesters/TaskBoardTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskBoardTemplate extends AbstractTaskBoardTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskBoardTemplateNotifier(this);
		this.requester = new TaskBoardTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskBoardTemplate));
DisplayFactory.register("TaskBoardTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskBoardTemplate)));