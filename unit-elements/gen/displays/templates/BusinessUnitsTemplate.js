import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiTemplateStamp from "alexandria-ui-elements/src/displays/components/TemplateStamp";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiMultiple from "alexandria-ui-elements/src/displays/components/Multiple";
import DisplaysBusinessUnitTemplate from "unit-elements/gen/displays/templates/BusinessUnitTemplate";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import BusinessUnitsTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import BusinessUnitsTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class BusinessUnitsTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new BusinessUnitsTemplateNotifier(this);
		this.requester = new BusinessUnitsTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock layout="vertical" style={{...this.props.style,...display}}>
				<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1002728907" mode="normal" translate={true} value="Business units">
				</UiText>
				<UiMultiple context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1896342810" multiple={{instances:"units",arrangement:"Vertical",noItemsMessage:"",spacing:0,editable:false,wrap:true,count:{min:0,max:-1}}}>
				</UiMultiple>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(BusinessUnitsTemplate));
DisplayFactory.register("BusinessUnitsTemplate", withStyles(styles, { withTheme: true })(withSnackbar(BusinessUnitsTemplate)));