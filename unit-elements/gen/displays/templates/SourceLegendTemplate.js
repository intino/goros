import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import SourceLegendTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import SourceLegendTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class SourceLegendTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new SourceLegendTemplateNotifier(this);
		this.requester = new SourceLegendTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock layout="horizontal center" style={{...this.props.style,...display}}>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a10049985" format="doubleAirRight" layout="horizontal center">
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a2145093129" format="body2 legendPillStyle middleAirRight" mode="normal" value="C" highlighted={{text:"white",background:"#4CAF50"}}>
					</UiText>
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_905133580" format="body2" mode="normal" translate={true} value="Category">
					</UiText>
				</UiBlock>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a2088874150" format="doubleAirRight" layout="horizontal center">
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1856495025" format="body2 legendPillStyle middleAirRight" mode="normal" value="S" highlighted={{text:"white",background:"#2896F3"}}>
					</UiText>
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a854109390" format="body2" mode="normal" translate={true} value="Selectable">
					</UiText>
				</UiBlock>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_237550838" format="doubleAirRight" layout="horizontal center">
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1855445049" format="body2 legendPillStyle middleAirRight" mode="normal" value="T" highlighted={{text:"white",background:"#272C34"}}>
					</UiText>
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_768339295" format="body2" mode="normal" translate={true} value="Term">
					</UiText>
				</UiBlock>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(SourceLegendTemplate));
DisplayFactory.register("SourceLegendTemplate", withStyles(styles, { withTheme: true })(withSnackbar(SourceLegendTemplate)));