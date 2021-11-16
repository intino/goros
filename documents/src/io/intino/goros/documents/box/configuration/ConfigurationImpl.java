package io.intino.goros.documents.box.configuration;

import org.monet.docservice.core.exceptions.ApplicationException;
import org.monet.docservice.core.util.Resources;
import org.monet.docservice.docprocessor.configuration.Configuration;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationImpl implements Configuration {
	private final Map<String, String> parameters;
	private final DatabaseConfiguration database;

	public ConfigurationImpl(Map<String, String> parameters) {
		this.parameters = parameters;
		this.database = DatabaseConfiguration.fromMap(parameters);
	}

	public String getPath(String key) {
		return getString(key);
	}

	public String getJDBCDataSource() {
		return database.datasource();
	}

	public int getJDBCMaxActiveConnections() {
		return database.maxActiveConnections();
	}

	public int getJDBCRemoveAbandonedTimeout() {
		return database.removeAbandonedTimeout();
	}

	public String getString(String key) {

		if (!existsParam(key))
			throw new ApplicationException(String.format("Configuration error, key '%s' not found", key));

		return getParam(key);
	}

	public int getInt(String key) {
		return Integer.parseInt(getString(key));
	}

	public boolean getBoolean(String key) {
		return Boolean.parseBoolean(getString(key));
	}

	public int getSignConfig(String key) {
		return getInt("Sign." + key);
	}

	public String getApplicationDir() {
		return Resources.getFullPath("/");
	}

	public String getUpgradesDir() {
		return getApplicationDir() + "/upgrades";
	}

	@Override
	public int getDocumentPreviewsCacheSize() {
		if (!existsParam(Configuration.DOCUMENT_PREVIEWS_CACHE_SIZE)) return 30;
		return getInt(Configuration.DOCUMENT_PREVIEWS_CACHE_SIZE);
	}

	@Override
	public String getUserDataDir() {
		return parameters.get("workspace");
	}

	@Override
	public String getLogsDir() {
		return getUserDataDir() + "/logs";
	}

	@Override
	public String[] getDocumentDisks() {
		if (!existsParam(Configuration.DOCUMENT_DISKS)) return null;
		String value = getString(Configuration.DOCUMENT_DISKS);
		return !value.isEmpty() ? value.split(",") : null;
	}

	@Override
	public void check() {
		if (this.getDocumentDisks() == null)
			throw new ApplicationException(String.format("Configuration error, key '%s' not found", Configuration.DOCUMENT_DISKS));
	}

	private boolean existsParam(String paramName) {
		return keyMap.containsKey(paramName) && parameters.containsKey(keyMap.get(paramName));
	}

	private String getParam(String paramName) {
		if (!existsParam(paramName)) return null;
		return parameters.get(keyMap.get(paramName));
	}

	private static Map<String, String> keyMap = new HashMap<>() {{
		put(JDBC_DATABASE, "jdbc-type");
		put(JDBC_DATASOURCE, "jdbc-datasource");
		put(JDBC_MAX_ACTIVE_CONNECTIONS, "jdbc-max-active-connections");
		put(JDBC_REMOVE_ABANDONED_TIMEOUT, "jdbc-remove-abandoned-timeout");
		put(PATH_TRUETYPE_FONTS, "true-type-fonts-path");
		put(PATH_TEMP, "temp-path");
		put(WORKQUEUE_THREADPOOL_SIZE, "workqueue-thread-pool-size");
		put(WORKQUEUE_THREADPOOL_PERIOD, "workqueue-collect-work-period");
		put(DOCUMENT_PREVIEWS_CACHE_SIZE, "document-previews-cache-size-in-days");
		put(DOCUMENT_DISKS, "document-disks");
		put(PDF_CONVERTER_CLASS, "pdf-converter-class");
		put(GENERATE_PDF_A, "generate-pdf-a");
		put(MODEL_PRODUCER_CLASS, "model-producer-class");
		put(SIGN_HEIGHT, "sign-height");
		put(OFFSET_X, "sign-offset-x");
		put(OFFSET_Y, "sign-offset-y");
		put(OFFSET_Y_FOR_BOTTOM, "sign-offset-y-for-bottom");
		put(COUNT_SIGN, "sign-count");
		put("PdfLicencePath", "pdf-licence-path");
	}};

}
