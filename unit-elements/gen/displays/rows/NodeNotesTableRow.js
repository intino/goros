import React from "react";
import { withStyles } from '@material-ui/core/styles';
import DisplaysNodeNotesTableNameItem from "unit-elements/gen/displays/items/NodeNotesTableNameItem";
import DisplaysNodeNotesTableValueItem from "unit-elements/gen/displays/items/NodeNotesTableValueItem";
import DisplaysNodeNotesTableOperationsItem from "unit-elements/gen/displays/items/NodeNotesTableOperationsItem";
import UiRow from "alexandria-ui-elements/src/displays/components/Row";
import NodeNotesTableRowNotifier from "alexandria-ui-elements/gen/displays/notifiers/RowNotifier";
import NodeNotesTableRowRequester from "alexandria-ui-elements/gen/displays/requesters/RowRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class NodeNotesTableRow extends UiRow {

	constructor(props) {
		super(props);
		this.notifier = new NodeNotesTableRowNotifier(this);
		this.requester = new NodeNotesTableRowRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return this.renderRow(
			<React.Fragment>
				<DisplaysNodeNotesTableNameItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a749380548" style={{width:"30%",paddingRight:"10px",paddingLeft:"10px"}} hidden="Never"></DisplaysNodeNotesTableNameItem>
				<DisplaysNodeNotesTableValueItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1633743967" style={{width:"60%",paddingRight:"10px"}} hidden="Never"></DisplaysNodeNotesTableValueItem>
				<DisplaysNodeNotesTableOperationsItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_633608022" style={{width:"10%",paddingRight:"10px"}} hidden="Never"></DisplaysNodeNotesTableOperationsItem>
			</React.Fragment>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(NodeNotesTableRow));
DisplayFactory.register("NodeNotesTableRow", withStyles(styles, { withTheme: true })(withSnackbar(NodeNotesTableRow)));