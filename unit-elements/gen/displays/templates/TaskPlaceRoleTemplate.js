import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiAction from "alexandria-ui-elements/src/displays/components/Action";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import TaskPlaceRoleTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import TaskPlaceRoleTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskPlaceRoleTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskPlaceRoleTemplateNotifier(this);
		this.requester = new TaskPlaceRoleTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock format="middleAirTop middleAirBottom" layout="vertical flexible" width="100.0%" height="100.0%" style={{...this.props.style,...display}}>
				<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a844508008" title="" target="self" mode="Link" size="Medium">
				</UiAction>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceRoleTemplate));
DisplayFactory.register("TaskPlaceRoleTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskPlaceRoleTemplate)));