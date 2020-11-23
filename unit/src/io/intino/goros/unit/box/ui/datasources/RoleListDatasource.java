package io.intino.goros.unit.box.ui.datasources;

import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import io.intino.alexandria.ui.model.datasource.filters.GroupFilter;
import io.intino.alexandria.ui.services.push.UISession;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.box.ui.datasources.model.role.RoleExpiredGrouping;
import io.intino.goros.unit.box.ui.datasources.model.role.RoleNatureGrouping;
import io.intino.goros.unit.box.ui.datasources.model.role.RoleTypeGrouping;
import io.intino.goros.unit.util.LayerHelper;
import org.monet.metamodel.RoleDefinition;
import org.monet.space.kernel.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class RoleListDatasource extends PageDatasource<Role> {
    private final UnitBox box;
    private final UISession session;

    public static final String DefinitionGrouping = "definition";
    public static final String TypeGrouping = "type";
    public static final String NatureGrouping = "nature";
    public static final String ExpiredGrouping = "expired";

    public RoleListDatasource(UnitBox box, UISession session) {
        this.box = box;
        this.session = session;
    }

    @Override
    public List<Role> items(int start, int count, String condition, List<Filter> filters, List<String> sortings) {
        DataRequest request = request(condition, filters);
        request.setStartPos(start);
        request.setLimit(count);
        return new ArrayList<>(roles(request, session));
    }

    @Override
    public long itemCount(String condition, List<Filter> filters) {
        return roles(request(condition, filters), session).size();
    }

    @Override
    public List<Group> groups(String key) {
        if (key.equalsIgnoreCase(TypeGrouping)) return Arrays.stream(RoleTypeGrouping.values()).map(f -> new Group().label(f.title())).collect(Collectors.toList());
        else if (key.equalsIgnoreCase(NatureGrouping)) return Arrays.stream(RoleNatureGrouping.values()).map(f -> new Group().label(f.title())).collect(Collectors.toList());
        else if (key.equalsIgnoreCase(DefinitionGrouping)) return Dictionary.getInstance().getRoleDefinitionList().stream().map(rd -> new Group().label(rd.getLabelString())).collect(Collectors.toList());
        else if (key.equalsIgnoreCase(ExpiredGrouping)) return Arrays.stream(RoleExpiredGrouping.values()).map(f -> new Group().label(f.title())).collect(Collectors.toList());
        return emptyList();
    }

    public static long itemCount(UISession session) {
        return roles(request(), session).size();
    }

    private static List<Role> roles(DataRequest request, UISession session) {
        return LayerHelper.roleLayer().loadRoleList(request).get().values().stream().filter(u -> !u.getId().equals("system")).collect(toList());
    }

    private DataRequest request(String condition, List<Filter> filters) {
        DataRequest request = request();
        request.setCondition(condition);
        String definitionCode = definitionCodeFrom(filters);
        if (definitionCode != null) request.setCode(definitionCode);
        addParameter(request, filters, TypeGrouping, DataRequest.MODE, value -> RoleTypeGrouping.from(value).name().toLowerCase());
        addParameter(request, filters, NatureGrouping, DataRequest.NATURE, value -> RoleNatureGrouping.from(value).name());
        addParameter(request, filters, ExpiredGrouping, DataRequest.NON_EXPIRED, value -> "" + RoleExpiredGrouping.NonExpired.value());
        return request;
    }

    private String definitionCodeFrom(List<Filter> filters) {
        GroupFilter filter = findFilter(filters, DefinitionGrouping);
        if (filter == null) return null;
        if (filter.groups().size() <= 0) return null;
        RoleDefinition roleDefinition = findDefinition(new ArrayList<>(filter.groups()).get(0));
        return roleDefinition != null ? roleDefinition.getCode() : null;
    }

    private void addParameter(DataRequest request, List<Filter> filters, String name, String parameter, Function<String, String> value) {
        GroupFilter filter = findFilter(filters, name);
        if (filter == null || filter.groups().size() <= 0) return;
        request.addParameter(parameter, value.apply(new ArrayList<>(filter.groups()).get(0)));
    }

    private RoleDefinition findDefinition(String label) {
        return Dictionary.getInstance().getRoleDefinitionList().stream().filter(r -> r.getLabelString().equals(label)).findFirst().orElse(null);
    }

    private GroupFilter findFilter(List<Filter> filters, String name) {
        return (GroupFilter) filters.stream().filter(f -> f.grouping().equals(name)).findFirst().orElse(null);
    }

    private static DataRequest request() {
        return new DataRequest();
    }

}