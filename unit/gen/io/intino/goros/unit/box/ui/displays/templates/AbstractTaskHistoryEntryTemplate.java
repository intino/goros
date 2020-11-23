package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import io.intino.goros.unit.box.ui.*;

import io.intino.goros.unit.box.UnitBox;

import io.intino.goros.unit.box.ui.displays.templates.*;






import io.intino.goros.unit.box.ui.displays.items.*;
import io.intino.goros.unit.box.ui.displays.rows.*;
import io.intino.alexandria.ui.displays.notifiers.TemplateNotifier;

public abstract class AbstractTaskHistoryEntryTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Tasvie_123_1_01281209709 tasvie_123_1_01281209709;
	public TaskHistoryEntryTemplate.Tasvie_123_1_01281209709. Date date;
	public TaskHistoryEntryTemplate.Tasvie_123_1_01281209709. Author author;
	public Title title;
	public Subtitle subtitle;
	public LinksBlock linksBlock;
	public TaskHistoryEntryTemplate.LinksBlock. Link link;

    public AbstractTaskHistoryEntryTemplate(B box) {
        super(box);
        id("taskHistoryEntryTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (tasvie_123_1_01281209709 == null) tasvie_123_1_01281209709 = register(new Tasvie_123_1_01281209709(box()).<Tasvie_123_1_01281209709>id("a360308932").owner(AbstractTaskHistoryEntryTemplate.this));
		if (tasvie_123_1_01281209709 != null) date = tasvie_123_1_01281209709.date;
		if (tasvie_123_1_01281209709 != null) author = tasvie_123_1_01281209709.author;
		if (title == null) title = register(new Title(box()).<Title>id("a_1405051979").owner(AbstractTaskHistoryEntryTemplate.this));
		if (subtitle == null) subtitle = register(new Subtitle(box()).<Subtitle>id("a657357211").owner(AbstractTaskHistoryEntryTemplate.this));
		if (linksBlock == null) linksBlock = register(new LinksBlock(box()).<LinksBlock>id("a_2063251177").owner(AbstractTaskHistoryEntryTemplate.this));
		if (linksBlock != null) link = linksBlock.link;
	}

	public class Tasvie_123_1_01281209709 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public TaskHistoryEntryTemplate.Tasvie_123_1_01281209709. Date date;
		public TaskHistoryEntryTemplate.Tasvie_123_1_01281209709. Author author;

		public Tasvie_123_1_01281209709(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (date == null) date = register(new Date(box()).<Date>id("a_1442549793").owner(AbstractTaskHistoryEntryTemplate.this));
			if (author == null) author = register(new Author(box()).<Author>id("a916674940").owner(AbstractTaskHistoryEntryTemplate.this));
		}

		public class Date extends io.intino.alexandria.ui.displays.components.Date<io.intino.alexandria.ui.displays.notifiers.DateNotifier, B>  {

			public Date(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}

		public class Author extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public Author(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}

	public class Title extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

		public Title(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
		}
	}

	public class Subtitle extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

		public Subtitle(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
		}
	}

	public class LinksBlock extends io.intino.alexandria.ui.displays.components.Multiple<B,LinksBlock, java.lang.Void>  {
		public TaskHistoryEntryTemplate.LinksBlock. Link link;

		public LinksBlock(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (link == null) link = register(new Link(box()).<Link>id("a_1802684894").owner(AbstractTaskHistoryEntryTemplate.this));
		}

		@Override
		public LinksBlock add(java.lang.Void value) {
			LinksBlock child = new LinksBlock(box());
			child.id(java.util.UUID.randomUUID().toString());
			add(child, "linksBlock");
		    notifyAdd(child);
			return child;
		}
		@Override
		public void remove(LinksBlock child) {
			removeChild(child, "linksBlock");
		}
		public void clear() {
		    super.clear("linksBlock");
		}
		public class Link extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B>  {

			public Link(B box) {
				super(box);
				_title("");
				_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Link"));
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}
}