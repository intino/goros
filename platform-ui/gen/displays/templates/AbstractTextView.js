import React from "react";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiTextEditable from "alexandria-ui-elements/src/displays/components/TextEditable";
import DisplaysFieldView from "../../../src/displays/templates/FieldView";

export default class AbstractTextView extends DisplaysFieldView {

	constructor(props) {
		super(props);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
		return(
			<UiBlock layout="vertical" style={{...this.props.style,...display}}>
				<UiTextEditable context={this._context.bind(this)} owner={this._owner.bind(this)} id="lY5" mode="normal" placeholder="">
				</UiTextEditable>
			</UiBlock>
		);
	}
}