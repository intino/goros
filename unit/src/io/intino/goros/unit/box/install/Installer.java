package io.intino.goros.unit.box.install;

import io.intino.alexandria.logger.Logger;
import io.intino.goros.shared.install.Db;
import io.intino.goros.shared.install.Files;
import io.intino.goros.shared.install.Shell;
import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.sql.SQLException;
import java.util.Map;

public class Installer {
	private Db db;
	private String workspace;
	private String spaceName;
	String fileNameSSL;
	String fileNameSSLPassword;
	String federationCAPassword;
	String federationCAFileCrt;
	String federationCAFileKey;


	public Installer(Map<String, String> parameters) {
		String DbUrl = parameters.get("Jdbc.Url");
		String DbUser = parameters.get("Jdbc.User");
		String DbPassword = parameters.get("Jdbc.Password");
		// Oracle local: https://www.databasestar.com/oracle-mac/
		db = new Db(DbUrl, DbUser, DbPassword);

		workspace = parameters.get("MONET_WORKSPACE");
		spaceName = parameters.get("MONET_NAME");
		fileNameSSL = workspace + "/certificates/" + FilenameUtils.getBaseName(parameters.get("MONET_CERTIFICATE_FILENAME"));
		fileNameSSLPassword = parameters.get("MONET_CERTIFICATE_PASSWORD");
		federationCAPassword = parameters.get("MONET_CERTIFICATE_CA_KEY_PASSWORD");
		federationCAFileCrt = parameters.get("MONET_CERTIFICATE_CA_CRT_FILENAME");
		federationCAFileKey = parameters.get("MONET_CERTIFICATE_CA_KEY_FILENAME");
	}

	public void initWorkspace() {
		File f = new File(workspace);
		if (!f.exists()) {
			f.mkdirs();
		}
	}

	public boolean isInstalled() {
		return isDBInstalled() && isLogsInstalled() && isCertificatesInstalled() && isCacheInstalled();
	}

	public void processDB() {
		if (isDBInstalled()) return;
		Logger.info("Install database...");

		String sqlScript = "/kernel/database/mysql.sql";
		InputStream in = Installer.class.getResourceAsStream(sqlScript);
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		try {
			db.executeScript(reader);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} catch (IOException e) {
			Logger.error(e);
		}
	}

	public void processLogs() {
		if (isLogsInstalled()) return;
		Logger.info("Install log configuration...");

		String log4jDist = "/WEB-INF/user_data/configuration/log4j.dist.config";
		InputStream in = Installer.class.getResourceAsStream(log4jDist);
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		File fileLog4j = new File(workspace + "/configuration/log4j.config");
		fileLog4j.getParentFile().mkdirs();

		Files.makeDir(workspace + "/logs");

		try {
			Files.saveReaderFile(reader, fileLog4j);
			Files.replaceTextInFile(fileLog4j, "#config_path#", workspace);
		} catch (IOException e) {
			Logger.error(e);
		}
	}

	public void processCertificates() {
		if (isCertificatesInstalled()) return;
		String command;
		Integer exitCode;
		Shell shell = new Shell();

		Files.makeDir(workspace + "/certificates");

		Logger.info("Generate space key");
		command = "openssl genrsa -des3 -passout pass:" + fileNameSSLPassword + " -out " + fileNameSSL + ".key 4096";
		exitCode = shell.executeCommand(command, new File(new File(fileNameSSL).getParent()));
		if (exitCode > 0) {
			Logger.error("I can not generate certificates.");
		}

		Logger.info("Generate space certificate");
		command = "openssl req -new -passin pass:" + fileNameSSLPassword + " -key " + fileNameSSL + ".key -out " + fileNameSSL + ".csr -subj \"/C=ES/ST=Las Palmas de Gran Canaria/L=Tafira/O=CES/OU=Calidad, Eficiencia y Sostenibilidad/CN=business_unit|" + spaceName + "/emailAddress=info@openmonet.com/\"";
		exitCode = shell.executeCommand(command, new File(new File(fileNameSSL).getParent()));
		if (exitCode > 0) Logger.error("I can not generate certificates.");

		Logger.info("Signing certificate");
		command = "openssl x509 -req -passin pass:" + federationCAPassword + " -days 3650 -CA " + federationCAFileCrt + " -CAkey " + federationCAFileKey + " -set_serial 01 -in " + fileNameSSL + ".csr -out " + fileNameSSL + ".crt";
		exitCode = shell.executeCommand(command, new File(new File(fileNameSSL).getParent()));
		if (exitCode > 0) Logger.error("I can not generate certificates.");


		Logger.info("Export certificate");
		command = "openssl pkcs12 -export -passin pass:" + fileNameSSLPassword + " -passout pass:" + fileNameSSLPassword + " -out " + fileNameSSL + ".p12 -inkey " + fileNameSSL + ".key -in " + fileNameSSL + ".crt -certfile " + federationCAFileCrt;
		exitCode = shell.executeCommand(command, new File(new File(fileNameSSL).getParent()));
		if (exitCode > 0) Logger.error("I can not generate certificates.");
	}

	public void processCache() {
		if (isLogsInstalled()) return;
		Logger.info("Install cache configuration...");

		String cacheDist = "/WEB-INF/user_data/configuration/cache.dist.ccf";
		InputStream in = Installer.class.getResourceAsStream(cacheDist);
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		File fileCache = new File(workspace + "/configuration/cache.ccf");
		fileCache.getParentFile().mkdirs();

		try {
			Files.saveReaderFile(reader, fileCache);
			Files.replaceTextInFile(fileCache, "#space_dir#", workspace);
		} catch (IOException e) {
			Logger.error(e);
		}
	}

	private boolean isDBInstalled() {
		try {
			String count = db.executeSentence("SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = '" + db.getDbname() + "' and table_name = 'ts\\$info'");
			return (!count.isEmpty() && Integer.parseInt(count) > 0);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} catch (IOException e) {
			Logger.error(e);
		}
		return true;
	}

	private boolean isLogsInstalled() {
		File f = new File(workspace + "/configuration/log4j.config");
		if (f.exists() && !f.isDirectory()) {
			return true;
		}
		return false;
	}

	private boolean isCertificatesInstalled() {
		File f = new File(fileNameSSL + ".key");
		if (f.exists() && !f.isDirectory()) {
			return true;
		}
		return false;
	}

	private boolean isCacheInstalled() {
		File f = new File(workspace + "/configuration/cache.ccf");
		if (f.exists() && !f.isDirectory()) {
			return true;
		}
		return false;
	}

}
