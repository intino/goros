import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiOpenDialog from "alexandria-ui-elements/src/displays/components/OpenDialog";
import UiDialog from "alexandria-ui-elements/src/displays/components/Dialog";
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiSelectorComboBox from "alexandria-ui-elements/src/displays/components/SelectorComboBox";
import UiDateEditable from "alexandria-ui-elements/src/displays/components/DateEditable";
import UiBlockConditional from "alexandria-ui-elements/src/displays/components/BlockConditional";
import UiSearchBox from "alexandria-ui-elements/src/displays/components/SearchBox";
import UiTable from "alexandria-ui-elements/src/displays/components/Table";
import UiHeading from "alexandria-ui-elements/src/displays/components/Heading";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
import UiDivider from "alexandria-ui-elements/src/displays/components/Divider";
import UiCloseDialog from "alexandria-ui-elements/src/displays/components/CloseDialog";
import UiAction from "alexandria-ui-elements/src/displays/components/Action";
import DisplaysAssignTaskDialogTableRow from "unit-elements/gen/displays/rows/AssignTaskDialogTableRow";
import DisplaysAssignTaskDialogTableFullnameItem from "unit-elements/gen/displays/items/AssignTaskDialogTableFullnameItem";
import DisplaysAssignTaskDialogTableEmailItem from "unit-elements/gen/displays/items/AssignTaskDialogTableEmailItem";
import DisplaysTrashTableRow from "unit-elements/gen/displays/rows/TrashTableRow";
import DisplaysTrashTableTypeItem from "unit-elements/gen/displays/items/TrashTableTypeItem";
import DisplaysTrashTableLabelItem from "unit-elements/gen/displays/items/TrashTableLabelItem";
import DisplaysTrashTableDeleteDateItem from "unit-elements/gen/displays/items/TrashTableDeleteDateItem";
import DisplaysTrashTableOperationsItem from "unit-elements/gen/displays/items/TrashTableOperationsItem";
import DisplaysRolesTableRow from "unit-elements/gen/displays/rows/RolesTableRow";
import DisplaysRolesTableUserItem from "unit-elements/gen/displays/items/RolesTableUserItem";
import DisplaysRolesTableDefinitionItem from "unit-elements/gen/displays/items/RolesTableDefinitionItem";
import DisplaysRolesTableTypeItem from "unit-elements/gen/displays/items/RolesTableTypeItem";
import DisplaysRolesTableNatureItem from "unit-elements/gen/displays/items/RolesTableNatureItem";
import DisplaysRolesTableStartDateItem from "unit-elements/gen/displays/items/RolesTableStartDateItem";
import DisplaysRolesTableEndDateItem from "unit-elements/gen/displays/items/RolesTableEndDateItem";
import DisplaysRolesTableOperationsItem from "unit-elements/gen/displays/items/RolesTableOperationsItem";
import DisplaysAddRoleUserTableRow from "unit-elements/gen/displays/rows/AddRoleUserTableRow";
import DisplaysAddRoleUserTableFullnameItem from "unit-elements/gen/displays/items/AddRoleUserTableFullnameItem";
import DisplaysAddRoleUserTableEmailItem from "unit-elements/gen/displays/items/AddRoleUserTableEmailItem";
import DisplaysAddRoleServiceTableRow from "unit-elements/gen/displays/rows/AddRoleServiceTableRow";
import DisplaysAddRoleServiceTableLabelItem from "unit-elements/gen/displays/items/AddRoleServiceTableLabelItem";
import DisplaysAddRoleServiceTablePartnerItem from "unit-elements/gen/displays/items/AddRoleServiceTablePartnerItem";
import DisplaysAddRoleFeederTableRow from "unit-elements/gen/displays/rows/AddRoleFeederTableRow";
import DisplaysAddRoleFeederTableLabelItem from "unit-elements/gen/displays/items/AddRoleFeederTableLabelItem";
import DisplaysAddRoleFeederTablePartnerItem from "unit-elements/gen/displays/items/AddRoleFeederTablePartnerItem";
import DisplaysLinksInTableRow from "unit-elements/gen/displays/rows/LinksInTableRow";
import DisplaysLinksInTableLabelItem from "unit-elements/gen/displays/items/LinksInTableLabelItem";
import DisplaysLinksInTableDescriptionItem from "unit-elements/gen/displays/items/LinksInTableDescriptionItem";
import DisplaysLinksOutTableRow from "unit-elements/gen/displays/rows/LinksOutTableRow";
import DisplaysLinksOutTableLabelItem from "unit-elements/gen/displays/items/LinksOutTableLabelItem";
import DisplaysLinksOutTableDescriptionItem from "unit-elements/gen/displays/items/LinksOutTableDescriptionItem";
import DisplaysNodeRevisionsTableRow from "unit-elements/gen/displays/rows/NodeRevisionsTableRow";
import DisplaysNodeRevisionsTableLabelItem from "unit-elements/gen/displays/items/NodeRevisionsTableLabelItem";
import DisplaysNodeRevisionsTableOperationsItem from "unit-elements/gen/displays/items/NodeRevisionsTableOperationsItem";
import DisplaysNodeNotesTableRow from "unit-elements/gen/displays/rows/NodeNotesTableRow";
import DisplaysNodeNotesTableNameItem from "unit-elements/gen/displays/items/NodeNotesTableNameItem";
import DisplaysNodeNotesTableValueItem from "unit-elements/gen/displays/items/NodeNotesTableValueItem";
import DisplaysNodeNotesTableOperationsItem from "unit-elements/gen/displays/items/NodeNotesTableOperationsItem";
import DisplaysTasksTableRow from "unit-elements/gen/displays/rows/TasksTableRow";
import DisplaysTasksTableLabelItem from "unit-elements/gen/displays/items/TasksTableLabelItem";
import DisplaysTasksTableDescriptionItem from "unit-elements/gen/displays/items/TasksTableDescriptionItem";
import DisplaysTasksTableOwnerItem from "unit-elements/gen/displays/items/TasksTableOwnerItem";
import DisplaysTasksTableCreateDateItem from "unit-elements/gen/displays/items/TasksTableCreateDateItem";
import DisplaysTasksTableUpdateDateItem from "unit-elements/gen/displays/items/TasksTableUpdateDateItem";
import DisplaysTasksTableCountMessagesItem from "unit-elements/gen/displays/items/TasksTableCountMessagesItem";
import DisplaysTasksTableOperationsItem from "unit-elements/gen/displays/items/TasksTableOperationsItem";
import UiTemplate from "alexandria-ui-elements/src/displays/components/Template";
import RolesToolbarTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import RolesToolbarTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class RolesToolbarTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new RolesToolbarTemplateNotifier(this);
		this.requester = new RolesToolbarTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock format="air" layout="horizontal" style={{...this.props.style,...display}}>
				<UiOpenDialog context={this._context.bind(this)} owner={this._owner.bind(this)} id="a763156980" title="Add role" target="self" mode="Button" size="Small" highlighted="Outline">
				</UiOpenDialog>
				<UiDialog context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1615998441" title="Add role" width="60.0%" height="80.0%">
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_584538543" layout="vertical flexible" width="100.0%" height="calc(100% - 50px)">
						<UiSelectorComboBox context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_268899224" label="Type" format="doubleAirBottom" multipleSelection={false} placeholder="Select type">
						</UiSelectorComboBox>
						<UiSelectorComboBox context={this._context.bind(this)} owner={this._owner.bind(this)} id="a2125494273" label="Class" format="doubleAirBottom" multipleSelection={false} placeholder="Select class">
						</UiSelectorComboBox>
						<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a522332155" format="airBottom" layout="horizontal">
							<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_148299243" layout="vertical" width="50.0%" height="100.0%">
								<UiDateEditable context={this._context.bind(this)} owner={this._owner.bind(this)} id="a508829073" label="Start date" format="airRight" pattern="DD/MM/YYYY">
								</UiDateEditable>
							</UiBlock>
							<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_802160724" layout="vertical" width="50.0%" height="100.0%">
								<UiDateEditable context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1057297924" label="End date" pattern="DD/MM/YYYY" allowEmpty={true}>
								</UiDateEditable>
							</UiBlock>
						</UiBlock>
						<UiBlockConditional context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_985396034" layout="vertical flexible">
							<UiSearchBox context={this._context.bind(this)} owner={this._owner.bind(this)} id="a728276930">
							</UiSearchBox>
							<UiTable context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_633276115" format="bordered" noItemsMessage="No users" pageSize={20} itemHeight={30} scrollingMark={false} selection="single">
								<UiHeading context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_76222253" style={{width:"40%",paddingRight:"10px",paddingLeft:"10px"}} hidden="Never">
									<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a364857027" mode="normal" translate={true} value="Fullname">
									</UiText>
								</UiHeading>
								<UiHeading context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_435973000" style={{width:"60%",paddingRight:"10px"}} hidden="Never">
									<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a608804218" mode="normal" translate={true} value="Email">
									</UiText>
								</UiHeading>
							</UiTable>
						</UiBlockConditional>
						<UiBlockConditional context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_972076368" layout="vertical flexible">
							<UiSearchBox context={this._context.bind(this)} owner={this._owner.bind(this)} id="a891760043">
							</UiSearchBox>
							<UiTable context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_278905759" format="bordered" noItemsMessage="No service partners available" pageSize={20} itemHeight={30} scrollingMark={false} selection="single">
								<UiHeading context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1422311339" style={{width:"40%",paddingRight:"10px",paddingLeft:"10px"}} hidden="Never">
									<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_499330695" mode="normal" translate={true} value="Name">
									</UiText>
								</UiHeading>
								<UiHeading context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1973385020" style={{width:"60%",paddingRight:"10px"}} hidden="Never">
									<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_559951635" mode="normal" translate={true} value="Partner">
									</UiText>
								</UiHeading>
							</UiTable>
						</UiBlockConditional>
						<UiBlockConditional context={this._context.bind(this)} owner={this._owner.bind(this)} id="a63732030" layout="vertical flexible">
							<UiSearchBox context={this._context.bind(this)} owner={this._owner.bind(this)} id="a2118691340">
							</UiSearchBox>
							<UiTable context={this._context.bind(this)} owner={this._owner.bind(this)} id="a629248813" format="bordered" noItemsMessage="No feeder partners available" pageSize={20} itemHeight={30} scrollingMark={false} selection="single">
								<UiHeading context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_845718845" style={{width:"40%",paddingRight:"10px",paddingLeft:"10px"}} hidden="Never">
									<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a482658956" mode="normal" translate={true} value="Name">
									</UiText>
								</UiHeading>
								<UiHeading context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_2142011008" style={{width:"60%",paddingRight:"10px"}} hidden="Never">
									<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1091305302" mode="normal" translate={true} value="Partner">
									</UiText>
								</UiHeading>
							</UiTable>
						</UiBlockConditional>
					</UiBlock>
					<UiDivider context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1817823830">
					</UiDivider>
					<UiBlock context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_118849437" layout="horizontal endjustified">
						<UiCloseDialog context={this._context.bind(this)} owner={this._owner.bind(this)} id="a685013139" title="Cancel" target="self" mode="Button" size="Medium" format="airRight">
						</UiCloseDialog>
						<UiAction context={this._context.bind(this)} owner={this._owner.bind(this)} id="a629276449" title="OK" target="self" mode="Button" size="Medium" highlighted="Fill">
						</UiAction>
					</UiBlock>
				</UiDialog>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(RolesToolbarTemplate));
DisplayFactory.register("RolesToolbarTemplate", withStyles(styles, { withTheme: true })(withSnackbar(RolesToolbarTemplate)));