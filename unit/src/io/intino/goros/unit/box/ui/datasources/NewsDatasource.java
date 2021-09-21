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
import org.monet.space.kernel.model.DataRequest;
import org.monet.space.kernel.model.Dictionary;
import org.monet.space.kernel.model.Role;
import org.monet.space.kernel.model.news.Post;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class NewsDatasource extends PageDatasource<Post> {
    private final UnitBox box;
    private final UISession session;

    public NewsDatasource(UnitBox box, UISession session) {
        this.box = box;
        this.session = session;
    }

    @Override
    public List<Post> items(int start, int count, String condition, List<Filter> filters, List<String> sortings) {
        return news(box, session, start, count);
    }

    @Override
    public long itemCount(String condition, List<Filter> filters) {
        return 100_000;
    }

    @Override
    public List<Group> groups(String key) {
        return emptyList();
    }

    private static List<Post> news(UnitBox box, UISession session, int start, int count) {
        return LayerHelper.newsLayer().getPosts(start, count);
    }

}