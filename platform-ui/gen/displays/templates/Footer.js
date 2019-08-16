import React from "react";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import FooterNotifier from "../notifiers/FooterNotifier";
import FooterRequester from "../requesters/FooterRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';

export default class Footer extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new FooterNotifier(this);
		this.requester = new FooterRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
		return(
			<UiBlock format="footerFormat" layout="vertical" style={{...this.props.style,...display}}>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="q2" layout="horizontal flexible aroundjustified centercenter">
				</UiBlock>
			</UiBlock>
		);
	}
}

DisplayFactory.register("Footer", Footer);