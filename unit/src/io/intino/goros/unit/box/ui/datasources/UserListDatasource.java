package io.intino.goros.unit.box.ui.datasources;

import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import io.intino.alexandria.ui.services.push.UISession;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.util.LayerHelper;
import org.monet.space.kernel.model.DataRequest;
import org.monet.space.kernel.model.User;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class UserListDatasource extends PageDatasource<User> {
    private final UnitBox box;
    private final UISession session;

    public UserListDatasource(UnitBox box, UISession session) {
        this.box = box;
        this.session = session;
    }

    @Override
    public List<User> items(int start, int count, String condition, List<Filter> filters, List<String> sortings) {
        DataRequest request = request(condition, filters);
        request.setStartPos(start);
        request.setLimit(count);
        return new ArrayList<>(users(request, box, session));
    }

    @Override
    public long itemCount(String condition, List<Filter> filters) {
        return users(request(condition, filters), box, session).size();
    }

    @Override
    public List<Group> groups(String key) {
        return emptyList();
    }

    public static long itemCount(UnitBox box, UISession session) {
        return users(request(), box, session).size();
    }

    private static List<User> users(DataRequest request, UnitBox box, UISession session) {
        box.linkSession(session);
        return LayerHelper.federationLayer(session).searchUsers(request).get().values().stream().filter(u -> !u.getId().equals("system")).collect(toList());
    }

    private DataRequest request(String condition, List<Filter> filters) {
        DataRequest request = request();
        request.setCondition(condition);
        return request;
    }

    private static DataRequest request() {
        return new DataRequest();
    }

}