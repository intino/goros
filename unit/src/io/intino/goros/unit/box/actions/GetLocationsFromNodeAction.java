package io.intino.goros.unit.box.actions;

import io.intino.goros.unit.box.UnitBox;
import io.intino.alexandria.exceptions.*;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

import io.intino.goros.unit.box.schemas.*;
import org.monet.space.kernel.components.ComponentPersistence;
import org.monet.space.kernel.components.layers.NodeLayer;
import org.monet.space.kernel.model.Dictionary;
import org.monet.space.kernel.model.Node;
import org.monet.space.kernel.model.map.LocationList;

public class GetLocationsFromNodeAction {
	public UnitBox box;
	public io.intino.alexandria.http.spark.SparkContext context;
	public String id;

	public List<io.intino.goros.unit.box.schemas.Location> execute() {

		NodeLayer nodeLayer = ComponentPersistence.getInstance().getNodeLayer();
		if(id == null) return null;
		Node node = nodeLayer.loadNode(id);
		if(node == null) return null;

		org.monet.space.kernel.model.map.Location location = node.getLocation();
		List<org.monet.space.kernel.model.map.Location> result = new ArrayList<>();
		result.add(location);

		return result.stream().map(this::changeType).collect(Collectors.toList());
	}

	private io.intino.goros.unit.box.schemas.Location changeType(org.monet.space.kernel.model.map.Location l) {
		io.intino.goros.unit.box.schemas.Location result = new io.intino.goros.unit.box.schemas.Location();
		List attributes = new ArrayList<>();

		for (var entry : l.getAttributes().entrySet()) {
			io.intino.goros.unit.box.schemas.Attribute attribute = new io.intino.goros.unit.box.schemas.Attribute();
			attribute.name(entry.getKey());
			attribute.value(entry.getValue());
			attributes.add(attribute);
		}
		result.attributes(attributes);
		result.name(l.getLabel());
		result.latitude(l.getGeometry().getCentroid().getCoordinate().x);
		result.longitude(l.getGeometry().getCentroid().getCoordinate().y);
		return result;
	}

}