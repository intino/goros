import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractDocumentPage from "../../../gen/displays/templates/AbstractDocumentPage";
import DocumentPageNotifier from "../../../gen/displays/notifiers/DocumentPageNotifier";
import DocumentPageRequester from "../../../gen/displays/requesters/DocumentPageRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class DocumentPage extends AbstractDocumentPage {

	constructor(props) {
		super(props);
		this.notifier = new DocumentPageNotifier(this);
		this.requester = new DocumentPageRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(DocumentPage));
DisplayFactory.register("DocumentPage", withStyles(styles, { withTheme: true })(withSnackbar(DocumentPage)));