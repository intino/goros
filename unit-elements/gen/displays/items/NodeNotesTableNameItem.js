import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiItem from "alexandria-ui-elements/src/displays/components/Item";
import NodeNotesTableNameItemNotifier from "alexandria-ui-elements/gen/displays/notifiers/ItemNotifier";
import NodeNotesTableNameItemRequester from "alexandria-ui-elements/gen/displays/requesters/ItemRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class NodeNotesTableNameItem extends UiItem {

	constructor(props) {
		super(props);
		this.notifier = new NodeNotesTableNameItemNotifier(this);
		this.requester = new NodeNotesTableNameItemRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<div style={{width:"100%",height:"100%",...this.props.style,...this.style(),...display}} className={className}>
				<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1486403034" mode="normal">
				</UiText>
			</div>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(NodeNotesTableNameItem));
DisplayFactory.register("NodeNotesTableNameItem", withStyles(styles, { withTheme: true })(withSnackbar(NodeNotesTableNameItem)));