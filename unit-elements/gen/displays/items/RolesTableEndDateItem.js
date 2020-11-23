import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiDate from "alexandria-ui-elements/src/displays/components/Date";
import UiItem from "alexandria-ui-elements/src/displays/components/Item";
import RolesTableEndDateItemNotifier from "alexandria-ui-elements/gen/displays/notifiers/ItemNotifier";
import RolesTableEndDateItemRequester from "alexandria-ui-elements/gen/displays/requesters/ItemRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class RolesTableEndDateItem extends UiItem {

	constructor(props) {
		super(props);
		this.notifier = new RolesTableEndDateItemNotifier(this);
		this.requester = new RolesTableEndDateItemRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<div style={{width:"100%",height:"100%",...this.props.style,...this.style(),...display}} className={className}>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1790548920" layout="horizontal centerjustified">
					<UiDate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_53864089" pattern="DD/MM/YYYY HH:mm">
					</UiDate>
				</UiBlock>
			</div>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(RolesTableEndDateItem));
DisplayFactory.register("RolesTableEndDateItem", withStyles(styles, { withTheme: true })(withSnackbar(RolesTableEndDateItem)));