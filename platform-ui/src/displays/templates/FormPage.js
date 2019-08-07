import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractFormPage from "../../../gen/displays/templates/AbstractFormPage";
import FormPageNotifier from "../../../gen/displays/notifiers/FormPageNotifier";
import FormPageRequester from "../../../gen/displays/requesters/FormPageRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class FormPage extends AbstractFormPage {

	constructor(props) {
		super(props);
		this.notifier = new FormPageNotifier(this);
		this.requester = new FormPageRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(FormPage));
DisplayFactory.register("FormPage", withStyles(styles, { withTheme: true })(withSnackbar(FormPage)));