import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiDisplayStamp from "alexandria-ui-elements/src/displays/components/DisplayStamp";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiAction from "alexandria-ui-elements/src/displays/components/Action";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import TaskPlaceEditionTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import TaskPlaceEditionTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskPlaceEditionTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskPlaceEditionTemplateNotifier(this);
		this.requester = new TaskPlaceEditionTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock layout="vertical flexible" width="100.0%" height="100.0%" style={{...this.props.style,...display}}>
				<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1202811126" format="h5" mode="normal">
				</UiText>
				<UiDisplayStamp context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1339694111">
				</UiDisplayStamp>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1212233338" visible={false} layout="vertical">
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1021289757" mode="normal" translate={true} value="No form defined">
					</UiText>
				</UiBlock>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a547141401" format="airTop" visible={false} layout="vertical">
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_3018984" mode="normal">
					</UiText>
				</UiBlock>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1729301907" layout="vertical" width="110px" height="-1px">
					<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1376469158" title="Continue" target="self" mode="Button" size="Small" highlighted="Outline">
					</UiAction>
				</UiBlock>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceEditionTemplate));
DisplayFactory.register("TaskPlaceEditionTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceEditionTemplate)));