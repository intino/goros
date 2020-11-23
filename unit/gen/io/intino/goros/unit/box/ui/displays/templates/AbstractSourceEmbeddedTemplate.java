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

public abstract class AbstractSourceEmbeddedTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public LevelsBlock levelsBlock;
	public SourceEmbeddedTemplate.LevelsBlock. Levels levels;
	public TermView termView;
	public PublishTermsDialog publishTermsDialog;
	public SourceTermDialog termDialog;

    public AbstractSourceEmbeddedTemplate(B box) {
        super(box);
        id("sourceEmbeddedTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (levelsBlock == null) levelsBlock = register(new LevelsBlock(box()).<LevelsBlock>id("a644854813").owner(AbstractSourceEmbeddedTemplate.this));
		if (levelsBlock != null) levels = levelsBlock.levels;
		if (termView == null) termView = register(new TermView(box()).<TermView>id("a_1551538734").owner(AbstractSourceEmbeddedTemplate.this));
		if (termView != null) publishTermsDialog = termView.publishTermsDialog;
		if (termView != null) termDialog = termView.termDialog;
	}

	public class LevelsBlock extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public SourceEmbeddedTemplate.LevelsBlock. Levels levels;

		public LevelsBlock(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (levels == null) levels = register(new Levels((UnitBox)box()).<Levels>id("a104969169").owner(AbstractSourceEmbeddedTemplate.this));
		}

		public class Levels extends io.intino.alexandria.ui.displays.components.Multiple<UnitBox,SourceLevelTemplate, java.lang.Void>  {

			public Levels(UnitBox box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}

			@Override
			public SourceLevelTemplate add(java.lang.Void value) {
				SourceLevelTemplate child = new SourceLevelTemplate(box());
				child.id(java.util.UUID.randomUUID().toString());
				add(child, "levels");
			    notifyAdd(child);
				return child;
			}
			@Override
			public void remove(SourceLevelTemplate child) {
				removeChild(child, "levels");
			}
			public void clear() {
			    super.clear("levels");
			}
		}
	}

	public class TermView extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
		public PublishTermsDialog publishTermsDialog;
		public SourceTermDialog termDialog;

		public TermView(B box) {
			super(box);
		}

		@Override
		public void initConditional() {
			super.init();
			if (publishTermsDialog == null) publishTermsDialog = register(new PublishTermsDialog((UnitBox)box()).id("a_829429587"));
			if (termDialog == null) termDialog = register(new SourceTermDialog((UnitBox)box()).id("a_2134596255"));
			if (publishTermsDialog == null) publishTermsDialog = termView.publishTermsDialog;
			if (termDialog == null) termDialog = termView.termDialog;
		}
	}
}