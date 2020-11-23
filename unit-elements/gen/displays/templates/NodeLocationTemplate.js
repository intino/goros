import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiLocationEditable from "alexandria-ui-elements/src/displays/components/LocationEditable";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import NodeLocationTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import NodeLocationTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class NodeLocationTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new NodeLocationTemplateNotifier(this);
		this.requester = new NodeLocationTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock format="spaced" layout="vertical flexible" width="100.0%" height="100.0%" style={{...this.props.style,...display}}>
				<UiLocationEditable context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1932760772" center={{lat:28.146773457066104,lng:-15.418557420532238}} zoom={{min:1,max:18,defaultZoom:15}}>
				</UiLocationEditable>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(NodeLocationTemplate));
DisplayFactory.register("NodeLocationTemplate", withStyles(styles, { withTheme: true })(withSnackbar(NodeLocationTemplate)));