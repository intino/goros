package io.intino.goros.unit.box.ui.displays.templates;

import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import io.intino.alexandria.logger.Logger;
import io.intino.alexandria.ui.displays.UserMessage;
import io.intino.alexandria.ui.model.Geometry;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.util.DictionaryHelper;
import io.intino.goros.unit.util.LayerHelper;
import org.monet.metamodel.AbstractManifestBase;
import org.monet.metamodel.NodeViewProperty;
import org.monet.space.kernel.model.BusinessUnit;
import org.monet.space.kernel.model.Dictionary;
import org.monet.space.kernel.model.Node;
import org.monet.space.kernel.model.map.GeometryHelper;

public class NodeLocationTemplate extends AbstractNodeLocationTemplate<UnitBox> {
    private Node node;
    private NodeViewProperty view;
    private boolean readonly = true;

    public NodeLocationTemplate(UnitBox box) {
        super(box);
    }

    public NodeLocationTemplate node(Node node) {
        this.node = node;
        return this;
    }

    public NodeLocationTemplate view(String view) {
        this.view = view != null ? DictionaryHelper.view(node, view) : null;
        return this;
    }

    public NodeLocationTemplate readonly(boolean readonly) {
        this.readonly = readonly;
        return this;
    }

    @Override
    public void init() {
        super.init();
        AbstractManifestBase.DefaultLocationProperty location = DictionaryHelper.defaultLocation();
        this.location.onChange(e -> saveLocation(e.value()));
        if (location != null) this.location.center(location.getLatitude(), location.getLongitude());
    }

    @Override
    public void refresh() {
        super.refresh();
        org.monet.space.kernel.model.map.Location location = node.getLocation();
        this.location.value(location != null && location.getGeometry() != null ? location.getGeometry().toText() : null);
        if (location != null) this.location.center(location.getGeometry().getCentroid().getX(), location.getGeometry().getCentroid().getY());
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