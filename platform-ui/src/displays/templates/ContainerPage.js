import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractContainerPage from "../../../gen/displays/templates/AbstractContainerPage";
import ContainerPageNotifier from "../../../gen/displays/notifiers/ContainerPageNotifier";
import ContainerPageRequester from "../../../gen/displays/requesters/ContainerPageRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class ContainerPage extends AbstractContainerPage {

	constructor(props) {
		super(props);
		this.notifier = new ContainerPageNotifier(this);
		this.requester = new ContainerPageRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(ContainerPage));
DisplayFactory.register("ContainerPage", withStyles(styles, { withTheme: true })(withSnackbar(ContainerPage)));