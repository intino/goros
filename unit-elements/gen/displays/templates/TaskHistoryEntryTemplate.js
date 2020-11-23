import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiDate from "alexandria-ui-elements/src/displays/components/Date";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiMultiple from "alexandria-ui-elements/src/displays/components/Multiple";
import UiAction from "alexandria-ui-elements/src/displays/components/Action";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import TaskHistoryEntryTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import TaskHistoryEntryTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskHistoryEntryTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskHistoryEntryTemplateNotifier(this);
		this.requester = new TaskHistoryEntryTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock format="middleTopSpaced middleBottomSpaced topLightDottedBordered" layout="vertical flexible" width="100.0%" height="100.0%" style={{...this.props.style,...display}}>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a360308932" layout="horizontal">
					<UiDate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1442549793" format="body2 grey middleAirRight" pattern="DD/MM/YYYY HH:mm:ss">
					</UiDate>
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a916674940" format="body2 grey" mode="normal">
					</UiText>
				</UiBlock>
				<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1405051979" format="middleAirRight" mode="normal">
				</UiText>
				<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a657357211" format="grey" mode="normal">
				</UiText>
				<UiMultiple context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_2063251177" multiple={{instances:"linksBlock",arrangement:"Vertical",noItemsMessage:"",spacing:0,editable:false,wrap:true,count:{min:0,max:-1}}} layout="vertical">
					<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1802684894" title="" target="self" mode="Link" size="Medium">
					</UiAction>
				</UiMultiple>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskHistoryEntryTemplate));
DisplayFactory.register("TaskHistoryEntryTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskHistoryEntryTemplate)));