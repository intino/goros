import React from "react";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiImage from "alexandria-ui-elements/src/displays/components/Image";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiUser from "alexandria-ui-elements/src/displays/components/User";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import HeaderNotifier from "../notifiers/HeaderNotifier";
import HeaderRequester from "../requesters/HeaderRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';

export default class Header extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new HeaderNotifier(this);
		this.requester = new HeaderRequester(this);
	};

	render() {
		return(
			<UiBlock format="air" color="black" layout="horizontal center" width="-1px" height="75px">
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="rE" layout="horizontal center flexible" spacing="24">
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="gJY" layout="vertical">
						<UiImage context={this._context.bind(this)} owner={this._owner.bind(this)} id="jRR" width="200px" height="50px">
						</UiImage>
						<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="kR5" format="headerSubtitle" mode="normal" value="Coordinación">
						</UiText>
					</UiBlock>
				</UiBlock>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="lY5" format="h6 secondary" layout="horizontal center endjustified" spacing="16">
					<UiUser context={this._context.bind(this)} owner={this._owner.bind(this)} id="mZO" color="grey">
					</UiUser>
				</UiBlock>
			</UiBlock>
		);
	}
}

DisplayFactory.register("Header", Header);