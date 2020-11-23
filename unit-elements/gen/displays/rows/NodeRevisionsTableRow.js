import React from "react";
import { withStyles } from '@material-ui/core/styles';
import DisplaysNodeRevisionsTableLabelItem from "unit-elements/gen/displays/items/NodeRevisionsTableLabelItem";
import DisplaysNodeRevisionsTableOperationsItem from "unit-elements/gen/displays/items/NodeRevisionsTableOperationsItem";
import UiRow from "alexandria-ui-elements/src/displays/components/Row";
import NodeRevisionsTableRowNotifier from "alexandria-ui-elements/gen/displays/notifiers/RowNotifier";
import NodeRevisionsTableRowRequester from "alexandria-ui-elements/gen/displays/requesters/RowRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class NodeRevisionsTableRow extends UiRow {

	constructor(props) {
		super(props);
		this.notifier = new NodeRevisionsTableRowNotifier(this);
		this.requester = new NodeRevisionsTableRowRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return this.renderRow(
			<React.Fragment>
				<DisplaysNodeRevisionsTableLabelItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1423086964" style={{width:"80%",paddingRight:"10px",paddingLeft:"10px"}} hidden="Never"></DisplaysNodeRevisionsTableLabelItem>
				<DisplaysNodeRevisionsTableOperationsItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1811963633" style={{width:"20%",paddingRight:"10px"}} hidden="Never"></DisplaysNodeRevisionsTableOperationsItem>
			</React.Fragment>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(NodeRevisionsTableRow));
DisplayFactory.register("NodeRevisionsTableRow", withStyles(styles, { withTheme: true })(withSnackbar(NodeRevisionsTableRow)));