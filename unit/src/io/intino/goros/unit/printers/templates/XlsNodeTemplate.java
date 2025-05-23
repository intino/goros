package io.intino.goros.unit.printers.templates;

import io.intino.itrules.template.Rule;
import io.intino.itrules.template.Template;

import java.util.ArrayList;
import java.util.List;

import static io.intino.itrules.template.condition.predicates.Predicates.*;
import static io.intino.itrules.template.outputs.Outputs.*;

public class XlsNodeTemplate extends Template {

	public List<Rule> ruleSet() {
		List<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(allTypes("node")).output(literal("<?xml version=\"1.0\"?>\n<?mso-application progid=\"Excel.Sheet\"?>\n<Workbook xmlns=\"urn:schemas-microsoft-com:office:spreadsheet\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:x=\"urn:schemas-microsoft-com:office:excel\" xmlns:ss=\"urn:schemas-microsoft-com:office:spreadsheet\" xmlns:html=\"http://www.w3.org/TR/REC-html40\" xmlns:xalan=\"http://xml.apache.org/xalan\">\n <DocumentProperties xmlns=\"urn:schemas-microsoft-com:office:office\">\n  <Author>Monet</Author>\n  <LastAuthor>Monet</LastAuthor>\n  <Created>2012-07-20T07:24:01Z</Created>\n  <Company>Microsoft</Company>\n  <Version>12.00</Version>\n </DocumentProperties>\n <ExcelWorkbook xmlns=\"urn:schemas-microsoft-com:office:excel\">\n  <WindowHeight>9480</WindowHeight>\n  <WindowWidth>22068</WindowWidth>\n  <WindowTopX>480</WindowTopX>\n  <WindowTopY>84</WindowTopY>\n  <ProtectStructure>False</ProtectStructure>\n  <ProtectWindows>False</ProtectWindows>\n </ExcelWorkbook>\n <Styles>\n  <Style ss:ID=\"Default\" ss:Name=\"Normal\">\n   <Alignment ss:Vertical=\"Bottom\"/>\n   <Borders/>\n   <Font ss:FontName=\"Calibri\" x:Family=\"Swiss\" ss:Size=\"11\" ss:Color=\"#000000\"/>\n   <Interior/>\n   <NumberFormat/>\n   <Protection/>\n  </Style>\n  <Style ss:ID=\"s62\">\n   <Font ss:FontName=\"Calibri\" x:Family=\"Swiss\" ss:Size=\"20\" ss:Color=\"#000000\"/>\n  </Style>\n  <Style ss:ID=\"s63\">\n   <Alignment ss:Horizontal=\"Center\" ss:Vertical=\"Bottom\"/>\n   <Font ss:FontName=\"Verdana\" x:Family=\"Swiss\" ss:Size=\"9\" ss:Color=\"#FFFFFF\"/>\n   <Interior ss:Color=\"#1F497D\" ss:Pattern=\"Solid\"/>\n  </Style>\n  <Style ss:ID=\"s64\">\n   <Borders/>\n  </Style>\n  <Style ss:ID=\"s73\">\n   <Font ss:FontName=\"Calibri\" x:Family=\"Swiss\" ss:Color=\"#5A5A5A\"/>\n  </Style>\n </Styles>\n <Worksheet ss:Name=\"Listado\">\n   ")).output(placeholder("content")).output(literal("\n  <WorksheetOptions xmlns=\"urn:schemas-microsoft-com:office:excel\">\n   <PageSetup>\n    <Header x:Margin=\"0.3\"/>\n    <Footer x:Margin=\"0.3\"/>\n    <PageMargins x:Bottom=\"0.75\" x:Left=\"0.7\" x:Right=\"0.7\" x:Top=\"0.75\"/>\n   </PageSetup>\n   <Unsynced/>\n   <Print>\n    <ValidPrinterInfo/>\n    <PaperSizeIndex>0</PaperSizeIndex>\n    <HorizontalResolution>600</HorizontalResolution>\n    <VerticalResolution>600</VerticalResolution>\n   </Print>\n   <Selected/>\n   <Panes>\n    <Pane>\n     <Number>3</Number>\n     <ActiveRow>4</ActiveRow>\n    </Pane>\n   </Panes>\n   <ProtectObjects>False</ProtectObjects>\n   <ProtectScenarios>False</ProtectScenarios>\n  </WorksheetOptions>\n </Worksheet>\n</Workbook>")));
		rules.add(rule().condition(allTypes("content", "empty")).output(literal("<Table ss:ExpandedColumnCount=\"2\" ss:ExpandedRowCount=\"3\" x:FullColumns=\"1\" x:FullRows=\"1\" ss:DefaultColumnWidth=\"62.400000000000006\" ss:DefaultRowHeight=\"14.55\">\n <Column ss:AutoFitWidth=\"0\" ss:Width=\"99.6\"/>\n <Column ss:AutoFitWidth=\"0\" ss:Width=\"57\"/>\n <Row ss:AutoFitHeight=\"0\" ss:Height=\"25.8\">\n  <Cell ss:StyleID=\"s62\"><Data ss:Type=\"String\">")).output(placeholder("label")).output(literal("</Data></Cell>\n </Row>\n <Row ss:AutoFitHeight=\"0\">\n  <Cell ss:StyleID=\"s73\"><Data ss:Type=\"String\">")).output(placeholder("date")).output(literal("</Data></Cell>\n </Row>\n <Row ss:AutoFitHeight=\"0\">\n   <Cell ss:StyleID=\"s64\"><Data ss:Type=\"String\">")).output(placeholder("noElementsMessage")).output(literal("</Data></Cell>\n </Row>\n</Table>")));
		rules.add(rule().condition(allTypes("content")).output(literal("<Table ss:ExpandedColumnCount=\"")).output(placeholder("headerCount")).output(literal("\" ss:ExpandedRowCount=\"")).output(placeholder("referencesCount")).output(literal("\" x:FullColumns=\"1\" x:FullRows=\"1\" ss:DefaultColumnWidth=\"62.400000000000006\" ss:DefaultRowHeight=\"14.55\">\n <Column ss:AutoFitWidth=\"0\" ss:Width=\"99.6\"/>\n <Column ss:AutoFitWidth=\"0\" ss:Width=\"57\"/>\n <Row ss:AutoFitHeight=\"0\" ss:Height=\"25.8\">\n  <Cell ss:StyleID=\"s62\"><Data ss:Type=\"String\">")).output(placeholder("label")).output(literal("</Data></Cell>\n </Row>\n <Row ss:AutoFitHeight=\"0\">\n  <Cell ss:StyleID=\"s73\"><Data ss:Type=\"String\">")).output(placeholder("date")).output(literal("</Data></Cell>\n </Row>\n ")).output(placeholder("header")).output(literal("\n ")).output(placeholder("references")).output(literal("\n</Table>")));
		rules.add(rule().condition(allTypes("header")).output(expression().output(placeholder("reference", "header").multiple("\n"))));
		rules.add(rule().condition(allTypes("references")).output(expression().output(placeholder("reference").multiple("\n"))));
		rules.add(rule().condition(all(allTypes("reference"), trigger("header"))).output(literal("<Row ss:Index=\"4\" ss:AutoFitHeight=\"0\">\n  ")).output(expression().output(placeholder("attribute", "header").multiple("\n"))).output(literal("\n</Row>")));
		rules.add(rule().condition(allTypes("reference")).output(literal("<Row ss:AutoFitHeight=\"0\">\n  ")).output(expression().output(placeholder("attribute").multiple("\n"))).output(literal("\n</Row>")));
		rules.add(rule().condition(all(allTypes("attribute"), trigger("header"))).output(literal("<Cell ss:StyleID=\"s63\"><Data ss:Type=\"String\">")).output(placeholder("label")).output(literal("</Data></Cell>")));
		rules.add(rule().condition(allTypes("attribute")).output(literal("<Cell ss:StyleID=\"s64\"><Data ss:Type=\"")).output(placeholder("type")).output(literal("\">")).output(placeholder("value")).output(literal("</Data></Cell>")));
		return rules;
	}

	public String render(Object object) {
		return new io.intino.itrules.Engine(this).render(object);
	}

	public String render(Object object, java.util.Map<String, io.intino.itrules.Formatter> formatters) {
		return new io.intino.itrules.Engine(this).addAll(formatters).render(object);
	}
}