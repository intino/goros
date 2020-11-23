import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiTemplateStamp from "alexandria-ui-elements/src/displays/components/TemplateStamp";
import UiAction from "alexandria-ui-elements/src/displays/components/Action";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import DisplaysComboFilterTemplate from "unit-elements/gen/displays/templates/ComboFilterTemplate";
import DisplaysDateRangeFilterTemplate from "unit-elements/gen/displays/templates/DateRangeFilterTemplate";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import TrashTableFiltersNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import TrashTableFiltersRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TrashTableFilters extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TrashTableFiltersNotifier(this);
		this.requester = new TrashTableFiltersRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock format="fullWidth spaced" layout="vertical" style={{...this.props.style,...display}}>
				<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_380214026" title="Reset filters" target="self" mode="Link" size="Medium" format="doubleAirBottom">
				</UiAction>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a2096879843" format="doubleAirBottom" layout="vertical">
					<DisplaysComboFilterTemplate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a809574469">
					</DisplaysComboFilterTemplate>
				</UiBlock>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1439791037" format="doubleAirBottom" layout="vertical">
					<DisplaysDateRangeFilterTemplate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a2030191203">
					</DisplaysDateRangeFilterTemplate>
				</UiBlock>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TrashTableFilters));
DisplayFactory.register("TrashTableFilters", withStyles(styles, { withTheme: true })(withSnackbar(TrashTableFilters)));