import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTextView from "../../../gen/displays/templates/AbstractTextView";
import TextViewNotifier from "../../../gen/displays/notifiers/TextViewNotifier";
import TextViewRequester from "../../../gen/displays/requesters/TextViewRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TextView extends AbstractTextView {

	constructor(props) {
		super(props);
		this.notifier = new TextViewNotifier(this);
		this.requester = new TextViewRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TextView));
DisplayFactory.register("TextView", withStyles(styles, { withTheme: true })(withSnackbar(TextView)));