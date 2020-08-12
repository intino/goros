import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTaskToolbarTemplate from "../../../gen/displays/templates/AbstractTaskToolbarTemplate";
import TaskToolbarTemplateNotifier from "../../../gen/displays/notifiers/TaskToolbarTemplateNotifier";
import TaskToolbarTemplateRequester from "../../../gen/displays/requesters/TaskToolbarTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskToolbarTemplate extends AbstractTaskToolbarTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskToolbarTemplateNotifier(this);
		this.requester = new TaskToolbarTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskToolbarTemplate));
DisplayFactory.register("TaskToolbarTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskToolbarTemplate)));