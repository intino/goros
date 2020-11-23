import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiSelectorComboBox from "alexandria-ui-elements/src/displays/components/SelectorComboBox";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import NodeDownloadDialogOptionNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import NodeDownloadDialogOptionRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class NodeDownloadDialogOption extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new NodeDownloadDialogOptionNotifier(this);
		this.requester = new NodeDownloadDialogOptionRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock format="airBottom" layout="horizontal" style={{...this.props.style,...display}}>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a425506369" layout="vertical" width="25.0%" height="100.0%">
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1197134942" mode="normal">
					</UiText>
				</UiBlock>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1378891889" layout="flexible">
					<UiSelectorComboBox context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1088052456" multipleSelection={false} placeholder="Seleccione una columna">
					</UiSelectorComboBox>
				</UiBlock>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(NodeDownloadDialogOption));
DisplayFactory.register("NodeDownloadDialogOption", withStyles(styles, { withTheme: true })(withSnackbar(NodeDownloadDialogOption)));