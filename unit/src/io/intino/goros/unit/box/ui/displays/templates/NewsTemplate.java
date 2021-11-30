package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.events.AddItemEvent;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.box.ui.datasources.NewsDatasource;
import io.intino.goros.unit.box.ui.displays.items.NewsListItem;
import io.intino.goros.unit.graph.PostType;
import io.intino.goros.unit.util.PathHelper;
import org.monet.space.kernel.model.news.Post;

public class NewsTemplate extends AbstractNewsTemplate<UnitBox> {

    public NewsTemplate(UnitBox box) {
        super(box);
    }

    @Override
    public void init() {
        super.init();
        newsList.onAddItem(this::refreshPost);
        newsList.source(new NewsDatasource(box(), session()));
        refresh();
    }

    @Override
    public void refresh() {
        super.refresh();
        newsList.reload();
    }

    private void refreshPost(AddItemEvent event) {
        Post post = event.item();
        NewsListItem item = event.component();
        item.type.value(translate(typeOf(post).label()));
        item.title.value(post.getTitle());
        item.title.visible(post.getTarget() == null);
        item.titleLink.title(post.getTitle());
        item.titleLink.visible(post.getTarget() != null);
        if (post.getTarget() != null) item.titleLink.address(path -> PathHelper.pathOf(post.getTarget()));
        item.date.value(post.getInternalCreateDate().toInstant());
        item.body.value(post.getBody());
    }

    private PostType typeOf(Post post) {
        return PostType.from(post.getType());
    }

}