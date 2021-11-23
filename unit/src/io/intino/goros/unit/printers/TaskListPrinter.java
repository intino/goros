package io.intino.goros.unit.printers;

import io.intino.alexandria.logger.Logger;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.printers.templates.*;
import io.intino.goros.unit.util.Formatters;
import io.intino.goros.unit.util.LayerHelper;
import io.intino.itrules.Frame;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.Template;
import org.monet.metamodel.AttributeProperty;
import org.monet.metamodel.IndexDefinition;
import org.monet.metamodel.SetDefinition;
import org.monet.metamodel.internal.Ref;
import org.monet.space.kernel.library.LibraryDate;
import org.monet.space.kernel.library.LibraryPDF;
import org.monet.space.kernel.model.*;
import org.monet.space.office.core.model.Language;
import org.monet.space.office.presentation.user.renders.TaskListPrintRender;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

import static org.monet.space.kernel.model.DefinitionType.map;

public class TaskListPrinter extends Printer {
	protected final UnitBox box;
	private final Account account;
	private final Map<String, Integer> columnDataSizes = new HashMap<>();
	private final Map<String, Integer> columnPercentages = new HashMap<>();
	protected final TaskSearchRequest request;
	protected final String format;
	protected final List<String> columns;

	public TaskListPrinter(UnitBox box, Account account, TaskSearchRequest request, String format, List<String> columns) {
		this.box = box;
		this.account = account;
		this.request = request;
		this.format = format;
		this.columns = columns;
	}

	public InputStream print(String language) {
		Template template = template();
		String result = template.render(build(language).toFrame());
		return new ByteArrayInputStream(generateDocument(result));
	}

	protected FrameBuilder build(String language) {
		FrameBuilder result = baseFrame().add("tasklist");

		result.add("orientation", "landscape");
		result.add("label", box.translatorService().translate("Tasks", language));
		result.add("pageLabel", box.translatorService().translate("Page", language));
		result.add("content", contentFrame(language));

		return result;
	}

	private FrameBuilder contentFrame(String language) {
		FrameBuilder result = new FrameBuilder().add("content");
		int count = LayerHelper.taskLayer().searchTasksCount(account, request);

		request.setStartPos(0);
		request.setLimit(count);

		result.add("label", box.translatorService().translate("Tasks", language));
		result.add("date", LibraryDate.getDateAndTimeString(new Date(), org.monet.space.office.core.model.Language.getCurrent(), Language.getCurrentTimeZone(), LibraryDate.Format.TEXT, true, "/"));
		result.add("rowCount", count);

		if (count <= 0) {
			result.add("empty");
			return result;
		}

		FrameBuilder references = referencesFrame(count, language);
		calculateColumnPercentages(count, language);

		result.add("references", references);
		result.add("referencesCount", referencesCount(count));
		result.add("header", headerFrame(language));
		result.add("headerCount", columns.size());

		return result;
	}

	private FrameBuilder headerFrame(String language) {
		FrameBuilder result = new FrameBuilder("header");
		result.add("reference", referenceFrame(language));
		return result;
	}

	private int referencesCount(int count) {
		return count > 0 ? (format.equalsIgnoreCase("xls") ? count + 4 : count) : 0;
	}

	private FrameBuilder referencesFrame(int count, String language) {
		FrameBuilder result = new FrameBuilder("references");
		request.setStartPos(0);
		request.setLimit(count);
		Collection<Task> tasks = LayerHelper.taskLayer().searchTasks(account, request).get().values();
		int pos = 0;
		for (Task task : tasks) {
			result.add("reference", referenceFrame(task, pos, language));
			pos++;
		}
		return result;
	}

	private FrameBuilder referenceFrame(String language) {
		FrameBuilder result = new FrameBuilder("reference");
		columns.forEach(column -> result.add("attribute", attributeFrame(column, language)));
		return result;
	}

	private FrameBuilder referenceFrame(Task task, int pos, String language) {
		FrameBuilder result = new FrameBuilder("reference");
		if (pos % 2 != 0) result.add("odd", new FrameBuilder("odd"));
		columns.forEach(column -> result.add("attribute", attributeFrame(task, column, language)));
		return result;
	}

	private FrameBuilder attributeFrame(Task task, String column, String language) {
		FrameBuilder result = attributeFrame(column, language);
		String value = attributeValue(task, column, language).replace("&nsbp;", " ").replace("&", "&amp;");
		updateColumnDataSize(value, column);
		result.add("value", !value.isEmpty() ? value : "-");
		return result;
	}

