package org.siani.goros.services;

import org.siani.goros.graph.Model;

import java.time.Instant;

public interface SetupService {
	void install(Model businessUnit);
	void update(Model businessUnit);
	void reset(Model businessUnit);
	Status getStatus();
	String getVersion();
	boolean isRunning();
	void run();
	void stop();

	interface Status {
		Instant runningDate();
	}
}
