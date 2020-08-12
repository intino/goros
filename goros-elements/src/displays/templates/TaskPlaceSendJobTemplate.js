import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTaskPlaceSendJobTemplate from "../../../gen/displays/templates/AbstractTaskPlaceSendJobTemplate";
import TaskPlaceSendJobTemplateNotifier from "../../../gen/displays/notifiers/TaskPlaceSendJobTemplateNotifier";
import TaskPlaceSendJobTemplateRequester from "../../../gen/displays/requesters/TaskPlaceSendJobTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskPlaceSendJobTemplate extends AbstractTaskPlaceSendJobTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskPlaceSendJobTemplateNotifier(this);
		this.requester = new TaskPlaceSendJobTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceSendJobTemplate));
DisplayFactory.register("TaskPlaceSendJobTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceSendJobTemplate)));