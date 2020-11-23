import React from "react";
import { withStyles } from '@material-ui/core/styles';
import DisplaysAssignTaskDialogTableFullnameItem from "unit-elements/gen/displays/items/AssignTaskDialogTableFullnameItem";
import DisplaysAssignTaskDialogTableEmailItem from "unit-elements/gen/displays/items/AssignTaskDialogTableEmailItem";
import UiRow from "alexandria-ui-elements/src/displays/components/Row";
import AssignTaskDialogTableRowNotifier from "alexandria-ui-elements/gen/displays/notifiers/RowNotifier";
import AssignTaskDialogTableRowRequester from "alexandria-ui-elements/gen/displays/requesters/RowRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class AssignTaskDialogTableRow extends UiRow {

	constructor(props) {
		super(props);
		this.notifier = new AssignTaskDialogTableRowNotifier(this);
		this.requester = new AssignTaskDialogTableRowRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return this.renderRow(
			<React.Fragment>
				<DisplaysAssignTaskDialogTableFullnameItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_997855662" style={{width:"16%",paddingRight:"10px",paddingLeft:"10px"}} hidden="Never"></DisplaysAssignTaskDialogTableFullnameItem>
				<DisplaysAssignTaskDialogTableEmailItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1462841145" style={{width:"16%",paddingRight:"10px"}} hidden="Never"></DisplaysAssignTaskDialogTableEmailItem>
			</React.Fragment>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(AssignTaskDialogTableRow));
DisplayFactory.register("AssignTaskDialogTableRow", withStyles(styles, { withTheme: true })(withSnackbar(AssignTaskDialogTableRow)));