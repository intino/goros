import React from "react";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import Notifier from "../notifiers/Notifier";
import Requester from "../requesters/Requester";

export default class AbstractPage extends UiTemplate {

	constructor(props) {
		super(props);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
		return(
			<UiBlock layout="vertical" style={{...this.props.style,...display}}>
			</UiBlock>
		);
	}
}