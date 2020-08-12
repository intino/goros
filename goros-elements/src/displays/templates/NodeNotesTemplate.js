import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractNodeNotesTemplate from "../../../gen/displays/templates/AbstractNodeNotesTemplate";
import NodeNotesTemplateNotifier from "../../../gen/displays/notifiers/NodeNotesTemplateNotifier";
import NodeNotesTemplateRequester from "../../../gen/displays/requesters/NodeNotesTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class NodeNotesTemplate extends AbstractNodeNotesTemplate {

	constructor(props) {
		super(props);
		this.notifier = new NodeNotesTemplateNotifier(this);
		this.requester = new NodeNotesTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(NodeNotesTemplate));
DisplayFactory.register("NodeNotesTemplate", withStyles(styles, { withTheme: true })(withSnackbar(NodeNotesTemplate)));