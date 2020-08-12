import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTaskTrayTemplate from "../../../gen/displays/templates/AbstractTaskTrayTemplate";
import TaskTrayTemplateNotifier from "../../../gen/displays/notifiers/TaskTrayTemplateNotifier";
import TaskTrayTemplateRequester from "../../../gen/displays/requesters/TaskTrayTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskTrayTemplate extends AbstractTaskTrayTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskTrayTemplateNotifier(this);
		this.requester = new TaskTrayTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskTrayTemplate));
DisplayFactory.register("TaskTrayTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskTrayTemplate)));