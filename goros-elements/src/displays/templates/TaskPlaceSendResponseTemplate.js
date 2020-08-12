import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTaskPlaceSendResponseTemplate from "../../../gen/displays/templates/AbstractTaskPlaceSendResponseTemplate";
import TaskPlaceSendResponseTemplateNotifier from "../../../gen/displays/notifiers/TaskPlaceSendResponseTemplateNotifier";
import TaskPlaceSendResponseTemplateRequester from "../../../gen/displays/requesters/TaskPlaceSendResponseTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskPlaceSendResponseTemplate extends AbstractTaskPlaceSendResponseTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskPlaceSendResponseTemplateNotifier(this);
		this.requester = new TaskPlaceSendResponseTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceSendResponseTemplate));
DisplayFactory.register("TaskPlaceSendResponseTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceSendResponseTemplate)));