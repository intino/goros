import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiItem from "alexandria-ui-elements/src/displays/components/Item";
import TrashTableTypeItemNotifier from "alexandria-ui-elements/gen/displays/notifiers/ItemNotifier";
import TrashTableTypeItemRequester from "alexandria-ui-elements/gen/displays/requesters/ItemRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TrashTableTypeItem extends UiItem {

	constructor(props) {
		super(props);
		this.notifier = new TrashTableTypeItemNotifier(this);
		this.requester = new TrashTableTypeItemRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<div style={{width:"100%",height:"100%",...this.props.style,...this.style(),...display}} className={className}>
				<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_713970543" mode="normal" translate={true} value="Loading...">
				</UiText>
			</div>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TrashTableTypeItem));
DisplayFactory.register("TrashTableTypeItem", withStyles(styles, { withTheme: true })(withSnackbar(TrashTableTypeItem)));