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

public abstract class AbstractTaskHistoryTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public EntriesBlock entriesBlock;
	public TaskHistoryTemplate.EntriesBlock. Entries entries;
	public MoreEntries moreEntries;

    public AbstractTaskHistoryTemplate(B box) {
        super(box);
        id("taskHistoryTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (entriesBlock == null) entriesBlock = register(new EntriesBlock(box()).<EntriesBlock>id("a_1394806318").owner(AbstractTaskHistoryTemplate.this));
		if (entriesBlock != null) entries = entriesBlock.entries;
		if (moreEntries == null) moreEntries = register(new MoreEntries(box()).<MoreEntries>id("a_231617306").owner(AbstractTaskHistoryTemplate.this));
	}

	public class EntriesBlock extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public TaskHistoryTemplate.EntriesBlock. Entries entries;

		public EntriesBlock(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (entries == null) entries = register(new Entries((UnitBox)box()).<Entries>id("a1261513507").owner(AbstractTaskHistoryTemplate.this));
		}

		public class Entries extends io.intino.alexandria.ui.displays.components.Multiple<UnitBox,TaskHistoryEntryTemplate, java.lang.Void>  {

			public Entries(UnitBox box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}

			@Override
			public TaskHistoryEntryTemplate add(java.lang.Void value) {
				TaskHistoryEntryTemplate child = new TaskHistoryEntryTemplate(box());
				child.id(java.util.UUID.randomUUID().toString());
				add(child, "entries");
			    notifyAdd(child);
				return child;
			}
			@Override
			public void remove(TaskHistoryEntryTemplate child) {
				removeChild(child, "entries");
			}
			public void clear() {
			    super.clear("entries");
			}
		}
	}

	public class MoreEntries extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B>  {

		public MoreEntries(B box) {
			super(box);
			_title("Ver más...");
			_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Link"));
		}

		@Override
		public void init() {
			super.init();
		}
	}
}