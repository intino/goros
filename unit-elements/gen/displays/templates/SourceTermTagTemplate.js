import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiTextEditable from "alexandria-ui-elements/src/displays/components/TextEditable";
import UiAction from "alexandria-ui-elements/src/displays/components/Action";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import SourceTermTagTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import SourceTermTagTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class SourceTermTagTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new SourceTermTagTemplateNotifier(this);
		this.requester = new SourceTermTagTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock layout="horizontal" style={{...this.props.style,...display}}>
				<UiTextEditable context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1153554788" format="airRight" mode="normal" placeholder="Name">
				</UiTextEditable>
				<UiTextEditable context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1393072256" mode="normal" placeholder="Value">
				</UiTextEditable>
				<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_747212420" title="Remove" target="self" mode="MaterialIconButton" icon="Clear" size="Medium">
				</UiAction>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(SourceTermTagTemplate));
DisplayFactory.register("SourceTermTagTemplate", withStyles(styles, { withTheme: true })(withSnackbar(SourceTermTagTemplate)));