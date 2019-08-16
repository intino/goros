import React from "react";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import DisplaysNodeView from "../../../src/displays/templates/NodeView";

export default class AbstractDesktopView extends DisplaysNodeView {

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