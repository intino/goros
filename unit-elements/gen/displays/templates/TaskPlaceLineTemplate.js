import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiTemplateStamp from "alexandria-ui-elements/src/displays/components/TemplateStamp";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiSpinner from "alexandria-ui-elements/src/displays/components/Spinner";
import UiMultiple from "alexandria-ui-elements/src/displays/components/Multiple";
import DisplaysTaskPlaceLineStopTemplate from "unit-elements/gen/displays/templates/TaskPlaceLineStopTemplate";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import TaskPlaceLineTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import TaskPlaceLineTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskPlaceLineTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskPlaceLineTemplateNotifier(this);
		this.requester = new TaskPlaceLineTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock layout="vertical flexible" width="100.0%" height="100.0%" style={{...this.props.style,...display}}>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1183826318" format="airBottom" layout="vertical">
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a205974072" mode="normal">
					</UiText>
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a434678946" visible={false} mode="normal">
					</UiText>
				</UiBlock>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a233750819" layout="vertical">
					<UiSpinner context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_534114340" mode="Rise">
					</UiSpinner>
				</UiBlock>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1700500010" layout="vertical">
					<UiMultiple context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1498621532" multiple={{instances:"stops",arrangement:"Vertical",noItemsMessage:"",spacing:0,editable:false,wrap:true,count:{min:0,max:-1}}}>
					</UiMultiple>
				</UiBlock>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceLineTemplate));
DisplayFactory.register("TaskPlaceLineTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceLineTemplate)));