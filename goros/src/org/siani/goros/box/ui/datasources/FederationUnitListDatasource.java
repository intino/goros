package org.siani.goros.box.ui.datasources;

import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import io.intino.alexandria.ui.services.push.UISession;
import org.monet.metamodel.RoleDefinition;
import org.monet.space.kernel.model.FederationUnit;
import org.monet.space.kernel.model.FederationUnitFeeder;
import org.monet.space.kernel.model.FederationUnitService;
import org.siani.goros.box.GorosBox;
import org.siani.goros.box.ui.datasources.model.role.RoleTypeGrouping;
import org.siani.goros.util.LayerHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

public class FederationUnitListDatasource extends PageDatasource<FederationUnit> {
    private final GorosBox box;
    private final UISession session;
    private final RoleDefinition roleDefinition;
    private final RoleTypeGrouping type;

    public FederationUnitListDatasource(GorosBox box, UISession session, RoleDefinition roleDefinition, RoleTypeGrouping type) {
        this.box = box;
        this.session = session;
        this.roleDefinition = roleDefinition;
        this.type = type;
    }

    @Override
    public List<FederationUnit> items(int start, int count, String condition, List<Filter> filters, List<String> sortings) {
        List<FederationUnit> result = new ArrayList<>(federationUnits(session, roleDefinition, type));
        int from = Math.min(start, result.size());
        int end = Math.min(start + count, result.size());
        return result.subList(from, end);
    }

    @Override
    public long itemCount(String condition, List<Filter> filters) {
        return federationUnits(session, roleDefinition, type).size();
    }

    @Override
    public List<Group> groups(String key) {
        return emptyList();
    }

    private static List<FederationUnit> federationUnits(UISession session, RoleDefinition definition, RoleTypeGrouping type) {
        ArrayList<FederationUnit> federationUnitList = new ArrayList<>(LayerHelper.federationLayer(session).loadPartners().get().values());
        return federationUnitList.stream().filter(fu -> conforms(fu, definition, type)).collect(Collectors.toList());
    }

    private static boolean conforms(FederationUnit unit, RoleDefinition definition, RoleTypeGrouping type) {
        if (type == RoleTypeGrouping.Service) return unit.getServiceList().get().values().stream().anyMatch(s -> conforms(s, definition, type));
        else return unit.getFeederList().get().values().stream().anyMatch(s -> conforms(s, definition, type));
    }

    private static boolean conforms(FederationUnitService service, RoleDefinition definition, RoleTypeGrouping type) {
        return ontologies(definition, type).contains(service.getOntology());
    }

    private static boolean conforms(FederationUnitFeeder feeder, RoleDefinition definition, RoleTypeGrouping type) {
        return ontologies(definition, type).contains(feeder.getOntology());
    }

    private static List<String> ontologies(RoleDefinition definition, RoleTypeGrouping type) {
        if (type == RoleTypeGrouping.Service && definition.getEnableServices() != null) return definition.getEnableServices().getOntology();
        if (type == RoleTypeGrouping.Feeder && definition.getEnableFeeders() != null) return definition.getEnableFeeders().getOntology();
        return emptyList();
    }

}