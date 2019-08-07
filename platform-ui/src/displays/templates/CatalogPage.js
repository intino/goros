import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractCatalogPage from "../../../gen/displays/templates/AbstractCatalogPage";
import CatalogPageNotifier from "../../../gen/displays/notifiers/CatalogPageNotifier";
import CatalogPageRequester from "../../../gen/displays/requesters/CatalogPageRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class CatalogPage extends AbstractCatalogPage {

	constructor(props) {
		super(props);
		this.notifier = new CatalogPageNotifier(this);
		this.requester = new CatalogPageRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(CatalogPage));
DisplayFactory.register("CatalogPage", withStyles(styles, { withTheme: true })(withSnackbar(CatalogPage)));