import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiAction from "alexandria-ui-elements/src/displays/components/Action";
import UiItem from "alexandria-ui-elements/src/displays/components/Item";
import NodeRevisionsTableOperationsItemNotifier from "alexandria-ui-elements/gen/displays/notifiers/ItemNotifier";
import NodeRevisionsTableOperationsItemRequester from "alexandria-ui-elements/gen/displays/requesters/ItemRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class NodeRevisionsTableOperationsItem extends UiItem {

	constructor(props) {
		super(props);
		this.notifier = new NodeRevisionsTableOperationsItemNotifier(this);
		this.requester = new NodeRevisionsTableOperationsItemRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<div style={{width:"100%",height:"100%",...this.props.style,...this.style(),...display}} className={className}>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a584140661" layout="horizontal endjustified">
					<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a111404379" title="Restaurar" target="self" mode="MaterialIconButton" icon="Restore" affirmed="¿Está seguro que quiere restaurar esta revisión?" size="Medium">
					</UiAction>
				</UiBlock>
			</div>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(NodeRevisionsTableOperationsItem));
DisplayFactory.register("NodeRevisionsTableOperationsItem", withStyles(styles, { withTheme: true })(withSnackbar(NodeRevisionsTableOperationsItem)));