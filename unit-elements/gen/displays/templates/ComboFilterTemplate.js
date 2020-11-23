import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiSelectorComboBox from "alexandria-ui-elements/src/displays/components/SelectorComboBox";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import ComboFilterTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import ComboFilterTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class ComboFilterTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new ComboFilterTemplateNotifier(this);
		this.requester = new ComboFilterTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock layout="vertical" style={{...this.props.style,...display}}>
				<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1152908214" format="body2" mode="normal">
				</UiText>
				<UiSelectorComboBox context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1343038752" multipleSelection={true} placeholder="Seleccione una opción">
				</UiSelectorComboBox>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(ComboFilterTemplate));
DisplayFactory.register("ComboFilterTemplate", withStyles(styles, { withTheme: true })(withSnackbar(ComboFilterTemplate)));