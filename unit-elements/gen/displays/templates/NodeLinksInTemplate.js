import React from "react";
import { withStyles } from '@material-ui/core/styles';
import UiBlock from "alexandria-ui-elements/src/displays/components/Block";
import UiTable from "alexandria-ui-elements/src/displays/components/Table";
import UiHeading from "alexandria-ui-elements/src/displays/components/Heading";
import UiText from "alexandria-ui-elements/src/displays/components/Text";
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
import NodeLinksInTemplateNotifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";
import NodeLinksInTemplateRequester from "alexandria-ui-elements/gen/displays/requesters/TemplateRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class NodeLinksInTemplate extends UiTemplate {

	constructor(props) {
		super(props);
		this.notifier = new NodeLinksInTemplateNotifier(this);
		this.requester = new NodeLinksInTemplateRequester(this);
	};

	render() {
	    const display = !this.state.visible ? {display:'none'} : undefined;
	    const className = "layout vertical center-justified" + (this.hiddenClass() !== "" ? " " + this.hiddenClass() : "");
		return(
			<UiBlock layout="vertical" width="100.0%" height="100.0%" style={{...this.props.style,...display}}>
				<UiTable context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1124382024" format="bordered" noItemsMessage="No hay elementos que lo relacionen" pageSize={20} itemHeight={50} scrollingMark={false}>
					<UiHeading context={this._context.bind(this)} owner={this._owner.bind(this)} id="a_1289219689" style={{width:"40%",paddingRight:"10px",paddingLeft:"10px"}} hidden="Never">
						<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a165999372" mode="normal" value="Título">
						</UiText>
					</UiHeading>
					<UiHeading context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1141824812" style={{width:"60%",paddingRight:"10px"}} hidden="Never">
						<UiText context={this._context.bind(this)} owner={this._owner.bind(this)} id="a1107571963" mode="normal" value="Descripción">
						</UiText>
					</UiHeading>
				</UiTable>
			</UiBlock>
		);
	}


}

export default withStyles(styles, { withTheme: true })(withSnackbar(NodeLinksInTemplate));
DisplayFactory.register("NodeLinksInTemplate", withStyles(styles, { withTheme: true })(withSnackbar(NodeLinksInTemplate)));