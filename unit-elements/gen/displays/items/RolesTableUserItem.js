import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiItem from "alexandria-ui-elements/src/displays/components/Item";
import RolesTableUserItemNotifier from "alexandria-ui-elements/gen/displays/notifiers/ItemNotifier";
import RolesTableUserItemRequester from "alexandria-ui-elements/gen/displays/requesters/ItemRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class RolesTableUserItem extends UiItem {

	constructor(props) {
		super(props);
		this.notifier = new RolesTableUserItemNotifier(this);
		this.requester = new RolesTableUserItemRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<div style={{width:"100%",height:"100%",...this.props.style,...this.style(),...display}} className={className}>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_502491952" layout="horizontal center">
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_651961985" layout="flexible">
						<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1780199828" format="airRight" mode="normal" translate={true} value="Loading...">
						</UiText>
					</UiBlock>
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a581941854" layout="endjustified">
						<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_462733274" format="body2 pillStyle" mode="normal" highlighted={{text:"white",background:"transparent"}}>
						</UiText>
					</UiBlock>
				</UiBlock>
			</div>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(RolesTableUserItem));
DisplayFactory.register("RolesTableUserItem", withStyles(styles, { withTheme: true })(withSnackbar(RolesTableUserItem)));