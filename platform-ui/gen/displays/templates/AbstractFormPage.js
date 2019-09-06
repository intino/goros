import React from "react";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiStamp from "alexandria-ui-elements/src/displays/components/Stamp";
import UiMultiple from "alexandria-ui-elements/src/displays/components/Multiple";
import DisplaysFieldView from "app-elements/src/displays/templates/FieldView";
import DisplaysNodePage from "../../../src/displays/templates/NodePage";
import Notifier from "../notifiers/Notifier";
import Requester from "../requesters/Requester";

export default class AbstractFormPage extends DisplaysNodePage {

	constructor(props) {
		super(props);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
		return(
			<UiBlock layout="vertical" style={{...this.props.style,...display}}>
				<UiMultiple context={this._context.bind(this)} owner={this._owner.bind(this)} id="YK" multiple={{instances:"formPage0",arrangement:"Vertical",noItemsMessage:"",spacing:0}}>
				</UiMultiple>
			</UiBlock>
		);
	}
}