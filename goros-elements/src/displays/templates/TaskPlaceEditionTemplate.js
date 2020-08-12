import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTaskPlaceEditionTemplate from "../../../gen/displays/templates/AbstractTaskPlaceEditionTemplate";
import TaskPlaceEditionTemplateNotifier from "../../../gen/displays/notifiers/TaskPlaceEditionTemplateNotifier";
import TaskPlaceEditionTemplateRequester from "../../../gen/displays/requesters/TaskPlaceEditionTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskPlaceEditionTemplate extends AbstractTaskPlaceEditionTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskPlaceEditionTemplateNotifier(this);
		this.requester = new TaskPlaceEditionTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceEditionTemplate));
DisplayFactory.register("TaskPlaceEditionTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceEditionTemplate)));