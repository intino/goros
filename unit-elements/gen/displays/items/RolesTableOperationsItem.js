import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiItem from "alexandria-ui-elements/src/displays/components/Item";
import RolesTableOperationsItemNotifier from "alexandria-ui-elements/gen/displays/notifiers/ItemNotifier";
import RolesTableOperationsItemRequester from "alexandria-ui-elements/gen/displays/requesters/ItemRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class RolesTableOperationsItem extends UiItem {

	constructor(props) {
		super(props);
		this.notifier = new RolesTableOperationsItemNotifier(this);
		this.requester = new RolesTableOperationsItemRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<div style={{width:"100%",height:"100%",...this.props.style,...this.style(),...display}} className={className}>
			</div>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(RolesTableOperationsItem));
DisplayFactory.register("RolesTableOperationsItem", withStyles(styles, { withTheme: true })(withSnackbar(RolesTableOperationsItem)));