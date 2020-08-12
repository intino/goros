import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractNodeRevisionsTemplate from "../../../gen/displays/templates/AbstractNodeRevisionsTemplate";
import NodeRevisionsTemplateNotifier from "../../../gen/displays/notifiers/NodeRevisionsTemplateNotifier";
import NodeRevisionsTemplateRequester from "../../../gen/displays/requesters/NodeRevisionsTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class NodeRevisionsTemplate extends AbstractNodeRevisionsTemplate {

	constructor(props) {
		super(props);
		this.notifier = new NodeRevisionsTemplateNotifier(this);
		this.requester = new NodeRevisionsTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(NodeRevisionsTemplate));
DisplayFactory.register("NodeRevisionsTemplate", withStyles(styles, { withTheme: true })(withSnackbar(NodeRevisionsTemplate)));