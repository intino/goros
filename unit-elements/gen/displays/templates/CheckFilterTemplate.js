import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiSelectorCheckBox from "alexandria-ui-elements/src/displays/components/SelectorCheckBox";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import CheckFilterTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import CheckFilterTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class CheckFilterTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new CheckFilterTemplateNotifier(this);
		this.requester = new CheckFilterTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock layout="vertical" style={{...this.props.style,...display}}>
				<UiSelectorCheckBox context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1907610845" format="body2" multipleSelection={false} layout="Vertical">
				</UiSelectorCheckBox>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(CheckFilterTemplate));
DisplayFactory.register("CheckFilterTemplate", withStyles(styles, { withTheme: true })(withSnackbar(CheckFilterTemplate)));