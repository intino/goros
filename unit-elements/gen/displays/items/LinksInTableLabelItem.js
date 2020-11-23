import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiAction from "alexandria-ui-elements/src/displays/components/Action";
import UiItem from "alexandria-ui-elements/src/displays/components/Item";
import LinksInTableLabelItemNotifier from "alexandria-ui-elements/gen/displays/notifiers/ItemNotifier";
import LinksInTableLabelItemRequester from "alexandria-ui-elements/gen/displays/requesters/ItemRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class LinksInTableLabelItem extends UiItem {

	constructor(props) {
		super(props);
		this.notifier = new LinksInTableLabelItemNotifier(this);
		this.requester = new LinksInTableLabelItemRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<div style={{width:"100%",height:"100%",...this.props.style,...this.style(),...display}} className={className}>
				<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1299068141" title="Cargando..." target="self" mode="Link" size="Medium">
				</UiAction>
			</div>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(LinksInTableLabelItem));
DisplayFactory.register("LinksInTableLabelItem", withStyles(styles, { withTheme: true })(withSnackbar(LinksInTableLabelItem)));