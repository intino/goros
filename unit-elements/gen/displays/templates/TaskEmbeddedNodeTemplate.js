import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import TaskEmbeddedNodeTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import TaskEmbeddedNodeTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TaskEmbeddedNodeTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TaskEmbeddedNodeTemplateNotifier(this);
		this.requester = new TaskEmbeddedNodeTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock layout="vertical flexible" width="100.0%" height="100.0%" style={{...this.props.style,...display}}>
				<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a2016630591" format="h5" mode="normal" value="Embedded node">
				</UiText>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TaskEmbeddedNodeTemplate));
DisplayFactory.register("TaskEmbeddedNodeTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TaskEmbeddedNodeTemplate)));