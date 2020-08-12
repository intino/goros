import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTaskPlaceLineTemplate from "../../../gen/displays/templates/AbstractTaskPlaceLineTemplate";
import TaskPlaceLineTemplateNotifier from "../../../gen/displays/notifiers/TaskPlaceLineTemplateNotifier";
import TaskPlaceLineTemplateRequester from "../../../gen/displays/requesters/TaskPlaceLineTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskPlaceLineTemplate extends AbstractTaskPlaceLineTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskPlaceLineTemplateNotifier(this);
		this.requester = new TaskPlaceLineTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceLineTemplate));
DisplayFactory.register("TaskPlaceLineTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceLineTemplate)));