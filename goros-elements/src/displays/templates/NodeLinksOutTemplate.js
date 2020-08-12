import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractNodeLinksOutTemplate from "../../../gen/displays/templates/AbstractNodeLinksOutTemplate";
import NodeLinksOutTemplateNotifier from "../../../gen/displays/notifiers/NodeLinksOutTemplateNotifier";
import NodeLinksOutTemplateRequester from "../../../gen/displays/requesters/NodeLinksOutTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class NodeLinksOutTemplate extends AbstractNodeLinksOutTemplate {

	constructor(props) {
		super(props);
		this.notifier = new NodeLinksOutTemplateNotifier(this);
		this.requester = new NodeLinksOutTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(NodeLinksOutTemplate));
DisplayFactory.register("NodeLinksOutTemplate", withStyles(styles, { withTheme: true })(withSnackbar(NodeLinksOutTemplate)));