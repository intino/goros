package io.intino.goros.box.ui.datasources;

import io.intino.alexandria.ui.model.datasource.Filter;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.alexandria.ui.model.datasource.PageDatasource;
import io.intino.alexandria.ui.services.push.UISession;
import org.monet.space.kernel.model.DataRequest;
import org.monet.space.kernel.model.User;
import io.intino.goros.box.GorosBox;
import io.intino.goros.util.LayerHelper;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class UserListDatasource extends PageDatasource<User> {
    private final GorosBox box;
    private final UISession session;

    public UserListDatasource(GorosBox box, UISession session) {
        this.box = box;
        this.session = session;
    }

    @Override
    public List<User> items(int start, int count, String condition, List<Filter> filters, List<String> sortings) {
        DataRequest request = request(condition, filters);
        request.setStartPos(start);
        request.setLimit(count);
        return new ArrayList<>(users(request, session));
    }

    @Override
    public long itemCount(String condition, List<Filter> filters) {
        return users(request(condition, filters), session).size();
    }

    @Override
    public List<Group> groups(String key) {
        return emptyList();
    }

    public static long itemCount(UISession session) {
        return users(request(), session).size();
    }

    private static List<User> users(DataRequest request, UISession session) {
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