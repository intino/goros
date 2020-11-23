package io.intino.goros.unit.printers;

import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.util.LayerHelper;
import io.intino.itrules.FrameBuilder;
import org.monet.metamodel.AttributeProperty;
import org.monet.metamodel.IndexDefinition;
import org.monet.metamodel.IndexDefinitionBase;
import org.monet.metamodel.SetDefinition;
import org.monet.metamodel.SetDefinition.SetViewProperty;
import org.monet.metamodel.internal.DescriptorDefinition;
import org.monet.metamodel.internal.Ref;
import org.monet.space.kernel.library.LibraryDate;
import org.monet.space.kernel.model.*;
import org.monet.space.kernel.model.DataRequest.GroupBy;
import org.monet.space.kernel.model.Dictionary;
import org.monet.space.office.configuration.Configuration;
import org.monet.space.office.core.model.Language;

import java.util.*;

import static edu.emory.mathcs.backport.java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;

public class SetPrinter extends NodePrinter {
	Map<String, Integer> columnDataSizes = new HashMap<>();
	Map<String, Integer> columnPercentages = new HashMap<>();

	private static final int WordLengthOffset = 10;

	public SetPrinter(UnitBox box, Node node, NodeDataRequest request, String format, List<String> columns) {
		super(box, node, request, format, columns);
		request.setCodeReference(index().getCode());
	}

	@Override
	protected FrameBuilder build(String language) {
		FrameBuilder result = super.baseFrame().add("node");
		SetDefinition definition = definition();
		IndexDefinition indexDefinition = index();

		result.add("orientation", (indexDefinition.getReference() != null && indexDefinition.getReference().getAttributePropertyList().size() > 5) ? "landscape" : "portrait");
		result.add("label", definition.getLabelString());
		result.add("pageLabel", box.translatorService().translate("Page", language));
		result.add("content", contentFrame(language));

		return result;
	}

	private FrameBuilder contentFrame(String language) {
		SetDefinition definition = definition();
		FrameBuilder result = new FrameBuilder("content");

		result.add("label", definition.getLabelString());
		result.add("date", LibraryDate.getDateAndTimeString(new Date(), language, Language.getCurrentTimeZone(), LibraryDate.Format.TEXT, true, "/"));
		result.add("filters", filtersFrame(language));
		result.add("noElementsMessage", box.translatorService().translate("No elements", language));

		if (view().getShow().getIndex() == null) {
			result.add("empty");
			return result;
		}

		int count = LayerHelper.nodeLayer().requestNodeListItemsCount(node.getId(), request);
		if (count <= 0) {
			result.add("empty");
			return result;
		}

		FrameBuilder references = referencesFrame(count, language);
		calculateColumnPercentages(count, language);

		result.add("references", references);
		result.add("referencesCount", referencesCount(count));
		result.add("header", headerFrame(language));
		result.add("headerCount", index().getReference().getAttributePropertyList().size());

		return result;
	}

	private int referencesCount(int count) {
		return count > 0 ? (format.equalsIgnoreCase("xls") ? count + 4 : count) : 0;
	}

	private FrameBuilder filtersFrame(String language) {
		FrameBuilder result = new FrameBuilder("filters");
		String condition = request.getCondition();

		if (request.getGroupsBy().size() == 0 && (condition == null || condition.isEmpty())) {
			result.add("empty");
			return result;
		}

		result.add("filtersMessage", box.translatorService().translate("Filters", language));

		if (condition != null && !condition.isEmpty())
			result.add("filter", filterFrame(box.translatorService().translate("Condition", language), condition));

		request.getGroupsBy().forEach(groupBy -> {
			AttributeProperty attributeDefinition = attributePropertyOf(groupBy.attribute(), language);
			String label = Language.getInstance().getModelResource(attributeDefinition.getLabel());
			List<String> values = filterValuesOfGroupBy(groupBy);
			result.add("filter", groupByFilterFrame(groupBy, label, values));
		});

		return result;
	}

	private FrameBuilder filterFrame(String label, String value) {
		return filterFrame(label, singletonList(value));
	}

	private FrameBuilder groupByFilterFrame(GroupBy groupBy, String label, List<String> values) {
		return filterFrame(label, values).add(groupBy.operator().toString().toLowerCase());
	}

