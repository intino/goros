package io.intino.goros.builder;

import io.intino.alexandria.logger.Logger;
import io.intino.goros.builder.monet.Dictionary;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class Modernization {
	private Properties properties = new Properties();

	private static final String ModuleName = "model";

	public String version() {
		return properties.getProperty("version");
	}

	public File logo() {
		return new File(properties.getProperty("logo"));
	}

	public File businessModel() {
		return new File(properties.getProperty("model"));
	}

	public String projectPackage() {
		return properties.getProperty("project.package");
	}

	public String projectPackageDirectory() {
		return projectPackage().replace(".", File.separator);
	}

	public String sourceDirectory() {
		return moduleDirectory() + File.separator + "src" + File.separator + projectPackageDirectory();
	}

	public String sourceBoxDirectory() {
		return sourceDirectory() + File.separator + "box";
	}

	public String sourceUiDirectory() {
		return "./temp/ui"; // TESTING
//		return sourceBoxDirectory() + File.separator + "ui";
	}

	public String projectName() {
		return properties.getProperty("project.name");
	}

	public File projectDirectory() {
		return new File(properties.getProperty("project.directory"));
	}

	public String moduleName() {
		return Modernization.ModuleName;
	}

	public File moduleDirectory() {
		return new File(projectDirectory() + File.separator + moduleName());
	}

	public List<String> excludedDefinitions() {
		String value = properties.getProperty("definitions.excluded");
		if (value == null || value.isEmpty()) return Collections.emptyList();
		return Arrays.asList(value.split(","));
	}

	public static Modernization load(File file) {
		try {
			Modernization modernization = new Modernization();
			modernization.properties.load(new FileInputStream(file));
			return modernization;
		} catch (IOException e) {
			Logger.error(e);
			return null;
		}
	}

}
