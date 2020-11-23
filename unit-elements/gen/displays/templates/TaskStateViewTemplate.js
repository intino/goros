import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiTemplateStamp from "alexandria-ui-elements/src/displays/components/TemplateStamp";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiDate from "alexandria-ui-elements/src/displays/components/Date";
import UiBlockConditional from "alexandria-ui-elements/src/displays/components/BlockConditional";
import DisplaysTaskOrderTemplate from "unit-elements/gen/displays/templates/TaskOrderTemplate";
import DisplaysTaskPlaceDelegationTemplate from "unit-elements/gen/displays/templates/TaskPlaceDelegationTemplate";
import DisplaysTaskPlaceSendJobTemplate from "unit-elements/gen/displays/templates/TaskPlaceSendJobTemplate";
import DisplaysTaskPlaceLineTemplate from "unit-elements/gen/displays/templates/TaskPlaceLineTemplate";
import DisplaysTaskPlaceEditionTemplate from "unit-elements/gen/displays/templates/TaskPlaceEditionTemplate";
import DisplaysTaskPlaceEnrollTemplate from "unit-elements/gen/displays/templates/TaskPlaceEnrollTemplate";
import DisplaysTaskPlaceWaitTemplate from "unit-elements/gen/displays/templates/TaskPlaceWaitTemplate";
import DisplaysTaskPlaceSendRequestTemplate from "unit-elements/gen/displays/templates/TaskPlaceSendRequestTemplate";
import DisplaysTaskPlaceSendResponseTemplate from "unit-elements/gen/displays/templates/TaskPlaceSendResponseTemplate";
import DisplaysTaskHistoryTemplate from "unit-elements/gen/displays/templates/TaskHistoryTemplate";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import TaskStateViewTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import TaskStateViewTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskStateViewTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskStateViewTemplateNotifier(this);
		this.requester = new TaskStateViewTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock layout="vertical flexible" width="100.0%" height="100.0%" style={{...this.props.style,...display}}>
				<DisplaysTaskOrderTemplate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1119020085" visible={false}>
				</DisplaysTaskOrderTemplate>
				<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a322929797" format="grey doubleAirBottom" mode="normal">
				</UiText>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1433101018" format="doubleAirBottom" layout="vertical">
					<UiDate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1005632251" format="body2 grey middleAirRight" pattern="DD/MM/YYYY HH:mm:ss">
					</UiDate>
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1095427558" mode="normal" highlighted={{text:"white",background:"#33942F"}}>
					</UiText>
				</UiBlock>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1791283879" layout="vertical">
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1170147606" mode="normal" translate={true} value="No pending tasks">
					</UiText>
				</UiBlock>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a394641967" layout="vertical">
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1919652454" mode="normal">
					</UiText>
				</UiBlock>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a972666951" layout="vertical">
					<UiBlockConditional context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1806338592" layout="vertical" width="100.0%" height="100.0%">
						<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_977198459" mode="normal" value="Task is finished">
						</UiText>
					</UiBlockConditional>
					<UiBlockConditional context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_2058172699" layout="vertical" width="100.0%" height="100.0%">
						<DisplaysTaskPlaceDelegationTemplate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1313593476">
						</DisplaysTaskPlaceDelegationTemplate>
					</UiBlockConditional>
					<UiBlockConditional context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_721369246" layout="vertical" width="100.0%" height="100.0%">
						<DisplaysTaskPlaceSendJobTemplate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_958266426">
						</DisplaysTaskPlaceSendJobTemplate>
					</UiBlockConditional>
					<UiBlockConditional context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1005380175" layout="vertical" width="100.0%" height="100.0%">
						<DisplaysTaskPlaceLineTemplate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1354284932">
						</DisplaysTaskPlaceLineTemplate>
					</UiBlockConditional>
					<UiBlockConditional context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1115915893" layout="vertical" width="100.0%" height="100.0%">
						<DisplaysTaskPlaceEditionTemplate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1621620684">
						</DisplaysTaskPlaceEditionTemplate>
					</UiBlockConditional>
					<UiBlockConditional context={this._context.bind(this)} owner={this._owner.bind(this)} id="a424114019" layout="vertical" width="100.0%" height="100.0%">
						<DisplaysTaskPlaceEnrollTemplate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1912174276">
						</DisplaysTaskPlaceEnrollTemplate>
					</UiBlockConditional>
					<UiBlockConditional context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1948690766" layout="vertical" width="100.0%" height="100.0%">
						<DisplaysTaskPlaceWaitTemplate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a50029404">
						</DisplaysTaskPlaceWaitTemplate>
					</UiBlockConditional>
					<UiBlockConditional context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_209603276" layout="vertical" width="100.0%" height="100.0%">
						<DisplaysTaskPlaceSendRequestTemplate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_836335582">
						</DisplaysTaskPlaceSendRequestTemplate>
					</UiBlockConditional>
					<UiBlockConditional context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_2058079450" layout="vertical" width="100.0%" height="100.0%">
						<DisplaysTaskPlaceSendResponseTemplate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a738927068">
						</DisplaysTaskPlaceSendResponseTemplate>
					</UiBlockConditional>
				</UiBlock>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a903504054" format="doubleAirTop" layout="vertical">
					<DisplaysTaskHistoryTemplate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1069521374">
					</DisplaysTaskHistoryTemplate>
				</UiBlock>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskStateViewTemplate));
DisplayFactory.register("TaskStateViewTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskStateViewTemplate)));