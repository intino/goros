import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiNumber from "alexandria-ui-elements/src/displays/components/Number";
import UiMaterialIcon from "alexandria-ui-elements/src/displays/components/MaterialIcon";
import UiItem from "alexandria-ui-elements/src/displays/components/Item";
import SourceLevelListItemNotifier from "alexandria-ui-elements/gen/displays/notifiers/ItemNotifier";
import SourceLevelListItemRequester from "alexandria-ui-elements/gen/displays/requesters/ItemRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class SourceLevelListItem extends UiItem {

	constructor(props) {
		super(props);
		this.notifier = new SourceLevelListItemNotifier(this);
		this.requester = new SourceLevelListItemRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<div style={{width:"100%",height:"100%",...this.props.style,...this.style(),...display}} className={className}>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a356551625" format="termReferenceStyle" layout="horizontal">
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1466757235" layout="vertical flexible">
						<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1500563454" layout="horizontal center">
							<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1900498371" format="body2 legendPillStyle middleAirRight" mode="normal" highlighted={{text:"white",background:"transparent"}}>
							</UiText>
							<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1205976145" format="middleAirRight" mode="normal" cropWithEllipsis={20}>
							</UiText>
						</UiBlock>
						<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a622513010" format="body2 grey" mode="normal" cropWithEllipsis={26}>
						</UiText>
						<UiNumber context={this._context.bind(this)} owner={this._owner.bind(this)} id="a170549777" label="Tags count" format="body2" style="Number" value={0.0} decimals={0} expanded={true}>
						</UiNumber>
					</UiBlock>
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a178247398" layout="vertical">
						<UiMaterialIcon context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1397110996" visible={false} icon="KeyboardArrowRight">
						</UiMaterialIcon>
					</UiBlock>
				</UiBlock>
			</div>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(SourceLevelListItem));
DisplayFactory.register("SourceLevelListItem", withStyles(styles, { withTheme: true })(withSnackbar(SourceLevelListItem)));