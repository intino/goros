import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTrashTableCatalog from "../../../gen/displays/templates/AbstractTrashTableCatalog";
import TrashTableCatalogNotifier from "../../../gen/displays/notifiers/TrashTableCatalogNotifier";
import TrashTableCatalogRequester from "../../../gen/displays/requesters/TrashTableCatalogRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TrashTableCatalog extends AbstractTrashTableCatalog {

	constructor(props) {
		super(props);
		this.notifier = new TrashTableCatalogNotifier(this);
		this.requester = new TrashTableCatalogRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TrashTableCatalog));
DisplayFactory.register("TrashTableCatalog", withStyles(styles, { withTheme: true })(withSnackbar(TrashTableCatalog)));