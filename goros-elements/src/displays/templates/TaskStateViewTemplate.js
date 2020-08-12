import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTaskStateViewTemplate from "../../../gen/displays/templates/AbstractTaskStateViewTemplate";
import TaskStateViewTemplateNotifier from "../../../gen/displays/notifiers/TaskStateViewTemplateNotifier";
import TaskStateViewTemplateRequester from "../../../gen/displays/requesters/TaskStateViewTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskStateViewTemplate extends AbstractTaskStateViewTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskStateViewTemplateNotifier(this);
		this.requester = new TaskStateViewTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskStateViewTemplate));
DisplayFactory.register("TaskStateViewTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskStateViewTemplate)));