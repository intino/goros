import React from "react";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import DisplaysPage from "../../../src/displays/templates/Page";
import Notifier from "../notifiers/Notifier";
import Requester from "../requesters/Requester";

export default class AbstractTaskPage extends DisplaysPage {

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