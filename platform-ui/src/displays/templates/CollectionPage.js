import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractCollectionPage from "../../../gen/displays/templates/AbstractCollectionPage";
import CollectionPageNotifier from "../../../gen/displays/notifiers/CollectionPageNotifier";
import CollectionPageRequester from "../../../gen/displays/requesters/CollectionPageRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class CollectionPage extends AbstractCollectionPage {

	constructor(props) {
		super(props);
		this.notifier = new CollectionPageNotifier(this);
		this.requester = new CollectionPageRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(CollectionPage));
DisplayFactory.register("CollectionPage", withStyles(styles, { withTheme: true })(withSnackbar(CollectionPage)));