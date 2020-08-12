import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractComboFilterTemplate from "../../../gen/displays/templates/AbstractComboFilterTemplate";
import ComboFilterTemplateNotifier from "../../../gen/displays/notifiers/ComboFilterTemplateNotifier";
import ComboFilterTemplateRequester from "../../../gen/displays/requesters/ComboFilterTemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class ComboFilterTemplate extends AbstractComboFilterTemplate {

	constructor(props) {
		super(props);
		this.notifier = new ComboFilterTemplateNotifier(this);
		this.requester = new ComboFilterTemplateRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(ComboFilterTemplate));
DisplayFactory.register("ComboFilterTemplate", withStyles(styles, { withTheme: true })(withSnackbar(ComboFilterTemplate)));