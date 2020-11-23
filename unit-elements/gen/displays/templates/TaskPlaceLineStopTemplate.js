import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiAction from "alexandria-ui-elements/src/displays/components/Action";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import TaskPlaceLineStopTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import TaskPlaceLineStopTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskPlaceLineStopTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskPlaceLineStopTemplateNotifier(this);
		this.requester = new TaskPlaceLineStopTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock layout="vertical" style={{...this.props.style,...display}}>
				<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1603241080" title="" target="self" mode="Link" size="Medium" format="middleAirTop middleAirBottom doubleAirLeft">
				</UiAction>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceLineStopTemplate));
DisplayFactory.register("TaskPlaceLineStopTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceLineStopTemplate)));