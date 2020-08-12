import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTaskEmbeddedNodeTemplate from "../../../gen/displays/templates/AbstractTaskEmbeddedNodeTemplate";
import TaskEmbeddedNodeTemplateNotifier from "../../../gen/displays/notifiers/TaskEmbeddedNodeTemplateNotifier";
import TaskEmbeddedNodeTemplateRequester from "../../../gen/displays/requesters/TaskEmbeddedNodeTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskEmbeddedNodeTemplate extends AbstractTaskEmbeddedNodeTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskEmbeddedNodeTemplateNotifier(this);
		this.requester = new TaskEmbeddedNodeTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskEmbeddedNodeTemplate));
DisplayFactory.register("TaskEmbeddedNodeTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskEmbeddedNodeTemplate)));