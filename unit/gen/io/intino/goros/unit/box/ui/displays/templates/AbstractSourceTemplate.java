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

public abstract class AbstractSourceTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Header header;
	public SourceTemplate.Header. Sou_7_8_12014258538 sou_7_8_12014258538;
	public SourceTemplate.Header.Sou_7_8_12014258538. Sou_8_12_1952734992 sou_8_12_1952734992;
	public SourceTemplate.Header.Sou_7_8_12014258538.Sou_8_12_1952734992. DesktopLink desktopLink;
	public SourceTemplate.Header.Sou_7_8_12014258538.Sou_8_12_1952734992. DesktopLinkSeparator desktopLinkSeparator;
	public SourceTemplate.Header.Sou_7_8_12014258538.Sou_8_12_1952734992. Label label;
	public SourceTemplate.Header.Sou_7_8_12014258538. Count count;
	public SourceLegendTemplate sou_13_12_01116687971;
	public Sou_15_4_11690252698 sou_15_4_11690252698;
	public SourceTemplate.Sou_15_4_11690252698. Sou_16_8_1286889868 sou_16_8_1286889868;
	public SourceEmbeddedTemplate content;

    public AbstractSourceTemplate(B box) {
        super(box);
        id("sourceTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (header == null) header = register(new Header(box()).<Header>id("a593751384").owner(AbstractSourceTemplate.this));
		if (header != null) sou_7_8_12014258538 = header.sou_7_8_12014258538;
		if (sou_7_8_12014258538 != null) sou_8_12_1952734992 = header.sou_7_8_12014258538.sou_8_12_1952734992;
		if (sou_8_12_1952734992 != null) desktopLink = header.sou_7_8_12014258538.sou_8_12_1952734992.desktopLink;
		if (sou_8_12_1952734992 != null) desktopLinkSeparator = header.sou_7_8_12014258538.sou_8_12_1952734992.desktopLinkSeparator;
		if (sou_8_12_1952734992 != null) label = header.sou_7_8_12014258538.sou_8_12_1952734992.label;
		if (sou_7_8_12014258538 != null) count = header.sou_7_8_12014258538.count;
		if (sou_7_8_12014258538 != null) sou_13_12_01116687971 = header.sou_7_8_12014258538.sou_13_12_01116687971;
		if (sou_15_4_11690252698 == null) sou_15_4_11690252698 = register(new Sou_15_4_11690252698(box()).<Sou_15_4_11690252698>id("a_1804383714").owner(AbstractSourceTemplate.this));
		if (sou_15_4_11690252698 != null) sou_16_8_1286889868 = sou_15_4_11690252698.sou_16_8_1286889868;
		if (sou_16_8_1286889868 != null) content = sou_15_4_11690252698.sou_16_8_1286889868.content;
	}

	public class Header extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public SourceTemplate.Header. Sou_7_8_12014258538 sou_7_8_12014258538;

		public Header(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (sou_7_8_12014258538 == null) sou_7_8_12014258538 = register(new Sou_7_8_12014258538(box()).<Sou_7_8_12014258538>id("a_846414245").owner(AbstractSourceTemplate.this));
		}

		public class Sou_7_8_12014258538 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public SourceTemplate.Header.Sou_7_8_12014258538. Sou_8_12_1952734992 sou_8_12_1952734992;
			public SourceTemplate.Header.Sou_7_8_12014258538. Count count;
			public SourceLegendTemplate sou_13_12_01116687971;

			public Sou_7_8_12014258538(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (sou_8_12_1952734992 == null) sou_8_12_1952734992 = register(new Sou_8_12_1952734992(box()).<Sou_8_12_1952734992>id("a_1126224355").owner(AbstractSourceTemplate.this));
				if (count == null) count = register(new Count(box()).<Count>id("a_1984517316").owner(AbstractSourceTemplate.this));
				if (sou_13_12_01116687971 == null) sou_13_12_01116687971 = register(new SourceLegendTemplate((UnitBox)box()).id("a1373225305"));
			}

			public class Sou_8_12_1952734992 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public SourceTemplate.Header.Sou_7_8_12014258538.Sou_8_12_1952734992. DesktopLink desktopLink;
				public SourceTemplate.Header.Sou_7_8_12014258538.Sou_8_12_1952734992. DesktopLinkSeparator desktopLinkSeparator;
				public SourceTemplate.Header.Sou_7_8_12014258538.Sou_8_12_1952734992. Label label;

				public Sou_8_12_1952734992(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (desktopLink == null) desktopLink = register(new DesktopLink(box()).<DesktopLink>id("a_133684349").owner(AbstractSourceTemplate.this));
					if (desktopLinkSeparator == null) desktopLinkSeparator = register(new DesktopLinkSeparator(box()).<DesktopLinkSeparator>id("a2076123810").owner(AbstractSourceTemplate.this));
					if (label == null) label = register(new Label(box()).<Label>id("a1992333825").owner(AbstractSourceTemplate.this));
				}

				public class DesktopLink extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B> implements io.intino.alexandria.ui.displays.components.addressable.Addressed<DesktopLink> {

					public DesktopLink(B box) {
						super(box);
						_title("");
						_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Link"));
						_path("");
					}

					@Override
					public void init() {
						super.init();
					}
					@Override
					public DesktopLink address(java.util.function.Function<String, String> addressFromPathResolver) {
					    address(addressFromPathResolver.apply(path()));
					    return this;
					}
				}

				public class DesktopLinkSeparator extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public DesktopLinkSeparator(B box) {
						super(box);
						_value("/");
					}

					@Override
					public void init() {
						super.init();
					}
				}

				public class Label extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public Label(B box) {
						super(box);
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
	}

	public class Sou_15_4_11690252698 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public SourceTemplate.Sou_15_4_11690252698. Sou_16_8_1286889868 sou_16_8_1286889868;

		public Sou_15_4_11690252698(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (sou_16_8_1286889868 == null) sou_16_8_1286889868 = register(new Sou_16_8_1286889868(box()).<Sou_16_8_1286889868>id("a_1544281735").owner(AbstractSourceTemplate.this));
		}

		public class Sou_16_8_1286889868 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public SourceEmbeddedTemplate content;

			public Sou_16_8_1286889868(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (content == null) content = register(new SourceEmbeddedTemplate((UnitBox)box()).id("a1439598428"));
			}
		}
	}
}