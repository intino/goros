import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractSourceLevelTemplate from "../../../gen/displays/templates/AbstractSourceLevelTemplate";
import SourceLevelTemplateNotifier from "../../../gen/displays/notifiers/SourceLevelTemplateNotifier";
import SourceLevelTemplateRequester from "../../../gen/displays/requesters/SourceLevelTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class SourceLevelTemplate extends AbstractSourceLevelTemplate {

	constructor(props) {
		super(props);
		this.notifier = new SourceLevelTemplateNotifier(this);
		this.requester = new SourceLevelTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(SourceLevelTemplate));
DisplayFactory.register("SourceLevelTemplate", withStyles(styles, { withTheme: true })(withSnackbar(SourceLevelTemplate)));