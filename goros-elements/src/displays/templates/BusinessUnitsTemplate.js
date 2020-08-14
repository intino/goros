import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractBusinessUnitsTemplate from "../../../gen/displays/templates/AbstractBusinessUnitsTemplate";
import BusinessUnitsTemplateNotifier from "../../../gen/displays/notifiers/BusinessUnitsTemplateNotifier";
import BusinessUnitsTemplateRequester from "../../../gen/displays/requesters/BusinessUnitsTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class BusinessUnitsTemplate extends AbstractBusinessUnitsTemplate {

	constructor(props) {
		super(props);
		this.notifier = new BusinessUnitsTemplateNotifier(this);
		this.requester = new BusinessUnitsTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(BusinessUnitsTemplate));
DisplayFactory.register("BusinessUnitsTemplate", withStyles(styles, { withTheme: true })(withSnackbar(BusinessUnitsTemplate)));