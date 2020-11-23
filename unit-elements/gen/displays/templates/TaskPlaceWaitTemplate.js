import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiAction from "alexandria-ui-elements/src/displays/components/Action";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import TaskPlaceWaitTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import TaskPlaceWaitTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskPlaceWaitTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskPlaceWaitTemplateNotifier(this);
		this.requester = new TaskPlaceWaitTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock layout="vertical flexible" width="100.0%" height="100.0%" style={{...this.props.style,...display}}>
				<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1057690151" format="h5" mode="normal">
				</UiText>
				<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_205216529" format="grey airBottom" mode="normal">
				</UiText>
				<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1877038731" title="pospone one hour" target="self" mode="Link" size="Medium" format="middleAirTop middleAirBottom">
				</UiAction>
				<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1879117291" title="pospone one day" target="self" mode="Link" size="Medium" format="middleAirTop middleAirBottom">
				</UiAction>
				<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1936730439" title="pospone one month" target="self" mode="Link" size="Medium" format="middleAirTop middleAirBottom">
				</UiAction>
				<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1877534948" title="pospone one year" target="self" mode="Link" size="Medium" format="middleAirTop middleAirBottom">
				</UiAction>
				<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_888424530" title="don't pospone" target="self" mode="Link" size="Medium" format="middleAirTop middleAirBottom">
				</UiAction>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceWaitTemplate));
DisplayFactory.register("TaskPlaceWaitTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceWaitTemplate)));