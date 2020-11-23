import React from "react";
import { withStyles } from '@material-ui/core/styles';
import DisplaysLinksInTableLabelItem from "unit-elements/gen/displays/items/LinksInTableLabelItem";
import DisplaysLinksInTableDescriptionItem from "unit-elements/gen/displays/items/LinksInTableDescriptionItem";
import UiRow from "alexandria-ui-elements/src/displays/components/Row";
import LinksInTableRowNotifier from "alexandria-ui-elements/gen/displays/notifiers/RowNotifier";
import LinksInTableRowRequester from "alexandria-ui-elements/gen/displays/requesters/RowRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class LinksInTableRow extends UiRow {

	constructor(props) {
		super(props);
		this.notifier = new LinksInTableRowNotifier(this);
		this.requester = new LinksInTableRowRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return this.renderRow(
			<React.Fragment>
				<DisplaysLinksInTableLabelItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1456117662" style={{width:"40%",paddingRight:"10px",paddingLeft:"10px"}} hidden="Never"></DisplaysLinksInTableLabelItem>
				<DisplaysLinksInTableDescriptionItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_2069332951" style={{width:"60%",paddingRight:"10px"}} hidden="Never"></DisplaysLinksInTableDescriptionItem>
			</React.Fragment>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(LinksInTableRow));
DisplayFactory.register("LinksInTableRow", withStyles(styles, { withTheme: true })(withSnackbar(LinksInTableRow)));