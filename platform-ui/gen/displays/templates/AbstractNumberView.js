import React from "react";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiNumberEditable from "alexandria-ui-elements/src/displays/components/NumberEditable";
import DisplaysFieldView from "../../../src/displays/templates/FieldView";
import Notifier from "../notifiers/Notifier";
import Requester from "../requesters/Requester";

export default class AbstractNumberView extends DisplaysFieldView {

	constructor(props) {
		super(props);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
		return(
			<UiBlock layout="vertical" style={{...this.props.style,...display}}>
				<UiNumberEditable context={this._context.bind(this)} owner={this._owner.bind(this)} id="o2j" value={0.0} min={-1.0} max={-1.0} step={-1.0}>
				</UiNumberEditable>
			</UiBlock>
		);
	}
}