import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTasksTableCatalog from "../../../gen/displays/templates/AbstractTasksTableCatalog";
import TasksTableCatalogNotifier from "../../../gen/displays/notifiers/TasksTableCatalogNotifier";
import TasksTableCatalogRequester from "../../../gen/displays/requesters/TasksTableCatalogRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TasksTableCatalog extends AbstractTasksTableCatalog {

	constructor(props) {
		super(props);
		this.notifier = new TasksTableCatalogNotifier(this);
		this.requester = new TasksTableCatalogRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TasksTableCatalog));
DisplayFactory.register("TasksTableCatalog", withStyles(styles, { withTheme: true })(withSnackbar(TasksTableCatalog)));