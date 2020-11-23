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

public abstract class AbstractTrashTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Header header;
	public TrashTemplate.Header. Tra_9_2_1186253000 tra_9_2_1186253000;
	public TrashTemplate.Header.Tra_9_2_1186253000. Tra_10_3_0273829 tra_10_3_0273829;
	public TrashTemplate.Header.Tra_9_2_1186253000.Tra_10_3_0273829. Label label;
	public TrashTemplate.Header.Tra_9_2_1186253000. Count count;
	public TrashTemplate.Header. RightToolbar rightToolbar;
	public TrashTemplate.Header.RightToolbar. Search search;
	public Tra_17_1_0521786897 tra_17_1_0521786897;
	public TrashTemplate.Tra_17_1_0521786897. Tra_18_2_01914842262 tra_18_2_01914842262;
	public TrashToolbarTemplate toolbar;
	public TrashTemplate.Tra_17_1_0521786897.Tra_18_2_01914842262. Tra_20_3_0167735262 tra_20_3_0167735262;
	public TrashTemplate.Tra_17_1_0521786897.Tra_18_2_01914842262.Tra_20_3_0167735262. TableView tableView;
	public TrashTableCatalog tableViewStamp;
	public TrashTemplate.Tra_17_1_0521786897. FiltersView filtersView;
	public TrashTemplate.Tra_17_1_0521786897.FiltersView. TableFilters tableFilters;
	public TrashTableFilters tableFiltersStamp;

    public AbstractTrashTemplate(B box) {
        super(box);
        id("trashTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (header == null) header = register(new Header(box()).<Header>id("a_90308999").owner(AbstractTrashTemplate.this));
		if (header != null) tra_9_2_1186253000 = header.tra_9_2_1186253000;
		if (tra_9_2_1186253000 != null) tra_10_3_0273829 = header.tra_9_2_1186253000.tra_10_3_0273829;
		if (tra_10_3_0273829 != null) label = header.tra_9_2_1186253000.tra_10_3_0273829.label;
		if (tra_9_2_1186253000 != null) count = header.tra_9_2_1186253000.count;
		if (header != null) rightToolbar = header.rightToolbar;
		if (rightToolbar != null) search = header.rightToolbar.search;
		if (tra_17_1_0521786897 == null) tra_17_1_0521786897 = register(new Tra_17_1_0521786897(box()).<Tra_17_1_0521786897>id("a751010564").owner(AbstractTrashTemplate.this));
		if (tra_17_1_0521786897 != null) tra_18_2_01914842262 = tra_17_1_0521786897.tra_18_2_01914842262;
		if (tra_18_2_01914842262 != null) toolbar = tra_17_1_0521786897.tra_18_2_01914842262.toolbar;
		if (tra_18_2_01914842262 != null) tra_20_3_0167735262 = tra_17_1_0521786897.tra_18_2_01914842262.tra_20_3_0167735262;
		if (tra_20_3_0167735262 != null) tableView = tra_17_1_0521786897.tra_18_2_01914842262.tra_20_3_0167735262.tableView;
		if (tableView != null) tableViewStamp = tra_17_1_0521786897.tra_18_2_01914842262.tra_20_3_0167735262.tableView.tableViewStamp;
		if (tra_17_1_0521786897 != null) filtersView = tra_17_1_0521786897.filtersView;
		if (filtersView != null) tableFilters = tra_17_1_0521786897.filtersView.tableFilters;
		if (tableFilters != null) tableFiltersStamp = tra_17_1_0521786897.filtersView.tableFilters.tableFiltersStamp;
	}

	public class Header extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public TrashTemplate.Header. Tra_9_2_1186253000 tra_9_2_1186253000;
		public TrashTemplate.Header. RightToolbar rightToolbar;

		public Header(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (tra_9_2_1186253000 == null) tra_9_2_1186253000 = register(new Tra_9_2_1186253000(box()).<Tra_9_2_1186253000>id("a1493166739").owner(AbstractTrashTemplate.this));
			if (rightToolbar == null) rightToolbar = register(new RightToolbar(box()).<RightToolbar>id("a1955692997").owner(AbstractTrashTemplate.this));
		}

		public class Tra_9_2_1186253000 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public TrashTemplate.Header.Tra_9_2_1186253000. Tra_10_3_0273829 tra_10_3_0273829;
			public TrashTemplate.Header.Tra_9_2_1186253000. Count count;

			public Tra_9_2_1186253000(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (tra_10_3_0273829 == null) tra_10_3_0273829 = register(new Tra_10_3_0273829(box()).<Tra_10_3_0273829>id("a_1946544309").owner(AbstractTrashTemplate.this));
				if (count == null) count = register(new Count(box()).<Count>id("a_1780046763").owner(AbstractTrashTemplate.this));
			}

			public class Tra_10_3_0273829 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public TrashTemplate.Header.Tra_9_2_1186253000.Tra_10_3_0273829. Label label;

				public Tra_10_3_0273829(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (label == null) label = register(new Label(box()).<Label>id("a1879949647").owner(AbstractTrashTemplate.this));
				}

				public class Label extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public Label(B box) {
						super(box);
						_value("Trash");
					}

					@Override
					public void init() {
						super.init();
					}
				}
			}

			public class Count extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public Count(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
				}
			}
		}

		public class RightToolbar extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public TrashTemplate.Header.RightToolbar. Search search;

			public RightToolbar(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (search == null) search = register(new Search(box()).<Search>id("a1235044706").owner(AbstractTrashTemplate.this));
			}

			public class Search extends io.intino.alexandria.ui.displays.components.SearchBox<io.intino.alexandria.ui.displays.notifiers.SearchBoxNotifier, B>  {

				public Search(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
				}
			}
		}
	}

	public class Tra_17_1_0521786897 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public TrashTemplate.Tra_17_1_0521786897. Tra_18_2_01914842262 tra_18_2_01914842262;
		public TrashTemplate.Tra_17_1_0521786897. FiltersView filtersView;

		public Tra_17_1_0521786897(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (tra_18_2_01914842262 == null) tra_18_2_01914842262 = register(new Tra_18_2_01914842262(box()).<Tra_18_2_01914842262>id("a489545162").owner(AbstractTrashTemplate.this));
			if (filtersView == null) filtersView = register(new FiltersView(box()).<FiltersView>id("a1283885600").owner(AbstractTrashTemplate.this));
		}

		public class Tra_18_2_01914842262 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public TrashToolbarTemplate toolbar;
			public TrashTemplate.Tra_17_1_0521786897.Tra_18_2_01914842262. Tra_20_3_0167735262 tra_20_3_0167735262;

			public Tra_18_2_01914842262(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (toolbar == null) toolbar = register(new TrashToolbarTemplate((UnitBox)box()).id("a1985202717"));
				if (tra_20_3_0167735262 == null) tra_20_3_0167735262 = register(new Tra_20_3_0167735262(box()).<Tra_20_3_0167735262>id("a1096271594").owner(AbstractTrashTemplate.this));
			}

			public class Tra_20_3_0167735262 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public TrashTemplate.Tra_17_1_0521786897.Tra_18_2_01914842262.Tra_20_3_0167735262. TableView tableView;

				public Tra_20_3_0167735262(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (tableView == null) tableView = register(new TableView(box()).<TableView>id("a_715671027").owner(AbstractTrashTemplate.this));
				}

				public class TableView extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
					public TrashTableCatalog tableViewStamp;

					public TableView(B box) {
						super(box);
					}

					@Override
					public void init() {
						super.init();
						if (tableViewStamp == null) tableViewStamp = register(new TrashTableCatalog((UnitBox)box()).id("a_1368163230"));
					}
				}
			}
		}

		public class FiltersView extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
			public TrashTemplate.Tra_17_1_0521786897.FiltersView. TableFilters tableFilters;

			public FiltersView(B box) {
				super(box);
			}

			@Override
			public void initConditional() {
				super.init();
				if (tableFilters == null) tableFilters = register(new TableFilters(box()).<TableFilters>id("a780472332").owner(AbstractTrashTemplate.this));
				if (tableFiltersStamp == null) tableFiltersStamp = tra_17_1_0521786897.filtersView.tableFilters.tableFiltersStamp;
			}

			public class TableFilters extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public TrashTableFilters tableFiltersStamp;

				public TableFilters(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (tableFiltersStamp == null) tableFiltersStamp = register(new TrashTableFilters((UnitBox)box()).id("a1069567491"));
				}
			}
		}
	}
}