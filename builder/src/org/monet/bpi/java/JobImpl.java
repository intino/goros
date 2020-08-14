package org.monet.bpi.java;

import org.monet.bpi.*;
import org.monet.bpi.types.Date;
import org.monet.bpi.types.Location;

public class JobImpl extends TaskImpl implements Job, BehaviorJob {

	@Override
	public void onArrivePlace(String placeCode) {

	}

	@Override
	public void onTimeoutPlace(String placeCode, String actionCode) {

	}

	@Override
	public void onTakePlace(String placeCode, String actionCode, String routeCode) {

	}

	@Override
	public void onSolveAction(String placeCode, String actionCode, Node form) {

	}

	@Override
	public void onCreateJobAction(String placeCode, String actionCode, JobRequest msg) {

	}

	@Override
	public void onCreatedJobAction(String placeCode, String actionCode, Job instance) {

	}

	@Override
	public void onFinishedJobAction(String placeCode, String actionCode, JobResponse msg) {

	}

	@Override
	public void onSelectDelegationRole(String placeCode, String actionCode, RoleChooser roleChooser) {

	}

	@Override
	public void onSetupDelegation(String placeCode, String actionCode, DelegationSetup delegationSetup) {

	}

	@Override
	public void onSetupWait(String placeCode, String actionCode, WaitSetup waitSetup) {

	}

	@Override
	public void onSetupTimeout(String placeCode, String actionCode, TimeoutSetup timeoutSetup) {

	}

	@Override
	public void onSetupDelegationComplete(String placeCode, String actionCode, String provider, Date suggestedStartDate, Date suggestedEndDate, String observations, boolean urgent) {

	}

	@Override
	public void onSetupEdition(String placeCode, String actionCode, Node form) {

	}

	@Override
	public void onSelectJobRole(String placeCode, String actionCode, RoleChooser roleChooser) {

	}

	@Override
	public void onSelectJobRoleComplete(String placeCode, String actionCode, Role role) {

	}

	@Override
	public void onSetupJob(String placeCode, String actionCode, JobSetup jobSetup) {

	}

	@Override
	public void onSetupJobComplete(String placeCode, String actionCode, String provider, Date suggestedStartDate, Date suggestedEndDate, String observations, boolean urgent) {

	}

	@Override
	public void onValidateForm(String placeCode, String actionCode, Node form, ValidationResult validationResult) {

	}

	@Override
	public boolean onIsBackEnable(String placeCode, String actionCode) {
		return false;
	}

	@Override
	public void onBack(String placeCode, String actionCode) {

	}

	@Override
	public String onCalculateClassificatorPlace(String placeCode, String actionCode) {
		return null;
	}

	@Override
	public Location getLocation() {
		return null;
	}

	@Override
	public void setLocation(Location location) {

	}
}
