import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiItem from "alexandria-ui-elements/src/displays/components/Item";
import TasksTableLabelItemNotifier from "alexandria-ui-elements/gen/displays/notifiers/ItemNotifier";
import TasksTableLabelItemRequester from "alexandria-ui-elements/gen/displays/requesters/ItemRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TasksTableLabelItem extends UiItem {

	constructor(props) {
		super(props);
		this.notifier = new TasksTableLabelItemNotifier(this);
		this.requester = new TasksTableLabelItemRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<div style={{width:"100%",height:"100%",...this.props.style,...this.style(),...display}} className={className}>
				<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_954405918" mode="normal" value="Loading...">
				</UiText>
				<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_947375745" format="body2 pillStyle" mode="normal" highlighted={{text:"white",background:"#33942F"}}>
				</UiText>
			</div>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TasksTableLabelItem));
DisplayFactory.register("TasksTableLabelItem", withStyles(styles, { withTheme: true })(withSnackbar(TasksTableLabelItem)));