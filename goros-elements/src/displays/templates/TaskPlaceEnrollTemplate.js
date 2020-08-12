import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTaskPlaceEnrollTemplate from "../../../gen/displays/templates/AbstractTaskPlaceEnrollTemplate";
import TaskPlaceEnrollTemplateNotifier from "../../../gen/displays/notifiers/TaskPlaceEnrollTemplateNotifier";
import TaskPlaceEnrollTemplateRequester from "../../../gen/displays/requesters/TaskPlaceEnrollTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskPlaceEnrollTemplate extends AbstractTaskPlaceEnrollTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskPlaceEnrollTemplateNotifier(this);
		this.requester = new TaskPlaceEnrollTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceEnrollTemplate));
DisplayFactory.register("TaskPlaceEnrollTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceEnrollTemplate)));