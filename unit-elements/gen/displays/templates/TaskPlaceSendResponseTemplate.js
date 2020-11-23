import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiBlockConditional from "alexandria-ui-elements/src/displays/components/BlockConditional";
import UiSpinner from "alexandria-ui-elements/src/displays/components/Spinner";
import UiAction from "alexandria-ui-elements/src/displays/components/Action";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import TaskPlaceSendResponseTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import TaskPlaceSendResponseTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskPlaceSendResponseTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskPlaceSendResponseTemplateNotifier(this);
		this.requester = new TaskPlaceSendResponseTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock layout="vertical flexible" width="100.0%" height="100.0%" style={{...this.props.style,...display}}>
				<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_789097829" format="h5" mode="normal" value="SendResponse">
				</UiText>
				<UiBlockConditional context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1403578246" format="doubleAirTop" layout="vertical">
					<UiSpinner context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_16325534" mode="Bar">
					</UiSpinner>
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1886556570" format="grey" mode="normal" translate={true} value="Sending response. Please, wait...">
					</UiText>
				</UiBlockConditional>
				<UiBlockConditional context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_837073482" layout="vertical">
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1033025578" mode="normal" translate={true} value="There was an attempt to send a response that failed">
					</UiText>
					<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_535549217" title="Retry" target="self" mode="Link" size="Medium">
					</UiAction>
				</UiBlockConditional>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceSendResponseTemplate));
DisplayFactory.register("TaskPlaceSendResponseTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceSendResponseTemplate)));