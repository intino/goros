import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiAction from "alexandria-ui-elements/src/displays/components/Action";
import UiNumber from "alexandria-ui-elements/src/displays/components/Number";
import UiDate from "alexandria-ui-elements/src/displays/components/Date";
import UiItem from "alexandria-ui-elements/src/displays/components/Item";
import TasksListItemNotifier from "alexandria-ui-elements/gen/displays/notifiers/ItemNotifier";
import TasksListItemRequester from "alexandria-ui-elements/gen/displays/requesters/ItemRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TasksListItem extends UiItem {

	constructor(props) {
		super(props);
		this.notifier = new TasksListItemNotifier(this);
		this.requester = new TasksListItemRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<div style={{width:"100%",height:"100%",...this.props.style,...this.style(),...display}} className={className}>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1252517152" format="catalogIndexReferenceStyle" layout="vertical">
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_2046327365" layout="horizontal center">
						<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a874387293" layout="horizontal flexible">
							<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a121538653" format="h4 airRight" mode="normal" value="Loading...">
							</UiText>
							<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a128568826" format="body2 pillStyle" mode="normal" highlighted={{text:"white",background:"#33942F"}}>
							</UiText>
						</UiBlock>
						<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1198467640" layout="horizontal endjustified">
							<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_843298219" title="Marcar/Desmarcar como urgente" target="self" mode="MaterialIconButton" icon="Alarm" size="Small" color="#ddd">
							</UiAction>
						</UiBlock>
					</UiBlock>
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1088108833" format="body2" mode="normal">
					</UiText>
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1964877720" label="Responsable" format="body2" mode="normal">
					</UiText>
					<UiNumber context={this._context.bind(this)} owner={this._owner.bind(this)} id="a52770656" label="Número de mensajes" format="body2" style="Number" value={0.0} decimals={0} expanded={true}>
					</UiNumber>
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1822868792" format="middleAirTop" layout="horizontal">
						<UiDate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_921778011" label="Fecha creación" format="body2 doubleAirRight" pattern="DD/MM/YYYY">
						</UiDate>
						<UiDate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1708044786" label="Fecha actualización" format="body2" pattern="DD/MM/YYYY">
						</UiDate>
					</UiBlock>
				</UiBlock>
			</div>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TasksListItem));
DisplayFactory.register("TasksListItem", withStyles(styles, { withTheme: true })(withSnackbar(TasksListItem)));