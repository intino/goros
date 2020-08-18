package io.intino.goros.builder.renderers;

import io.intino.goros.builder.Modernization;
import io.intino.goros.builder.monet.Dictionary;
import io.intino.goros.builder.util.StringUtil;
import io.intino.itrules.FrameBuilder;
import org.monet.metamodel.*;
import org.monet.metamodel.FormDefinitionBase.FormViewProperty;

import javax.swing.text.html.FormView;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.logging.Logger;

import static io.intino.goros.builder.util.StringUtil.firstUpperCase;
import static io.intino.goros.builder.util.StringUtil.stripAccents;

public abstract class Renderer {
	protected final Dictionary dictionary;
	protected final Modernization modernization;

	public Renderer(Dictionary dictionary, Modernization modernization) {
		this.dictionary = dictionary;
		this.modernization = modernization;
	}

	public abstract void write();

	protected FrameBuilder baseFrame() {
		return new FrameBuilder().add("package", modernization.projectPackage()).add("module", modernization.moduleName());
	}

	protected void writeFrame(File file, String content) {
		try {
			file.getParentFile().mkdirs();
			Files.write(file.toPath(), content.getBytes(StandardCharsets.UTF_8));
		} catch (IOException e) {
			Logger.getGlobal().severe(e.getMessage());
		}
	}

	protected String nameOf(Definition definition) {
		String name = definition.getName();
		return name.contains(".") ? name.substring(name.lastIndexOf(".")+1) : name;
	}

	protected String nameOf(NodeViewProperty viewProperty) {
		String name = viewProperty.getName();
		if (name != null && !name.isEmpty()) return name;
		return normalize((String)viewProperty.getLabel());
	}

	protected String normalize(String name) {
		name = name.replace(" ", "-").replace("_", "-");
		return stripAccents(firstUpperCase(StringUtil.snakeCaseToCamelCase(name)));
	}

	protected String typeOf(NodeViewProperty viewProperty) {
		if (viewProperty instanceof SetDefinition.SetViewProperty) return typeOf(((SetDefinition.SetViewProperty)viewProperty).getShow());
		if (viewProperty instanceof ContainerDefinitionBase.ViewProperty) return typeOf(((ContainerDefinitionBase.ViewProperty)viewProperty).getShow());
		if (viewProperty instanceof FormViewProperty) return typeOf(((FormViewProperty)viewProperty).getShow());
		return null;
	}

	protected String typeOf(SetDefinitionBase.SetViewPropertyBase.ShowProperty showProperty) {
		if (showProperty.getIndex() != null) return "index";
		if (showProperty.getItems() != null) return "items";
		if (showProperty.getOwnedPrototypes() != null) return "ownedprototypes";
		if (showProperty.getSharedPrototypes() != null) return "sharedprototypes";
		if (showProperty.getLocations() != null) return "locations";
		if (showProperty.getReport() != null) return "report";
		return null;
	}

	protected String typeOf(ContainerDefinitionBase.ViewProperty.ShowProperty showProperty) {
		if (showProperty.getLinksIn() != null) return "linksin";
		else if (showProperty.getLinksOut() != null) return "linksout";
		else if (showProperty.getLocation() != null) return "location";
		else if (showProperty.getNotes() != null) return "notes";
		else if (showProperty.getRecentTask() != null) return "recenttask";
		else if (showProperty.getRevisions() != null) return "revisions";
		else if (showProperty.getTasks() != null) return "tasks";
		else if (showProperty.getComponent().size() > 0) return "components";
		return null;
	}

	protected String typeOf(FormViewProperty.ShowProperty showProperty) {
		if (showProperty.getNotes() != null) return "notes";
		else if (showProperty.getField().size() > 0) return "fields";
		else if (showProperty.getAttachments() != null) return "attachments";
		else if (showProperty.getRecentTask() != null) return "recenttask";
		else if (showProperty.getLayout() != null) return "layout";
		else if (showProperty.getLayoutExtended() != null) return "layoutextended";
		else if (showProperty.getLinksIn() != null) return "linksin";
		else if (showProperty.getLinksOut() != null) return "linksout";
		else if (showProperty.getLocation() != null) return "location";
		else if (showProperty.getRevisions() != null) return "revisions";
		else if (showProperty.getTasks() != null) return "tasks";
		return null;
	}

}
