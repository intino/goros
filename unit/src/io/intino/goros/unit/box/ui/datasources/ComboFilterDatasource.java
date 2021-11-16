package io.intino.goros.unit.box.ui.datasources;

import io.intino.alexandria.ui.displays.components.Collection;
import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import io.intino.alexandria.ui.services.push.UISession;
import io.intino.goros.unit.box.UnitBox;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ComboFilterDatasource extends PageDatasource<String> {
	private final UnitBox box;
	private final UISession session;
	private final Collection collection;
	private final String attribute;

	public ComboFilterDatasource(UnitBox box, UISession session, Collection collection, String attribute) {
		this.box = box;
		this.session = session;
		this.collection = collection;
		this.attribute = attribute;
	}

	@Override
	public List<String> items(int start, int count, String condition, List<Filter> filters, List<String> sortings) {
		List<Group> result = collection.source().groups(attribute);
		result = condition != null ? result.stream().filter(g -> g.label().toLowerCase().contains(condition.toLowerCase())).collect(Collectors.toList()) : result;
		int from = Math.min(start, result.size());
		int end = Math.min(start + count, result.size());
		return result.subList(from, end).stream().map(Group::label).collect(Collectors.toList());
	}

	@Override
	public long itemCount(String condition, List<Filter> filters) {
		return collection.source().groups(attribute).size();
	}

	@Override
	public List<Group> groups(String key) {
		return Collections.emptyList();
	}

}
