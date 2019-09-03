import React from "react";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiImage from "alexandria-ui-elements/src/displays/components/Image";
import UiUser from "alexandria-ui-elements/src/displays/components/User";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import Notifier from "../notifiers/Notifier";
import Requester from "../requesters/Requester";

export default class AbstractHeader extends UiTemplate {

	constructor(props) {
		super(props);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
		return(
			<UiBlock layout="horizontal center" style={{...this.props.style,...display}}>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="k5" layout="horizontal center flexible" spacing="24">
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="l5" layout="vertical">
						<UiImage context={this._context.bind(this)} owner={this._owner.bind(this)} id="mO" width="150px" height="50px">
						</UiImage>
					</UiBlock>
				</UiBlock>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="nR" format="h6 secondary" layout="horizontal center endjustified" spacing="16">
					<UiUser context={this._context.bind(this)} owner={this._owner.bind(this)} id="oj" color="grey">
					</UiUser>
				</UiBlock>
			</UiBlock>
		);
	}
}