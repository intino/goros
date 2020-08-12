import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractListFilterTemplate from "../../../gen/displays/templates/AbstractListFilterTemplate";
import ListFilterTemplateNotifier from "../../../gen/displays/notifiers/ListFilterTemplateNotifier";
import ListFilterTemplateRequester from "../../../gen/displays/requesters/ListFilterTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class ListFilterTemplate extends AbstractListFilterTemplate {

	constructor(props) {
		super(props);
		this.notifier = new ListFilterTemplateNotifier(this);
		this.requester = new ListFilterTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(ListFilterTemplate));
DisplayFactory.register("ListFilterTemplate", withStyles(styles, { withTheme: true })(withSnackbar(ListFilterTemplate)));