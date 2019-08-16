package org.siani.goros.graph;

import io.intino.tara.magritte.Graph;

public class AbstractGraph extends io.intino.tara.magritte.GraphWrapper {

	protected io.intino.tara.magritte.Graph graph;
	private java.util.List<org.siani.goros.graph.BusinessUnit> businessUnitList = new java.util.ArrayList<>();

	private java.util.Map<String, Indexer> _index = _fillIndex();

	public AbstractGraph(io.intino.tara.magritte.Graph graph) {
		this.graph = graph;
		this.graph.i18n().register("goros");
	}

	public AbstractGraph(io.intino.tara.magritte.Graph graph, AbstractGraph wrapper) {
		this.graph = graph;
		this.graph.i18n().register("goros");
		this.businessUnitList = new java.util.ArrayList<>(wrapper.businessUnitList);
	}

	public <T extends io.intino.tara.magritte.GraphWrapper> T a$(Class<T> t) {
		return this.core$().as(t);
	}

    @Override
	public void update() {
		this._index.values().forEach(v -> v.clear());
		graph.rootList().forEach(r -> addNode$(r));
	}

	@Override
	protected void addNode$(io.intino.tara.magritte.Node node) {
		for (io.intino.tara.magritte.Concept c : node.conceptList()) if (this._index.containsKey(c.id())) this._index.get(c.id()).add(node);
		if (this._index.containsKey(node.id())) this._index.get(node.id()).add(node);
	}

	@Override
	protected void removeNode$(io.intino.tara.magritte.Node node) {
		for (io.intino.tara.magritte.Concept c : node.conceptList()) if (this._index.containsKey(c.id())) this._index.get(c.id()).remove(node);
		if (this._index.containsKey(node.id())) this._index.get(node.id()).remove(node);
	}

	public java.net.URL resourceAsMessage$(String language, String key) {
		return graph.loadResource(graph.i18n().message(language, key));
	}

	public java.util.List<org.siani.goros.graph.BusinessUnit> businessUnitList() {
		return businessUnitList;
	}

	public java.util.stream.Stream<org.siani.goros.graph.BusinessUnit> businessUnitList(java.util.function.Predicate<org.siani.goros.graph.BusinessUnit> filter) {
		return businessUnitList.stream().filter(filter);
	}

	public org.siani.goros.graph.BusinessUnit businessUnit(int index) {
		return businessUnitList.get(index);
	}

	public io.intino.tara.magritte.Graph core$() {
		return graph;
	}

	public io.intino.tara.magritte.utils.I18n i18n$() {
		return graph.i18n();
	}

	public Create create() {
		return new Create("Misc", null);
	}

	public Create create(String stash) {
		return new Create(stash, null);
	}

	public Create create(String stash, String name) {
		return new Create(stash, name);
	}

	public Clear clear() {
		return new Clear();
	}

	public class Create {
		private final String stash;
		private final String name;

		public Create(String stash, String name) {
			this.stash = stash;
			this.name = name;
		}
	}

	public class Clear {
	}


	private java.util.HashMap<String, Indexer> _fillIndex() {
		java.util.HashMap<String, Indexer> map = new java.util.HashMap<>();
		map.put("BusinessUnit", new Indexer(node -> businessUnitList.add(node.as(org.siani.goros.graph.BusinessUnit.class)), node -> businessUnitList.remove(node.as(org.siani.goros.graph.BusinessUnit.class)), () -> businessUnitList.clear()));
		return map;
	}

	public static class Indexer {
		Add add;
		Remove remove;
		IndexClear clear;

		public Indexer(Add add, Remove remove, IndexClear clear) {
			this.add = add;
			this.remove = remove;
			this.clear = clear;
		}

		void add(io.intino.tara.magritte.Node node) {
			this.add.add(node);
		}

		void remove(io.intino.tara.magritte.Node node) {
			this.remove.remove(node);
		}

		void clear() {
			this.clear.clear();
		}
	}

	interface Add {
		void add(io.intino.tara.magritte.Node node);
	}

	interface Remove {
		void remove(io.intino.tara.magritte.Node node);
	}

	interface IndexClear {
		void clear();
	}
}