import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTaskOrdersTemplate from "../../../gen/displays/templates/AbstractTaskOrdersTemplate";
import TaskOrdersTemplateNotifier from "../../../gen/displays/notifiers/TaskOrdersTemplateNotifier";
import TaskOrdersTemplateRequester from "../../../gen/displays/requesters/TaskOrdersTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskOrdersTemplate extends AbstractTaskOrdersTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskOrdersTemplateNotifier(this);
		this.requester = new TaskOrdersTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskOrdersTemplate));
DisplayFactory.register("TaskOrdersTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskOrdersTemplate)));