	private FrameBuilder filterFrame(String label, List<String> values) {
		FrameBuilder result = new FrameBuilder("filter").add("label", label);
		values.forEach(v -> result.add("value", v));
		return result;
	}

	private SetDefinition definition() {
		return (SetDefinition) node.getDefinition();
	}

	private IndexDefinition index() {
		return Dictionary.getInstance().getIndexDefinition(definition().getIndex().getValue());
	}

	private IndexDefinitionBase.IndexViewProperty indexView() {
		String value = view().getShow().getIndex().getWithView().getValue();
		return index().getView(value);
	}

	private SetViewProperty view() {
		return (SetViewProperty) definition().getNodeView(request.getCodeView());
	}

	private List<String> filterValuesOfGroupBy(GroupBy groupBy) {
		return groupBy.values().stream().map(v -> {
			v = format(groupBy, v);
			if (v instanceof Date)
				return LibraryDate.getDateAndTimeString((Date) v, Language.getCurrent(), BusinessUnit.getTimeZone(), LibraryDate.Format.TEXT, false, "/").trim();
			return (String)v;
		}).collect(toList());
	}

	private Object format(GroupBy groupBy, Object value) {
		if (!groupBy.attribute().equals(DescriptorDefinition.ATTRIBUTE_CODE)) return value;
		return Dictionary.getInstance().getDefinition((String)value).getLabelString();
	}

	private AttributeProperty attributePropertyOf(String attribute, String language) {
		AttributeProperty attributeDefinition = index().getAttribute(attribute);
		if (attributeDefinition != null) return attributeDefinition;

		attributeDefinition = new DescriptorDefinition().getAttribute(attribute);
		attributeDefinition.setLabel(box.translatorService().translate("Code", language));

		return attributeDefinition;
	}

	private FrameBuilder headerFrame(String language) {
		FrameBuilder result = new FrameBuilder("header");
		result.add("reference", referenceFrame(language));
		return result;
	}

	private FrameBuilder referencesFrame(int count, String language) {
		FrameBuilder result = new FrameBuilder("references");
		request.setStartPos(0);
		request.setLimit(count);
		Collection<Node> nodes = LayerHelper.nodeLayer().requestNodeListItems(node.getId(), request).values();
		int pos = 0;
		for (Node node : nodes) {
			result.add("reference", referenceFrame(node, pos, language));
			pos++;
		}
		return result;
	}

	private FrameBuilder referenceFrame(String language) {
		FrameBuilder result = new FrameBuilder("reference");
		columns.forEach(column -> result.add("attribute", attributeFrame(column, language)));
		return result;
	}

	private FrameBuilder referenceFrame(Node node, int pos, String language) {
		IndexDefinition index = index();
		Reference reference = node.getReference(index.getCode());
		FrameBuilder result = new FrameBuilder("reference");
		if (pos % 2 != 0) result.add("odd", new FrameBuilder("odd"));
		columns.forEach(column -> result.add("attribute", attributeFrame(reference, column, language)));
		return result;
	}

	private FrameBuilder attributeFrame(Reference reference, String column, String language) {
		FrameBuilder result = attributeFrame(column, language);
		AttributeProperty attributeProperty = attributePropertyOf(column, language);
		ReferenceAttribute<?> attribute = reference.getAttribute(attributeProperty.getCode());
		String value = valueOf(attribute, attributeProperty);
		updateColumnDataSize(value, attributeProperty);
		result.add("value", !value.isEmpty() ? value : "-");
		return result;
	}

	private FrameBuilder attributeFrame(String column, String language) {
		AttributeProperty attributeProperty = attributePropertyOf(column, language);
		FrameBuilder result = new FrameBuilder("attribute", attributeProperty.getType().toString().toLowerCase());
		result.add("label", Language.getInstance().getModelResource(attributeProperty.getLabel(), language));
		result.add("width", columnPercentages.getOrDefault(attributeProperty.getCode(), 0));
		return result;
	}

	private String valueOf(ReferenceAttribute<?> attribute, AttributeProperty attributeDeclaration) {
		String value = attribute.getValueAsString();

		if (attributeDeclaration.getType() == AttributeProperty.TypeEnumeration.PICTURE)
			value = Configuration.getInstance().getFmsServletUrl() + "?op=downloadimage&nid=" + node.getId() + "&f=" + value.replace(" ", "%20") + "&thumb=1&r=" + Math.random();

		if (attributeDeclaration.getType() == AttributeProperty.TypeEnumeration.BOOLEAN)
			value = value.toLowerCase().equals("true") ? "X" : "";

		return value.replace("&", "&amp;");
	}

