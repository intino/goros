import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiTemplateStamp from "alexandria-ui-elements/src/displays/components/TemplateStamp";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiSearchBox from "alexandria-ui-elements/src/displays/components/SearchBox";
import UiBlockConditional from "alexandria-ui-elements/src/displays/components/BlockConditional";
import DisplaysTrashToolbarTemplate from "unit-elements/gen/displays/templates/TrashToolbarTemplate";
import DisplaysTrashTableCatalog from "unit-elements/gen/displays/templates/TrashTableCatalog";
import DisplaysTrashTableFilters from "unit-elements/gen/displays/templates/TrashTableFilters";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import TrashTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import TrashTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class TrashTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new TrashTemplateNotifier(this);
		this.requester = new TrashTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock format="smallAir" layout="vertical flexible" style={{...this.props.style,...display}}>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_90308999" format="bordered spaced" layout="horizontal">
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1493166739" layout="vertical flexible">
						<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1946544309" layout="horizontal">
							<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1879949647" format="h4 bold" mode="normal" translate={true} value="Trash">
							</UiText>
						</UiBlock>
						<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1780046763" format="body2" mode="normal">
						</UiText>
					</UiBlock>
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1955692997" layout="horizontal center">
						<UiSearchBox context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1235044706" format="airRight smallAirTop">
						</UiSearchBox>
					</UiBlock>
				</UiBlock>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a751010564" format="smallAirTop" layout="horizontal flexible">
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a489545162" format="bordered" layout="vertical flexible">
						<DisplaysTrashToolbarTemplate context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1985202717">
						</DisplaysTrashToolbarTemplate>
						<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1096271594" layout="vertical flexible" width="100.0%" height="100.0%">
							<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_715671027" layout="vertical flexible">
								<DisplaysTrashTableCatalog context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1368163230" format="fullHeight">
								</DisplaysTrashTableCatalog>
							</UiBlock>
						</UiBlock>
					</UiBlock>
					<UiBlockConditional context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1283885600" format="smallAirLeft middleSpaced bordered" layout="vertical" width="30.0%" height="100.0%" animation={{mode:"Slide",direction:"Left",duration:"500"}}>
						<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a780472332" layout="vertical flexible">
							<DisplaysTrashTableFilters context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1069567491" format="fullHeight">
							</DisplaysTrashTableFilters>
						</UiBlock>
					</UiBlockConditional>
				</UiBlock>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(TrashTemplate));
DisplayFactory.register("TrashTemplate", withStyles(styles, { withTheme: true })(withSnackbar(TrashTemplate)));