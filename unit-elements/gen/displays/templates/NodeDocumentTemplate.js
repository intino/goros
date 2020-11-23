import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiOpenDialog from "alexandria-ui-elements/src/displays/components/OpenDialog";
import UiFile from "alexandria-ui-elements/src/displays/components/File";
import UiDialog from "alexandria-ui-elements/src/displays/components/Dialog";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiStepper from "alexandria-ui-elements/src/displays/components/Stepper";
import UiStep from "alexandria-ui-elements/src/displays/components/Step";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiDownload from "alexandria-ui-elements/src/displays/components/Download";
import UiFileEditable from "alexandria-ui-elements/src/displays/components/FileEditable";
import UiDivider from "alexandria-ui-elements/src/displays/components/Divider";
import UiCloseDialog from "alexandria-ui-elements/src/displays/components/CloseDialog";
import UiAction from "alexandria-ui-elements/src/displays/components/Action";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import NodeDocumentTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import NodeDocumentTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class NodeDocumentTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new NodeDocumentTemplateNotifier(this);
		this.requester = new NodeDocumentTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock format="spaced relative" layout="vertical" width="100.0%" height="100.0%" style={{...this.props.style,...display}}>
				<UiOpenDialog context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1729628403" title="Modify document" target="self" mode="MaterialIconButton" icon="Edit" size="Medium" format="editDocumentButtonStyle" visible={false}>
				</UiOpenDialog>
				<UiFile context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_2087979969">
				</UiFile>
				<UiDialog context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1257892374" title="Modify document" width="60.0%" height="60.0%">
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1545256" layout="vertical" width="100.0%" height="calc(100% - 50px)">
						<UiStepper context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_150559212" style="Full"    orientation="horizontal" position="top">
							<UiStep context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1568998335" label="Download document">
								<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_2026710827" layout="vertical centercenter" width="100.0%" height="100.0%">
									<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a165163608" mode="normal" translate={true} value="Download document to edit it in your computer.">
									</UiText>
									<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_772309171" format="airBottom" mode="normal" translate={true} value="Click next if you have already edit the document.">
									</UiText>
									<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1574091835" layout="vertical">
										<UiDownload context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1809514646" title="Download" target="self" mode="Button" size="Medium" highlighted="Outline">
										</UiDownload>
									</UiBlock>
								</UiBlock>
							</UiStep>
							<UiStep context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1839109415" label="Edit document">
								<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_332414746" layout="vertical centercenter" width="100.0%" height="100.0%">
									<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1120518139" mode="normal" translate={true} value="Open the document and insert the changes that you want.">
									</UiText>
									<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1466031691" format="airBottom" mode="normal" translate={true} value="When you finish, indicate the location of the modified document to save the last version in the system.">
									</UiText>
									<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_2097732414" layout="vertical">
										<UiFileEditable context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1060849346" dropZone={true}>
										</UiFileEditable>
									</UiBlock>
								</UiBlock>
							</UiStep>
							<UiStep context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_640196342" label="Document saved">
								<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1481571749" layout="vertical centercenter" width="100.0%" height="100.0%">
									<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_445678905" mode="normal" translate={true} value="New version of document received.">
									</UiText>
									<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a578403748" mode="normal" translate={true} value="Click save to replace current version.">
									</UiText>
								</UiBlock>
							</UiStep>
						</UiStepper>
					</UiBlock>
					<UiDivider context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1825339574">
					</UiDivider>
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a2129647878" layout="horizontal endjustified">
						<UiCloseDialog context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1425830529" title="Cancel" target="self" mode="Button" size="Medium" format="airRight">
						</UiCloseDialog>
						<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_357951361" title="Save" target="self" mode="Button" size="Medium" highlighted="Fill">
						</UiAction>
					</UiBlock>
				</UiDialog>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(NodeDocumentTemplate));
DisplayFactory.register("NodeDocumentTemplate", withStyles(styles, { withTheme: true })(withSnackbar(NodeDocumentTemplate)));