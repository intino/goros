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

public class NodeDownloadDialog extends AbstractNodeDownloadDialog<UnitBox> {
    private Node node;
    private String view;
    private List<Column> columns = new ArrayList<>();
    private Consumer<Boolean> terminateListener;
    private String condition;
    private List<Filter> filters;

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

    public NodeDownloadDialog columns(List<Column> columns) {
        this.columns = columns;
        return this;
    }

    @Override
    public void init() {
        super.init();
        format.onSelect(e -> refreshToolbar());
        downloadCancel.onExecute(e -> terminateListener.accept(true));
        downloadAccept.onExecute(e -> accept());
    }

    @Override
    public void refresh() {
        super.refresh();
        refreshColumns();
        downloadAccept.readonly(true);
    }

    private boolean check() {
        if (format.selection().size() <= 0) return false;
        return options.children(NodeDownloadDialogOption.class).stream().anyMatch(c -> c.selectedColumn() != null);
    }

    private List<Column> dateColumns() {
        return columns.stream().filter(Column::isDate).collect(Collectors.toList());
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
        return dataRequest;
    }

    private List<String> selectedColumns() {
        List<NodeDownloadDialogOption> children = options.children(NodeDownloadDialogOption.class);
        return children.stream().map(NodeDownloadDialogOption::selectedColumn).filter(Objects::nonNull).map(Column::code).collect(Collectors.toList());
    }

    private void refreshColumns() {
        columnsBlock.hide();
        options.clear();
        for (int i=0; i<columns.size(); i++) fill(i, this.options.add());
        columnsBlock.show();
    }

    private void fill(int pos, NodeDownloadDialogOption view) {
        view.index(pos);
        view.columns(columns);
        view.onSelect(e -> refreshToolbar());
        view.refresh();
    }

    private void refreshToolbar() {
        downloadAccept.readonly(!check());
    }

}