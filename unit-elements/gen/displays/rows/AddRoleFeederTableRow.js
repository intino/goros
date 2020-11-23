import React from "react";
import { withStyles } from '@material-ui/core/styles';
import DisplaysAddRoleFeederTableLabelItem from "unit-elements/gen/displays/items/AddRoleFeederTableLabelItem";
import DisplaysAddRoleFeederTablePartnerItem from "unit-elements/gen/displays/items/AddRoleFeederTablePartnerItem";
import UiRow from "alexandria-ui-elements/src/displays/components/Row";
import AddRoleFeederTableRowNotifier from "alexandria-ui-elements/gen/displays/notifiers/RowNotifier";
import AddRoleFeederTableRowRequester from "alexandria-ui-elements/gen/displays/requesters/RowRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class AddRoleFeederTableRow extends UiRow {

	constructor(props) {
		super(props);
		this.notifier = new AddRoleFeederTableRowNotifier(this);
		this.requester = new AddRoleFeederTableRowRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return this.renderRow(
			<React.Fragment>
				<DisplaysAddRoleFeederTableLabelItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1532510734" style={{width:"40%",paddingRight:"10px",paddingLeft:"10px"}} hidden="Never"></DisplaysAddRoleFeederTableLabelItem>
				<DisplaysAddRoleFeederTablePartnerItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a853170261" style={{width:"60%",paddingRight:"10px"}} hidden="Never"></DisplaysAddRoleFeederTablePartnerItem>
			</React.Fragment>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(AddRoleFeederTableRow));
DisplayFactory.register("AddRoleFeederTableRow", withStyles(styles, { withTheme: true })(withSnackbar(AddRoleFeederTableRow)));