import React from "react";
import { withStyles } from '@material-ui/core/styles';
import DisplaysLinksOutTableLabelItem from "unit-elements/gen/displays/items/LinksOutTableLabelItem";
import DisplaysLinksOutTableDescriptionItem from "unit-elements/gen/displays/items/LinksOutTableDescriptionItem";
import UiRow from "alexandria-ui-elements/src/displays/components/Row";
import LinksOutTableRowNotifier from "alexandria-ui-elements/gen/displays/notifiers/RowNotifier";
import LinksOutTableRowRequester from "alexandria-ui-elements/gen/displays/requesters/RowRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class LinksOutTableRow extends UiRow {

	constructor(props) {
		super(props);
		this.notifier = new LinksOutTableRowNotifier(this);
		this.requester = new LinksOutTableRowRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return this.renderRow(
			<React.Fragment>
				<DisplaysLinksOutTableLabelItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a95169672" style={{width:"40%",paddingRight:"10px",paddingLeft:"10px"}} hidden="Never"></DisplaysLinksOutTableLabelItem>
				<DisplaysLinksOutTableDescriptionItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1789681555" style={{width:"60%",paddingRight:"10px"}} hidden="Never"></DisplaysLinksOutTableDescriptionItem>
			</React.Fragment>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(LinksOutTableRow));
DisplayFactory.register("LinksOutTableRow", withStyles(styles, { withTheme: true })(withSnackbar(LinksOutTableRow)));