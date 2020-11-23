import React from "react";
import { withStyles } from '@material-ui/core/styles';
import DisplaysAddRoleServiceTableLabelItem from "unit-elements/gen/displays/items/AddRoleServiceTableLabelItem";
import DisplaysAddRoleServiceTablePartnerItem from "unit-elements/gen/displays/items/AddRoleServiceTablePartnerItem";
import UiRow from "alexandria-ui-elements/src/displays/components/Row";
import AddRoleServiceTableRowNotifier from "alexandria-ui-elements/gen/displays/notifiers/RowNotifier";
import AddRoleServiceTableRowRequester from "alexandria-ui-elements/gen/displays/requesters/RowRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class AddRoleServiceTableRow extends UiRow {

	constructor(props) {
		super(props);
		this.notifier = new AddRoleServiceTableRowNotifier(this);
		this.requester = new AddRoleServiceTableRowRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return this.renderRow(
			<React.Fragment>
				<DisplaysAddRoleServiceTableLabelItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_737144416" style={{width:"40%",paddingRight:"10px",paddingLeft:"10px"}} hidden="Never"></DisplaysAddRoleServiceTableLabelItem>
				<DisplaysAddRoleServiceTablePartnerItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a254293905" style={{width:"60%",paddingRight:"10px"}} hidden="Never"></DisplaysAddRoleServiceTablePartnerItem>
			</React.Fragment>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(AddRoleServiceTableRow));
DisplayFactory.register("AddRoleServiceTableRow", withStyles(styles, { withTheme: true })(withSnackbar(AddRoleServiceTableRow)));