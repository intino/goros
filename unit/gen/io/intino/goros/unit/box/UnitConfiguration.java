package io.intino.goros.unit.box;

import java.util.Map;
import java.util.HashMap;

public class UnitConfiguration extends io.intino.alexandria.core.BoxConfiguration {

	public UnitConfiguration(String[] args) {
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

	public String certificateFilename() {
		return get("certificate-filename");
	}

	public String certificatePassword() {
		return get("certificate-password");
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

	public String servicesRequestMaxElapsedTime() {
		return get("services-request-max-elapsed-time");
	}

	public String userDataDir() {
		return get("user-data-dir");
	}

	public String componentDocumentsMonetUrl() {
		return get("component-documents-monet-url");
	}

	public String componentDatawarehouseMonetUrl() {
		return get("component-datawarehouse-monet-url");
	}

	public String servicesBaseUrl() {
		return get("services-base-url");
	}

	public String storeDirectory() {
		return get("store-directory");
	}

	public String applicationDefinitionFilename() {
		return get("application-definition-filename");
	}

	public String componentDefinitionFilename() {
		return get("component-definition-filename");
	}

	public String translatorDefinitionFilename() {
		return get("translator-definition-filename");
	}

	public String businessModelDefinitionsDictionaryFilename() {
		return get("business-model-definitions-dictionary-filename");
	}

	public String businessModelHelpNotFoundFilename() {
		return get("business-model-help-not-found-filename");
	}

	public String businessModelDatasourceFilename() {
		return get("business-model-datasource-filename");
	}

	public String businessModelNodeExporterMainFilename() {
		return get("business-model-node-exporter-main-filename");
	}

	public String businessModelNodeImporterMainFilename() {
		return get("business-model-node-importer-main-filename");
	}

	public String businessModelThesaurusSeparator() {
		return get("business-model-thesaurus-separator");
	}

	public String businessModelDatasourceItemSeparator() {
		return get("business-model-datasource-item-separator");
	}

	public String businessModelPackagesPath() {
		return get("business-model-packages-path");
	}

	public String simpleFieldPattern() {
		return get("simple-field-pattern");
	}

	public String multipleFieldPattern() {
		return get("multiple-field-pattern");
	}

	public String indicatorNodeLink() {
		return get("indicator-node-link");
	}

	public String encriptParameters() {
		return get("encript-parameters");
	}

	public String runBusinessUnit() {
		return get("run-business-unit");
	}

	public String useSsl() {
		return get("use-ssl");
	}

	public String defaultApplication() {
		return get("default-application");
	}

	public String modelType() {
		return get("model-type");
	}

	public String isPushEnabled() {
		return get("is-push-enabled");
	}

	public String mobileFcmSettingsFilename() {
		return get("mobile-fcm-settings-filename");
	}

	public String mobileFcmProjectId() {
		return get("mobile-fcm-project-id");
	}

	public String mobileGoogleApiKey() {
		return get("mobile-google-api-key");
	}

	public String isDebugMode() {
		return get("is-debug-mode");
	}

	public String databaseQueryExecutionTimeWarning() {
		return get("database-query-execution-time-warning");
	}

	public String workqueuePeriod() {
		return get("workqueue-period");
	}

	public String datawarehouseUpgradeLaunchOnStart() {
		return get("datawarehouse-upgrade-launch-on-start");
	}

	public String datawarehouseUpgradeHour() {
		return get("datawarehouse-upgrade-hour");
	}

	public String datawarehouseDir() {
		return get("datawarehouse-dir");
	}

	public String sourceUpgradeLaunchOnStart() {
		return get("source-upgrade-launch-on-start");
	}

	public String sourceUpgradeHour() {
		return get("source-upgrade-hour");
	}

	public String mailAdminHost() {
		return get("mail-admin-host");
	}

	public String mailAdminFrom() {
		return get("mail-admin-from");
	}

	public String mailAdminTo() {
		return get("mail-admin-to");
	}

	public String mailAdminUsername() {
		return get("mail-admin-username");
	}

	public String mailAdminPassword() {
		return get("mail-admin-password");
	}

	public String mailAdminPort() {
		return get("mail-admin-port");
	}

	public String mailAdminSecure() {
		return get("mail-admin-secure");
	}
}