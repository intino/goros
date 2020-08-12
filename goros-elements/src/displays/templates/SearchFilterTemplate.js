import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractSearchFilterTemplate from "../../../gen/displays/templates/AbstractSearchFilterTemplate";
import SearchFilterTemplateNotifier from "../../../gen/displays/notifiers/SearchFilterTemplateNotifier";
import SearchFilterTemplateRequester from "../../../gen/displays/requesters/SearchFilterTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class SearchFilterTemplate extends AbstractSearchFilterTemplate {

	constructor(props) {
		super(props);
		this.notifier = new SearchFilterTemplateNotifier(this);
		this.requester = new SearchFilterTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(SearchFilterTemplate));
DisplayFactory.register("SearchFilterTemplate", withStyles(styles, { withTheme: true })(withSnackbar(SearchFilterTemplate)));