import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiTemplateStamp from "alexandria-ui-elements/src/displays/components/TemplateStamp";
import UiAction from "alexandria-ui-elements/src/displays/components/Action";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import DisplaysComboFilterTemplate from "unit-elements/gen/displays/templates/ComboFilterTemplate";
import DisplaysCheckFilterTemplate from "unit-elements/gen/displays/templates/CheckFilterTemplate";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import RolesFiltersTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import RolesFiltersTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class RolesFiltersTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new RolesFiltersTemplateNotifier(this);
		this.requester = new RolesFiltersTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock format="fullWidth spaced" layout="vertical" style={{...this.props.style,...display}}>
				<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_782801145" title="Resetear filtros" target="self" mode="Link" size="Medium" format="doubleAirBottom">
				</UiAction>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_270513103" format="doubleAirBottom" layout="vertical">
					<DisplaysComboFilterTemplate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1100952305">
					</DisplaysComboFilterTemplate>
				</UiBlock>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a313729465" format="doubleAirBottom" layout="vertical">
					<DisplaysComboFilterTemplate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1217673161">
					</DisplaysComboFilterTemplate>
				</UiBlock>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1288173502" format="doubleAirBottom" layout="vertical">
					<DisplaysComboFilterTemplate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1951849347">
					</DisplaysComboFilterTemplate>
				</UiBlock>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1432041590" format="doubleAirBottom" layout="vertical">
					<DisplaysCheckFilterTemplate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_162343286">
					</DisplaysCheckFilterTemplate>
				</UiBlock>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(RolesFiltersTemplate));
DisplayFactory.register("RolesFiltersTemplate", withStyles(styles, { withTheme: true })(withSnackbar(RolesFiltersTemplate)));