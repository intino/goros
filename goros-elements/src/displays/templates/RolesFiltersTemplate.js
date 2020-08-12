import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractRolesFiltersTemplate from "../../../gen/displays/templates/AbstractRolesFiltersTemplate";
import RolesFiltersTemplateNotifier from "../../../gen/displays/notifiers/RolesFiltersTemplateNotifier";
import RolesFiltersTemplateRequester from "../../../gen/displays/requesters/RolesFiltersTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class RolesFiltersTemplate extends AbstractRolesFiltersTemplate {

	constructor(props) {
		super(props);
		this.notifier = new RolesFiltersTemplateNotifier(this);
		this.requester = new RolesFiltersTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(RolesFiltersTemplate));
DisplayFactory.register("RolesFiltersTemplate", withStyles(styles, { withTheme: true })(withSnackbar(RolesFiltersTemplate)));