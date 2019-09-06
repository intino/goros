import React from "react";
import UiStamp from "alexandria-ui-elements/src/displays/components/Stamp";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiBlockDrawer from "alexandria-ui-elements/src/displays/components/BlockDrawer";
import UiOpenDrawer from "alexandria-ui-elements/src/displays/components/OpenDrawer";
import UiCloseDrawer from "alexandria-ui-elements/src/displays/components/CloseDrawer";
import UiDivider from "alexandria-ui-elements/src/displays/components/Divider";
import UiSelectorListBox from "alexandria-ui-elements/src/displays/components/SelectorListBox";
import UiHeader from "alexandria-ui-elements/src/displays/components/Header";
import UiSelectorTabs from "alexandria-ui-elements/src/displays/components/SelectorTabs";
import UiMultiple from "alexandria-ui-elements/src/displays/components/Multiple";
import DisplaysDrawerOption from "app-elements/src/displays/templates/DrawerOption";
import DisplaysHeader from "app-elements/src/displays/templates/Header";
import DisplaysView from "app-elements/src/displays/templates/View";
import DisplaysFooter from "app-elements/src/displays/templates/Footer";
import DisplaysNodePage from "../../../src/displays/templates/NodePage";
import Notifier from "../notifiers/Notifier";
import Requester from "../requesters/Requester";

export default class AbstractDesktopPage extends DisplaysNodePage {

	constructor(props) {
		super(props);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
		return(
			<UiBlock layout="vertical flexible" width="100.0%" height="100.0%" style={{...this.props.style,...display}}>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="wR" layout="horizontal flexible" width="100.0%" height="100.0%">
					<UiBlockDrawer context={this._context.bind(this)} owner={this._owner.bind(this)} id="x9" layout="vertical" width="200px" height="-1px" position="Left" variant="PersistentAndMini">
						<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="y7" layout="horizontal endjustified center" width="-1px" height="60px">
							<UiOpenDrawer context={this._context.bind(this)} owner={this._owner.bind(this)} id="zY" title="open menu" target="self" mode="MaterialIconButton" icon="ChevronRight" size="Medium" format="airMenuRight">
							</UiOpenDrawer>
							<UiCloseDrawer context={this._context.bind(this)} owner={this._owner.bind(this)} id="AO" title="minimize" target="self" mode="MaterialIconButton" icon="ChevronLeft" size="Medium" format="airMenuRight">
							</UiCloseDrawer>
						</UiBlock>
						<UiDivider context={this._context.bind(this)} owner={this._owner.bind(this)} id="BX">
						</UiDivider>
						<UiSelectorListBox context={this._context.bind(this)} owner={this._owner.bind(this)} id="Dx" multipleSelection={false}>
						</UiSelectorListBox>
						<DisplaysDrawerOption context={this._context.bind(this)} owner={this._owner.bind(this)} id="Ev">
						</DisplaysDrawerOption>
					</UiBlockDrawer>
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="G7" layout="vertical" width="100.0%" height="100.0%">
						<UiHeader context={this._context.bind(this)} owner={this._owner.bind(this)} id="J2" format="air" color="white" position="relative" width="-1px" height="65px" elevation={0}>
							<DisplaysHeader context={this._context.bind(this)} owner={this._owner.bind(this)} id="KR">
							</DisplaysHeader>
						</UiHeader>
						<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="Lw" layout="vertical flexible">
							<UiSelectorTabs context={this._context.bind(this)} owner={this._owner.bind(this)} id="MA" multipleSelection={false}>
							</UiSelectorTabs>
							<UiMultiple context={this._context.bind(this)} owner={this._owner.bind(this)} id="N6" multiple={{instances:"views",arrangement:"Vertical",noItemsMessage:"",spacing:0}}>
							</UiMultiple>
						</UiBlock>
						<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="Op" layout="vertical">
							<DisplaysFooter context={this._context.bind(this)} owner={this._owner.bind(this)} id="Pw">
							</DisplaysFooter>
						</UiBlock>
					</UiBlock>
				</UiBlock>
			</UiBlock>
		);
	}
}