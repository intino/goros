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
import DisplaysTaskPlaceRoleTemplate from "unit-elements/gen/displays/templates/TaskPlaceRoleTemplate";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import TaskPlaceSendJobTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import TaskPlaceSendJobTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskPlaceSendJobTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskPlaceSendJobTemplateNotifier(this);
		this.requester = new TaskPlaceSendJobTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock layout="vertical flexible" width="100.0%" height="100.0%" style={{...this.props.style,...display}}>
				<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a279493665" format="h5" mode="normal">
				</UiText>
				<UiBlockConditional context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_2070659585" format="doubleAirTop" layout="vertical">
					<UiSpinner context={this._context.bind(this)} owner={this._owner.bind(this)} id="a315135007" mode="Bar">
					</UiSpinner>
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_181156070" mode="normal" translate={true} value="Sending to selected worker...">
					</UiText>
				</UiBlockConditional>
				<UiBlockConditional context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1430487991" layout="vertical">
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a166272294" format="grey" mode="normal">
					</UiText>
					<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1371847139" title="Ver roles" target="self" mode="Link" size="Medium">
					</UiAction>
					<UiMultiple context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_257076409" multiple={{instances:"roles",arrangement:"Vertical",noItemsMessage:"",spacing:0,editable:false,wrap:true,count:{min:0,max:-1}}}>
					</UiMultiple>
					<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1420204205" title="Unassigned" target="self" mode="Link" size="Medium" format="middleAirTop middleAirBottom doubleAirLeft">
					</UiAction>
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1150755270" format="doubleAirTop" layout="vertical">
						<UiDisplayStamp context={this._context.bind(this)} owner={this._owner.bind(this)} id="a537657609">
						</UiDisplayStamp>
						<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a760048663" format="airTop" layout="vertical" width="110px" height="-1px">
							<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1091450534" title="Continue" target="self" mode="Button" size="Small" highlighted="Outline">
							</UiAction>
						</UiBlock>
					</UiBlock>
				</UiBlockConditional>
				<UiBlockConditional context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_472059204" layout="vertical">
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1733111054" layout="horizontal">
						<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_933099258" format="middleAirRight" mode="normal" translate={true} value="Send order failure">
						</UiText>
					</UiBlock>
				</UiBlockConditional>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceSendJobTemplate));
DisplayFactory.register("TaskPlaceSendJobTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceSendJobTemplate)));