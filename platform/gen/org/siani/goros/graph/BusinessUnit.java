package org.siani.goros.graph;

import org.siani.goros.graph.*;

public class BusinessUnit  extends io.intino.tara.magritte.Layer {
	protected java.lang.String label;
	protected java.lang.String url;
	protected java.net.URL logo;
	protected java.lang.String federationStoreDirectory;
	protected boolean pushEnabled;
	protected boolean debugMode;
	protected int workQueuePeriod;
	protected java.time.Instant installed;
	protected java.time.Instant lastReset;
	protected org.siani.goros.graph.functions.SetupFunction onInstall;
	protected org.siani.goros.graph.functions.SetupFunction onReset;
	protected org.siani.goros.graph.BusinessUnit.BusinessModel businessModel;
	protected org.siani.goros.graph.BusinessUnit.Certificate certificate;
	protected org.siani.goros.graph.BusinessUnit.Database database;
	protected org.siani.goros.graph.BusinessUnit.Mail mail;
	protected org.siani.goros.graph.BusinessUnit.DocumentService documentService;
	protected org.siani.goros.graph.BusinessUnit.Datawarehouse datawarehouse;
	protected org.siani.goros.graph.BusinessUnit.MasterData masterData;
	protected org.siani.goros.graph.BusinessUnit.Maps maps;
	protected org.siani.goros.graph.BusinessUnit.Firebase firebase;

	public BusinessUnit(io.intino.tara.magritte.Node node) {
		super(node);
	}

	public java.lang.String label() {
		return label;
	}

	public java.lang.String url() {
		return url;
	}

	public java.net.URL logo() {
		return logo;
	}

	public java.lang.String federationStoreDirectory() {
		return federationStoreDirectory;
	}

	public boolean pushEnabled() {
		return pushEnabled;
	}

	public boolean debugMode() {
		return debugMode;
	}

	public int workQueuePeriod() {
		return workQueuePeriod;
	}

	public java.time.Instant installed() {
		return installed;
	}

	public java.time.Instant lastReset() {
		return lastReset;
	}

	public void onInstall() {
		 onInstall.execute();
	}

	public void onReset() {
		 onReset.execute();
	}

	public BusinessUnit label(java.lang.String value) {
		this.label = value;
		return (BusinessUnit) this;
	}

	public BusinessUnit url(java.lang.String value) {
		this.url = value;
		return (BusinessUnit) this;
	}

	public BusinessUnit logo(java.net.URL url, String destination) {
		if (url == null) this.logo = null;
		else this.logo = graph().core$().save(url, destination, this.logo, core$());
		return (BusinessUnit) this;
	}

	public BusinessUnit logo(java.io.InputStream stream, String destination) {
		if (stream == null) this.logo = null;
		else this.logo = graph().core$().save(stream, destination, this.logo, core$());
		return (BusinessUnit) this;
	}

	public BusinessUnit federationStoreDirectory(java.lang.String value) {
		this.federationStoreDirectory = value;
		return (BusinessUnit) this;
	}

	public BusinessUnit pushEnabled(boolean value) {
		this.pushEnabled = value;
		return (BusinessUnit) this;
	}

	public BusinessUnit debugMode(boolean value) {
		this.debugMode = value;
		return (BusinessUnit) this;
	}

	public BusinessUnit workQueuePeriod(int value) {
		this.workQueuePeriod = value;
		return (BusinessUnit) this;
	}

	public BusinessUnit installed(java.time.Instant value) {
		this.installed = value;
		return (BusinessUnit) this;
	}

	public BusinessUnit lastReset(java.time.Instant value) {
		this.lastReset = value;
		return (BusinessUnit) this;
	}

	public BusinessUnit onInstall(org.siani.goros.graph.functions.SetupFunction value) {
		this.onInstall = io.intino.tara.magritte.loaders.FunctionLoader.load(onInstall, this, org.siani.goros.graph.functions.SetupFunction.class);
		return (BusinessUnit) this;
	}

	public BusinessUnit onReset(org.siani.goros.graph.functions.SetupFunction value) {
		this.onReset = io.intino.tara.magritte.loaders.FunctionLoader.load(onReset, this, org.siani.goros.graph.functions.SetupFunction.class);
		return (BusinessUnit) this;
	}

	public org.siani.goros.graph.BusinessUnit.BusinessModel businessModel() {
		return businessModel;
	}

	public org.siani.goros.graph.BusinessUnit.Certificate certificate() {
		return certificate;
	}

	public org.siani.goros.graph.BusinessUnit.Database database() {
		return database;
	}

	public org.siani.goros.graph.BusinessUnit.Mail mail() {
		return mail;
	}

	public org.siani.goros.graph.BusinessUnit.DocumentService documentService() {
		return documentService;
	}

	public org.siani.goros.graph.BusinessUnit.Datawarehouse datawarehouse() {
		return datawarehouse;
	}

