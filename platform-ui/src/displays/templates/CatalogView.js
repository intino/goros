import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractCatalogView from "../../../gen/displays/templates/AbstractCatalogView";
import CatalogViewNotifier from "../../../gen/displays/notifiers/CatalogViewNotifier";
import CatalogViewRequester from "../../../gen/displays/requesters/CatalogViewRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class CatalogView extends AbstractCatalogView {

	constructor(props) {
		super(props);
		this.notifier = new CatalogViewNotifier(this);
		this.requester = new CatalogViewRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(CatalogView));
DisplayFactory.register("CatalogView", withStyles(styles, { withTheme: true })(withSnackbar(CatalogView)));