import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractNodePage from "../../../gen/displays/templates/AbstractNodePage";
import NodePageNotifier from "../../../gen/displays/notifiers/NodePageNotifier";
import NodePageRequester from "../../../gen/displays/requesters/NodePageRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

export default class NodePage extends AbstractNodePage {

	constructor(props) {
		super(props);
		this.notifier = new NodePageNotifier(this);
		this.requester = new NodePageRequester(this);
	};


}

DisplayFactory.register("NodePage", withStyles(styles, { withTheme: true })(withSnackbar(NodePage)));