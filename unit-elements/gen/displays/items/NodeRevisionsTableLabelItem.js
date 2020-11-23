import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiDate from "alexandria-ui-elements/src/displays/components/Date";
import UiItem from "alexandria-ui-elements/src/displays/components/Item";
import NodeRevisionsTableLabelItemNotifier from "alexandria-ui-elements/gen/displays/notifiers/ItemNotifier";
import NodeRevisionsTableLabelItemRequester from "alexandria-ui-elements/gen/displays/requesters/ItemRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class NodeRevisionsTableLabelItem extends UiItem {

	constructor(props) {
		super(props);
		this.notifier = new NodeRevisionsTableLabelItemNotifier(this);
		this.requester = new NodeRevisionsTableLabelItemRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<div style={{width:"100%",height:"100%",...this.props.style,...this.style(),...display}} className={className}>
				<UiDate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1872916375" pattern="DD/MM/YYYY" mode="fromnow">
				</UiDate>
			</div>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(NodeRevisionsTableLabelItem));
DisplayFactory.register("NodeRevisionsTableLabelItem", withStyles(styles, { withTheme: true })(withSnackbar(NodeRevisionsTableLabelItem)));