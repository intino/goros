import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractSourceEmbeddedTemplate from "../../../gen/displays/templates/AbstractSourceEmbeddedTemplate";
import SourceEmbeddedTemplateNotifier from "../../../gen/displays/notifiers/SourceEmbeddedTemplateNotifier";
import SourceEmbeddedTemplateRequester from "../../../gen/displays/requesters/SourceEmbeddedTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class SourceEmbeddedTemplate extends AbstractSourceEmbeddedTemplate {

	constructor(props) {
		super(props);
		this.notifier = new SourceEmbeddedTemplateNotifier(this);
		this.requester = new SourceEmbeddedTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(SourceEmbeddedTemplate));
DisplayFactory.register("SourceEmbeddedTemplate", withStyles(styles, { withTheme: true })(withSnackbar(SourceEmbeddedTemplate)));