import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiTemplateStamp from "alexandria-ui-elements/src/displays/components/TemplateStamp";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiTextEditable from "alexandria-ui-elements/src/displays/components/TextEditable";
import UiSelectorComboBox from "alexandria-ui-elements/src/displays/components/SelectorComboBox";
import UiActionSwitch from "alexandria-ui-elements/src/displays/components/ActionSwitch";
import UiMultiple from "alexandria-ui-elements/src/displays/components/Multiple";
import UiAction from "alexandria-ui-elements/src/displays/components/Action";
import DisplaysSourceTermTagTemplate from "unit-elements/gen/displays/templates/SourceTermTagTemplate";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import SourceTermDialogNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import SourceTermDialogRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class SourceTermDialog extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new SourceTermDialogNotifier(this);
		this.requester = new SourceTermDialogRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock layout="vertical" style={{...this.props.style,...display}}>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1123941020" format="doubleAirBottom middleSpaced leftSpaced rightSpaced" layout="vertical">
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a202840821" format="h5 airBottom" mode="normal">
					</UiText>
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1587795460" format="bordered dialog" layout="vertical">
						<UiTextEditable context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1211355951" label="Code" format="doubleAirBottom" mode="normal" placeholder="" readonly={true}>
						</UiTextEditable>
						<UiTextEditable context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1110563984" label="Label" format="doubleAirBottom" mode="normal" placeholder="">
						</UiTextEditable>
						<UiSelectorComboBox context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1210839522" label="Type" multipleSelection={false} placeholder="Select type">
							<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a980047559" name="termType" mode="normal" translate={true} value="Term">
							</UiText>
							<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_709374503" name="categoryType" mode="normal" translate={true} value="Category">
							</UiText>
						</UiSelectorComboBox>
						<UiActionSwitch context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_2078760985" title="Contain other terms" target="self" mode="Link" size="Medium" format="doubleAirBottom" state="Off">
						</UiActionSwitch>
						<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a2039945735" format="grey" mode="normal" translate={true} value="Tags">
						</UiText>
						<UiMultiple context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1210862851" multiple={{instances:"tags",arrangement:"Vertical",noItemsMessage:"No tags",spacing:0,editable:false,wrap:true,count:{min:0,max:-1}}}>
						</UiMultiple>
					</UiBlock>
				</UiBlock>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_815145931" format="middleSpaced leftSpaced rightSpaced" layout="vertical">
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_499239167" format="h5 airBottom" mode="normal">
					</UiText>
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a706663146" format="bordered dialog" layout="vertical">
						<UiTextEditable context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1704898938" label="Code" format="doubleAirBottom" mode="normal" placeholder="">
						</UiTextEditable>
						<UiTextEditable context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1320152327" label="Label" format="doubleAirBottom" mode="normal" placeholder="">
						</UiTextEditable>
						<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1283214812" layout="vertical" width="150px" height="-1px">
							<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_76440842" title="Add" target="self" mode="Button" size="Small" highlighted="Outline">
							</UiAction>
						</UiBlock>
					</UiBlock>
				</UiBlock>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(SourceTermDialog));
DisplayFactory.register("SourceTermDialog", withStyles(styles, { withTheme: true })(withSnackbar(SourceTermDialog)));