package io.intino.goros.unit.box.ui.datasources;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.geom.impl.CoordinateArraySequence;
import io.intino.alexandria.ui.model.PlaceMark;
import io.intino.alexandria.ui.model.datasource.*;
import io.intino.alexandria.ui.model.locations.Point;
import io.intino.alexandria.ui.model.locations.Polyline;
import io.intino.alexandria.ui.services.push.UISession;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.util.LayerHelper;
import io.intino.goros.unit.util.NodeHelper;
import org.monet.metamodel.*;
import org.monet.space.kernel.model.Dictionary;
import org.monet.space.kernel.model.Node;
import org.monet.space.kernel.model.NodeDataRequest;
import org.monet.space.kernel.model.map.GeometryHelper;
import org.monet.space.kernel.model.map.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class CollectionMapDatasource extends MapDatasource<String> {
    private final UnitBox box;
    private final UISession session;
    private Node set;
    private NodeViewProperty view;

    public CollectionMapDatasource(UnitBox box, UISession session, Node set, String view) {
        this.box = box;
        this.session = session;
        this.set = set;
        this.view = set.getDefinition().getNodeView(view);
    }

    public void node(Node node) {
        this.set = node;
    }

    public void view(String view) {
        this.view = set.getDefinition().getNodeView(view);
    }

    @Override
    public List<PlaceMark<String>> placeMarks(String condition, List<Filter> filters, BoundingBox boundingBox) {
        box.linkSession(session);
        SetDefinition definition = (SetDefinition) set.getDefinition();
        IndexDefinition indexDefinition = Dictionary.getInstance().getIndexDefinition(definition.getIndex().getValue());
        Map<String, Integer> cache = new HashMap<>();
        return LayerHelper.nodeLayer().loadLocationsInNode(set, boundingBoxOf(boundingBox), indexDefinition.getCode()).get().values().stream().map(l -> fix(placeMarkOf(l), cache)).collect(java.util.stream.Collectors.toList());
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

    @SuppressWarnings("unchecked")
	public static PlaceMark<String> placeMarkOf(Node node) {
        String location = locationOf(node);
        PlaceMark<String> placeMark = (PlaceMark<String>) PlaceMark.build(node.getLabel(), location);
        placeMark.item(node.getId());
        return placeMark;
    }

    @SuppressWarnings("unchecked")
	public static PlaceMark<String> placeMarkOf(Location location) {
        PlaceMark<String> placeMark = (PlaceMark<String>) PlaceMark.build(location.getLabel(), wktOf(location));
        placeMark.item(location.getNodeId());
        return placeMark;
    }

    private static String locationOf(Node node) {
        return wktOf(node.getLocation());
    }

    private static String wktOf(Location location) {
        return location != null ? location.getGeometry().toText() : null;
    }

    private static Node nodeOf(Location location) {
        return LayerHelper.nodeLayer().loadNode(location.getNodeId());
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

    private PlaceMark<String> fix(PlaceMark<String> placeMark, Map<String, Integer> locations) {
        if (placeMark.location() == null) return placeMark;
        String wkt = placeMark.location().toWkt();
        locations.put(wkt, locations.containsKey(wkt) ? locations.get(wkt)+1 : 1);
        if (locations.get(wkt) == 1) return placeMark;
        double offset = locations.get(wkt)*0.00002;
        fixPoint(placeMark, offset);
        fixPolyline(placeMark, offset);
        fixPolygon(placeMark, offset);
        return placeMark;
    }

    private void fixPoint(PlaceMark<String> placeMark, double offset) {
        if (!placeMark.location().isPoint()) return;
        Point location = (Point) placeMark.location();
        location.longitude(location.longitude()+offset);
        location.latitude(location.latitude()+offset);
    }

    private void fixPolyline(PlaceMark<String> placeMark, double offset) {
        if (!placeMark.location().isPolyline()) return;
        Polyline location = (Polyline) placeMark.location();
        List<Point> path = location.path();
        if (path.isEmpty()) return;
        path.get(0).longitude(path.get(0).longitude()+offset);
        path.get(0).latitude(path.get(0).latitude()+offset);
    }

    private void fixPolygon(PlaceMark<String> placeMark, double offset) {
        if (!placeMark.location().isPolygon()) return;
        io.intino.alexandria.ui.model.locations.Polygon location = (io.intino.alexandria.ui.model.locations.Polygon) placeMark.location();
        List<List<Point>> path = location.paths();
        if (path.isEmpty()) return;
        List<Point> points = path.get(0);
        if (points.isEmpty()) return;
        points.get(0).longitude(points.get(0).longitude()+offset);
        points.get(0).latitude(points.get(0).latitude()+offset);
    }

}