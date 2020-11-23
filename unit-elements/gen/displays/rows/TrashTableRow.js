import React from "react";
import { withStyles } from '@material-ui/core/styles';
import DisplaysTrashTableTypeItem from "unit-elements/gen/displays/items/TrashTableTypeItem";
import DisplaysTrashTableLabelItem from "unit-elements/gen/displays/items/TrashTableLabelItem";
import DisplaysTrashTableDeleteDateItem from "unit-elements/gen/displays/items/TrashTableDeleteDateItem";
import DisplaysTrashTableOperationsItem from "unit-elements/gen/displays/items/TrashTableOperationsItem";
import UiRow from "alexandria-ui-elements/src/displays/components/Row";
import TrashTableRowNotifier from "alexandria-ui-elements/gen/displays/notifiers/RowNotifier";
import TrashTableRowRequester from "alexandria-ui-elements/gen/displays/requesters/RowRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TrashTableRow extends UiRow {

	constructor(props) {
		super(props);
		this.notifier = new TrashTableRowNotifier(this);
		this.requester = new TrashTableRowRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return this.renderRow(
			<React.Fragment>
				<DisplaysTrashTableTypeItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1929334648" style={{width:"30%",paddingRight:"10px",paddingLeft:"10px"}} hidden="Never"></DisplaysTrashTableTypeItem>
				<DisplaysTrashTableLabelItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1347607505" style={{width:"40%",paddingRight:"10px"}} hidden="Never"></DisplaysTrashTableLabelItem>
				<DisplaysTrashTableDeleteDateItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a993587649" style={{width:"20%",paddingRight:"10px"}} hidden="Never"></DisplaysTrashTableDeleteDateItem>
				<DisplaysTrashTableOperationsItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1980355300" style={{width:"10%",paddingRight:"10px"}} hidden="Never"></DisplaysTrashTableOperationsItem>
			</React.Fragment>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TrashTableRow));
DisplayFactory.register("TrashTableRow", withStyles(styles, { withTheme: true })(withSnackbar(TrashTableRow)));