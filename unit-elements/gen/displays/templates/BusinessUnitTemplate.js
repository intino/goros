import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiOpenSite from "alexandria-ui-elements/src/displays/components/OpenSite";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiFrame from "alexandria-ui-elements/src/displays/components/Frame";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import BusinessUnitTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import BusinessUnitTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class BusinessUnitTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new BusinessUnitTemplateNotifier(this);
		this.requester = new BusinessUnitTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock layout="vertical" style={{...this.props.style,...display}}>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a54338127" layout="horizontal">
					<UiOpenSite context={this._context.bind(this)} owner={this._owner.bind(this)} id="a23238615" title="" target="blank" mode="Link" size="Medium" format="middleAirRight" visible={false}>
					</UiOpenSite>
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_600011356" format="middleAirRight" visible={false} mode="normal">
					</UiText>
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a407863939" visible={false} mode="normal" translate={true} value="(current)">
					</UiText>
				</UiBlock>
				<UiFrame context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1944867175"    width="-1px" height="55px" url="">
				</UiFrame>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(BusinessUnitTemplate));
DisplayFactory.register("BusinessUnitTemplate", withStyles(styles, { withTheme: true })(withSnackbar(BusinessUnitTemplate)));