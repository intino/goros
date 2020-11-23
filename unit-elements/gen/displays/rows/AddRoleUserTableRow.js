import React from "react";
import { withStyles } from '@material-ui/core/styles';
import DisplaysAddRoleUserTableFullnameItem from "unit-elements/gen/displays/items/AddRoleUserTableFullnameItem";
import DisplaysAddRoleUserTableEmailItem from "unit-elements/gen/displays/items/AddRoleUserTableEmailItem";
import UiRow from "alexandria-ui-elements/src/displays/components/Row";
import AddRoleUserTableRowNotifier from "alexandria-ui-elements/gen/displays/notifiers/RowNotifier";
import AddRoleUserTableRowRequester from "alexandria-ui-elements/gen/displays/requesters/RowRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class AddRoleUserTableRow extends UiRow {

	constructor(props) {
		super(props);
		this.notifier = new AddRoleUserTableRowNotifier(this);
		this.requester = new AddRoleUserTableRowRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return this.renderRow(
			<React.Fragment>
				<DisplaysAddRoleUserTableFullnameItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1079009762" style={{width:"40%",paddingRight:"10px",paddingLeft:"10px"}} hidden="Never"></DisplaysAddRoleUserTableFullnameItem>
				<DisplaysAddRoleUserTableEmailItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1375987805" style={{width:"60%",paddingRight:"10px"}} hidden="Never"></DisplaysAddRoleUserTableEmailItem>
			</React.Fragment>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(AddRoleUserTableRow));
DisplayFactory.register("AddRoleUserTableRow", withStyles(styles, { withTheme: true })(withSnackbar(AddRoleUserTableRow)));