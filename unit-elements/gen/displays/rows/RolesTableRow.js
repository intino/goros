import React from "react";
import { withStyles } from '@material-ui/core/styles';
import DisplaysRolesTableUserItem from "unit-elements/gen/displays/items/RolesTableUserItem";
import DisplaysRolesTableDefinitionItem from "unit-elements/gen/displays/items/RolesTableDefinitionItem";
import DisplaysRolesTableTypeItem from "unit-elements/gen/displays/items/RolesTableTypeItem";
import DisplaysRolesTableNatureItem from "unit-elements/gen/displays/items/RolesTableNatureItem";
import DisplaysRolesTableStartDateItem from "unit-elements/gen/displays/items/RolesTableStartDateItem";
import DisplaysRolesTableEndDateItem from "unit-elements/gen/displays/items/RolesTableEndDateItem";
import DisplaysRolesTableOperationsItem from "unit-elements/gen/displays/items/RolesTableOperationsItem";
import UiRow from "alexandria-ui-elements/src/displays/components/Row";
import RolesTableRowNotifier from "alexandria-ui-elements/gen/displays/notifiers/RowNotifier";
import RolesTableRowRequester from "alexandria-ui-elements/gen/displays/requesters/RowRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class RolesTableRow extends UiRow {

	constructor(props) {
		super(props);
		this.notifier = new RolesTableRowNotifier(this);
		this.requester = new RolesTableRowRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return this.renderRow(
			<React.Fragment>
				<DisplaysRolesTableUserItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1732349193" style={{width:"20%",paddingRight:"10px",paddingLeft:"10px"}} hidden="Never"></DisplaysRolesTableUserItem>
				<DisplaysRolesTableDefinitionItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1064485060" style={{width:"20%",paddingRight:"10px"}} hidden="Never"></DisplaysRolesTableDefinitionItem>
				<DisplaysRolesTableTypeItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1140630920" style={{width:"10%",paddingRight:"10px"}} hidden="Never"></DisplaysRolesTableTypeItem>
				<DisplaysRolesTableNatureItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1102436782" style={{width:"10%",paddingRight:"10px"}} hidden="Never"></DisplaysRolesTableNatureItem>
				<DisplaysRolesTableStartDateItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1586706557" style={{width:"15%",paddingRight:"10px"}} hidden="Never"></DisplaysRolesTableStartDateItem>
				<DisplaysRolesTableEndDateItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1725386241" style={{width:"15%",paddingRight:"10px"}} hidden="Never"></DisplaysRolesTableEndDateItem>
				<DisplaysRolesTableOperationsItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a31029305" style={{width:"10%",paddingRight:"10px"}} hidden="Never"></DisplaysRolesTableOperationsItem>
			</React.Fragment>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(RolesTableRow));
DisplayFactory.register("RolesTableRow", withStyles(styles, { withTheme: true })(withSnackbar(RolesTableRow)));