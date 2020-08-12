import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTaskPlaceDelegationTemplate from "../../../gen/displays/templates/AbstractTaskPlaceDelegationTemplate";
import TaskPlaceDelegationTemplateNotifier from "../../../gen/displays/notifiers/TaskPlaceDelegationTemplateNotifier";
import TaskPlaceDelegationTemplateRequester from "../../../gen/displays/requesters/TaskPlaceDelegationTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskPlaceDelegationTemplate extends AbstractTaskPlaceDelegationTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskPlaceDelegationTemplateNotifier(this);
		this.requester = new TaskPlaceDelegationTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceDelegationTemplate));
DisplayFactory.register("TaskPlaceDelegationTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceDelegationTemplate)));