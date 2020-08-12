import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractFieldNodeTemplate from "../../../gen/displays/templates/AbstractFieldNodeTemplate";
import FieldNodeTemplateNotifier from "../../../gen/displays/notifiers/FieldNodeTemplateNotifier";
import FieldNodeTemplateRequester from "../../../gen/displays/requesters/FieldNodeTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class FieldNodeTemplate extends AbstractFieldNodeTemplate {

	constructor(props) {
		super(props);
		this.notifier = new FieldNodeTemplateNotifier(this);
		this.requester = new FieldNodeTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(FieldNodeTemplate));
DisplayFactory.register("FieldNodeTemplate", withStyles(styles, { withTheme: true })(withSnackbar(FieldNodeTemplate)));