import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractTasksListCatalog from "../../../gen/displays/templates/AbstractTasksListCatalog";
import TasksListCatalogNotifier from "../../../gen/displays/notifiers/TasksListCatalogNotifier";
import TasksListCatalogRequester from "../../../gen/displays/requesters/TasksListCatalogRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TasksListCatalog extends AbstractTasksListCatalog {

	constructor(props) {
		super(props);
		this.notifier = new TasksListCatalogNotifier(this);
		this.requester = new TasksListCatalogRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TasksListCatalog));
DisplayFactory.register("TasksListCatalog", withStyles(styles, { withTheme: true })(withSnackbar(TasksListCatalog)));