import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTrashTableFilters from "../../../gen/displays/templates/AbstractTrashTableFilters";
import TrashTableFiltersNotifier from "../../../gen/displays/notifiers/TrashTableFiltersNotifier";
import TrashTableFiltersRequester from "../../../gen/displays/requesters/TrashTableFiltersRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TrashTableFilters extends AbstractTrashTableFilters {

	constructor(props) {
		super(props);
		this.notifier = new TrashTableFiltersNotifier(this);
		this.requester = new TrashTableFiltersRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TrashTableFilters));
DisplayFactory.register("TrashTableFilters", withStyles(styles, { withTheme: true })(withSnackbar(TrashTableFilters)));