	private void calculateColumnPercentages(int numRows, String language) {
		int totalSize = getTotalSize();
		if (totalSize == 0) return;

		totalSize = fixColumnsWithShortOrLongData(totalSize, language);
		int maxColumnSize = maxColumnPercentageWith(columns.size());

		for (String column : columns) {
			int wordLength = wordLength(Language.getInstance().getModelResource(attributeLabel(column)));
			int dataSize = columnDataSizes.getOrDefault(column, 0);

			if (dataSize > 0 && wordLength > dataSize)
				dataSize = Math.min(wordLength, maxColumnSize);

			int percentage = (dataSize*100)/totalSize;

			columnPercentages.put(column, percentage);
		}
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
			int wordLength = this.wordLength(Language.getInstance().getModelResource(attributeLabel(column))) + 10;
			int dataSize = columnDataSizes.getOrDefault(column, 0);

			if (dataSize > 0 && wordLength > dataSize) {
				columnDataSizes.put(column, wordLength);

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
			int dataSize = columnDataSizes.getOrDefault(column, 0);

			if ((dataSize*100/totalSize) > maxColumnSize) {
				int newSize = Math.abs(totalSize*maxColumnSize/100);
				columnDataSizes.put(column, newSize);

				totalSize = totalSize-dataSize;
				dataSize = newSize;
				totalSize = totalSize+dataSize;
			}
		}
		return totalSize;
	}

	protected int maxColumnPercentageWith(int countColumns) {
		return 100/countColumns;
	}

	private void updateColumnDataSize(String value, String column) {
		int size = columnDataSizes.getOrDefault(column, 0);
		columnDataSizes.put(column, Math.max(value.length(), size));
	}

	private FrameBuilder attributeFrame(String column, String language) {
		FrameBuilder result = new FrameBuilder("attribute", attributeType(column).toLowerCase());
		result.add("label", attributeLabel(column));
		result.add("width", columnPercentages.getOrDefault(column, 0));
		return result;
	}

	private String attributeLabel(String column) {
		String language = Language.getCurrent();

		if (! TaskListPrintRender.attributesLabels.containsKey(language))
			language = "es";

		return TaskListPrintRender.attributesLabels.get(language).get(positionOf(column));
	}

	private String attributeType(String column) {
		return TaskListPrintRender.attributesTypes.get(positionOf(column));
	}

	private String attributeValue(Task task, String attributeCode, String language) {

		if (attributeCode.equals(TaskListPrinter.Attribute.Label))
			return task.getLabel();

		if (attributeCode.equals(TaskListPrinter.Attribute.Description))
			return String.format("%s. %s", task.getDefinition().getLabel(), task.getDescription());

		if (attributeCode.equals(TaskListPrinter.Attribute.CreateDate))
			return LibraryDate.getDateAndTimeString(task.getInternalCreateDate(), Language.getCurrent(), Language.getCurrentTimeZone(), LibraryDate.Format.NUMERIC, false, "/");

		if (attributeCode.equals(TaskListPrinter.Attribute.UpdateDate))
			return LibraryDate.getDateAndTimeString(task.getInternalUpdateDate(), Language.getCurrent(), Language.getCurrentTimeZone(), LibraryDate.Format.NUMERIC, false, "/");

		if (attributeCode.equals(TaskListPrinter.Attribute.State))
			return box.translatorService().translate(Formatters.firstUpperCase(task.getState()), language);

		if (attributeCode.equals(TaskListPrinter.Attribute.Urgent))
			return box.translatorService().translate(task.isUrgent() ? "Yes" : "No", language);;

		if (attributeCode.equals(TaskListPrinter.Attribute.Owner))
			return String.valueOf(task.getOwner() != null ? task.getOwner().getInfo().getFullname() : "-");

		if (attributeCode.equals(TaskListPrinter.Attribute.Comments))
			return task.getComments() != null ? task.getComments() : "";

		return "";
	}

	private int positionOf(String attribute) {
		int pos = 0;
		for (String currentAttribute : TaskListPrintRender.attributes) {
			if (currentAttribute.equals(attribute))
				return pos;
			pos++;
		}
		return -1;
	}

	protected FrameBuilder baseFrame() {
		return new FrameBuilder();
	}

	private Template template() {
		if (format.equalsIgnoreCase("pdf")) return new PdfTaskListTemplate();
		else if (format.equalsIgnoreCase("xls")) return new XlsTaskListTemplate();
		return new CsvTaskListTemplate();
	}

	protected byte[] generateDocument(String result) {
		try {
			result = result.replace("&amp;nbsp;", " ");
			if (format.equalsIgnoreCase("pdf")) return LibraryPDF.create(new ByteArrayInputStream(result.getBytes("utf8"))).toByteArray();
			if (format.equalsIgnoreCase("xls")) return result.replaceAll("\\\\n", "\r\n").getBytes("UTF-8");
			return result.replaceAll("\\\\n", "\r\n").getBytes("UTF-16LE");
		}
		catch (UnsupportedEncodingException e) {
			Logger.error(e);
			return new byte[0];
		}
	}

	private static final class Attribute {
		private static final String Label = "label";
		private static final String Description = "description";
		private static final String CreateDate = "createDate";
		private static final String UpdateDate = "updateDate";
		private static final String State = "state";
		private static final String Urgent = "urgent";
		private static final String Owner = "owner";
		private static final String Comments = "comments";
	}
}
