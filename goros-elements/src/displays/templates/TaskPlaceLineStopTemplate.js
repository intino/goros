import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTaskPlaceLineStopTemplate from "../../../gen/displays/templates/AbstractTaskPlaceLineStopTemplate";
import TaskPlaceLineStopTemplateNotifier from "../../../gen/displays/notifiers/TaskPlaceLineStopTemplateNotifier";
import TaskPlaceLineStopTemplateRequester from "../../../gen/displays/requesters/TaskPlaceLineStopTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskPlaceLineStopTemplate extends AbstractTaskPlaceLineStopTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskPlaceLineStopTemplateNotifier(this);
		this.requester = new TaskPlaceLineStopTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceLineStopTemplate));
DisplayFactory.register("TaskPlaceLineStopTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceLineStopTemplate)));