package io.intino.goros.util;

import io.intino.alexandria.ui.Soul;
import io.intino.alexandria.ui.displays.DisplayRouteManager;
import org.monet.metamodel.Definition;
import org.monet.space.kernel.model.Node;
import org.monet.space.kernel.model.Task;
import io.intino.goros.box.ui.displays.RouteDispatcher;

public class PathHelper {

	public static void dispatch(DisplayRouteManager manager, Soul soul, Node node) {
		RouteDispatcher dispatcher = (RouteDispatcher) manager.routeDispatcher();
		dispatcher.dispatch(soul, PathHelper.pathOf(node));
	}

	public static String fill(String path, Task task) {
		return path.replace(":task", task.getId());
	}

	public static String pathOf(Node node) {
		String result = "/" + subPathOf(node);
//		Node parent = node.getParent();
//		while (parent != null) {
//			result = subPathOf(parent) + "/" + result;
//			parent = parent.getParent();
//		}
		return result;
	}

	private static String subPathOf(Node node) {
		String pathId = pathIdOf(node);
		return (node.isSingleton() ? "elemento/" : "instancia/") + NodeHelper.nameOf(node) + (pathId.isEmpty() ? "" : "/" + pathId);
	}

	private static String pathIdOf(Node node) {
		return node.isSingleton() ? "" : node.getId();
	}

}
