package io.intino.goros.unit.box.ui.datasources;

import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import io.intino.alexandria.ui.services.push.UISession;
import io.intino.goros.unit.box.UnitBox;
import org.monet.metamodel.SourceDefinition;
import org.monet.space.kernel.model.DataRequest;
import org.monet.space.kernel.model.Source;
import org.monet.space.kernel.model.Term;
import org.monet.space.kernel.model.TermList;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

public class SourceDatasource extends PageDatasource<Term> {
    private final UnitBox box;
    private final UISession session;
    private final Source<SourceDefinition> source;
    private final Term from;

    public SourceDatasource(UnitBox box, UISession session, Source<SourceDefinition> source, Term from) {
        this.box = box;
        this.session = session;
        this.source = source;
        this.from = from;
    }

    @Override
    public List<Term> items(int start, int count, String condition, List<Filter> filters, List<String> sortings) {
        DataRequest request = request(condition, filters, from);
        request.setStartPos(start);
        request.setLimit(count);
        return new ArrayList<>(terms(source, request));
    }

    @Override
    public long itemCount(String condition, List<Filter> filters) {
        return terms(source, request(condition, filters, from)).size();
    }

    @Override
    public List<Group> groups(String key) {
        return emptyList();
    }

    public static long itemCount(Source<SourceDefinition> source, DataRequest request) {
        return terms(source, request).size();
    }

    private static List<Term> terms(Source<SourceDefinition> source, DataRequest request) {
        boolean onlyEnabled = onlyEnabled(request);
        String condition = request.getCondition();
        TermList terms = condition == null || condition.isEmpty() ? source.loadTerms(request, onlyEnabled) : source.searchTerms(request);
        return new ArrayList<>(terms.get().values());
    }

    private static boolean onlyEnabled(DataRequest request) {
        String mode = request.getParameter(DataRequest.MODE);
        return mode == null || !mode.equals(DataRequest.Mode.TREE);
    }

    private DataRequest request(String condition, List<Filter> filters, Term from) {
        DataRequest request = request();
        request.setCondition(condition);
        request.addParameter(DataRequest.MODE, "tree");
        request.addParameter(DataRequest.DEPTH, "1");
        if (from != null) request.addParameter(DataRequest.FROM, from.getCode());
        return request;
    }

    private static DataRequest request() {
        return new DataRequest();
    }

}