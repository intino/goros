package io.intino.goros.unit.printers;

import io.intino.alexandria.logger.Logger;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.printers.templates.CsvNodeTemplate;
import io.intino.goros.unit.printers.templates.PdfNodeTemplate;
import io.intino.goros.unit.printers.templates.XlsNodeTemplate;
import io.intino.goros.unit.util.RendererFormatters;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.template.Template;
import org.monet.space.kernel.library.LibraryPDF;
import org.monet.space.kernel.model.Node;
import org.monet.space.kernel.model.NodeDataRequest;

import java.io.*;
import java.util.List;
import java.util.UUID;

public abstract class NodePrinter extends Printer {
	protected final UnitBox box;
	protected final Node node;
	protected final NodeDataRequest request;
	protected final String format;
	protected final List<String> columns;

	public NodePrinter(UnitBox box, Node node, NodeDataRequest request, String format, List<String> columns) {
		this.box = box;
		this.node = node;
		this.request = request;
		this.format = format;
		this.columns = columns;
	}

	public InputStream print(String language) {
		Template template = template();
		String result = new io.intino.itrules.Engine(template).addAll(RendererFormatters.all).render(build(language).toFrame());
		return generateDocument(result);
	}

	protected abstract FrameBuilder build(String language);

	protected FrameBuilder baseFrame() {
		return new FrameBuilder();
	}

	private Template template() {
		if (format.equalsIgnoreCase("pdf")) return new PdfNodeTemplate();
		else if (format.equalsIgnoreCase("xls")) return new XlsNodeTemplate();
		return new CsvNodeTemplate();
	}

	protected InputStream generateDocument(String result) {
		try {
			if (format.equalsIgnoreCase("pdf")) {
				File output = File.createTempFile(UUID.randomUUID().toString(), ".pdf");
				LibraryPDF.create(new ByteArrayInputStream(result.getBytes("utf8")), output);
				return new FileInputStream(output);
			}
			if (format.equalsIgnoreCase("xls")) return streamOf(result.replaceAll("\\\\n", "\r\n").getBytes("UTF-8"));
			return streamOf(result.replaceAll("\\\\n", "\r\n").getBytes("UTF-16LE"));
		}
		catch (IOException e) {
			Logger.error(e);
			return streamOf(new byte[0]);
		}
	}

	private InputStream streamOf(byte[] bytes) {
		return new ByteArrayInputStream(bytes);
	}

}
