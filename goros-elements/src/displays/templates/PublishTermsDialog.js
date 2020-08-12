import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractPublishTermsDialog from "../../../gen/displays/templates/AbstractPublishTermsDialog";
import PublishTermsDialogNotifier from "../../../gen/displays/notifiers/PublishTermsDialogNotifier";
import PublishTermsDialogRequester from "../../../gen/displays/requesters/PublishTermsDialogRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class PublishTermsDialog extends AbstractPublishTermsDialog {

	constructor(props) {
		super(props);
		this.notifier = new PublishTermsDialogNotifier(this);
		this.requester = new PublishTermsDialogRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(PublishTermsDialog));
DisplayFactory.register("PublishTermsDialog", withStyles(styles, { withTheme: true })(withSnackbar(PublishTermsDialog)));