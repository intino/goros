import React from "react";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiStamp from "alexandria-ui-elements/src/displays/components/Stamp";
import UiMultiple from "alexandria-ui-elements/src/displays/components/Multiple";
import DisplaysFieldView from "app-elements/src/displays/templates/FieldView";
import DisplaysNodeView from "../../../src/displays/templates/NodeView";

export default class AbstractFormView extends DisplaysNodeView {

	constructor(props) {
		super(props);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
		return(
			<UiBlock layout="vertical" style={{...this.props.style,...display}}>
				<UiMultiple context={this._context.bind(this)} owner={this._owner.bind(this)} id="rkE" multiple={{instances:"formView0",arrangement:"Vertical",noItemsMessage:"",spacing:0}}>
				</UiMultiple>
			</UiBlock>
		);
	}
}