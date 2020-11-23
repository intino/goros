import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiDateEditable from "alexandria-ui-elements/src/displays/components/DateEditable";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import DateRangeFilterTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import DateRangeFilterTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class DateRangeFilterTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new DateRangeFilterTemplateNotifier(this);
		this.requester = new DateRangeFilterTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock layout="vertical" style={{...this.props.style,...display}}>
				<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_929956521" format="body2" mode="normal">
				</UiText>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1745292057" layout="horizontal flexible">
					<UiDateEditable context={this._context.bind(this)} owner={this._owner.bind(this)} id="a979259520" label="Desde" format="airRight" pattern="DD/MM/YYYY" allowEmpty={true}>
					</UiDateEditable>
					<UiDateEditable context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1393392431" label="Hasta" pattern="DD/MM/YYYY" allowEmpty={true}>
					</UiDateEditable>
				</UiBlock>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(DateRangeFilterTemplate));
DisplayFactory.register("DateRangeFilterTemplate", withStyles(styles, { withTheme: true })(withSnackbar(DateRangeFilterTemplate)));