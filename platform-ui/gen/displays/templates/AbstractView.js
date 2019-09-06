import React from "react";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import Notifier from "../notifiers/Notifier";
import Requester from "../requesters/Requester";

export default class AbstractView extends UiTemplate {

	constructor(props) {
		super(props);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
		return(
			<UiBlock layout="vertical" style={{...this.props.style,...display}}>
				<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="_5B" mode="normal">
				</UiText>
			</UiBlock>
		);
	}
}