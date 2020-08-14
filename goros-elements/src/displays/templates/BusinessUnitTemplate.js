import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractBusinessUnitTemplate from "../../../gen/displays/templates/AbstractBusinessUnitTemplate";
import BusinessUnitTemplateNotifier from "../../../gen/displays/notifiers/BusinessUnitTemplateNotifier";
import BusinessUnitTemplateRequester from "../../../gen/displays/requesters/BusinessUnitTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class BusinessUnitTemplate extends AbstractBusinessUnitTemplate {

	constructor(props) {
		super(props);
		this.notifier = new BusinessUnitTemplateNotifier(this);
		this.requester = new BusinessUnitTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(BusinessUnitTemplate));
DisplayFactory.register("BusinessUnitTemplate", withStyles(styles, { withTheme: true })(withSnackbar(BusinessUnitTemplate)));