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

public abstract class AbstractTaskPlaceLineTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Tasvie_72_1_0614664671 tasvie_72_1_0614664671;
	public TaskPlaceLineTemplate.Tasvie_72_1_0614664671. Label label;
	public TaskPlaceLineTemplate.Tasvie_72_1_0614664671. TimeoutMessage timeoutMessage;
	public LoadingStops loadingStops;
	public TaskPlaceLineTemplate.LoadingStops. Tasvie_75_22_1339785223 tasvie_75_22_1339785223;
	public StopsBlock stopsBlock;
	public TaskPlaceLineTemplate.StopsBlock. Stops stops;

    public AbstractTaskPlaceLineTemplate(B box) {
        super(box);
        id("taskPlaceLineTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (tasvie_72_1_0614664671 == null) tasvie_72_1_0614664671 = register(new Tasvie_72_1_0614664671(box()).<Tasvie_72_1_0614664671>id("a_1183826318").owner(AbstractTaskPlaceLineTemplate.this));
		if (tasvie_72_1_0614664671 != null) label = tasvie_72_1_0614664671.label;
		if (tasvie_72_1_0614664671 != null) timeoutMessage = tasvie_72_1_0614664671.timeoutMessage;
		if (loadingStops == null) loadingStops = register(new LoadingStops(box()).<LoadingStops>id("a233750819").owner(AbstractTaskPlaceLineTemplate.this));
		if (loadingStops != null) tasvie_75_22_1339785223 = loadingStops.tasvie_75_22_1339785223;
		if (stopsBlock == null) stopsBlock = register(new StopsBlock(box()).<StopsBlock>id("a1700500010").owner(AbstractTaskPlaceLineTemplate.this));
		if (stopsBlock != null) stops = stopsBlock.stops;
	}

	public class Tasvie_72_1_0614664671 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public TaskPlaceLineTemplate.Tasvie_72_1_0614664671. Label label;
		public TaskPlaceLineTemplate.Tasvie_72_1_0614664671. TimeoutMessage timeoutMessage;

		public Tasvie_72_1_0614664671(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (label == null) label = register(new Label(box()).<Label>id("a205974072").owner(AbstractTaskPlaceLineTemplate.this));
			if (timeoutMessage == null) timeoutMessage = register(new TimeoutMessage(box()).<TimeoutMessage>id("a434678946").owner(AbstractTaskPlaceLineTemplate.this));
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

		public class TimeoutMessage extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public TimeoutMessage(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}

	public class LoadingStops extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public TaskPlaceLineTemplate.LoadingStops. Tasvie_75_22_1339785223 tasvie_75_22_1339785223;

		public LoadingStops(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (tasvie_75_22_1339785223 == null) tasvie_75_22_1339785223 = register(new Tasvie_75_22_1339785223(box()).<Tasvie_75_22_1339785223>id("a_534114340").owner(AbstractTaskPlaceLineTemplate.this));
		}

		public class Tasvie_75_22_1339785223 extends io.intino.alexandria.ui.displays.components.Spinner<io.intino.alexandria.ui.displays.notifiers.SpinnerNotifier, B>  {

			public Tasvie_75_22_1339785223(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}

	public class StopsBlock extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public TaskPlaceLineTemplate.StopsBlock. Stops stops;

		public StopsBlock(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (stops == null) stops = register(new Stops((UnitBox)box()).<Stops>id("a1498621532").owner(AbstractTaskPlaceLineTemplate.this));
		}

		public class Stops extends io.intino.alexandria.ui.displays.components.Multiple<UnitBox,TaskPlaceLineStopTemplate, java.lang.Void>  {

			public Stops(UnitBox box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}

			@Override
			public TaskPlaceLineStopTemplate add(java.lang.Void value) {
				TaskPlaceLineStopTemplate child = new TaskPlaceLineStopTemplate(box());
				child.id(java.util.UUID.randomUUID().toString());
				add(child, "stops");
			    notifyAdd(child);
				return child;
			}
			@Override
			public void remove(TaskPlaceLineStopTemplate child) {
				removeChild(child, "stops");
			}
			public void clear() {
			    super.clear("stops");
			}
		}
	}
}