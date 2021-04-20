package io.intino.goros.unit.box.ui.datasources;

import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import io.intino.alexandria.ui.services.push.UISession;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.util.LayerHelper;
import org.monet.metamodel.RoleDefinition;
import org.monet.space.kernel.model.FederationUnit;
import org.monet.space.kernel.model.FederationUnitService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

public class FederationUnitServiceListDatasource extends PageDatasource<FederationUnitService> {
    private final UnitBox box;
    private final UISession session;
    private final RoleDefinition roleDefinition;

    public FederationUnitServiceListDatasource(UnitBox box, UISession session, RoleDefinition roleDefinition) {
        this.box = box;
        this.session = session;
        this.roleDefinition = roleDefinition;
    }

    @Override
    public List<FederationUnitService> items(int start, int count, String condition, List<Filter> filters, List<String> sortings) {
        List<FederationUnitService> result = new ArrayList<>(federationUnitsServices(box, session, roleDefinition));
        int from = Math.min(start, result.size());
        int end = Math.min(start + count, result.size());
        return result.subList(from, end);
    }

    @Override
    public long itemCount(String condition, List<Filter> filters) {
        return federationUnitsServices(box, session, roleDefinition).size();
    }

    @Override
    public List<Group> groups(String key) {
        return emptyList();
    }

    private static List<FederationUnitService> federationUnitsServices(UnitBox box, UISession session, RoleDefinition definition) {
        if (definition == null) return emptyList();
        box.linkSession(session);
        ArrayList<FederationUnit> federationUnitList = new ArrayList<>(LayerHelper.federationLayer(session).loadPartners().get().values());
        return federationUnitList.stream().map(fu -> fu.getServiceList().get().values()).flatMap(Collection::stream).filter(service -> conforms(service, definition)).collect(Collectors.toList());
    }

    private static boolean conforms(FederationUnitService service, RoleDefinition definition) {
        return ontologies(definition).contains(service.getOntology());
    }

    private static List<String> ontologies(RoleDefinition definition) {
        if (definition.getEnableServices() != null) return definition.getEnableServices().getOntology();
        return emptyList();
    }

}