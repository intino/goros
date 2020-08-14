package org.monet.bpi.java;

import org.monet.bpi.Node;
import org.monet.bpi.NodeService;

public class NodeServiceImpl extends NodeService {

	@Override
	protected Node locateImpl(String name) {
		return null;
	}

	@Override
	protected Node getImpl(String nodeId) {
		return null;
	}

	@Override
	protected String getKmlLayerImpl(String nodeId) {
		return null;
	}

	@Override
	protected Node createImpl(Class<? extends Node> nodeClass, Node parent) {
		return null;
	}

	@Override
	protected Node createImpl(String name, Node parent) {
		return null;
	}
}
