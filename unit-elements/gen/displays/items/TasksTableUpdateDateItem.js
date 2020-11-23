import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiDate from "alexandria-ui-elements/src/displays/components/Date";
import UiItem from "alexandria-ui-elements/src/displays/components/Item";
import TasksTableUpdateDateItemNotifier from "alexandria-ui-elements/gen/displays/notifiers/ItemNotifier";
import TasksTableUpdateDateItemRequester from "alexandria-ui-elements/gen/displays/requesters/ItemRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TasksTableUpdateDateItem extends UiItem {

	constructor(props) {
		super(props);
		this.notifier = new TasksTableUpdateDateItemNotifier(this);
		this.requester = new TasksTableUpdateDateItemRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<div style={{width:"100%",height:"100%",...this.props.style,...this.style(),...display}} className={className}>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1646625725" layout="horizontal centerjustified">
					<UiDate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_246632021" pattern="DD/MM/YYYY">
					</UiDate>
				</UiBlock>
			</div>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TasksTableUpdateDateItem));
DisplayFactory.register("TasksTableUpdateDateItem", withStyles(styles, { withTheme: true })(withSnackbar(TasksTableUpdateDateItem)));