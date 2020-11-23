import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiTemplateStamp from "alexandria-ui-elements/src/displays/components/TemplateStamp";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiSelectorComboBox from "alexandria-ui-elements/src/displays/components/SelectorComboBox";
import UiMultiple from "alexandria-ui-elements/src/displays/components/Multiple";
import UiDivider from "alexandria-ui-elements/src/displays/components/Divider";
import UiAction from "alexandria-ui-elements/src/displays/components/Action";
import UiDownload from "alexandria-ui-elements/src/displays/components/Download";
import DisplaysNodeDownloadDialogOption from "unit-elements/gen/displays/templates/NodeDownloadDialogOption";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import NodeDownloadDialogNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import NodeDownloadDialogRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class NodeDownloadDialog extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new NodeDownloadDialogNotifier(this);
		this.requester = new NodeDownloadDialogRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock layout="flexible" width="100.0%" height="100.0%" style={{...this.props.style,...display}}>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1955491608" format="autoOverflow" layout="flexible" width="100.0%" height="calc(100% - 50px)">
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a706215557" format="airBottom" layout="vertical">
						<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a828680825" format="airBottom" mode="normal" value="Indique el formato de descarga">
						</UiText>
						<UiSelectorComboBox context={this._context.bind(this)} owner={this._owner.bind(this)} id="a2085126658" multipleSelection={false} placeholder="Seleccione un formato">
							<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1082167605" name="pdf" mode="normal" value="Formato de documento portátil (pdf)">
							</UiText>
							<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1082155593" name="csv" mode="normal" value="Valores separados por coma (csv)">
							</UiText>
							<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1082175554" name="xls" mode="normal" value="Documento de Excel (xls)">
							</UiText>
						</UiSelectorComboBox>
					</UiBlock>
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_246641411" format="airBottom doubleAirTop" layout="vertical">
						<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a532976130" format="airBottom" mode="normal" value="Indique las columnas de la cabecera del documento">
						</UiText>
						<UiMultiple context={this._context.bind(this)} owner={this._owner.bind(this)} id="a465071452" multiple={{instances:"options",arrangement:"Vertical",noItemsMessage:"",spacing:0,editable:false,wrap:true,count:{min:0,max:-1}}}>
						</UiMultiple>
					</UiBlock>
				</UiBlock>
				<UiDivider context={this._context.bind(this)} owner={this._owner.bind(this)} id="a2010955798">
				</UiDivider>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a2083941692" layout="horizontal endjustified">
					<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a848750163" title="Cancelar" target="self" mode="Button" size="Small" format="airRight">
					</UiAction>
					<UiDownload context={this._context.bind(this)} owner={this._owner.bind(this)} id="a793013473" title="Aceptar" target="self" mode="Button" size="Small">
					</UiDownload>
				</UiBlock>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(NodeDownloadDialog));
DisplayFactory.register("NodeDownloadDialog", withStyles(styles, { withTheme: true })(withSnackbar(NodeDownloadDialog)));