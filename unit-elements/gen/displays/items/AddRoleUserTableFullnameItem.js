import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiItem from "alexandria-ui-elements/src/displays/components/Item";
import AddRoleUserTableFullnameItemNotifier from "alexandria-ui-elements/gen/displays/notifiers/ItemNotifier";
import AddRoleUserTableFullnameItemRequester from "alexandria-ui-elements/gen/displays/requesters/ItemRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class AddRoleUserTableFullnameItem extends UiItem {

	constructor(props) {
		super(props);
		this.notifier = new AddRoleUserTableFullnameItemNotifier(this);
		this.requester = new AddRoleUserTableFullnameItemRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<div style={{width:"100%",height:"100%",...this.props.style,...this.style(),...display}} className={className}>
				<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_350552201" mode="normal" value="Loading...">
				</UiText>
			</div>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(AddRoleUserTableFullnameItem));
DisplayFactory.register("AddRoleUserTableFullnameItem", withStyles(styles, { withTheme: true })(withSnackbar(AddRoleUserTableFullnameItem)));