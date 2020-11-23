import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiAction from "alexandria-ui-elements/src/displays/components/Action";
import UiItem from "alexandria-ui-elements/src/displays/components/Item";
import NodeNotesTableOperationsItemNotifier from "alexandria-ui-elements/gen/displays/notifiers/ItemNotifier";
import NodeNotesTableOperationsItemRequester from "alexandria-ui-elements/gen/displays/requesters/ItemRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class NodeNotesTableOperationsItem extends UiItem {

	constructor(props) {
		super(props);
		this.notifier = new NodeNotesTableOperationsItemNotifier(this);
		this.requester = new NodeNotesTableOperationsItemRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<div style={{width:"100%",height:"100%",...this.props.style,...this.style(),...display}} className={className}>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_660615266" layout="horizontal endjustified">
					<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1673783525" title="Eliminar nota" target="self" mode="MaterialIconButton" icon="Clear" affirmed="¿Está seguro que quiere borrar la nota?" size="Small">
					</UiAction>
				</UiBlock>
			</div>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(NodeNotesTableOperationsItem));
DisplayFactory.register("NodeNotesTableOperationsItem", withStyles(styles, { withTheme: true })(withSnackbar(NodeNotesTableOperationsItem)));