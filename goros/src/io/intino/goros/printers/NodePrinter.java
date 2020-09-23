package io.intino.goros.printers;

import io.intino.alexandria.logger.Logger;
import io.intino.goros.box.GorosBox;
import io.intino.goros.printers.templates.CsvNodeTemplate;
import io.intino.goros.printers.templates.PdfNodeTemplate;
import io.intino.goros.printers.templates.XlsNodeTemplate;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.Template;
import org.monet.space.kernel.library.LibraryPDF;
import org.monet.space.kernel.model.Node;
import org.monet.space.kernel.model.NodeDataRequest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

public abstract class NodePrinter {
	protected final GorosBox box;
	protected final Node node;
	protected final NodeDataRequest request;
	protected final String format;
	protected final List<String> columns;

	public NodePrinter(GorosBox box, Node node, NodeDataRequest request, String format, List<String> columns) {
		this.box = box;
		this.node = node;
		this.request = request;
		this.format = format;
		this.columns = columns;
	}

	public InputStream print(String language) {
		Template template = template();
		String result = template.render(build(language).toFrame());
		return new ByteArrayInputStream(generateDocument(result));
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

	protected byte[] generateDocument(String result) {
		try {
			if (format.equalsIgnoreCase("pdf")) return LibraryPDF.create(new ByteArrayInputStream(result.getBytes("utf8"))).toByteArray();
			if (format.equalsIgnoreCase("xls")) return result.replaceAll("\\\\n", "\r\n").getBytes("UTF-8");
			return result.replaceAll("\\\\n", "\r\n").getBytes("UTF-16LE");
		}
		catch (UnsupportedEncodingException e) {
			Logger.error(e);
			return new byte[0];
		}
	}

}
