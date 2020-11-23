import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiSelectorListBox from "alexandria-ui-elements/src/displays/components/SelectorListBox";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import ListFilterTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import ListFilterTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class ListFilterTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new ListFilterTemplateNotifier(this);
		this.requester = new ListFilterTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock layout="vertical" style={{...this.props.style,...display}}>
				<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1788605020" format="body2" mode="normal">
				</UiText>
				<UiSelectorListBox context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_2048775858" multipleSelection={true}>
				</UiSelectorListBox>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(ListFilterTemplate));
DisplayFactory.register("ListFilterTemplate", withStyles(styles, { withTheme: true })(withSnackbar(ListFilterTemplate)));