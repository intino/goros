package io.intino.goros.unit.box.ui.datasources;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.geom.impl.CoordinateArraySequence;
import io.intino.alexandria.ui.model.PlaceMark;
import io.intino.alexandria.ui.model.datasource.*;
import io.intino.alexandria.ui.services.push.UISession;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.util.LayerHelper;
import io.intino.goros.unit.util.NodeHelper;
import org.monet.metamodel.NodeViewProperty;
import org.monet.metamodel.SetDefinition;
import org.monet.space.kernel.model.Node;
import org.monet.space.kernel.model.NodeDataRequest;
import org.monet.space.kernel.model.map.GeometryHelper;
import org.monet.space.kernel.model.map.Location;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class CollectionMapDatasource extends MapDatasource<Node> {
    private final UnitBox box;
    private final UISession session;
    private final Node set;
    private final NodeViewProperty view;

    public CollectionMapDatasource(UnitBox box, UISession session, Node set, String view) {
        this.box = box;
        this.session = session;
        this.set = set;
        this.view = set.getDefinition().getNodeView(view);
    }

    @Override
    public List<PlaceMark<Node>> placeMarks(String condition, List<Filter> filters, BoundingBox boundingBox) {
        NodeDataRequest request = request(condition, filters);
        request.setStartPos(0);
        request.setLimit(1000000);
        request.setBoundingBox(boundingBoxOf(boundingBox));
        box.linkSession(session);
        return new ArrayList<>(LayerHelper.nodeLayer().requestNodeListItems(set.getId(), request).values().stream().map(node -> placeMarkOf(node)).collect(toList()));
    }

    @Override
    public long placeMarkCount(String condition, List<Filter> filters) {
        box.linkSession(session);
        return LayerHelper.nodeLayer().requestNodeListItemsCount(set.getId(), request(condition, filters));
    }

    @Override
    public List<Group> groups(String key) {
        List<String> groups = set.getGroupOptions(key, emptyList(), emptyList());
        return groups.stream().map(o -> new Group().label(o)).collect(toList());
    }

    public static long itemCount(Node set) {
        return LayerHelper.nodeLayer().requestNodeListItemsCount(set.getId(), request(set));
    }

    private NodeDataRequest request(String condition, List<Filter> filters) {
        NodeDataRequest request = request(set);
        request.setCondition(condition);
        request.setGroupsBy(NodeHelper.groupsByOf(filters));
        request.setCodeView(view.getCode());
        return request;
    }

    private static NodeDataRequest request(Node set) {
        NodeDataRequest request = new NodeDataRequest();
        request.setCodeReference(((SetDefinition)set.getDefinition()).getIndex().getValue());
        return request;
    }

    private PlaceMark<Node> placeMarkOf(Node node) {
        Location location = node.getLocation();
        PlaceMark<Node> placeMark = PlaceMark.build(node.getLabel(), location != null && location.getGeometry() != null ? location.getGeometry().toText() : null);
        placeMark.item(node);
        return placeMark;
    }

    private Polygon boundingBoxOf(BoundingBox boundingBox) {
        if (boundingBox == null) return null;

        double dnex = boundingBox.northEast().longitude();
        double dney = boundingBox.northEast().latitude();
        double dswx = boundingBox.southWest().longitude();
        double dswy = boundingBox.southWest().latitude();

        Coordinate[] coordinates = new Coordinate[5];
        coordinates[0] = new Coordinate(dswx, dney);
        coordinates[1] = new Coordinate(dnex, dney);
        coordinates[2] = new Coordinate(dnex, dswy);
        coordinates[3] = new Coordinate(dswx, dswy);
        coordinates[4] = new Coordinate(dswx, dney);
        CoordinateArraySequence sequence = new CoordinateArraySequence(coordinates);

        return new Polygon(new LinearRing(sequence, GeometryHelper.getFactory()), null, GeometryHelper.getFactory());
    }

}