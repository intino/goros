import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiTemplateStamp from "alexandria-ui-elements/src/displays/components/TemplateStamp";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiMultiple from "alexandria-ui-elements/src/displays/components/Multiple";
import UiBlockConditional from "alexandria-ui-elements/src/displays/components/BlockConditional";
import DisplaysSourceLevelTemplate from "unit-elements/gen/displays/templates/SourceLevelTemplate";
import DisplaysPublishTermsDialog from "unit-elements/gen/displays/templates/PublishTermsDialog";
import DisplaysSourceTermDialog from "unit-elements/gen/displays/templates/SourceTermDialog";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import SourceEmbeddedTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import SourceEmbeddedTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class SourceEmbeddedTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new SourceEmbeddedTemplateNotifier(this);
		this.requester = new SourceEmbeddedTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock layout="horizontal flexible" width="100.0%" height="100.0%" style={{...this.props.style,...display}}>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a644854813" format="autoOverflow" layout="vertical flexible" width="100.0%" height="100.0%">
					<UiMultiple context={this._context.bind(this)} owner={this._owner.bind(this)} id="a104969169" multiple={{instances:"levels",arrangement:"Horizontal",noItemsMessage:"",spacing:0,editable:false,wrap:false,count:{min:0,max:-1}}}>
					</UiMultiple>
				</UiBlock>
				<UiBlockConditional context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1551538734" format="smallAirLeft leftBordered" layout="vertical" width="35.0%" height="100.0%" animation={{mode:"Slide",direction:"Left",duration:"500"}}>
					<DisplaysPublishTermsDialog context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_829429587">
					</DisplaysPublishTermsDialog>
					<DisplaysSourceTermDialog context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_2134596255">
					</DisplaysSourceTermDialog>
				</UiBlockConditional>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(SourceEmbeddedTemplate));
DisplayFactory.register("SourceEmbeddedTemplate", withStyles(styles, { withTheme: true })(withSnackbar(SourceEmbeddedTemplate)));