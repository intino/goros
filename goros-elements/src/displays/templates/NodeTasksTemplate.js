import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractNodeTasksTemplate from "../../../gen/displays/templates/AbstractNodeTasksTemplate";
import NodeTasksTemplateNotifier from "../../../gen/displays/notifiers/NodeTasksTemplateNotifier";
import NodeTasksTemplateRequester from "../../../gen/displays/requesters/NodeTasksTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class NodeTasksTemplate extends AbstractNodeTasksTemplate {

	constructor(props) {
		super(props);
		this.notifier = new NodeTasksTemplateNotifier(this);
		this.requester = new NodeTasksTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(NodeTasksTemplate));
DisplayFactory.register("NodeTasksTemplate", withStyles(styles, { withTheme: true })(withSnackbar(NodeTasksTemplate)));