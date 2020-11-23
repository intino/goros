import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiDate from "alexandria-ui-elements/src/displays/components/Date";
import UiItem from "alexandria-ui-elements/src/displays/components/Item";
import RolesTableStartDateItemNotifier from "alexandria-ui-elements/gen/displays/notifiers/ItemNotifier";
import RolesTableStartDateItemRequester from "alexandria-ui-elements/gen/displays/requesters/ItemRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class RolesTableStartDateItem extends UiItem {

	constructor(props) {
		super(props);
		this.notifier = new RolesTableStartDateItemNotifier(this);
		this.requester = new RolesTableStartDateItemRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<div style={{width:"100%",height:"100%",...this.props.style,...this.style(),...display}} className={className}>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1553111070" layout="horizontal centerjustified">
					<UiDate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1298093421" pattern="DD/MM/YYYY HH:mm">
					</UiDate>
				</UiBlock>
			</div>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(RolesTableStartDateItem));
DisplayFactory.register("RolesTableStartDateItem", withStyles(styles, { withTheme: true })(withSnackbar(RolesTableStartDateItem)));