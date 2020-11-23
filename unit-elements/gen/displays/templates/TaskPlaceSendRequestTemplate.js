import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiBlockConditional from "alexandria-ui-elements/src/displays/components/BlockConditional";
import UiSpinner from "alexandria-ui-elements/src/displays/components/Spinner";
import UiAction from "alexandria-ui-elements/src/displays/components/Action";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import TaskPlaceSendRequestTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import TaskPlaceSendRequestTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskPlaceSendRequestTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskPlaceSendRequestTemplateNotifier(this);
		this.requester = new TaskPlaceSendRequestTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock layout="vertical flexible" width="100.0%" height="100.0%" style={{...this.props.style,...display}}>
				<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1429252339" format="h5" mode="normal">
				</UiText>
				<UiBlockConditional context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1876026402" format="doubleAirTop" layout="vertical">
					<UiSpinner context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1308471444" mode="Bar">
					</UiSpinner>
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1440582557" format="grey" mode="normal" translate={true} value="Sending request. Please, wait...">
					</UiText>
				</UiBlockConditional>
				<UiBlockConditional context={this._context.bind(this)} owner={this._owner.bind(this)} id="a178289166" layout="vertical">
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a92722803" mode="normal" translate={true} value="There was an attempt to send a request that failed">
					</UiText>
					<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_670646985" title="Retry" target="self" mode="Link" size="Medium">
					</UiAction>
				</UiBlockConditional>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceSendRequestTemplate));
DisplayFactory.register("TaskPlaceSendRequestTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceSendRequestTemplate)));