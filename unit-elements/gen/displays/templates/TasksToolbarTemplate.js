import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import TasksToolbarTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import TasksToolbarTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TasksToolbarTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TasksToolbarTemplateNotifier(this);
		this.requester = new TasksToolbarTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock format="air" layout="horizontal" style={{...this.props.style,...display}}>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TasksToolbarTemplate));
DisplayFactory.register("TasksToolbarTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TasksToolbarTemplate)));