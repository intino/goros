import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiList from "alexandria-ui-elements/src/displays/components/List";
import DisplaysSourceLevelListItem from "unit-elements/gen/displays/items/SourceLevelListItem";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import SourceLevelTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import SourceLevelTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class SourceLevelTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new SourceLevelTemplateNotifier(this);
		this.requester = new SourceLevelTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock format="rightBordered sourceLevelWidth" layout="vertical" width="100.0%" height="100.0%" style={{...this.props.style,...display}}>
				<UiList context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1365275436" noItemsMessage="No existen términos" pageSize={20} itemHeight={90} scrollingMark={false} selection="single">
				</UiList>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(SourceLevelTemplate));
DisplayFactory.register("SourceLevelTemplate", withStyles(styles, { withTheme: true })(withSnackbar(SourceLevelTemplate)));