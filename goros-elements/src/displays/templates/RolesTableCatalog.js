import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractRolesTableCatalog from "../../../gen/displays/templates/AbstractRolesTableCatalog";
import RolesTableCatalogNotifier from "../../../gen/displays/notifiers/RolesTableCatalogNotifier";
import RolesTableCatalogRequester from "../../../gen/displays/requesters/RolesTableCatalogRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class RolesTableCatalog extends AbstractRolesTableCatalog {

	constructor(props) {
		super(props);
		this.notifier = new RolesTableCatalogNotifier(this);
		this.requester = new RolesTableCatalogRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(RolesTableCatalog));
DisplayFactory.register("RolesTableCatalog", withStyles(styles, { withTheme: true })(withSnackbar(RolesTableCatalog)));