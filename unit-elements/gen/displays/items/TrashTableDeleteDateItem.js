import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiDate from "alexandria-ui-elements/src/displays/components/Date";
import UiItem from "alexandria-ui-elements/src/displays/components/Item";
import TrashTableDeleteDateItemNotifier from "alexandria-ui-elements/gen/displays/notifiers/ItemNotifier";
import TrashTableDeleteDateItemRequester from "alexandria-ui-elements/gen/displays/requesters/ItemRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TrashTableDeleteDateItem extends UiItem {

	constructor(props) {
		super(props);
		this.notifier = new TrashTableDeleteDateItemNotifier(this);
		this.requester = new TrashTableDeleteDateItemRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<div style={{width:"100%",height:"100%",...this.props.style,...this.style(),...display}} className={className}>
				<UiDate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_983003849" pattern="DD/MM/YYYY HH:mm:ss">
				</UiDate>
			</div>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TrashTableDeleteDateItem));
DisplayFactory.register("TrashTableDeleteDateItem", withStyles(styles, { withTheme: true })(withSnackbar(TrashTableDeleteDateItem)));