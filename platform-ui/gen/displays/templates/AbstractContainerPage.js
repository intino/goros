import React from "react";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import DisplaysNodePage from "../../../src/displays/templates/NodePage";

export default class AbstractContainerPage extends DisplaysNodePage {

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