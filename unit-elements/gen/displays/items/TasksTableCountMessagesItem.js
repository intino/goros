import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiNumber from "alexandria-ui-elements/src/displays/components/Number";
import UiItem from "alexandria-ui-elements/src/displays/components/Item";
import TasksTableCountMessagesItemNotifier from "alexandria-ui-elements/gen/displays/notifiers/ItemNotifier";
import TasksTableCountMessagesItemRequester from "alexandria-ui-elements/gen/displays/requesters/ItemRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TasksTableCountMessagesItem extends UiItem {

	constructor(props) {
		super(props);
		this.notifier = new TasksTableCountMessagesItemNotifier(this);
		this.requester = new TasksTableCountMessagesItemRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<div style={{width:"100%",height:"100%",...this.props.style,...this.style(),...display}} className={className}>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_2051326049" layout="horizontal centerjustified">
					<UiNumber context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_680303001" style="Number" value={0.0} decimals={0} expanded={true}>
					</UiNumber>
				</UiBlock>
			</div>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TasksTableCountMessagesItem));
DisplayFactory.register("TasksTableCountMessagesItem", withStyles(styles, { withTheme: true })(withSnackbar(TasksTableCountMessagesItem)));