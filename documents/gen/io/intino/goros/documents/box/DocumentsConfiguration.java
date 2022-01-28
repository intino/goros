package io.intino.goros.documents.box;

import java.util.Map;
import java.util.HashMap;

public class DocumentsConfiguration extends io.intino.alexandria.core.BoxConfiguration {

	public DocumentsConfiguration(String[] args) {
		super(args);
	}

	public String port() {
		return get("port");
	}

	public String workspace() {
		return get("workspace");
	}

	public String name() {
		return get("name");
	}

	public String jdbcDatasource() {
		return get("jdbc-datasource");
	}

	public String jdbcType() {
		return get("jdbc-type");
	}

	public String jdbcUrl() {
		return get("jdbc-url");
	}

	public String jdbcUser() {
		return get("jdbc-user");
	}

	public String jdbcPassword() {
		return get("jdbc-password");
	}

	public String jdbcMaxActiveConnections() {
		return get("jdbc-max-active-connections");
	}

	public String jdbcMaxIdleConnections() {
		return get("jdbc-max-idle-connections");
	}

	public String jdbcRemoveAbandonedTimeout() {
		return get("jdbc-remove-abandoned-timeout");
	}

	public String trueTypeFontsPath() {
		return get("true-type-fonts-path");
	}

	public String tempPath() {
		return get("temp-path");
	}

	public String documentDisks() {
		return get("document-disks");
	}

	public String workqueueThreadPoolSize() {
		return get("workqueue-thread-pool-size");
	}

	public String workqueueCollectWorkPeriod() {
		return get("workqueue-collect-work-period");
	}

	public String documentPreviewsCacheSizeInDays() {
		return get("document-previews-cache-size-in-days");
	}

	public String generatePdfA() {
		return get("generate-pdf-a");
	}

	public String pdfLicencePath() {
		return get("pdf-licence-path");
	}

	public String pdfConverterClass() {
		return get("pdf-converter-class");
	}

	public String modelProducerClass() {
		return get("model-producer-class");
	}

	public String signHeight() {
		return get("sign-height");
	}

	public String signOffsetX() {
		return get("sign-offset-x");
	}

	public String signOffsetY() {
		return get("sign-offset-y");
	}

	public String signOffsetYForBottom() {
		return get("sign-offset-y-for-bottom");
	}

	public String signCount() {
		return get("sign-count");
	}

	public java.io.File home() {
		return new java.io.File(args.getOrDefault("home", System.getProperty("user.home")));
	}
}