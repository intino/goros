import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiAction from "alexandria-ui-elements/src/displays/components/Action";
import UiItem from "alexandria-ui-elements/src/displays/components/Item";
import LinksOutTableLabelItemNotifier from "alexandria-ui-elements/gen/displays/notifiers/ItemNotifier";
import LinksOutTableLabelItemRequester from "alexandria-ui-elements/gen/displays/requesters/ItemRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class LinksOutTableLabelItem extends UiItem {

	constructor(props) {
		super(props);
		this.notifier = new LinksOutTableLabelItemNotifier(this);
		this.requester = new LinksOutTableLabelItemRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<div style={{width:"100%",height:"100%",...this.props.style,...this.style(),...display}} className={className}>
				<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1768327293" title="Loading..." target="self" mode="Link" size="Medium">
				</UiAction>
			</div>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(LinksOutTableLabelItem));
DisplayFactory.register("LinksOutTableLabelItem", withStyles(styles, { withTheme: true })(withSnackbar(LinksOutTableLabelItem)));