package io.intino.goros.unit.box.actions;

import io.intino.goros.unit.box.UnitBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

import io.intino.goros.unit.box.schemas.*;
import org.monet.metamodel.ContainerDefinition;
import org.monet.metamodel.Definition;
import org.monet.metamodel.DefinitionBase;
import org.monet.metamodel.FormDefinition;
import org.monet.space.kernel.model.Dictionary;


public class GetDefinitionsAction {
	public UnitBox box;
	public io.intino.alexandria.http.spark.SparkContext context;

	public List<io.intino.goros.unit.box.schemas.Definition> execute() {
		Dictionary dictionary = Dictionary.getInstance();
		List<Definition> definitionList = dictionary.getAllDefinitions().stream().filter(GetDefinitionsAction::isGeoreferencedDefinition).collect(Collectors.toList());
		return definitionList.stream().map(this::definitionOf).collect(Collectors.toList());
	}

	private io.intino.goros.unit.box.schemas.Definition definitionOf(Definition d) {
		io.intino.goros.unit.box.schemas.Definition result = new io.intino.goros.unit.box.schemas.Definition();
		result.name(d.getName());
		return result;
	}


	private static boolean isGeoreferencedDefinition(Definition definition) {
		if (definition instanceof ContainerDefinition) return ((ContainerDefinition)definition).isGeoreferenced();
		if (definition instanceof FormDefinition) return ((FormDefinition)definition).isGeoreferenced();
		return false;
	}

	public void onMalformedRequest(Throwable e) {
	}
}