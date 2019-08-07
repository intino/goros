import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractFieldView from "../../../gen/displays/templates/AbstractFieldView";
import FieldViewNotifier from "../../../gen/displays/notifiers/FieldViewNotifier";
import FieldViewRequester from "../../../gen/displays/requesters/FieldViewRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class FieldView extends AbstractFieldView {

	constructor(props) {
		super(props);
		this.notifier = new FieldViewNotifier(this);
		this.requester = new FieldViewRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(FieldView));
DisplayFactory.register("FieldView", withStyles(styles, { withTheme: true })(withSnackbar(FieldView)));