	public org.siani.goros.graph.BusinessUnit.MasterData masterData() {
		return masterData;
	}

	public org.siani.goros.graph.BusinessUnit.Maps maps() {
		return maps;
	}

	public org.siani.goros.graph.BusinessUnit.Firebase firebase() {
		return firebase;
	}

	protected java.util.List<io.intino.tara.magritte.Node> componentList$() {
		java.util.Set<io.intino.tara.magritte.Node> components = new java.util.LinkedHashSet<>(super.componentList$());
		if (businessModel != null) components.add(this.businessModel.core$());
		if (certificate != null) components.add(this.certificate.core$());
		if (database != null) components.add(this.database.core$());
		if (mail != null) components.add(this.mail.core$());
		if (documentService != null) components.add(this.documentService.core$());
		if (datawarehouse != null) components.add(this.datawarehouse.core$());
		if (masterData != null) components.add(this.masterData.core$());
		if (maps != null) components.add(this.maps.core$());
		if (firebase != null) components.add(this.firebase.core$());
		return new java.util.ArrayList<>(components);
	}

	@Override
	protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
		java.util.Map<String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
		map.put("label", new java.util.ArrayList(java.util.Collections.singletonList(this.label)));
		map.put("url", new java.util.ArrayList(java.util.Collections.singletonList(this.url)));
		map.put("logo", new java.util.ArrayList(java.util.Collections.singletonList(this.logo)));
		map.put("federationStoreDirectory", new java.util.ArrayList(java.util.Collections.singletonList(this.federationStoreDirectory)));
		map.put("pushEnabled", new java.util.ArrayList(java.util.Collections.singletonList(this.pushEnabled)));
		map.put("debugMode", new java.util.ArrayList(java.util.Collections.singletonList(this.debugMode)));
		map.put("workQueuePeriod", new java.util.ArrayList(java.util.Collections.singletonList(this.workQueuePeriod)));
		map.put("installed", new java.util.ArrayList(java.util.Collections.singletonList(this.installed)));
		map.put("lastReset", new java.util.ArrayList(java.util.Collections.singletonList(this.lastReset)));
		map.put("onInstall", this.onInstall != null ? new java.util.ArrayList(java.util.Collections.singletonList(this.onInstall)) : java.util.Collections.emptyList());
		map.put("onReset", this.onReset != null ? new java.util.ArrayList(java.util.Collections.singletonList(this.onReset)) : java.util.Collections.emptyList());
		return map;
	}

	@Override
	protected void addNode$(io.intino.tara.magritte.Node node) {
		super.addNode$(node);
		if (node.is("BusinessUnit$BusinessModel")) this.businessModel = node.as(org.siani.goros.graph.BusinessUnit.BusinessModel.class);
		if (node.is("BusinessUnit$Certificate")) this.certificate = node.as(org.siani.goros.graph.BusinessUnit.Certificate.class);
		if (node.is("BusinessUnit$Database")) this.database = node.as(org.siani.goros.graph.BusinessUnit.Database.class);
		if (node.is("BusinessUnit$Mail")) this.mail = node.as(org.siani.goros.graph.BusinessUnit.Mail.class);
		if (node.is("BusinessUnit$DocumentService")) this.documentService = node.as(org.siani.goros.graph.BusinessUnit.DocumentService.class);
		if (node.is("BusinessUnit$Datawarehouse")) this.datawarehouse = node.as(org.siani.goros.graph.BusinessUnit.Datawarehouse.class);
		if (node.is("BusinessUnit$MasterData")) this.masterData = node.as(org.siani.goros.graph.BusinessUnit.MasterData.class);
		if (node.is("BusinessUnit$Maps")) this.maps = node.as(org.siani.goros.graph.BusinessUnit.Maps.class);
		if (node.is("BusinessUnit$Firebase")) this.firebase = node.as(org.siani.goros.graph.BusinessUnit.Firebase.class);
	}

	@Override
	    protected void removeNode$(io.intino.tara.magritte.Node node) {
	        super.removeNode$(node);
	        if (node.is("BusinessUnit$BusinessModel")) this.businessModel = null;
	        if (node.is("BusinessUnit$Certificate")) this.certificate = null;
	        if (node.is("BusinessUnit$Database")) this.database = null;
	        if (node.is("BusinessUnit$Mail")) this.mail = null;
	        if (node.is("BusinessUnit$DocumentService")) this.documentService = null;
	        if (node.is("BusinessUnit$Datawarehouse")) this.datawarehouse = null;
	        if (node.is("BusinessUnit$MasterData")) this.masterData = null;
	        if (node.is("BusinessUnit$Maps")) this.maps = null;
	        if (node.is("BusinessUnit$Firebase")) this.firebase = null;
	    }

	@Override
	protected void load$(java.lang.String name, java.util.List<?> values) {
		super.load$(name, values);
		if (name.equalsIgnoreCase("label")) this.label = io.intino.tara.magritte.loaders.StringLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("url")) this.url = io.intino.tara.magritte.loaders.StringLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("logo")) this.logo = io.intino.tara.magritte.loaders.ResourceLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("federationStoreDirectory")) this.federationStoreDirectory = io.intino.tara.magritte.loaders.StringLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("pushEnabled")) this.pushEnabled = io.intino.tara.magritte.loaders.BooleanLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("debugMode")) this.debugMode = io.intino.tara.magritte.loaders.BooleanLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("workQueuePeriod")) this.workQueuePeriod = io.intino.tara.magritte.loaders.IntegerLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("installed")) this.installed = io.intino.tara.magritte.loaders.InstantLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("lastReset")) this.lastReset = io.intino.tara.magritte.loaders.InstantLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("onInstall")) this.onInstall = io.intino.tara.magritte.loaders.FunctionLoader.load(values, this, org.siani.goros.graph.functions.SetupFunction.class).get(0);
		else if (name.equalsIgnoreCase("onReset")) this.onReset = io.intino.tara.magritte.loaders.FunctionLoader.load(values, this, org.siani.goros.graph.functions.SetupFunction.class).get(0);
	}

	@Override
	protected void set$(java.lang.String name, java.util.List<?> values) {
		super.set$(name, values);
		if (name.equalsIgnoreCase("label")) this.label = (java.lang.String) values.get(0);
		else if (name.equalsIgnoreCase("url")) this.url = (java.lang.String) values.get(0);
		else if (name.equalsIgnoreCase("logo")) this.logo = (java.net.URL) values.get(0);
		else if (name.equalsIgnoreCase("federationStoreDirectory")) this.federationStoreDirectory = (java.lang.String) values.get(0);
		else if (name.equalsIgnoreCase("pushEnabled")) this.pushEnabled = (java.lang.Boolean) values.get(0);
		else if (name.equalsIgnoreCase("debugMode")) this.debugMode = (java.lang.Boolean) values.get(0);
		else if (name.equalsIgnoreCase("workQueuePeriod")) this.workQueuePeriod = (java.lang.Integer) values.get(0);
		else if (name.equalsIgnoreCase("installed")) this.installed = (java.time.Instant) values.get(0);
		else if (name.equalsIgnoreCase("lastReset")) this.lastReset = (java.time.Instant) values.get(0);
		else if (name.equalsIgnoreCase("onInstall")) this.onInstall = io.intino.tara.magritte.loaders.FunctionLoader.load(values.get(0), this, org.siani.goros.graph.functions.SetupFunction.class);
		else if (name.equalsIgnoreCase("onReset")) this.onReset = io.intino.tara.magritte.loaders.FunctionLoader.load(values.get(0), this, org.siani.goros.graph.functions.SetupFunction.class);
	}

	public Create create() {
		return new Create(null);
	}

	public Create create(java.lang.String name) {
		return new Create(name);
	}

	public class Create  {
		protected final java.lang.String name;

		public Create(java.lang.String name) {
			this.name = name;
		}

		public org.siani.goros.graph.BusinessUnit.BusinessModel businessModel(java.net.URL jarFile) {
		    org.siani.goros.graph.BusinessUnit.BusinessModel newElement = core$().graph().concept(org.siani.goros.graph.BusinessUnit.BusinessModel.class).createNode(this.name, core$()).as(org.siani.goros.graph.BusinessUnit.BusinessModel.class);
			newElement.core$().set(newElement, "jarFile", java.util.Collections.singletonList(jarFile));
		    return newElement;
		}

		public org.siani.goros.graph.BusinessUnit.Certificate certificate(java.net.URL file, java.lang.String password) {
		    org.siani.goros.graph.BusinessUnit.Certificate newElement = core$().graph().concept(org.siani.goros.graph.BusinessUnit.Certificate.class).createNode(this.name, core$()).as(org.siani.goros.graph.BusinessUnit.Certificate.class);
			newElement.core$().set(newElement, "file", java.util.Collections.singletonList(file));
			newElement.core$().set(newElement, "password", java.util.Collections.singletonList(password));
		    return newElement;
		}

		public org.siani.goros.graph.BusinessUnit.Database database(org.siani.goros.graph.BusinessUnit.Database.Type type, java.lang.String url, java.lang.String user, java.lang.String password) {
		    org.siani.goros.graph.BusinessUnit.Database newElement = core$().graph().concept(org.siani.goros.graph.BusinessUnit.Database.class).createNode(this.name, core$()).as(org.siani.goros.graph.BusinessUnit.Database.class);
			newElement.core$().set(newElement, "type", java.util.Collections.singletonList(type));
			newElement.core$().set(newElement, "url", java.util.Collections.singletonList(url));
			newElement.core$().set(newElement, "user", java.util.Collections.singletonList(user));
			newElement.core$().set(newElement, "password", java.util.Collections.singletonList(password));
		    return newElement;
		}

		public org.siani.goros.graph.BusinessUnit.Mail mail(java.lang.String host, java.lang.String adminFrom, java.lang.String adminTo, java.lang.String username, java.lang.String password) {
		    org.siani.goros.graph.BusinessUnit.Mail newElement = core$().graph().concept(org.siani.goros.graph.BusinessUnit.Mail.class).createNode(this.name, core$()).as(org.siani.goros.graph.BusinessUnit.Mail.class);
			newElement.core$().set(newElement, "host", java.util.Collections.singletonList(host));
			newElement.core$().set(newElement, "adminFrom", java.util.Collections.singletonList(adminFrom));
			newElement.core$().set(newElement, "adminTo", java.util.Collections.singletonList(adminTo));
			newElement.core$().set(newElement, "username", java.util.Collections.singletonList(username));
			newElement.core$().set(newElement, "password", java.util.Collections.singletonList(password));
		    return newElement;
		}

		public org.siani.goros.graph.BusinessUnit.DocumentService documentService(java.lang.String url) {
		    org.siani.goros.graph.BusinessUnit.DocumentService newElement = core$().graph().concept(org.siani.goros.graph.BusinessUnit.DocumentService.class).createNode(this.name, core$()).as(org.siani.goros.graph.BusinessUnit.DocumentService.class);
			newElement.core$().set(newElement, "url", java.util.Collections.singletonList(url));
		    return newElement;
		}

		public org.siani.goros.graph.BusinessUnit.Datawarehouse datawarehouse(java.lang.String url, java.lang.String directory) {
		    org.siani.goros.graph.BusinessUnit.Datawarehouse newElement = core$().graph().concept(org.siani.goros.graph.BusinessUnit.Datawarehouse.class).createNode(this.name, core$()).as(org.siani.goros.graph.BusinessUnit.Datawarehouse.class);
			newElement.core$().set(newElement, "url", java.util.Collections.singletonList(url));
			newElement.core$().set(newElement, "directory", java.util.Collections.singletonList(directory));
		    return newElement;
		}

		public org.siani.goros.graph.BusinessUnit.MasterData masterData() {
		    org.siani.goros.graph.BusinessUnit.MasterData newElement = core$().graph().concept(org.siani.goros.graph.BusinessUnit.MasterData.class).createNode(this.name, core$()).as(org.siani.goros.graph.BusinessUnit.MasterData.class);

		    return newElement;
		}

		public org.siani.goros.graph.BusinessUnit.Maps maps(java.lang.String googleApiKey) {
		    org.siani.goros.graph.BusinessUnit.Maps newElement = core$().graph().concept(org.siani.goros.graph.BusinessUnit.Maps.class).createNode(this.name, core$()).as(org.siani.goros.graph.BusinessUnit.Maps.class);
			newElement.core$().set(newElement, "googleApiKey", java.util.Collections.singletonList(googleApiKey));
		    return newElement;
		}

		public org.siani.goros.graph.BusinessUnit.Firebase firebase(java.net.URL settingsFilename, java.lang.String projectId) {
		    org.siani.goros.graph.BusinessUnit.Firebase newElement = core$().graph().concept(org.siani.goros.graph.BusinessUnit.Firebase.class).createNode(this.name, core$()).as(org.siani.goros.graph.BusinessUnit.Firebase.class);
			newElement.core$().set(newElement, "settingsFilename", java.util.Collections.singletonList(settingsFilename));
			newElement.core$().set(newElement, "projectId", java.util.Collections.singletonList(projectId));
		    return newElement;
		}

	}

	public static class BusinessModel  extends io.intino.tara.magritte.Layer implements io.intino.tara.magritte.tags.Terminal {
		protected java.net.URL jarFile;

		public BusinessModel(io.intino.tara.magritte.Node node) {
			super(node);
		}

		public java.net.URL jarFile() {
			return jarFile;
		}

		public BusinessModel jarFile(java.net.URL url, String destination) {
			if (url == null) this.jarFile = null;
			else this.jarFile = graph().core$().save(url, destination, this.jarFile, core$());
			return (BusinessModel) this;
		}

		public BusinessModel jarFile(java.io.InputStream stream, String destination) {
			if (stream == null) this.jarFile = null;
			else this.jarFile = graph().core$().save(stream, destination, this.jarFile, core$());
			return (BusinessModel) this;
		}

		@Override
		protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
			java.util.Map<String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
			map.put("jarFile", new java.util.ArrayList(java.util.Collections.singletonList(this.jarFile)));
			return map;
		}

		@Override
		protected void load$(java.lang.String name, java.util.List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("jarFile")) this.jarFile = io.intino.tara.magritte.loaders.ResourceLoader.load(values, this).get(0);
		}

		@Override
		protected void set$(java.lang.String name, java.util.List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("jarFile")) this.jarFile = (java.net.URL) values.get(0);
		}

		public org.siani.goros.graph.GorosGraph graph() {
			return (org.siani.goros.graph.GorosGraph) core$().graph().as(org.siani.goros.graph.GorosGraph.class);
		}
	}

	public static class Certificate  extends io.intino.tara.magritte.Layer implements io.intino.tara.magritte.tags.Terminal {
		protected java.net.URL file;
		protected java.lang.String password;
		protected int duration;

		public Certificate(io.intino.tara.magritte.Node node) {
			super(node);
		}

		public java.net.URL file() {
			return file;
		}

		public java.lang.String password() {
			return password;
		}

		public int duration() {
			return duration;
		}

		public Certificate file(java.net.URL url, String destination) {
			if (url == null) this.file = null;
			else this.file = graph().core$().save(url, destination, this.file, core$());
			return (Certificate) this;
		}

		public Certificate file(java.io.InputStream stream, String destination) {
			if (stream == null) this.file = null;
			else this.file = graph().core$().save(stream, destination, this.file, core$());
			return (Certificate) this;
		}

		public Certificate password(java.lang.String value) {
			this.password = value;
			return (Certificate) this;
		}

		public Certificate duration(int value) {
			this.duration = value;
			return (Certificate) this;
		}

		@Override
		protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
			java.util.Map<String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
			map.put("file", new java.util.ArrayList(java.util.Collections.singletonList(this.file)));
			map.put("password", new java.util.ArrayList(java.util.Collections.singletonList(this.password)));
			map.put("duration", new java.util.ArrayList(java.util.Collections.singletonList(this.duration)));
			return map;
		}

		@Override
		protected void load$(java.lang.String name, java.util.List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("file")) this.file = io.intino.tara.magritte.loaders.ResourceLoader.load(values, this).get(0);
			else if (name.equalsIgnoreCase("password")) this.password = io.intino.tara.magritte.loaders.StringLoader.load(values, this).get(0);
			else if (name.equalsIgnoreCase("duration")) this.duration = io.intino.tara.magritte.loaders.IntegerLoader.load(values, this).get(0);
		}

		@Override
		protected void set$(java.lang.String name, java.util.List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("file")) this.file = (java.net.URL) values.get(0);
			else if (name.equalsIgnoreCase("password")) this.password = (java.lang.String) values.get(0);
			else if (name.equalsIgnoreCase("duration")) this.duration = (java.lang.Integer) values.get(0);
		}

		public org.siani.goros.graph.GorosGraph graph() {
			return (org.siani.goros.graph.GorosGraph) core$().graph().as(org.siani.goros.graph.GorosGraph.class);
		}
	}

	public static class Database  extends io.intino.tara.magritte.Layer implements io.intino.tara.magritte.tags.Terminal {
		protected Type type;

		public enum Type {
			Mysql, Oracle;
		}
		protected java.lang.String url;
		protected java.lang.String user;
		protected java.lang.String password;
		protected int queryExecutionTimeWarning;

		public Database(io.intino.tara.magritte.Node node) {
			super(node);
		}

		public Type type() {
			return type;
		}

		public java.lang.String url() {
			return url;
		}

		public java.lang.String user() {
			return user;
		}

		public java.lang.String password() {
			return password;
		}

		public int queryExecutionTimeWarning() {
			return queryExecutionTimeWarning;
		}

		public Database type(org.siani.goros.graph.BusinessUnit.Database.Type value) {
			this.type = value;
			return (Database) this;
		}

		public Database url(java.lang.String value) {
			this.url = value;
			return (Database) this;
		}

		public Database user(java.lang.String value) {
			this.user = value;
			return (Database) this;
		}

		public Database password(java.lang.String value) {
			this.password = value;
			return (Database) this;
		}

		public Database queryExecutionTimeWarning(int value) {
			this.queryExecutionTimeWarning = value;
			return (Database) this;
		}

		@Override
		protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
			java.util.Map<String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
			map.put("type", new java.util.ArrayList(java.util.Collections.singletonList(this.type)));
			map.put("url", new java.util.ArrayList(java.util.Collections.singletonList(this.url)));
			map.put("user", new java.util.ArrayList(java.util.Collections.singletonList(this.user)));
			map.put("password", new java.util.ArrayList(java.util.Collections.singletonList(this.password)));
			map.put("queryExecutionTimeWarning", new java.util.ArrayList(java.util.Collections.singletonList(this.queryExecutionTimeWarning)));
			return map;
		}

		@Override
		protected void load$(java.lang.String name, java.util.List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("type")) this.type = io.intino.tara.magritte.loaders.WordLoader.load(values, Type.class, this).get(0);
			else if (name.equalsIgnoreCase("url")) this.url = io.intino.tara.magritte.loaders.StringLoader.load(values, this).get(0);
			else if (name.equalsIgnoreCase("user")) this.user = io.intino.tara.magritte.loaders.StringLoader.load(values, this).get(0);
			else if (name.equalsIgnoreCase("password")) this.password = io.intino.tara.magritte.loaders.StringLoader.load(values, this).get(0);
			else if (name.equalsIgnoreCase("queryExecutionTimeWarning")) this.queryExecutionTimeWarning = io.intino.tara.magritte.loaders.IntegerLoader.load(values, this).get(0);
		}

		@Override
		protected void set$(java.lang.String name, java.util.List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("type")) this.type = (Type) values.get(0);
			else if (name.equalsIgnoreCase("url")) this.url = (java.lang.String) values.get(0);
			else if (name.equalsIgnoreCase("user")) this.user = (java.lang.String) values.get(0);
			else if (name.equalsIgnoreCase("password")) this.password = (java.lang.String) values.get(0);
			else if (name.equalsIgnoreCase("queryExecutionTimeWarning")) this.queryExecutionTimeWarning = (java.lang.Integer) values.get(0);
		}

		public org.siani.goros.graph.GorosGraph graph() {
			return (org.siani.goros.graph.GorosGraph) core$().graph().as(org.siani.goros.graph.GorosGraph.class);
		}
	}

	public static class Mail  extends io.intino.tara.magritte.Layer implements io.intino.tara.magritte.tags.Terminal {
		protected java.lang.String host;
		protected java.lang.String adminFrom;
		protected java.lang.String adminTo;
		protected java.lang.String username;
		protected java.lang.String password;
		protected int port;
		protected boolean secure;

		public Mail(io.intino.tara.magritte.Node node) {
			super(node);
		}

		public java.lang.String host() {
			return host;
		}

		public java.lang.String adminFrom() {
			return adminFrom;
		}

		public java.lang.String adminTo() {
			return adminTo;
		}

		public java.lang.String username() {
			return username;
		}

		public java.lang.String password() {
			return password;
		}

		public int port() {
			return port;
		}

		public boolean secure() {
			return secure;
		}

		public Mail host(java.lang.String value) {
			this.host = value;
			return (Mail) this;
		}

		public Mail adminFrom(java.lang.String value) {
			this.adminFrom = value;
			return (Mail) this;
		}

		public Mail adminTo(java.lang.String value) {
			this.adminTo = value;
			return (Mail) this;
		}

		public Mail username(java.lang.String value) {
			this.username = value;
			return (Mail) this;
		}

		public Mail password(java.lang.String value) {
			this.password = value;
			return (Mail) this;
		}

		public Mail port(int value) {
			this.port = value;
			return (Mail) this;
		}

		public Mail secure(boolean value) {
			this.secure = value;
			return (Mail) this;
		}

		@Override
		protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
			java.util.Map<String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
			map.put("host", new java.util.ArrayList(java.util.Collections.singletonList(this.host)));
			map.put("adminFrom", new java.util.ArrayList(java.util.Collections.singletonList(this.adminFrom)));
			map.put("adminTo", new java.util.ArrayList(java.util.Collections.singletonList(this.adminTo)));
			map.put("username", new java.util.ArrayList(java.util.Collections.singletonList(this.username)));
			map.put("password", new java.util.ArrayList(java.util.Collections.singletonList(this.password)));
			map.put("port", new java.util.ArrayList(java.util.Collections.singletonList(this.port)));
			map.put("secure", new java.util.ArrayList(java.util.Collections.singletonList(this.secure)));
			return map;
		}

		@Override
		protected void load$(java.lang.String name, java.util.List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("host")) this.host = io.intino.tara.magritte.loaders.StringLoader.load(values, this).get(0);
			else if (name.equalsIgnoreCase("adminFrom")) this.adminFrom = io.intino.tara.magritte.loaders.StringLoader.load(values, this).get(0);
			else if (name.equalsIgnoreCase("adminTo")) this.adminTo = io.intino.tara.magritte.loaders.StringLoader.load(values, this).get(0);
			else if (name.equalsIgnoreCase("username")) this.username = io.intino.tara.magritte.loaders.StringLoader.load(values, this).get(0);
			else if (name.equalsIgnoreCase("password")) this.password = io.intino.tara.magritte.loaders.StringLoader.load(values, this).get(0);
			else if (name.equalsIgnoreCase("port")) this.port = io.intino.tara.magritte.loaders.IntegerLoader.load(values, this).get(0);
			else if (name.equalsIgnoreCase("secure")) this.secure = io.intino.tara.magritte.loaders.BooleanLoader.load(values, this).get(0);
		}

		@Override
		protected void set$(java.lang.String name, java.util.List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("host")) this.host = (java.lang.String) values.get(0);
			else if (name.equalsIgnoreCase("adminFrom")) this.adminFrom = (java.lang.String) values.get(0);
			else if (name.equalsIgnoreCase("adminTo")) this.adminTo = (java.lang.String) values.get(0);
			else if (name.equalsIgnoreCase("username")) this.username = (java.lang.String) values.get(0);
			else if (name.equalsIgnoreCase("password")) this.password = (java.lang.String) values.get(0);
			else if (name.equalsIgnoreCase("port")) this.port = (java.lang.Integer) values.get(0);
			else if (name.equalsIgnoreCase("secure")) this.secure = (java.lang.Boolean) values.get(0);
		}

		public org.siani.goros.graph.GorosGraph graph() {
			return (org.siani.goros.graph.GorosGraph) core$().graph().as(org.siani.goros.graph.GorosGraph.class);
		}
	}

	public static class DocumentService  extends io.intino.tara.magritte.Layer implements io.intino.tara.magritte.tags.Terminal {
		protected java.lang.String url;

		public DocumentService(io.intino.tara.magritte.Node node) {
			super(node);
		}

		public java.lang.String url() {
			return url;
		}

		public DocumentService url(java.lang.String value) {
			this.url = value;
			return (DocumentService) this;
		}

		@Override
		protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
			java.util.Map<String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
			map.put("url", new java.util.ArrayList(java.util.Collections.singletonList(this.url)));
			return map;
		}

		@Override
		protected void load$(java.lang.String name, java.util.List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("url")) this.url = io.intino.tara.magritte.loaders.StringLoader.load(values, this).get(0);
		}

		@Override
		protected void set$(java.lang.String name, java.util.List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("url")) this.url = (java.lang.String) values.get(0);
		}

		public org.siani.goros.graph.GorosGraph graph() {
			return (org.siani.goros.graph.GorosGraph) core$().graph().as(org.siani.goros.graph.GorosGraph.class);
		}
	}

	public static class Datawarehouse  extends io.intino.tara.magritte.Layer implements io.intino.tara.magritte.tags.Terminal {
		protected java.lang.String url;
		protected java.lang.String directory;
		protected int syncAt;
		protected boolean syncOnStart;

		public Datawarehouse(io.intino.tara.magritte.Node node) {
			super(node);
		}

		public java.lang.String url() {
			return url;
		}

		public java.lang.String directory() {
			return directory;
		}

		public int syncAt() {
			return syncAt;
		}

		public boolean syncOnStart() {
			return syncOnStart;
		}

		public Datawarehouse url(java.lang.String value) {
			this.url = value;
			return (Datawarehouse) this;
		}

		public Datawarehouse directory(java.lang.String value) {
			this.directory = value;
			return (Datawarehouse) this;
		}

		public Datawarehouse syncAt(int value) {
			this.syncAt = value;
			return (Datawarehouse) this;
		}

		public Datawarehouse syncOnStart(boolean value) {
			this.syncOnStart = value;
			return (Datawarehouse) this;
		}

		@Override
		protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
			java.util.Map<String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
			map.put("url", new java.util.ArrayList(java.util.Collections.singletonList(this.url)));
			map.put("directory", new java.util.ArrayList(java.util.Collections.singletonList(this.directory)));
			map.put("syncAt", new java.util.ArrayList(java.util.Collections.singletonList(this.syncAt)));
			map.put("syncOnStart", new java.util.ArrayList(java.util.Collections.singletonList(this.syncOnStart)));
			return map;
		}

		@Override
		protected void load$(java.lang.String name, java.util.List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("url")) this.url = io.intino.tara.magritte.loaders.StringLoader.load(values, this).get(0);
			else if (name.equalsIgnoreCase("directory")) this.directory = io.intino.tara.magritte.loaders.StringLoader.load(values, this).get(0);
			else if (name.equalsIgnoreCase("syncAt")) this.syncAt = io.intino.tara.magritte.loaders.IntegerLoader.load(values, this).get(0);
			else if (name.equalsIgnoreCase("syncOnStart")) this.syncOnStart = io.intino.tara.magritte.loaders.BooleanLoader.load(values, this).get(0);
		}

		@Override
		protected void set$(java.lang.String name, java.util.List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("url")) this.url = (java.lang.String) values.get(0);
			else if (name.equalsIgnoreCase("directory")) this.directory = (java.lang.String) values.get(0);
			else if (name.equalsIgnoreCase("syncAt")) this.syncAt = (java.lang.Integer) values.get(0);
			else if (name.equalsIgnoreCase("syncOnStart")) this.syncOnStart = (java.lang.Boolean) values.get(0);
		}

		public org.siani.goros.graph.GorosGraph graph() {
			return (org.siani.goros.graph.GorosGraph) core$().graph().as(org.siani.goros.graph.GorosGraph.class);
		}
	}

	public static class MasterData  extends io.intino.tara.magritte.Layer implements io.intino.tara.magritte.tags.Terminal {
		protected int syncAt;
		protected boolean syncOnStart;

		public MasterData(io.intino.tara.magritte.Node node) {
			super(node);
		}

		public int syncAt() {
			return syncAt;
		}

		public boolean syncOnStart() {
			return syncOnStart;
		}

		public MasterData syncAt(int value) {
			this.syncAt = value;
			return (MasterData) this;
		}

		public MasterData syncOnStart(boolean value) {
			this.syncOnStart = value;
			return (MasterData) this;
		}

		@Override
		protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
			java.util.Map<String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
			map.put("syncAt", new java.util.ArrayList(java.util.Collections.singletonList(this.syncAt)));
			map.put("syncOnStart", new java.util.ArrayList(java.util.Collections.singletonList(this.syncOnStart)));
			return map;
		}

		@Override
		protected void load$(java.lang.String name, java.util.List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("syncAt")) this.syncAt = io.intino.tara.magritte.loaders.IntegerLoader.load(values, this).get(0);
			else if (name.equalsIgnoreCase("syncOnStart")) this.syncOnStart = io.intino.tara.magritte.loaders.BooleanLoader.load(values, this).get(0);
		}

		@Override
		protected void set$(java.lang.String name, java.util.List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("syncAt")) this.syncAt = (java.lang.Integer) values.get(0);
			else if (name.equalsIgnoreCase("syncOnStart")) this.syncOnStart = (java.lang.Boolean) values.get(0);
		}

		public org.siani.goros.graph.GorosGraph graph() {
			return (org.siani.goros.graph.GorosGraph) core$().graph().as(org.siani.goros.graph.GorosGraph.class);
		}
	}

	public static class Maps  extends io.intino.tara.magritte.Layer implements io.intino.tara.magritte.tags.Terminal {
		protected java.lang.String googleApiKey;

		public Maps(io.intino.tara.magritte.Node node) {
			super(node);
		}

		public java.lang.String googleApiKey() {
			return googleApiKey;
		}

		public Maps googleApiKey(java.lang.String value) {
			this.googleApiKey = value;
			return (Maps) this;
		}

		@Override
		protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
			java.util.Map<String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
			map.put("googleApiKey", new java.util.ArrayList(java.util.Collections.singletonList(this.googleApiKey)));
			return map;
		}

		@Override
		protected void load$(java.lang.String name, java.util.List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("googleApiKey")) this.googleApiKey = io.intino.tara.magritte.loaders.StringLoader.load(values, this).get(0);
		}

		@Override
		protected void set$(java.lang.String name, java.util.List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("googleApiKey")) this.googleApiKey = (java.lang.String) values.get(0);
		}

		public org.siani.goros.graph.GorosGraph graph() {
			return (org.siani.goros.graph.GorosGraph) core$().graph().as(org.siani.goros.graph.GorosGraph.class);
		}
	}

	public static class Firebase  extends io.intino.tara.magritte.Layer implements io.intino.tara.magritte.tags.Terminal {
		protected java.net.URL settingsFilename;
		protected java.lang.String projectId;

		public Firebase(io.intino.tara.magritte.Node node) {
			super(node);
		}

		public java.net.URL settingsFilename() {
			return settingsFilename;
		}

		public java.lang.String projectId() {
			return projectId;
		}

		public Firebase settingsFilename(java.net.URL url, String destination) {
			if (url == null) this.settingsFilename = null;
			else this.settingsFilename = graph().core$().save(url, destination, this.settingsFilename, core$());
			return (Firebase) this;
		}

		public Firebase settingsFilename(java.io.InputStream stream, String destination) {
			if (stream == null) this.settingsFilename = null;
			else this.settingsFilename = graph().core$().save(stream, destination, this.settingsFilename, core$());
			return (Firebase) this;
		}

		public Firebase projectId(java.lang.String value) {
			this.projectId = value;
			return (Firebase) this;
		}

		@Override
		protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
			java.util.Map<String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
			map.put("settingsFilename", new java.util.ArrayList(java.util.Collections.singletonList(this.settingsFilename)));
			map.put("projectId", new java.util.ArrayList(java.util.Collections.singletonList(this.projectId)));
			return map;
		}

		@Override
		protected void load$(java.lang.String name, java.util.List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("settingsFilename")) this.settingsFilename = io.intino.tara.magritte.loaders.ResourceLoader.load(values, this).get(0);
			else if (name.equalsIgnoreCase("projectId")) this.projectId = io.intino.tara.magritte.loaders.StringLoader.load(values, this).get(0);
		}

		@Override
		protected void set$(java.lang.String name, java.util.List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("settingsFilename")) this.settingsFilename = (java.net.URL) values.get(0);
			else if (name.equalsIgnoreCase("projectId")) this.projectId = (java.lang.String) values.get(0);
		}

		public org.siani.goros.graph.GorosGraph graph() {
			return (org.siani.goros.graph.GorosGraph) core$().graph().as(org.siani.goros.graph.GorosGraph.class);
		}
	}


	public org.siani.goros.graph.GorosGraph graph() {
		return (org.siani.goros.graph.GorosGraph) core$().graph().as(org.siani.goros.graph.GorosGraph.class);
	}
}