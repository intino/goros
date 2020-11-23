import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiTextEditable from "alexandria-ui-elements/src/displays/components/TextEditable";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import SearchFilterTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import SearchFilterTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class SearchFilterTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new SearchFilterTemplateNotifier(this);
		this.requester = new SearchFilterTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock layout="vertical" style={{...this.props.style,...display}}>
				<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1872658962" format="body2" mode="normal">
				</UiText>
				<UiTextEditable context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_2013772306" mode="normal" placeholder="Indique un texto a buscar">
				</UiTextEditable>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(SearchFilterTemplate));
DisplayFactory.register("SearchFilterTemplate", withStyles(styles, { withTheme: true })(withSnackbar(SearchFilterTemplate)));