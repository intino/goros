import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiTemplateStamp from "alexandria-ui-elements/src/displays/components/TemplateStamp";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiAction from "alexandria-ui-elements/src/displays/components/Action";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import DisplaysSourceLegendTemplate from "unit-elements/gen/displays/templates/SourceLegendTemplate";
import DisplaysSourceEmbeddedTemplate from "unit-elements/gen/displays/templates/SourceEmbeddedTemplate";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import SourceTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import SourceTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class SourceTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new SourceTemplateNotifier(this);
		this.requester = new SourceTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock format="smallAir" layout="vertical flexible" style={{...this.props.style,...display}}>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a593751384" format="bordered spaced" layout="horizontal">
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_846414245" layout="vertical flexible">
						<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1126224355" layout="horizontal">
							<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_133684349" title="" target="self" mode="Link" size="Medium" format="h4 middleAirRight" visible={false}>
							</UiAction>
							<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a2076123810" format="h4 middleAirRight" visible={false} mode="normal" value="/">
							</UiText>
							<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1992333825" format="h4 bold" mode="normal">
							</UiText>
						</UiBlock>
						<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1984517316" format="body2" mode="normal">
						</UiText>
						<DisplaysSourceLegendTemplate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1373225305">
						</DisplaysSourceLegendTemplate>
					</UiBlock>
				</UiBlock>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1804383714" format="smallAirTop" layout="horizontal flexible">
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1544281735" format="bordered" layout="vertical flexible">
						<DisplaysSourceEmbeddedTemplate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1439598428">
						</DisplaysSourceEmbeddedTemplate>
					</UiBlock>
				</UiBlock>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(SourceTemplate));
DisplayFactory.register("SourceTemplate", withStyles(styles, { withTheme: true })(withSnackbar(SourceTemplate)));