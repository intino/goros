import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTaskPlaceSendRequestTemplate from "../../../gen/displays/templates/AbstractTaskPlaceSendRequestTemplate";
import TaskPlaceSendRequestTemplateNotifier from "../../../gen/displays/notifiers/TaskPlaceSendRequestTemplateNotifier";
import TaskPlaceSendRequestTemplateRequester from "../../../gen/displays/requesters/TaskPlaceSendRequestTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskPlaceSendRequestTemplate extends AbstractTaskPlaceSendRequestTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskPlaceSendRequestTemplateNotifier(this);
		this.requester = new TaskPlaceSendRequestTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceSendRequestTemplate));
DisplayFactory.register("TaskPlaceSendRequestTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceSendRequestTemplate)));