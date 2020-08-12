import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractDateRangeFilterTemplate from "../../../gen/displays/templates/AbstractDateRangeFilterTemplate";
import DateRangeFilterTemplateNotifier from "../../../gen/displays/notifiers/DateRangeFilterTemplateNotifier";
import DateRangeFilterTemplateRequester from "../../../gen/displays/requesters/DateRangeFilterTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class DateRangeFilterTemplate extends AbstractDateRangeFilterTemplate {

	constructor(props) {
		super(props);
		this.notifier = new DateRangeFilterTemplateNotifier(this);
		this.requester = new DateRangeFilterTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(DateRangeFilterTemplate));
DisplayFactory.register("DateRangeFilterTemplate", withStyles(styles, { withTheme: true })(withSnackbar(DateRangeFilterTemplate)));