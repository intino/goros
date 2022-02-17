package io.intino.goros.unit.box.actions;

import io.intino.goros.unit.box.UnitBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

import io.intino.goros.unit.box.schemas.*;
import org.monet.metamodel.*;
import org.monet.metamodel.Definition;
import org.monet.space.kernel.components.ComponentPersistence;
import org.monet.space.kernel.components.layers.NodeLayer;
import org.monet.space.kernel.model.Dictionary;
import org.monet.space.kernel.model.Node;
import org.monet.space.kernel.model.map.LocationList;

public class GetLocationsByOwnerAction {
	public UnitBox box;
	public io.intino.alexandria.http.spark.SparkContext context;
	public String owner;
	public String name;

	public List<io.intino.goros.unit.box.schemas.Location> execute() {
		org.monet.space.kernel.model.Dictionary dictionary = Dictionary.getInstance();
		List<org.monet.metamodel.Definition> definitionList = dictionary.getAllDefinitions().stream().filter(GetLocationsByOwnerAction::isGeoreferencedDefinition).collect(Collectors.toList());
		if(name == null || name == "" ) return null;

		org.monet.metamodel.Definition definition = definitionList.stream().filter(d -> sameName(d,name)).findFirst().orElse(null);
		if(definition == null) definition = definitionList.stream().filter(d -> sameLabel(d,name)).findFirst().orElse(null);
		if(definition == null) return null;

		String code = definition.getCode();
		NodeLayer nodeLayer = ComponentPersistence.getInstance().getNodeLayer();
		LocationList locations = nodeLayer.loadLocations(code, owner);

		List<org.monet.space.kernel.model.map.Location> result = new ArrayList<>();
		locations.forEach(result::add);
		NodeDefinition nodeDefinition = Dictionary.getInstance().getNodeDefinition(code);
		IndexDefinition indexDefinition = Dictionary.getInstance().locateIndex(nodeDefinition);
		return result.stream().map((org.monet.space.kernel.model.map.Location l) -> changeType(l,indexDefinition)).collect(Collectors.toList());
	}
	private boolean sameName(org.monet.metamodel.Definition definition, String name) {
		return definition.getName().equals(name);
	}

	private boolean sameLabel(org.monet.metamodel.Definition definition, String name) {
		return definition.getLabel().equals(name);
	}

	private static boolean isGeoreferencedDefinition(Definition definition) {
		if (definition instanceof ContainerDefinition) return ((ContainerDefinition)definition).isGeoreferenced();
		if (definition instanceof FormDefinition) return ((FormDefinition)definition).isGeoreferenced();
		return false;
	}

	private io.intino.goros.unit.box.schemas.Location changeType(org.monet.space.kernel.model.map.Location l, IndexDefinition indexDefinition) {
		io.intino.goros.unit.box.schemas.Location result = new io.intino.goros.unit.box.schemas.Location();
		List attributes = new ArrayList<>();
		result.id(l.getNodeId());
		for (var entry : l.getAttributes().entrySet()) {
			io.intino.goros.unit.box.schemas.Attribute attribute = new io.intino.goros.unit.box.schemas.Attribute();
			attribute.name(entry.getKey());
			attribute.label(indexDefinition.getAttribute(entry.getKey()).getLabel().toString());
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