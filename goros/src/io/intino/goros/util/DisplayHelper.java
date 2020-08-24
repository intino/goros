package io.intino.goros.util;

import io.intino.alexandria.ui.displays.components.SelectorCollectionBox;
import io.intino.alexandria.ui.displays.components.SelectorTabs;
import io.intino.alexandria.ui.displays.components.SelectorToggleBox;
import org.monet.metamodel.*;
import org.monet.space.kernel.model.Language;
import org.monet.space.kernel.model.Node;
import org.monet.space.kernel.model.NodeItem;
import org.monet.space.kernel.model.Task;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Consumer;

public class DisplayHelper {

	public static void executeDelayed(Consumer<Boolean> consumer) {
		executeDelayed(consumer, 1000);
	}

	public static void executeDelayed(Consumer<Boolean> consumer, long delay) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				consumer.accept(true);
			}
		}, delay);
	}

	public static void selectDefaultView(SelectorTabs selector, Node node) {
		NodeViewProperty defaultView = node.getDefinition().getDefaultView();
		if (defaultView == null) selector.select(0);
		else selector.select(StringHelper.validName(Language.getInstance().getModelResource(defaultView.getLabel())));
	}

	public static void selectDefaultView(SelectorTabs selector, Task task) {
		ProcessDefinitionBase.ViewProperty defaultView = null;
		if (task.getDefinition().isActivity()) defaultView = ((ActivityDefinition)task.getDefinition()).getDefaultView();
		else if (task.getDefinition().isService()) defaultView = ((ServiceDefinition)task.getDefinition()).getDefaultView();
		if (defaultView == null) selector.select(0);
		else selector.select(StringHelper.validName(Language.getInstance().getModelResource(defaultView.getLabel())));
	}

	public static void selectDefaultView(SelectorToggleBox selector, Node node) {
		NodeViewProperty defaultView = defaultView(node);
		selector.select(StringHelper.validName(Language.getInstance().getModelResource(defaultView.getLabel())));
	}

	public static NodeViewProperty defaultView(Node node) {
		NodeViewProperty defaultView = node.getDefinition().getDefaultView();
		List<NodeViewProperty> viewList = node.getDefinition().getViewDefinitionList();
		return defaultView != null ? defaultView : (viewList.size() > 0 ? viewList.get(0) : null);
	}

	public static NodeViewProperty defaultEmbeddedView(Node node) {
		NodeDefinition definition = node.getDefinition();
		NodeViewProperty defaultView = definition.getDefaultView();
		if (defaultView.isVisibleWhenEmbedded()) return defaultView;
		return definition.getViewDefinitionList().stream().filter(NodeViewProperty::isVisibleWhenEmbedded).findFirst().orElse(definition.getDefaultView());
	}

	public static void selectNotSystemView(SelectorTabs selector, Node node) {
		NodeViewProperty view = node.getDefinition().getDefaultView();
		if (view != null && !DictionaryHelper.isSystemView(view)) {
			selector.select(Language.getInstance().getModelResource(view.getLabel()));
			return;
		}
		view = node.getDefinition().getViewDefinitionList().stream().filter(v -> !DictionaryHelper.isSystemView(v)).findFirst().orElse(null);
		if (view == null) selector.select(0);
		else selector.select(StringHelper.validName(Language.getInstance().getModelResource(view.getLabel())));
	}

	public static String requireConfirmationMessage(PlaceActionProperty property) {
		PlaceActionProperty.RequireConfirmationProperty requireConfirmation = property.getRequireConfirmation();

		if (requireConfirmation == null)
			return null;

		return requireConfirmation.getMessage() != null ? Language.getInstance().getModelResource(requireConfirmation.getMessage()) : "Are you sure you want continue with task?";
	}

	public static SelectorCollectionBox.ValueProvider linkValueProvider() {
		return nodeItem -> ((NodeItem)nodeItem).getAttribute("value");
	}
}
