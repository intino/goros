import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiAction from "alexandria-ui-elements/src/displays/components/Action";
import UiItem from "alexandria-ui-elements/src/displays/components/Item";
import TrashTableOperationsItemNotifier from "alexandria-ui-elements/gen/displays/notifiers/ItemNotifier";
import TrashTableOperationsItemRequester from "alexandria-ui-elements/gen/displays/requesters/ItemRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TrashTableOperationsItem extends UiItem {

	constructor(props) {
		super(props);
		this.notifier = new TrashTableOperationsItemNotifier(this);
		this.requester = new TrashTableOperationsItemRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<div style={{width:"100%",height:"100%",...this.props.style,...this.style(),...display}} className={className}>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a476650536" layout="horizontal endjustified">
					<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a2091042572" title="Restore" target="self" mode="MaterialIconButton" icon="RestoreFromTrash" affirmed="Are you sure you want to restore element from trash?" size="Small">
					</UiAction>
				</UiBlock>
			</div>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TrashTableOperationsItem));
DisplayFactory.register("TrashTableOperationsItem", withStyles(styles, { withTheme: true })(withSnackbar(TrashTableOperationsItem)));