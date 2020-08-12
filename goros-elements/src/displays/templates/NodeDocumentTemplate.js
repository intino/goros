import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractNodeDocumentTemplate from "../../../gen/displays/templates/AbstractNodeDocumentTemplate";
import NodeDocumentTemplateNotifier from "../../../gen/displays/notifiers/NodeDocumentTemplateNotifier";
import NodeDocumentTemplateRequester from "../../../gen/displays/requesters/NodeDocumentTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class NodeDocumentTemplate extends AbstractNodeDocumentTemplate {

	constructor(props) {
		super(props);
		this.notifier = new NodeDocumentTemplateNotifier(this);
		this.requester = new NodeDocumentTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(NodeDocumentTemplate));
DisplayFactory.register("NodeDocumentTemplate", withStyles(styles, { withTheme: true })(withSnackbar(NodeDocumentTemplate)));