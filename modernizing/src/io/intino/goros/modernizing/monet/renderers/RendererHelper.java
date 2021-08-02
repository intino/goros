package io.intino.goros.modernizing.monet.renderers;

import io.intino.goros.modernizing.monet.util.StringUtil;
import org.monet.metamodel.*;

import java.util.Arrays;
import java.util.stream.Collectors;

import static io.intino.goros.modernizing.monet.util.StringUtil.*;

public class RendererHelper {

	public static String nameOf(Definition definition, String basePackage) {
		String prefix = prefixOf(definition, basePackage);
		String name = definition.getName();
		name = name.contains(".") ? name.substring(name.lastIndexOf(".")+1) : name;
		return prefix + name;
	}

	private static String prefixOf(Definition definition, String basePackage) {
		String prefix = definition.getName();
		if (!prefix.contains(".")) return "";
		prefix = prefix.substring(0, prefix.lastIndexOf("."));
		prefix = prefix.replace(basePackage + ".", "").replace(basePackage, "").replace(".", "-");
		return snakeCaseToCamelCase(/*shortName(*/prefix/*)*/);
	}

	public static String nameOf(IndexDefinitionBase.IndexViewProperty viewProperty) {
		return nameOf(viewProperty, viewProperty.getName());
	}

	public static String nameOf(NodeViewProperty viewProperty) {
		return nameOf(viewProperty, normalize(labelOf(viewProperty)));
	}

	public static String nameOf(ProcessDefinitionBase.ViewProperty viewProperty) {
		return nameOf(viewProperty, normalize(labelOf(viewProperty)));
	}

	public static String nameOf(ViewProperty viewProperty, String label) {
		String name = viewProperty.getName();
		if (name != null && !name.isEmpty()) return name;
		return normalize(label != null ? label : viewProperty.getCode());
	}

	public static String shortName(String snakeName) {
		return Arrays.stream(snakeName.split("-")).map(RendererHelper::initials).collect(Collectors.joining("-"));
	}

	public static String initials(String name) {
		String initials = name.replaceAll("[a-z]", "");
		if (!initials.isEmpty()) return initials;
		return name.length() > 2 ? name.substring(0, 3) : name;
	}

	public static String labelOf(NodeViewProperty viewProperty) {
		return labelOf((String) viewProperty.getLabel(), viewProperty.getName());
	}

	public static String labelOf(ProcessDefinitionBase.ViewProperty viewProperty) {
		return labelOf((String) viewProperty.getLabel(), viewProperty.getName());
	}

	public static String labelOf(String label, String name) {
		return label != null && !label.isEmpty() ? label : name;
	}

	public static String normalize(String name) {
		if (name == null) return null;
		name = name.replace("/", "-").replace(" ", "-").replace("_", "-");
		return stripAccents(firstUpperCase(StringUtil.snakeCaseToCamelCase(name)));
	}

	public static String typeOf(NodeViewProperty viewProperty) {
		if (viewProperty instanceof DesktopDefinitionBase.ViewProperty) return typeOf(((DesktopDefinitionBase.ViewProperty)viewProperty).getShow());
		if (viewProperty instanceof SetDefinition.SetViewProperty) return typeOf(((SetDefinition.SetViewProperty)viewProperty).getShow());
		if (viewProperty instanceof ContainerDefinitionBase.ViewProperty) return typeOf(((ContainerDefinitionBase.ViewProperty)viewProperty).getShow());
		if (viewProperty instanceof FormDefinitionBase.FormViewProperty) return typeOf(((FormDefinitionBase.FormViewProperty)viewProperty).getShow());
		return null;
	}

	public static String typeOf(DesktopDefinition.ViewProperty.ShowProperty showProperty) {
		if (showProperty.getLink().size() > 0) return "links";
		if (showProperty.getDashboard().size() > 0) return "dashboards";
		return null;
	}

	public static String typeOf(SetDefinitionBase.SetViewPropertyBase.ShowProperty showProperty) {
		if (showProperty.getIndex() != null) return "index";
		if (showProperty.getItems() != null) return "items";
		if (showProperty.getOwnedPrototypes() != null) return "ownedprototypes";
		if (showProperty.getSharedPrototypes() != null) return "sharedprototypes";
		if (showProperty.getLocations() != null) return "locations";
		if (showProperty.getReport() != null) return "report";
		return null;
	}

	public static String typeOf(ContainerDefinitionBase.ViewProperty.ShowProperty showProperty) {
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

	public static String typeOf(FormDefinitionBase.FormViewProperty.ShowProperty showProperty) {
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

	public static String typeOf(CompositeFieldProperty.ViewProperty.ShowProperty showProperty) {
		if (showProperty == null || showProperty.getField().size() > 0) return "fields";
		else if (showProperty.getLayout() != null) return "layout";
		return null;
	}

	public static String attributeTypeOf(AttributeProperty attributeProperty) {
		AttributeProperty.TypeEnumeration type = attributeProperty.getType();
		if (type == AttributeProperty.TypeEnumeration.DATE) return "Date";
		else if (type == AttributeProperty.TypeEnumeration.PICTURE) return "Image";
		else if (type == AttributeProperty.TypeEnumeration.INTEGER || type == AttributeProperty.TypeEnumeration.REAL) return "Number";
		return "Text";
	}

	public static String dimensionTypeOf(AttributeProperty attributeProperty) {
		AttributeProperty.TypeEnumeration type = attributeProperty.getType();
		if (type == AttributeProperty.TypeEnumeration.DATE) return "DateRange";
		if (type == AttributeProperty.TypeEnumeration.STRING) return "Search";
		if (type == AttributeProperty.TypeEnumeration.BOOLEAN) return "Check";
		return "Combo";
	}

	public static int countAttributes(IndexDefinitionBase.IndexViewProperty viewProperty) {
		IndexDefinitionBase.IndexViewProperty.ShowProperty show = viewProperty.getShow();
		int count = 0;
		if (show.getTitle() != null) count++;
		if (show.getPicture() != null) count++;
		if (show.getIcon() != null) count++;
		count += show.getHighlight().size();
		count += show.getLine().size();
		count += show.getLineBelow().size();
		count += show.getFooter().size();
		return count;
	}
}
