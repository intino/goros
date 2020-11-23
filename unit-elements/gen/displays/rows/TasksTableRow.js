import React from "react";
import { withStyles } from '@material-ui/core/styles';
import DisplaysTasksTableLabelItem from "unit-elements/gen/displays/items/TasksTableLabelItem";
import DisplaysTasksTableDescriptionItem from "unit-elements/gen/displays/items/TasksTableDescriptionItem";
import DisplaysTasksTableOwnerItem from "unit-elements/gen/displays/items/TasksTableOwnerItem";
import DisplaysTasksTableCreateDateItem from "unit-elements/gen/displays/items/TasksTableCreateDateItem";
import DisplaysTasksTableUpdateDateItem from "unit-elements/gen/displays/items/TasksTableUpdateDateItem";
import DisplaysTasksTableCountMessagesItem from "unit-elements/gen/displays/items/TasksTableCountMessagesItem";
import DisplaysTasksTableOperationsItem from "unit-elements/gen/displays/items/TasksTableOperationsItem";
import UiRow from "alexandria-ui-elements/src/displays/components/Row";
import TasksTableRowNotifier from "alexandria-ui-elements/gen/displays/notifiers/RowNotifier";
import TasksTableRowRequester from "alexandria-ui-elements/gen/displays/requesters/RowRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TasksTableRow extends UiRow {

	constructor(props) {
		super(props);
		this.notifier = new TasksTableRowNotifier(this);
		this.requester = new TasksTableRowRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return this.renderRow(
			<React.Fragment>
				<DisplaysTasksTableLabelItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a2000043949" style={{width:"20%",paddingRight:"10px",paddingLeft:"10px"}} hidden="Never"></DisplaysTasksTableLabelItem>
				<DisplaysTasksTableDescriptionItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a688437946" style={{width:"30%",paddingRight:"10px"}} hidden="Never"></DisplaysTasksTableDescriptionItem>
				<DisplaysTasksTableOwnerItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a68884553" style={{width:"10%",paddingRight:"10px"}} hidden="Never"></DisplaysTasksTableOwnerItem>
				<DisplaysTasksTableCreateDateItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1540070121" style={{width:"10%",paddingRight:"10px"}} hidden="Never"></DisplaysTasksTableCreateDateItem>
				<DisplaysTasksTableUpdateDateItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1938290177" style={{width:"10%",paddingRight:"10px"}} hidden="Never"></DisplaysTasksTableUpdateDateItem>
				<DisplaysTasksTableCountMessagesItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a675688538" style={{width:"10%",paddingRight:"10px"}} hidden="Never"></DisplaysTasksTableCountMessagesItem>
				<DisplaysTasksTableOperationsItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_428043685" style={{width:"10%",paddingRight:"10px"}} hidden="Never"></DisplaysTasksTableOperationsItem>
			</React.Fragment>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TasksTableRow));
DisplayFactory.register("TasksTableRow", withStyles(styles, { withTheme: true })(withSnackbar(TasksTableRow)));