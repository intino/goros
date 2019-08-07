import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractFormView from "../../../gen/displays/templates/AbstractFormView";
import FormViewNotifier from "../../../gen/displays/notifiers/FormViewNotifier";
import FormViewRequester from "../../../gen/displays/requesters/FormViewRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class FormView extends AbstractFormView {

	constructor(props) {
		super(props);
		this.notifier = new FormViewNotifier(this);
		this.requester = new FormViewRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(FormView));
DisplayFactory.register("FormView", withStyles(styles, { withTheme: true })(withSnackbar(FormView)));