import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractNodeView from "../../../gen/displays/templates/AbstractNodeView";
import NodeViewNotifier from "../../../gen/displays/notifiers/NodeViewNotifier";
import NodeViewRequester from "../../../gen/displays/requesters/NodeViewRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class NodeView extends AbstractNodeView {

	constructor(props) {
		super(props);
		this.notifier = new NodeViewNotifier(this);
		this.requester = new NodeViewRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(NodeView));
DisplayFactory.register("NodeView", withStyles(styles, { withTheme: true })(withSnackbar(NodeView)));