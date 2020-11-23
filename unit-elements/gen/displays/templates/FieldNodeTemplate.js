import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiDisplayStamp from "alexandria-ui-elements/src/displays/components/DisplayStamp";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiAction from "alexandria-ui-elements/src/displays/components/Action";
import UiOpenDialog from "alexandria-ui-elements/src/displays/components/OpenDialog";
import UiDecisionDialog from "alexandria-ui-elements/src/displays/components/DecisionDialog";
import UiSelectorListBox from "alexandria-ui-elements/src/displays/components/SelectorListBox";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import FieldNodeTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import FieldNodeTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class FieldNodeTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new FieldNodeTemplateNotifier(this);
		this.requester = new FieldNodeTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock format="nodeFieldStyle" layout="vertical" style={{...this.props.style,...display}}>
				<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a782578768" format="h5 airBottom" mode="normal">
				</UiText>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_727863414" layout="horizontal centerjustified" width="100.0%" height="100.0%">
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1020337941" layout="vertical" width="100.0%" height="100.0%">
						<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a474060001" visible={false} layout="vertical">
							<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a834478397" format="red" mode="normal" translate={true} value="Your model is wrong. Property 'add' or 'contain' not defined.">
							</UiText>
						</UiBlock>
						<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_675895269" visible={false} layout="vertical">
							<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1268040713" mode="normal" translate={true} value="No element defined">
							</UiText>
							<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_998994482" format="airTop" layout="vertical" width="175px" height="-1px">
								<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a197496209" title="Add element" target="self" mode="Button" size="Medium" highlighted="Outline" visible={false}>
								</UiAction>
								<UiOpenDialog context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1088344192" title="Add element" target="self" mode="Button" size="Medium" highlighted="Outline" visible={false}>
								</UiOpenDialog>
							</UiBlock>
						</UiBlock>
						<UiDisplayStamp context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1760861104">
						</UiDisplayStamp>
					</UiBlock>
				</UiBlock>
				<UiDecisionDialog context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1309250584" title="Select element type">
					<UiSelectorListBox context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1724746791" multipleSelection={false}>
					</UiSelectorListBox>
				</UiDecisionDialog>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(FieldNodeTemplate));
DisplayFactory.register("FieldNodeTemplate", withStyles(styles, { withTheme: true })(withSnackbar(FieldNodeTemplate)));