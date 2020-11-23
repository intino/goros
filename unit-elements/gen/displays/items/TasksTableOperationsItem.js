import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiAction from "alexandria-ui-elements/src/displays/components/Action";
import UiItem from "alexandria-ui-elements/src/displays/components/Item";
import TasksTableOperationsItemNotifier from "alexandria-ui-elements/gen/displays/notifiers/ItemNotifier";
import TasksTableOperationsItemRequester from "alexandria-ui-elements/gen/displays/requesters/ItemRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TasksTableOperationsItem extends UiItem {

	constructor(props) {
		super(props);
		this.notifier = new TasksTableOperationsItemNotifier(this);
		this.requester = new TasksTableOperationsItemRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<div style={{width:"100%",height:"100%",...this.props.style,...this.style(),...display}} className={className}>
				<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_567021147" title="Marcar/Desmarcar como urgente" target="self" mode="MaterialIconButton" icon="Alarm" size="Small" color="#ddd">
				</UiAction>
			</div>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TasksTableOperationsItem));
DisplayFactory.register("TasksTableOperationsItem", withStyles(styles, { withTheme: true })(withSnackbar(TasksTableOperationsItem)));