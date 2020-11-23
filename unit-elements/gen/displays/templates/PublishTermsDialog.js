import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiSelectorCheckBox from "alexandria-ui-elements/src/displays/components/SelectorCheckBox";
import UiAction from "alexandria-ui-elements/src/displays/components/Action";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import PublishTermsDialogNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import PublishTermsDialogRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class PublishTermsDialog extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new PublishTermsDialogNotifier(this);
		this.requester = new PublishTermsDialogRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock layout="vertical" style={{...this.props.style,...display}}>
				<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a864934770" format="doubleAirBottom middleSpaced leftSpaced rightSpaced" layout="vertical">
					<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_64378376" format="h5 airBottom" mode="normal" translate={true} value="New terms added recently that are not published yet">
					</UiText>
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1563167354" format="bordered dialog" layout="vertical">
						<UiSelectorCheckBox context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1452060588" multipleSelection={false} layout="Horizontal">
						</UiSelectorCheckBox>
						<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a916123763" layout="horizontal">
							<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1415005011" format="airRight" layout="vertical" width="150px" height="-1px">
								<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a504803623" title="Publish" target="self" mode="Button" size="Small" highlighted="Outline">
								</UiAction>
							</UiBlock>
							<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1005060311" layout="vertical" width="150px" height="-1px">
								<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1418736793" title="Publish all" target="self" mode="Button" size="Small" highlighted="Outline">
								</UiAction>
							</UiBlock>
						</UiBlock>
					</UiBlock>
				</UiBlock>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(PublishTermsDialog));
DisplayFactory.register("PublishTermsDialog", withStyles(styles, { withTheme: true })(withSnackbar(PublishTermsDialog)));