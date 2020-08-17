package io.intino.goros;

import com.jcabi.aether.Aether;
import org.eclipse.aether.util.artifact.JavaScopes;
import org.sonatype.aether.artifact.Artifact;
import org.sonatype.aether.resolution.DependencyResolutionException;
import org.sonatype.aether.util.artifact.DefaultArtifact;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.io.File.separator;

public class Shifter {

	public static final String GROUP_ID = "io.intino.goros.builders";

	public static void main(String[] args) throws Exception {
		File file = new File(args[0]);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(file);
		NodeList nodeList = document.getElementsByTagName("platform");
		if (nodeList == null || nodeList.getLength() == 0) throw new Exception("Platform parameter not found");
		Node platform = nodeList.item(0);
		String[] coors = platform.getTextContent().split("-");
		List<File> libraries = find(GROUP_ID + ":" + coors[0] + ":" + coors[1]);
		execute(libraries, file);
	}

	private static void execute(List<File> libraries, File file) throws IOException {
		List<String> commandParameters = new ArrayList<>();
		String javaBin = java.lang.System.getProperty("java.home") + separator + "bin" + separator + "java";
		commandParameters.add(javaBin);
		commandParameters.add("-Dfile.encoding=UTF-8");
		commandParameters.addAll(Arrays.asList("-jar", libraries.get(0).getAbsolutePath()));
		commandParameters.add(file.getAbsolutePath());
		new ProcessBuilder(commandParameters).redirectErrorStream(true).start();
	}

	private static List<File> find(String artifact) throws DependencyResolutionException {
		Aether aether = new Aether(Collections.emptyList(), new File(System.getProperty("user.home") + File.separator + ".m2" + File.separator + "repository"));
		return aether.resolve(new DefaultArtifact(artifact.toLowerCase()), JavaScopes.COMPILE).stream().map(Artifact::getFile).collect(Collectors.toList());
	}
}
