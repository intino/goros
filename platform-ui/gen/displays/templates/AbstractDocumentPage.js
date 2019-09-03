import React from "react";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import DisplaysNodePage from "../../../src/displays/templates/NodePage";
import Notifier from "../notifiers/Notifier";
import Requester from "../requesters/Requester";

export default class AbstractDocumentPage extends DisplaysNodePage {

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