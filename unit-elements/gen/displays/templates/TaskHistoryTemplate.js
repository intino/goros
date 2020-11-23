import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiTemplateStamp from "alexandria-ui-elements/src/displays/components/TemplateStamp";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiMultiple from "alexandria-ui-elements/src/displays/components/Multiple";
import UiAction from "alexandria-ui-elements/src/displays/components/Action";
import DisplaysTaskHistoryEntryTemplate from "unit-elements/gen/displays/templates/TaskHistoryEntryTemplate";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import TaskHistoryTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import TaskHistoryTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskHistoryTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskHistoryTemplateNotifier(this);
		this.requester = new TaskHistoryTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock layout="vertical flexible" width="100.0%" height="100.0%" style={{...this.props.style,...display}}>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1394806318" layout="vertical">
					<UiMultiple context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1261513507" multiple={{instances:"entries",arrangement:"Vertical",noItemsMessage:"",spacing:0,editable:false,wrap:true,count:{min:0,max:-1}}}>
					</UiMultiple>
				</UiBlock>
				<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_231617306" title="Ver más..." target="self" mode="Link" size="Medium" visible={false}>
				</UiAction>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskHistoryTemplate));
DisplayFactory.register("TaskHistoryTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskHistoryTemplate)));