package org.monet.bpi.java;

import org.monet.bpi.*;
import org.monet.bpi.types.Date;
import org.monet.bpi.types.Link;
import org.monet.bpi.types.Location;

import java.util.List;
import java.util.Map;

public abstract class NodeImpl implements Node, BehaviorNode {

	@Override
	public User getAuthor() {
		return null;
	}

	@Override
	public String getOwnerId() {
		return null;
	}

	@Override
	public void addPermission(String userId) {
		addPermission(userId, new Date());
	}

	@Override
	public void addPermission(User user) {
		addPermission(user.getId());
	}

	@Override
	public void addPermission(String userId, Date beginDate) {
		addPermission(userId, beginDate, null);
	}

	@Override
	public void addPermission(User user, Date beginDate) {
		addPermission(user.getId(), beginDate);
	}

	@Override
	public void addPermission(String userId, Date beginDate, Date endDate) {
	}

	@Override
	public void addPermission(User user, Date beginDate, Date endDate) {
		addPermission(user.getId(), beginDate, endDate);
	}

	@Override
	public boolean hasPermission(String userId) {
		return false;
	}

	@Override
	public boolean hasPermission(User user) {
		return hasPermission(user.getId());
	}

	@Override
	public void deletePermission(String userId) {
	}

	@Override
	public void deletePermission(User user) {
		deletePermission(user.getId());
	}

	@Override
	public Node getOwner() {
		return null;
	}

	@Override
	public void setOwner(Node owner) {
	}

	@Override
	public boolean isPrototype() {
		return false;
	}

	public Node getPrototypeNode() {
		return null;
	}

	@Override
	public boolean isGeoReferenced() {
		return false;
	}

	@Override
	public String getCode() {
		return null;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public String getLabel() {
		return null;
	}

	@Override
	public void setLabel(String label) {
	}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public void setDescription(String description) {
	}

	@Override
	public String getColor() {
		return null;
	}

	@Override
	public void setColor(String color) {
	}

	protected IndexEntry getIndexEntry(String name) {
		return null;
	}

	@Override
	public Map<String, String> getFlags() {
		return null;
	}

	@Override
	public String getFlag(String name) {
		return null;
	}

	@Override
	public void setFlag(String name, String value) {
	}

	@Override
	public void removeFlag(String name) {
	}

	@Override
	public String getNote(String name) {
		return null;
	}

	@Override
	public void setNote(String name, String value) {
	}

	@Override
	public void removeNote(String name) {
	}

	@Override
	public void save() {
	}

	@Override
	public void lock() {
	}

	@Override
	public void unLock() {
	}

	@Override
	public boolean isLocked() {
		return false;
	}

	@Override
	public String getPartnerContext() {
		return null;
	}

	@Override
	public void setPartnerContext(String context) {
	}

	@Override
	public void setEditable(boolean value) {
	}

	@Override
	public boolean isEditable() {
		return false;
	}

	@Override
	public void setDeletable(boolean value) {
	}

	@Override
	public boolean isDeletable() {
		return false;
	}

	@Override
	public Location getLocation() {
		return null;
	}

	@Override
	public void setLocation(Location bpiLocation) {
	}

	public Link toLink() {
		return null;
	}

	public MonetLink toMonetLink() {
		return null;
	}

	public MonetLink toMonetLink(boolean editMode) {
		return null;
	}

	protected void setFlag(String ruleCode, org.monet.metamodel.NodeDefinitionBase.RuleNodeProperty.AddFlagEnumeration flag) {
	}

	@Override
	public Node clone(Node bpiParent) {
		return null;
	}

	@Override
	public List<Node> getLinksIn() {
		return null;
	}

	@Override
	public List<Node> getLinksOut() {
		return null;
	}

	@Override
	public List<Task> getLinkedTasks() {
		return null;
	}

	@Override
	public void merge(Node source) {
	}

	@Override
	public void constructor() {
	}

	@Override
	public void onOpened() {
	}

	@Override
	public void onClosed() {
	}

	@Override
	public void onSave() {
	}

	@Override
	public void onSaved() {
	}

	@Override
	public void onSetContext() {
	}

	@Override
	public void onRemoved() {
	}

	@Override
	public void executeCommand(String operation) {
	}

	@Override
	public boolean executeCommandConfirmationWhen(String operation) {
		return false;
	}

	@Override
	public void executeCommandConfirmationOnCancel(String operation) {
	}

}
