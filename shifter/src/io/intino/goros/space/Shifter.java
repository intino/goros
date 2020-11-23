package io.intino.goros.space;

import com.jcabi.aether.Aether;
import org.eclipse.aether.util.artifact.JavaScopes;
import org.sonatype.aether.artifact.Artifact;
import org.sonatype.aether.repository.RemoteRepository;
import org.sonatype.aether.repository.RepositoryPolicy;
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
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.io.File.separator;
import static org.sonatype.aether.repository.RepositoryPolicy.UPDATE_POLICY_ALWAYS;
import static org.sonatype.aether.repository.RepositoryPolicy.UPDATE_POLICY_DAILY;

public class Shifter {
	public static final String INTINO_RELEASES = "https://artifactory.intino.io/artifactory/releases";
	public static final String INTINO_SNAPSHOTS = "https://artifactory.intino.io/artifactory/snapshots";

	public static final String GROUP_ID = "io.intino.goros.modernizing";

	public static void main(String[] args) throws Exception {
		File file = new File(args[0]);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(file);
		NodeList nodeList = document.getElementsByTagName("platform");
		if (nodeList == null || nodeList.getLength() == 0) throw new Exception("Platform parameter not found");
		Node platform = nodeList.item(0);
		String artifactId = platform.getTextContent().substring(0, platform.getTextContent().indexOf("-"));
		String version = platform.getTextContent().substring(platform.getTextContent().indexOf("-") + 1);
		List<File> libraries = find(GROUP_ID + ":" + artifactId + ":" + version);
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
		Aether aether = new Aether(artifactories(), new File(System.getProperty("user.home") + File.separator + ".m2" + File.separator + "repository"));
		return aether.resolve(new DefaultArtifact(artifact.toLowerCase()), JavaScopes.COMPILE).stream().map(Artifact::getFile).collect(Collectors.toList());
	}

	private static Collection<RemoteRepository> artifactories() {
		List<RemoteRepository> remotes = new ArrayList<>();
		remotes.add(new RemoteRepository("intino-maven", "default", INTINO_RELEASES).setPolicy(false, new RepositoryPolicy().setEnabled(true).setUpdatePolicy(UPDATE_POLICY_DAILY)));
		remotes.add(new RemoteRepository("intino-maven", "default", INTINO_SNAPSHOTS).setPolicy(true, new RepositoryPolicy().setEnabled(true).setUpdatePolicy(UPDATE_POLICY_ALWAYS)));
		return remotes;
	}
}
