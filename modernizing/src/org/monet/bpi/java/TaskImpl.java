package org.monet.bpi.java;

import org.monet.bpi.*;
import org.monet.metamodel.internal.Lock;

public abstract class TaskImpl implements Task, BehaviorTask {
	@Override
	public String getId() {
		return null;
	}

	@Override
	public void setLabel(String label) {
	}

	@Override
	public String getLabel() {
		return null;
	}

	@Override
	public void setDescription(String description) {
	}

	@Override
	public void setUrgent(boolean value) {
	}

	@Override
	public boolean isUrgent() {
		return false;
	}

	@Override
	public void setComments(String comments) {
	}

	@Override
	public String getComments() {
		return null;
	}

	protected Node genericGetTarget() {
		return null;
	}

	protected void genericSetTarget(Node target) {
	}

	protected Node getShortCut(String name) {
		return null;
	}

	protected void setShortCut(String name, Node node) {
	}

	protected void removeShortCut(String name) {
	}

	@Override
	public String getFlag(String name) {
		return null;
	}

	@Override
	public boolean isFlagActive(String name) {
		return false;
	}

	@Override
	public void setFlag(String name, String value) {
	}

	@Override
	public void setFlag(String name, boolean value) {
	}

	@Override
	public void removeFlag(String name) {
	}

	@Override
	public void doGoto(String place, String historyText) {
	}

	@Override
	public String currentPlace() {
		return null;
	}

	public void addLog(String title, String text) {
		this.addLog(title, text, (Iterable<MonetLink>) null);
	}

	public void addLog(String title, String text, Iterable<MonetLink> links) {
	}

	@Override
	public void save() {
	}

	@Override
	public void resume() {
	}

	protected void lock(Lock lock) {
	}

	protected void unlock(Lock lock) {
	}

	public void assignTo(User user, String reason) {
	}

	public void free() {
	}

	public void abort() {
	}

	public MonetLink toMonetLink() {
		return null;
	}

	public boolean isFinished() {
		return false;
	}

	public boolean isAborted() {
		return false;
	}

	@Override
	public void onCreate() {
	}

	@Override
	public void onAbort() {
	}

	@Override
	public void onAssign(User user) {
	}

	@Override
	public void onUnassign() {
	}

	@Override
	public void onInitialize() {
	}

	@Override
	public void onTerminate() {
	}

}
