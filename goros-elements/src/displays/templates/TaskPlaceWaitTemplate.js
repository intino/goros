import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTaskPlaceWaitTemplate from "../../../gen/displays/templates/AbstractTaskPlaceWaitTemplate";
import TaskPlaceWaitTemplateNotifier from "../../../gen/displays/notifiers/TaskPlaceWaitTemplateNotifier";
import TaskPlaceWaitTemplateRequester from "../../../gen/displays/requesters/TaskPlaceWaitTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskPlaceWaitTemplate extends AbstractTaskPlaceWaitTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskPlaceWaitTemplateNotifier(this);
		this.requester = new TaskPlaceWaitTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceWaitTemplate));
DisplayFactory.register("TaskPlaceWaitTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceWaitTemplate)));