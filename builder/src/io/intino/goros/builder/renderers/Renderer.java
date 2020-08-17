package io.intino.goros.builder.renderers;

import io.intino.goros.builder.Modernization;
import io.intino.goros.builder.monet.Dictionary;
import io.intino.goros.builder.util.StringUtil;
import io.intino.itrules.FrameBuilder;
import org.monet.metamodel.Definition;
import org.monet.metamodel.FormDefinitionBase;
import org.monet.metamodel.NodeViewProperty;

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
		String label = ((String)viewProperty.getLabel()).replace(" ", "-");
		return stripAccents(firstUpperCase(StringUtil.snakeCaseToCamelCase(label)));
	}

	protected String typeOf(FormDefinitionBase.FormViewProperty viewProperty) {
		return typeOf(viewProperty.getShow());
	}

	protected String typeOf(FormDefinitionBase.FormViewProperty.ShowProperty showProperty) {
		if (showProperty.getNotes() != null) return "notes";
		else if (showProperty.getField() != null) return "fields";
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
