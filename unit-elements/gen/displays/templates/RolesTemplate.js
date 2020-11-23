import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiTemplateStamp from "alexandria-ui-elements/src/displays/components/TemplateStamp";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiSearchBox from "alexandria-ui-elements/src/displays/components/SearchBox";
import UiAction from "alexandria-ui-elements/src/displays/components/Action";
import UiActionToggle from "alexandria-ui-elements/src/displays/components/ActionToggle";
import UiBlockConditional from "alexandria-ui-elements/src/displays/components/BlockConditional";
import DisplaysRolesToolbarTemplate from "unit-elements/gen/displays/templates/RolesToolbarTemplate";
import DisplaysRolesTableCatalog from "unit-elements/gen/displays/templates/RolesTableCatalog";
import DisplaysRolesFiltersTemplate from "unit-elements/gen/displays/templates/RolesFiltersTemplate";
import DisplaysRoleEmbeddedTemplate from "unit-elements/gen/displays/templates/RoleEmbeddedTemplate";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import RolesTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import RolesTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class RolesTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new RolesTemplateNotifier(this);
		this.requester = new RolesTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock format="smallAir" layout="vertical flexible" style={{...this.props.style,...display}}>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a2090485844" format="bordered spaced" layout="horizontal">
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1121117010" layout="vertical flexible">
						<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a382579449" layout="horizontal">
							<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a635808812" format="h4 bold" mode="normal" value="Roles">
							</UiText>
						</UiBlock>
						<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1985240474" format="body2" mode="normal">
						</UiText>
					</UiBlock>
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_2091953206" layout="horizontal center">
						<UiSearchBox context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1517623229" format="airRight smallAirTop">
						</UiSearchBox>
						<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1313781411" title="Download" target="self" mode="MaterialIconButton" icon="Archive" size="Medium" format="airRight black">
						</UiAction>
						<UiActionToggle context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1273771142" title="Filtrar" name="filters" target="self" mode="MaterialIconToggle" icon="FilterList" size="Small" format="airRight">
						</UiActionToggle>
					</UiBlock>
				</UiBlock>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a325249795" format="smallAirTop" layout="horizontal flexible">
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a772894237" format="bordered" layout="vertical flexible">
						<DisplaysRolesToolbarTemplate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a199459193">
						</DisplaysRolesToolbarTemplate>
						<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1003279537" layout="vertical flexible" width="100.0%" height="100.0%">
							<UiBlockConditional context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1171720809" layout="vertical flexible">
								<DisplaysRolesTableCatalog context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_170530682" format="fullHeight">
								</DisplaysRolesTableCatalog>
							</UiBlockConditional>
						</UiBlock>
					</UiBlock>
					<UiBlockConditional context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1703726212" format="smallAirLeft middleSpaced bordered" layout="vertical" width="30.0%" height="100.0%" animation={{mode:"Slide",direction:"Left",duration:"500"}}>
						<DisplaysRolesFiltersTemplate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a661182946" format="fullHeight">
						</DisplaysRolesFiltersTemplate>
					</UiBlockConditional>
					<UiBlockConditional context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1622624385" format="smallAirLeft middleSpaced bordered" layout="vertical" width="40.0%" height="100.0%" animation={{mode:"Slide",direction:"Left",duration:"500"}}>
						<DisplaysRoleEmbeddedTemplate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a958647341">
						</DisplaysRoleEmbeddedTemplate>
					</UiBlockConditional>
				</UiBlock>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(RolesTemplate));
DisplayFactory.register("RolesTemplate", withStyles(styles, { withTheme: true })(withSnackbar(RolesTemplate)));