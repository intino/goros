package io.intino.goros.modernizing;

import io.intino.alexandria.logger.Logger;
import io.intino.alexandria.xml.Xml;
import io.intino.goros.modernizing.monet.util.StringUtil;
import io.intino.itrules.formatters.StringFormatters;
import org.w3c.dom.Node;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Modernization {
	private Map<String, String> properties = new HashMap<>();

	public String version() {
		return properties.getOrDefault("version", "");
	}

	public File logo() {
		return new File(properties.getOrDefault("logo", ""));
	}

	public File businessModel() {
		return new File(properties.getOrDefault("model", ""));
	}

	public String projectPackage() {
		return properties.getOrDefault("project.package", "");
	}

	public String projectPackageDirectory() {
		return projectPackage().replace(".", File.separator);
	}

	public String sourceDirectory() {
		return moduleDirectory() + File.separator + "src" + File.separator + projectPackageDirectory() + File.separator + moduleName();
	}

	public String sourceBoxDirectory() {
		return sourceDirectory() + File.separator + "box";
	}

	public String sourceGraphDirectory() {
		return sourceDirectory() + File.separator + "graph";
	}

	public String sourceUiDirectory() {
//		return "./temp/ui"; // TESTING
		return sourceBoxDirectory() + File.separator + "ui";
	}

	public String projectName() {
		return properties.getOrDefault("project.name", "");
	}

	public File projectDirectory() {
		return new File(properties.getOrDefault("project.directory", ""));
	}

	public String moduleName() {
		return properties.getOrDefault("module.name", "");
	}

	public String boxName() {
		String boxName = properties.getOrDefault("artifact.name", "");
		if (boxName.isEmpty()) return moduleName();
		return StringUtil.snakeCaseToCamelCase(boxName);
	}

	public File moduleDirectory() {
		return new File(projectDirectory() + File.separator + moduleName());
	}

	public List<String> excludedDefinitions() {
		String value = properties.getOrDefault("definitions.excluded", "");
		if (value == null || value.isEmpty()) return Collections.emptyList();
		return Arrays.asList(value.split(","));
	}

	private void put(String key, String value) {
		properties.put(key, value);
	}

	public static Modernization load(File file) {
		try {
			Modernization modernization = new Modernization();
			Xml xml = new Xml(new FileInputStream(file));
			io.intino.alexandria.xml.Node root = xml.document().getChildNodes().get(0);
			Node projectNode = root.child("project").get();
			Node moduleNode = root.child("module").get();
			Node artifactNode = root.child("artifact") != null ? root.child("artifact").get() : null;
			Node definitionsNode = root.child("definitions").get();
			modernization.put("model", root.child("model").get().getTextContent());
			modernization.put("project.name", projectNode.getAttributes().getNamedItem("name").getTextContent());
			modernization.put("project.package", projectNode.getAttributes().getNamedItem("package").getTextContent());
			modernization.put("project.directory", projectNode.getAttributes().getNamedItem("directory").getTextContent());
			modernization.put("module.name", moduleNode.getAttributes().getNamedItem("name").getTextContent());
			modernization.put("artifact.name", artifactNode != null ? artifactNode.getAttributes().getNamedItem("name").getTextContent() : "");
			modernization.put("definitions.excluded", definitionsNode.getAttributes().getNamedItem("excluded").getTextContent());
			return modernization;
		} catch (IOException e) {
			Logger.error(e);
			return null;
		}
	}

}
