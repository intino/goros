import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractSourceLegendTemplate from "../../../gen/displays/templates/AbstractSourceLegendTemplate";
import SourceLegendTemplateNotifier from "../../../gen/displays/notifiers/SourceLegendTemplateNotifier";
import SourceLegendTemplateRequester from "../../../gen/displays/requesters/SourceLegendTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class SourceLegendTemplate extends AbstractSourceLegendTemplate {

	constructor(props) {
		super(props);
		this.notifier = new SourceLegendTemplateNotifier(this);
		this.requester = new SourceLegendTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(SourceLegendTemplate));
DisplayFactory.register("SourceLegendTemplate", withStyles(styles, { withTheme: true })(withSnackbar(SourceLegendTemplate)));