package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.UserMessage;
import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.spark.UIFile;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.box.ui.datasources.model.Column;
import io.intino.goros.unit.util.Formatters;
import io.intino.goros.unit.util.NodeHelper;
import org.monet.space.kernel.model.Node;
import org.monet.space.kernel.model.NodeDataRequest;

import java.io.InputStream;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static io.intino.goros.unit.util.NodeHelper.sortingOf;
import static io.intino.goros.unit.util.NodeHelper.sortsByOf;
import static java.util.Collections.singletonList;

public class NodeDownloadDialog extends AbstractNodeDownloadDialog<UnitBox> {
    private Node node;
    private String view;
    private List<Column> columns = new ArrayList<>();
    private Consumer<Boolean> terminateListener;
    private String condition;
    private List<Filter> filters;
    private String sorting;
    private String sortingMode;

    public NodeDownloadDialog(UnitBox box) {
        super(box);
    }

    public NodeDownloadDialog onTerminate(Consumer<Boolean> listener) {
        this.terminateListener = listener;
        return this;
    }

    public NodeDownloadDialog node(Node node) {
        this.node = node;
        return this;
    }

    public NodeDownloadDialog view(String view) {
        this.view = view;
        return this;
    }

    public NodeDownloadDialog condition(String condition) {
        this.condition = condition;
        return this;
    }

    public NodeDownloadDialog filters(List<Filter> filters) {
        this.filters = filters;
        return this;
    }

    public NodeDownloadDialog sorting(String sorting, String mode) {
        this.sorting = sorting;
        this.sortingMode = mode;
        return this;
    }

    public NodeDownloadDialog columns(List<Column> columns) {
        this.columns = columns;
        return this;
    }

    @Override
    public void init() {
        super.init();
        format.onSelect(e -> {
            refreshDownloadMessage();
            refreshToolbar();
        });
        downloadCancel.onExecute(e -> terminateListener.accept(true));
        downloadAccept.onExecute(e -> accept());
        columnModeSelector.onSelect(e -> updateMode());
    }

    @Override
    public void refresh() {
        super.refresh();
        format.select("pdf");
        columnModeSelector.select("allColumns");
        refreshDownloadMessage();
        refreshColumns();
        refreshToolbar();
    }

    private void refreshDownloadMessage() {
        boolean checkCount = format.selection().isEmpty() || !format.selection().get(0).equalsIgnoreCase("csv");
        if (!checkCount) {
            downloadMessage.visible(false);
            return;
        }
        long countItems = totalItems(request());
        boolean exceeded = limitExceeded(countItems);
        downloadMessage.visible(exceeded);
        if (!exceeded) return;
        downloadMessage.value(String.format("La descarga total es de %s. Por rendimiento, será incluirán %s para los formatos PDF ó XLS. Si desea descargar todos los elementos, seleccione la descarga en formato CSV.", Formatters.countMessage(countItems, "elemento", "elementos"), Formatters.countMessage(limit(), "elemento", "elementos")));
    }

    private boolean check() {
        if (format.selection().size() <= 0) return false;
        if (allColumnsMode()) return true;
        return options.children(DownloadDialogOption.class).stream().anyMatch(c -> c.selectedColumn() != null);
    }

    private int totalItems(NodeDataRequest request) {
        return NodeHelper.countItems(node, request);
    }

    private boolean limitExceeded(long countItems) {
        long limit = limit();
        boolean check = format.selection().isEmpty() || !format.selection().get(0).equals("csv");
        if (!check) return false;
        return limit != -1 && countItems >= limit;
    }

    private int limit() {
        String limit = box().configuration().downloadNodesLimit();
        return limit != null && !limit.isEmpty() ? Integer.parseInt(box().configuration().downloadNodesLimit()) : -1;
    }

    private UIFile accept() {
        terminateListener.accept(true);
        notifyUser(translate("Downloading data..."), UserMessage.Type.Info);
        String format = this.format.selection().get(0);
        List<String> selection = selectedColumns();
        InputStream result = NodeHelper.download(box(), node, request(), format, selection, language());
        notifyUser(translate("Download finished"), UserMessage.Type.Success);
        return new UIFile() {
            @Override
            public String label() {
                return node.getLabel() + "_" + Formatters.downloadDate(Instant.now()) + "." + format.toLowerCase();
            }

            @Override
            public InputStream content() {
                return result;
            }
        };
    }

    private NodeDataRequest request() {
        NodeDataRequest dataRequest = new NodeDataRequest();
        dataRequest.setCodeDomainNode(node.getDefinition().getCode());
        dataRequest.setCodeView(view);
        dataRequest.setCondition(condition);
        dataRequest.setGroupsBy(NodeHelper.groupsByOf(filters));
        if (sorting != null) dataRequest.setSortsBy(sortsByOf(singletonList(sortingOf(sorting, sortingMode))));
        dataRequest.setStartPos(0);
        int countItems = totalItems(dataRequest);
        dataRequest.setLimit(limitExceeded(countItems) ? limit() : countItems);
        return dataRequest;
    }

    private List<String> selectedColumns() {
        if (allColumnsMode()) return columns.stream().map(Column::code).collect(Collectors.toList());
        List<DownloadDialogOption> children = options.children(DownloadDialogOption.class);
        return children.stream().map(DownloadDialogOption::selectedColumn).filter(Objects::nonNull).map(Column::code).collect(Collectors.toList());
    }

    private List<Column> availableColumns(Column current) {
        List<String> selection = selectedColumns();
        return columns.stream().filter(c -> (current != null && current.code().equals(c.code())) || !selection.contains(c.code())).collect(Collectors.toList());
    }

    private void refreshAvailableColumns() {
        List<DownloadDialogOption> children = options.children(DownloadDialogOption.class);
        children.forEach(c -> c.columns(availableColumns(c.selectedColumn())).refresh());
    }

    private void refreshColumns() {
        customColumnsBlock.visible(!allColumnsMode());
        columnsBlock.hide();
        options.clear();
        for (int i=0; i<columns.size(); i++) fill(i, this.options.add());
        columnsBlock.show();
    }

    private void fill(int pos, DownloadDialogOption view) {
        view.index(pos);
        view.columns(columns);
        view.onSelect(e -> {
            refreshToolbar();
            refreshAvailableColumns();
        });
        view.refresh();
    }

    private void refreshToolbar() {
        downloadAccept.readonly(!check());
    }

    private boolean allColumnsMode() {
        String mode = columnModeSelector.selection().size() > 0 ? columnModeSelector.selection().get(0) : null;
        return mode == null || mode.equalsIgnoreCase("allColumns");
    }

    private void updateMode() {
        customColumnsBlock.visible(!allColumnsMode());
        refreshToolbar();
    }

}