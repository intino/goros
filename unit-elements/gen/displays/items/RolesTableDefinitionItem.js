import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiItem from "alexandria-ui-elements/src/displays/components/Item";
import RolesTableDefinitionItemNotifier from "alexandria-ui-elements/gen/displays/notifiers/ItemNotifier";
import RolesTableDefinitionItemRequester from "alexandria-ui-elements/gen/displays/requesters/ItemRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class RolesTableDefinitionItem extends UiItem {

	constructor(props) {
		super(props);
		this.notifier = new RolesTableDefinitionItemNotifier(this);
		this.requester = new RolesTableDefinitionItemRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<div style={{width:"100%",height:"100%",...this.props.style,...this.style(),...display}} className={className}>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a287885616" layout="horizontal centerjustified">
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1145196561" mode="normal">
					</UiText>
				</UiBlock>
			</div>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(RolesTableDefinitionItem));
DisplayFactory.register("RolesTableDefinitionItem", withStyles(styles, { withTheme: true })(withSnackbar(RolesTableDefinitionItem)));