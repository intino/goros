import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiTemplateStamp from "alexandria-ui-elements/src/displays/components/TemplateStamp";
import UiAction from "alexandria-ui-elements/src/displays/components/Action";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import DisplaysComboFilterTemplate from "unit-elements/gen/displays/templates/ComboFilterTemplate";
import DisplaysCheckFilterTemplate from "unit-elements/gen/displays/templates/CheckFilterTemplate";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import TasksFiltersTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import TasksFiltersTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TasksFiltersTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TasksFiltersTemplateNotifier(this);
		this.requester = new TasksFiltersTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock format="fullWidth spaced" layout="vertical" style={{...this.props.style,...display}}>
				<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a999970518" title="Resetear filtros" target="self" mode="Link" size="Medium" format="doubleAirBottom">
				</UiAction>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1053781370" format="doubleAirBottom" layout="vertical">
					<DisplaysComboFilterTemplate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a284156686">
					</DisplaysComboFilterTemplate>
				</UiBlock>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1123053130" format="doubleAirBottom" layout="vertical">
					<DisplaysComboFilterTemplate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a304002150">
					</DisplaysComboFilterTemplate>
				</UiBlock>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1237014931" format="doubleAirBottom" layout="vertical">
					<DisplaysCheckFilterTemplate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a323189791">
					</DisplaysCheckFilterTemplate>
				</UiBlock>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TasksFiltersTemplate));
DisplayFactory.register("TasksFiltersTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TasksFiltersTemplate)));