import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiAction from "alexandria-ui-elements/src/displays/components/Action";
import UiSelectPreviousItem from "alexandria-ui-elements/src/displays/components/SelectPreviousItem";
import UiSelectNextItem from "alexandria-ui-elements/src/displays/components/SelectNextItem";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiDate from "alexandria-ui-elements/src/displays/components/Date";
import UiDateEditable from "alexandria-ui-elements/src/displays/components/DateEditable";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import RoleEmbeddedTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import RoleEmbeddedTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class RoleEmbeddedTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new RoleEmbeddedTemplateNotifier(this);
		this.requester = new RoleEmbeddedTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock layout="vertical" style={{...this.props.style,...display}}>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1784351532" format="bottomBordered bottomSpaced leftSpaced middleTopSpaced" layout="horizontal">
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_502556931" layout="horizontal flexible">
						<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a677416160" title="Editar" target="self" mode="Button" size="Small" format="airRight" highlighted="Outline">
						</UiAction>
						<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1464610852" title="Revocar" target="self" mode="Button" affirmed="Are you sure to revoke role?" size="Small" highlighted="Outline">
						</UiAction>
					</UiBlock>
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1125247581" layout="horizontal endjustified">
						<UiSelectPreviousItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_957022283" title="Anterior" target="self" mode="MaterialIconButton" icon="KeyboardArrowLeft" size="Small" format="airRight">
						</UiSelectPreviousItem>
						<UiSelectNextItem context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_444539215" title="Siguiente" target="self" mode="MaterialIconButton" icon="KeyboardArrowRight" size="Small" format="airRight">
						</UiSelectNextItem>
					</UiBlock>
				</UiBlock>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_404051167" format="spaced" layout="vertical flexible" width="100.0%" height="100.0%">
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1700811042" layout="horizontal center">
						<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_320200732" format="airRight" mode="normal">
						</UiText>
						<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1338109032" format="body2 pillStyle" mode="normal" highlighted={{text:"white",background:"transparent"}}>
						</UiText>
					</UiBlock>
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a433948556" format="grey" mode="normal">
					</UiText>
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a280478185" format="doubleAirBottom doubleAirTop" layout="vertical">
						<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a455729971" label="Class" mode="normal">
						</UiText>
						<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a300360986" label="Type" mode="normal">
						</UiText>
						<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a690297479" label="Nature" mode="normal">
						</UiText>
						<UiDate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1112523440" label="Start date" pattern="DD/MM/YYYY HH:mm">
						</UiDate>
					</UiBlock>
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1021699601" layout="vertical" width="300px" height="-1px">
						<UiDateEditable context={this._context.bind(this)} owner={this._owner.bind(this)} id="a487891726" label="End date" pattern="DD/MM/YYYY" allowEmpty={true}>
						</UiDateEditable>
					</UiBlock>
				</UiBlock>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(RoleEmbeddedTemplate));
DisplayFactory.register("RoleEmbeddedTemplate", withStyles(styles, { withTheme: true })(withSnackbar(RoleEmbeddedTemplate)));