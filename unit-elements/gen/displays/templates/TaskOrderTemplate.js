import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiDateEditable from "alexandria-ui-elements/src/displays/components/DateEditable";
import UiTextEditable from "alexandria-ui-elements/src/displays/components/TextEditable";
import UiActionSwitch from "alexandria-ui-elements/src/displays/components/ActionSwitch";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import TaskOrderTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import TaskOrderTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskOrderTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskOrderTemplateNotifier(this);
		this.requester = new TaskOrderTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock layout="vertical" style={{...this.props.style,...display}}>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1680272292" format="doubleAirBottom" layout="horizontal flexible">
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1918787818" layout="vertical" width="50.0%" height="100.0%">
						<UiDateEditable context={this._context.bind(this)} owner={this._owner.bind(this)} id="a17718905" label="Suggested start date" format="airRight" pattern="DD/MM/YYYY">
						</UiDateEditable>
					</UiBlock>
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a2122657784" layout="vertical" width="50.0%" height="100.0%">
						<UiDateEditable context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_338341103" label="Suggested end date" pattern="DD/MM/YYYY">
						</UiDateEditable>
					</UiBlock>
				</UiBlock>
				<UiTextEditable context={this._context.bind(this)} owner={this._owner.bind(this)} id="a2122260975" label="Comments" format="airBottom" mode="normal" editionMode="Raw" rows={5} placeholder="">
				</UiTextEditable>
				<UiActionSwitch context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1410606596" title="Urgent" target="self" mode="Link" size="Medium">
				</UiActionSwitch>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskOrderTemplate));
DisplayFactory.register("TaskOrderTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskOrderTemplate)));