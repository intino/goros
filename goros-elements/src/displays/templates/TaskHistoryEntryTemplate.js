import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTaskHistoryEntryTemplate from "../../../gen/displays/templates/AbstractTaskHistoryEntryTemplate";
import TaskHistoryEntryTemplateNotifier from "../../../gen/displays/notifiers/TaskHistoryEntryTemplateNotifier";
import TaskHistoryEntryTemplateRequester from "../../../gen/displays/requesters/TaskHistoryEntryTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskHistoryEntryTemplate extends AbstractTaskHistoryEntryTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskHistoryEntryTemplateNotifier(this);
		this.requester = new TaskHistoryEntryTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskHistoryEntryTemplate));
DisplayFactory.register("TaskHistoryEntryTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskHistoryEntryTemplate)));