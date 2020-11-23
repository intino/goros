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

public abstract class AbstractSourceLevelTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public SourceLevelList sourceLevelList;

    public AbstractSourceLevelTemplate(B box) {
        super(box);
        id("sourceLevelTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (sourceLevelList == null) sourceLevelList = register(new SourceLevelList(box()).<SourceLevelList>id("a1365275436").owner(AbstractSourceLevelTemplate.this));
	}

	public class SourceLevelList extends io.intino.alexandria.ui.displays.components.List<B, SourceLevelListItem, org.monet.space.kernel.model.Term> implements io.intino.alexandria.ui.displays.components.collection.Selectable {

		public SourceLevelList(B box) {
			super(box);

			_pageSize(20);
		}

		@Override
		public void init() {
			super.init();
		}
		public void onSelect(io.intino.alexandria.ui.displays.events.SelectionListener listener) {
			super.addSelectionListener(listener);
		}
		public SourceLevelListItem create(org.monet.space.kernel.model.Term element) {
			SourceLevelListItem result = new SourceLevelListItem((UnitBox)box());
			result.id(java.util.UUID.randomUUID().toString());
			result.item(element);
			return result;
		}
	}
}