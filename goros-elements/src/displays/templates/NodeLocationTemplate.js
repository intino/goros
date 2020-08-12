import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractNodeLocationTemplate from "../../../gen/displays/templates/AbstractNodeLocationTemplate";
import NodeLocationTemplateNotifier from "../../../gen/displays/notifiers/NodeLocationTemplateNotifier";
import NodeLocationTemplateRequester from "../../../gen/displays/requesters/NodeLocationTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class NodeLocationTemplate extends AbstractNodeLocationTemplate {

	constructor(props) {
		super(props);
		this.notifier = new NodeLocationTemplateNotifier(this);
		this.requester = new NodeLocationTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(NodeLocationTemplate));
DisplayFactory.register("NodeLocationTemplate", withStyles(styles, { withTheme: true })(withSnackbar(NodeLocationTemplate)));