import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiList from "alexandria-ui-elements/src/displays/components/List";
import DisplaysTasksListItem from "unit-elements/gen/displays/items/TasksListItem";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import TasksListCatalogNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import TasksListCatalogRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TasksListCatalog extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TasksListCatalogNotifier(this);
		this.requester = new TasksListCatalogRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock layout="vertical flexible" width="100.0%" height="100.0%" style={{...this.props.style,...display}}>
				<UiList context={this._context.bind(this)} owner={this._owner.bind(this)} id="a2103281753" noItemsMessage="No hay tareas" pageSize={20} itemHeight={140} scrollingMark={false} selection="single">
				</UiList>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TasksListCatalog));
DisplayFactory.register("TasksListCatalog", withStyles(styles, { withTheme: true })(withSnackbar(TasksListCatalog)));