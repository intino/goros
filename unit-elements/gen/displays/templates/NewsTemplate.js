import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import NewsTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import NewsTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class NewsTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new NewsTemplateNotifier(this);
		this.requester = new NewsTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock format="smallAir" layout="vertical flexible" style={{...this.props.style,...display}}>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a488525792" format="bordered spaced" layout="horizontal">
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1663999730" layout="vertical flexible">
						<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1006337503" layout="horizontal">
							<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1332929896" format="h4 bold" mode="normal" value="News">
							</UiText>
						</UiBlock>
						<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_420855183" format="body2" mode="normal">
						</UiText>
					</UiBlock>
				</UiBlock>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a5511773" format="smallAirTop" layout="horizontal flexible">
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1849841940" format="bordered" layout="vertical flexible">
						<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_824234697" layout="vertical flexible centercenter">
							<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1996904669" mode="normal" value="Pendiente de implementar">
							</UiText>
						</UiBlock>
					</UiBlock>
				</UiBlock>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(NewsTemplate));
DisplayFactory.register("NewsTemplate", withStyles(styles, { withTheme: true })(withSnackbar(NewsTemplate)));