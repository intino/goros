import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiTemplateStamp from "alexandria-ui-elements/src/displays/components/TemplateStamp";
import UiDisplayStamp from "alexandria-ui-elements/src/displays/components/DisplayStamp";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiBlockConditional from "alexandria-ui-elements/src/displays/components/BlockConditional";
import UiSpinner from "alexandria-ui-elements/src/displays/components/Spinner";
import UiAction from "alexandria-ui-elements/src/displays/components/Action";
import UiMultiple from "alexandria-ui-elements/src/displays/components/Multiple";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiDate from "alexandria-ui-elements/src/displays/components/Date";
import DisplaysTaskPlaceRoleTemplate from "unit-elements/gen/displays/templates/TaskPlaceRoleTemplate";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import TaskPlaceDelegationTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import TaskPlaceDelegationTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskPlaceDelegationTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskPlaceDelegationTemplateNotifier(this);
		this.requester = new TaskPlaceDelegationTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock layout="vertical flexible" width="100.0%" height="100.0%" style={{...this.props.style,...display}}>
				<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a711828058" format="h5" mode="normal">
				</UiText>
				<UiBlockConditional context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_606612104" format="doubleAirTop" layout="vertical">
					<UiSpinner context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_970468134" mode="Bar">
					</UiSpinner>
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_171701608" mode="normal" translate={true} value="Sending to selected provider...">
					</UiText>
				</UiBlockConditional>
				<UiBlockConditional context={this._context.bind(this)} owner={this._owner.bind(this)} id="a33559490" layout="vertical">
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1944681331" format="grey" mode="normal">
					</UiText>
					<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1397135958" title="Ver roles" target="self" mode="Link" size="Medium">
					</UiAction>
					<UiMultiple context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1467329536" multiple={{instances:"roles",arrangement:"Vertical",noItemsMessage:"",spacing:0,editable:false,wrap:true,count:{min:0,max:-1}}}>
					</UiMultiple>
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1089885357" format="doubleAirTop" layout="vertical">
						<UiDisplayStamp context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1511667774">
						</UiDisplayStamp>
						<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1546622832" format="airTop" layout="vertical" width="110px" height="-1px">
							<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_2029198195" title="Continue" target="self" mode="Button" size="Small" highlighted="Outline">
							</UiAction>
						</UiBlock>
					</UiBlock>
				</UiBlockConditional>
				<UiBlockConditional context={this._context.bind(this)} owner={this._owner.bind(this)} id="a991988277" layout="vertical">
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_369507359" layout="horizontal">
						<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1921835005" format="middleAirRight" mode="normal" translate={true} value="Trying to send order. Last sent request was at">
						</UiText>
						<UiDate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1532897477" pattern="DD/MM/YYYY HH:mm:ss">
						</UiDate>
					</UiBlock>
				</UiBlockConditional>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceDelegationTemplate));
DisplayFactory.register("TaskPlaceDelegationTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceDelegationTemplate)));