import React from "react";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import DisplaysPage from "../../../src/displays/templates/Page";

export default class AbstractNodePage extends DisplaysPage {

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