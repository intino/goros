import React from "react";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import DisplaysTaskView from "../../../src/displays/templates/TaskView";

export default class AbstractStateView extends DisplaysTaskView {

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