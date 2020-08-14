package io.intino.goros.box.ui.displays.templates;

import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import io.intino.alexandria.logger.Logger;
import io.intino.alexandria.ui.displays.UserMessage;
import io.intino.alexandria.ui.model.Geometry;
import org.monet.metamodel.AbstractManifestBase;
import org.monet.metamodel.NodeViewProperty;
import org.monet.space.kernel.model.BusinessUnit;
import org.monet.space.kernel.model.Node;
import org.monet.space.kernel.model.map.GeometryHelper;
import io.intino.goros.box.GorosBox;
import io.intino.goros.util.LayerHelper;

public class NodeLocationTemplate extends AbstractNodeLocationTemplate<GorosBox> {
    private Node node;
    private NodeViewProperty view;
    private boolean readonly = true;

    public NodeLocationTemplate(GorosBox box) {
        super(box);
    }

    public NodeLocationTemplate node(Node node) {
        this.node = node;
        return this;
    }

    public NodeLocationTemplate view(NodeViewProperty view) {
        this.view = view;
        return this;
    }

    public NodeLocationTemplate readonly(boolean readonly) {
        this.readonly = readonly;
        return this;
    }

    @Override
    public void init() {
        super.init();
        AbstractManifestBase.DefaultLocationProperty location = BusinessUnit.getInstance().getDistribution().getDefaultLocation();
        this.location.onChange(e -> saveLocation(e.value()));
        if (location != null) this.location.center(location.getLatitude(), location.getLongitude());
    }

    @Override
    public void refresh() {
        super.refresh();
        org.monet.space.kernel.model.map.Location location = node.getLocation();
        this.location.value(location != null && location.getGeometry() != null ? location.getGeometry().toText() : null);
        this.location.readonly(readonly);
    }

    private void saveLocation(Geometry geometry) {
        LayerHelper.nodeLayer().updateNodeLocation(node, geometry != null ? toMonetGeometry(geometry) : null);
    }

    private com.vividsolutions.jts.geom.Geometry toMonetGeometry(Geometry geometry) {
        try {
            GeometryFactory factory = GeometryHelper.getFactory();
            WKTReader reader = new WKTReader(factory);
            return reader.read(geometry.toWkt());
        } catch (ParseException e) {
            notifyUser(translate("Could not save new location"), UserMessage.Type.Error);
            Logger.error(e);
            return null;
        }
    }

}