	private void updateColumnDataSize(String value, AttributeProperty attributeProperty) {
		int size = attributeProperty.getType() == AttributeProperty.TypeEnumeration.PICTURE ? 20 : columnDataSizes.getOrDefault(attributeProperty.getCode(), 0);
		columnDataSizes.put(attributeProperty.getCode(), Math.max(value.length(), size));
	}

	private void calculateColumnPercentages(int numRows, String language) {
		ArrayList<Ref> showList = mergeIndexShows();

		if (showList.size() == 0) return;

		int totalSize = getTotalSize();
		if (totalSize == 0) return;

		totalSize = fixColumnsWithShortOrLongData(totalSize, language);
		int maxColumnSize = maxColumnPercentageWith(columns.size());

		for (String column : columns) {
			AttributeProperty attributeDefinition = attributePropertyOf(column, language);
			String code = attributeDefinition.getCode();
			int wordLength = wordLength(Language.getInstance().getModelResource(attributeDefinition.getLabel()));
			int dataSize = columnDataSizes.getOrDefault(code, 0);

			if (dataSize > 0 && wordLength > dataSize)
				dataSize = Math.min(wordLength, maxColumnSize);

			int percentage = (dataSize*100)/totalSize;

			columnPercentages.put(code, percentage);
		}
	}

	protected ArrayList<Ref> mergeIndexShows() {
		ArrayList<Ref> showList = new ArrayList<Ref>();
		IndexDefinitionBase.IndexViewProperty.ShowProperty showProperty = indexView().getShow();

		if (showProperty.getTitle() != null)
			showList.add(showProperty.getTitle());

		if (showProperty.getPicture() != null)
			showList.add(showProperty.getPicture());

		showList.addAll(showProperty.getHighlight());
		showList.addAll(showProperty.getLine());
		showList.addAll(showProperty.getLineBelow());
		showList.addAll(showProperty.getFooter());

		return showList;
	}

	private int getTotalSize() {
		return columnDataSizes.values().stream().mapToInt(v -> v).sum();
	}

	private int fixColumnsWithShortOrLongData(int totalSize, String language) {

		totalSize = fixShortDataColumns(totalSize, language);
		totalSize = fixLongDataColumns(totalSize, language);

		return totalSize;
	}

	private int fixShortDataColumns(int totalSize, String language) {
		for (String column : columns) {
			AttributeProperty attributeDefinition = attributePropertyOf(column, language);
			String code = attributeDefinition.getCode();
			int wordLength = this.wordLength(Language.getInstance().getModelResource(attributeDefinition.getLabel())) + 10;
			int dataSize = columnDataSizes.getOrDefault(code, 0);

			if (dataSize > 0 && wordLength > dataSize) {
				columnDataSizes.put(code, wordLength);

				totalSize = totalSize-dataSize;
				dataSize = wordLength;
				totalSize = totalSize+dataSize;
			}
		}
		return totalSize;
	}

	private int fixLongDataColumns(int totalSize, String language) {
		int maxColumnSize = maxColumnPercentageWith(columns.size());

		for (String column : columns) {
			AttributeProperty attributeDefinition = attributePropertyOf(column, language);
			String code = attributeDefinition.getCode();
			int dataSize = columnDataSizes.getOrDefault(code, 0);

			if ((dataSize*100/totalSize) > maxColumnSize) {
				int newSize = Math.abs(totalSize*maxColumnSize/100);
				columnDataSizes.put(code, newSize);

				totalSize = totalSize-dataSize;
				dataSize = newSize;
				totalSize = totalSize+dataSize;
			}
		}
		return totalSize;
	}

	int wordLength(String label) {
		if (label == null)
			return 0;

		String[] labelArray = label.split(" ");
		int result = 0;
		for (int i=0; i<labelArray.length; i++) {
			if (labelArray[i].length() > result)
				result = labelArray[i].length();
		}

		return result + WordLengthOffset;
	}

	protected int maxColumnPercentageWith(int countColumns) {
		return 100/countColumns;
	}
}
