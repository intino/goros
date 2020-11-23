import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiAction from "alexandria-ui-elements/src/displays/components/Action";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import TrashToolbarTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import TrashToolbarTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TrashToolbarTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TrashToolbarTemplateNotifier(this);
		this.requester = new TrashToolbarTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock format="air" layout="horizontal" style={{...this.props.style,...display}}>
				<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a71247982" title="Empty trash" target="self" mode="Button" affirmed="Are you sure you want to empty the trash?" size="Small" highlighted="Outline">
				</UiAction>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TrashToolbarTemplate));
DisplayFactory.register("TrashToolbarTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TrashToolbarTemplate)));