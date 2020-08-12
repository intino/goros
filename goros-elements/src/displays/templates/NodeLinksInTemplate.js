import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractNodeLinksInTemplate from "../../../gen/displays/templates/AbstractNodeLinksInTemplate";
import NodeLinksInTemplateNotifier from "../../../gen/displays/notifiers/NodeLinksInTemplateNotifier";
import NodeLinksInTemplateRequester from "../../../gen/displays/requesters/NodeLinksInTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class NodeLinksInTemplate extends AbstractNodeLinksInTemplate {

	constructor(props) {
		super(props);
		this.notifier = new NodeLinksInTemplateNotifier(this);
		this.requester = new NodeLinksInTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(NodeLinksInTemplate));
DisplayFactory.register("NodeLinksInTemplate", withStyles(styles, { withTheme: true })(withSnackbar(NodeLinksInTemplate)));