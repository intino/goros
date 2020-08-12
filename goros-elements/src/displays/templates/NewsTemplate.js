import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractNewsTemplate from "../../../gen/displays/templates/AbstractNewsTemplate";
import NewsTemplateNotifier from "../../../gen/displays/notifiers/NewsTemplateNotifier";
import NewsTemplateRequester from "../../../gen/displays/requesters/NewsTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class NewsTemplate extends AbstractNewsTemplate {

	constructor(props) {
		super(props);
		this.notifier = new NewsTemplateNotifier(this);
		this.requester = new NewsTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(NewsTemplate));
DisplayFactory.register("NewsTemplate", withStyles(styles, { withTheme: true })(withSnackbar(NewsTemplate)));