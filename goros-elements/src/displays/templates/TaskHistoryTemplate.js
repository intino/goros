import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTaskHistoryTemplate from "../../../gen/displays/templates/AbstractTaskHistoryTemplate";
import TaskHistoryTemplateNotifier from "../../../gen/displays/notifiers/TaskHistoryTemplateNotifier";
import TaskHistoryTemplateRequester from "../../../gen/displays/requesters/TaskHistoryTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskHistoryTemplate extends AbstractTaskHistoryTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskHistoryTemplateNotifier(this);
		this.requester = new TaskHistoryTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskHistoryTemplate));
DisplayFactory.register("TaskHistoryTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskHistoryTemplate)));