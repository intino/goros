package io.intino.goros.unit.box.ui.datasources;

import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import io.intino.alexandria.ui.services.push.UISession;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.util.LayerHelper;
import org.monet.metamodel.RoleDefinition;
import org.monet.space.kernel.model.FederationUnit;
import org.monet.space.kernel.model.FederationUnitFeeder;
import org.monet.space.kernel.model.FederationUnitService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

public class FederationUnitFeederListDatasource extends PageDatasource<FederationUnitFeeder> {
    private final UnitBox box;
    private final UISession session;
    private final RoleDefinition roleDefinition;

    public FederationUnitFeederListDatasource(UnitBox box, UISession session, RoleDefinition roleDefinition) {
        this.box = box;
        this.session = session;
        this.roleDefinition = roleDefinition;
    }

    @Override
    public List<FederationUnitFeeder> items(int start, int count, String condition, List<Filter> filters, List<String> sortings) {
        List<FederationUnitFeeder> result = new ArrayList<>(filter(federationUnitsFeeders(box, session, roleDefinition), condition, filters));
        int from = Math.min(start, result.size());
        int end = Math.min(start + count, result.size());
        return result.subList(from, end);
    }

    @Override
    public long itemCount(String condition, List<Filter> filters) {
        return federationUnitsFeeders(box, session, roleDefinition).size();
    }

    @Override
    public List<Group> groups(String key) {
        return emptyList();
    }

    private static List<FederationUnitFeeder> federationUnitsFeeders(UnitBox box, UISession session, RoleDefinition definition) {
        if (definition == null) return emptyList();
        box.linkSession(session);
        ArrayList<FederationUnit> federationUnitList = new ArrayList<>(LayerHelper.federationLayer(session).loadPartners().get().values());
        return federationUnitList.stream().map(fu -> fu.getFeederList().get().values()).flatMap(Collection::stream).filter(feeder -> conforms(feeder, definition)).collect(Collectors.toList());
    }

    private List<FederationUnitFeeder> filter(List<FederationUnitFeeder> federationUnitFeeders, String condition, List<Filter> filters) {
        if (condition == null) return federationUnitFeeders;
        String[] lowerCondition = condition.toLowerCase().split(" ");
        return federationUnitFeeders.stream().filter(fu -> DatasourceHelper.matches(fu.getLabel(), lowerCondition) || DatasourceHelper.matches(fu.getName(), lowerCondition)).collect(Collectors.toList());
    }

    private static boolean conforms(FederationUnitFeeder feeder, RoleDefinition definition) {
        return ontologies(definition).contains(feeder.getOntology());
    }

    private static List<String> ontologies(RoleDefinition definition) {
        if (definition.getEnableFeeders() != null) return definition.getEnableFeeders().getOntology();
        return emptyList();
    }

}