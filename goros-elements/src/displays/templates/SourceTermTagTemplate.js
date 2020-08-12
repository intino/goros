import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractSourceTermTagTemplate from "../../../gen/displays/templates/AbstractSourceTermTagTemplate";
import SourceTermTagTemplateNotifier from "../../../gen/displays/notifiers/SourceTermTagTemplateNotifier";
import SourceTermTagTemplateRequester from "../../../gen/displays/requesters/SourceTermTagTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class SourceTermTagTemplate extends AbstractSourceTermTagTemplate {

	constructor(props) {
		super(props);
		this.notifier = new SourceTermTagTemplateNotifier(this);
		this.requester = new SourceTermTagTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(SourceTermTagTemplate));
DisplayFactory.register("SourceTermTagTemplate", withStyles(styles, { withTheme: true })(withSnackbar(SourceTermTagTemplate)));