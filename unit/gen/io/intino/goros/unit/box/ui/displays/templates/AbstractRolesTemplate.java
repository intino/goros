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

public abstract class AbstractRolesTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Header header;
	public RolesTemplate.Header. Rol_9_2_11339642018 rol_9_2_11339642018;
	public RolesTemplate.Header.Rol_9_2_11339642018. Rol_10_3_01249520959 rol_10_3_01249520959;
	public RolesTemplate.Header.Rol_9_2_11339642018.Rol_10_3_01249520959. Rol_11_4_02075283838 rol_11_4_02075283838;
	public RolesTemplate.Header.Rol_9_2_11339642018. Count count;
	public RolesTemplate.Header. RightToolbar rightToolbar;
	public RolesTemplate.Header.RightToolbar. Search search;
	public RolesTemplate.Header.RightToolbar. Download download;
	public RolesTemplate.Header.RightToolbar. Filters filters;
	public Rol_18_1_1366070726 rol_18_1_1366070726;
	public RolesTemplate.Rol_18_1_1366070726. Rol_19_2_11650325332 rol_19_2_11650325332;
	public RolesToolbarTemplate toolbar;
	public RolesTemplate.Rol_18_1_1366070726.Rol_19_2_11650325332. Rol_21_3_0424019081 rol_21_3_0424019081;
	public RolesTemplate.Rol_18_1_1366070726.Rol_19_2_11650325332.Rol_21_3_0424019081. TableView tableView;
	public RolesTableCatalog tableViewStamp;
	public RolesTemplate.Rol_18_1_1366070726. FiltersView filtersView;
	public RolesFiltersTemplate rolesFiltersStamp;
	public RolesTemplate.Rol_18_1_1366070726. RoleView roleView;
	public RoleEmbeddedTemplate roleStamp;

    public AbstractRolesTemplate(B box) {
        super(box);
        id("rolesTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (header == null) header = register(new Header(box()).<Header>id("a2090485844").owner(AbstractRolesTemplate.this));
		if (header != null) rol_9_2_11339642018 = header.rol_9_2_11339642018;
		if (rol_9_2_11339642018 != null) rol_10_3_01249520959 = header.rol_9_2_11339642018.rol_10_3_01249520959;
		if (rol_10_3_01249520959 != null) rol_11_4_02075283838 = header.rol_9_2_11339642018.rol_10_3_01249520959.rol_11_4_02075283838;
		if (rol_9_2_11339642018 != null) count = header.rol_9_2_11339642018.count;
		if (header != null) rightToolbar = header.rightToolbar;
		if (rightToolbar != null) search = header.rightToolbar.search;
		if (rightToolbar != null) download = header.rightToolbar.download;
		if (rightToolbar != null) filters = header.rightToolbar.filters;
		if (rol_18_1_1366070726 == null) rol_18_1_1366070726 = register(new Rol_18_1_1366070726(box()).<Rol_18_1_1366070726>id("a325249795").owner(AbstractRolesTemplate.this));
		if (rol_18_1_1366070726 != null) rol_19_2_11650325332 = rol_18_1_1366070726.rol_19_2_11650325332;
		if (rol_19_2_11650325332 != null) toolbar = rol_18_1_1366070726.rol_19_2_11650325332.toolbar;
		if (rol_19_2_11650325332 != null) rol_21_3_0424019081 = rol_18_1_1366070726.rol_19_2_11650325332.rol_21_3_0424019081;
		if (rol_21_3_0424019081 != null) tableView = rol_18_1_1366070726.rol_19_2_11650325332.rol_21_3_0424019081.tableView;
		if (tableView != null) tableViewStamp = rol_18_1_1366070726.rol_19_2_11650325332.rol_21_3_0424019081.tableView.tableViewStamp;
		if (rol_18_1_1366070726 != null) filtersView = rol_18_1_1366070726.filtersView;
		if (filtersView != null) rolesFiltersStamp = rol_18_1_1366070726.filtersView.rolesFiltersStamp;
		if (rol_18_1_1366070726 != null) roleView = rol_18_1_1366070726.roleView;
		if (roleView != null) roleStamp = rol_18_1_1366070726.roleView.roleStamp;
	}

	public class Header extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public RolesTemplate.Header. Rol_9_2_11339642018 rol_9_2_11339642018;
		public RolesTemplate.Header. RightToolbar rightToolbar;

		public Header(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (rol_9_2_11339642018 == null) rol_9_2_11339642018 = register(new Rol_9_2_11339642018(box()).<Rol_9_2_11339642018>id("a_1121117010").owner(AbstractRolesTemplate.this));
			if (rightToolbar == null) rightToolbar = register(new RightToolbar(box()).<RightToolbar>id("a_2091953206").owner(AbstractRolesTemplate.this));
		}

		public class Rol_9_2_11339642018 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public RolesTemplate.Header.Rol_9_2_11339642018. Rol_10_3_01249520959 rol_10_3_01249520959;
			public RolesTemplate.Header.Rol_9_2_11339642018. Count count;

			public Rol_9_2_11339642018(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (rol_10_3_01249520959 == null) rol_10_3_01249520959 = register(new Rol_10_3_01249520959(box()).<Rol_10_3_01249520959>id("a382579449").owner(AbstractRolesTemplate.this));
				if (count == null) count = register(new Count(box()).<Count>id("a1985240474").owner(AbstractRolesTemplate.this));
			}

			public class Rol_10_3_01249520959 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public RolesTemplate.Header.Rol_9_2_11339642018.Rol_10_3_01249520959. Rol_11_4_02075283838 rol_11_4_02075283838;

				public Rol_10_3_01249520959(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (rol_11_4_02075283838 == null) rol_11_4_02075283838 = register(new Rol_11_4_02075283838(box()).<Rol_11_4_02075283838>id("a635808812").owner(AbstractRolesTemplate.this));
				}

				public class Rol_11_4_02075283838 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public Rol_11_4_02075283838(B box) {
						super(box);
						_value("Roles");
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
			public RolesTemplate.Header.RightToolbar. Search search;
			public RolesTemplate.Header.RightToolbar. Download download;
			public RolesTemplate.Header.RightToolbar. Filters filters;

			public RightToolbar(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (search == null) search = register(new Search(box()).<Search>id("a1517623229").owner(AbstractRolesTemplate.this));
				if (download == null) download = register(new Download(box()).<Download>id("a_1313781411").owner(AbstractRolesTemplate.this));
				if (filters == null) filters = register(new Filters(box()).<Filters>id("a1273771142").owner(AbstractRolesTemplate.this));
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

			public class Download extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B>  {

				public Download(B box) {
					super(box);
					_title("Download");
					_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("MaterialIconButton"));
					_icon("Archive");
				}

				@Override
				public void init() {
					super.init();
				}
			}

			public class Filters extends io.intino.alexandria.ui.displays.components.ActionToggle<io.intino.alexandria.ui.displays.notifiers.ActionToggleNotifier, B> implements io.intino.alexandria.ui.displays.components.selector.SelectorOption {

				public Filters(B box) {
					super(box);
					_title("Filtrar");
					_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("MaterialIconToggle"));
					_icon("FilterList");
				}

				@Override
				public void init() {
					super.init();
				}
			}
		}
	}

	public class Rol_18_1_1366070726 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public RolesTemplate.Rol_18_1_1366070726. Rol_19_2_11650325332 rol_19_2_11650325332;
		public RolesTemplate.Rol_18_1_1366070726. FiltersView filtersView;
		public RolesTemplate.Rol_18_1_1366070726. RoleView roleView;

		public Rol_18_1_1366070726(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (rol_19_2_11650325332 == null) rol_19_2_11650325332 = register(new Rol_19_2_11650325332(box()).<Rol_19_2_11650325332>id("a772894237").owner(AbstractRolesTemplate.this));
			if (filtersView == null) filtersView = register(new FiltersView(box()).<FiltersView>id("a_1703726212").owner(AbstractRolesTemplate.this));
			if (roleView == null) roleView = register(new RoleView(box()).<RoleView>id("a_1622624385").owner(AbstractRolesTemplate.this));
		}

		public class Rol_19_2_11650325332 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public RolesToolbarTemplate toolbar;
			public RolesTemplate.Rol_18_1_1366070726.Rol_19_2_11650325332. Rol_21_3_0424019081 rol_21_3_0424019081;

			public Rol_19_2_11650325332(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (toolbar == null) toolbar = register(new RolesToolbarTemplate((UnitBox)box()).id("a199459193"));
				if (rol_21_3_0424019081 == null) rol_21_3_0424019081 = register(new Rol_21_3_0424019081(box()).<Rol_21_3_0424019081>id("a1003279537").owner(AbstractRolesTemplate.this));
			}

			public class Rol_21_3_0424019081 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public RolesTemplate.Rol_18_1_1366070726.Rol_19_2_11650325332.Rol_21_3_0424019081. TableView tableView;

				public Rol_21_3_0424019081(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (tableView == null) tableView = register(new TableView(box()).<TableView>id("a1171720809").owner(AbstractRolesTemplate.this));
				}

				public class TableView extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
					public RolesTableCatalog tableViewStamp;

					public TableView(B box) {
						super(box);
					}

					@Override
					public void initConditional() {
						super.init();
						if (tableViewStamp == null) tableViewStamp = register(new RolesTableCatalog((UnitBox)box()).id("a_170530682"));
						if (tableViewStamp == null) tableViewStamp = rol_18_1_1366070726.rol_19_2_11650325332.rol_21_3_0424019081.tableView.tableViewStamp;
					}
				}
			}
		}

		public class FiltersView extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
			public RolesFiltersTemplate rolesFiltersStamp;

			public FiltersView(B box) {
				super(box);
			}

			@Override
			public void initConditional() {
				super.init();
				if (rolesFiltersStamp == null) rolesFiltersStamp = register(new RolesFiltersTemplate((UnitBox)box()).id("a661182946"));
				if (rolesFiltersStamp == null) rolesFiltersStamp = rol_18_1_1366070726.filtersView.rolesFiltersStamp;
			}
		}

		public class RoleView extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
			public RoleEmbeddedTemplate roleStamp;

			public RoleView(B box) {
				super(box);
			}

			@Override
			public void initConditional() {
				super.init();
				if (roleStamp == null) roleStamp = register(new RoleEmbeddedTemplate((UnitBox)box()).id("a958647341"));
				if (roleStamp == null) roleStamp = rol_18_1_1366070726.roleView.roleStamp;
			}
		}
	}
}