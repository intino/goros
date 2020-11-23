package io.intino.goros.unit.util;

import io.intino.alexandria.ui.Soul;
import io.intino.alexandria.ui.displays.DisplayRouteManager;
import org.monet.metamodel.Definition;
import org.monet.space.kernel.model.Dictionary;
import org.monet.space.kernel.model.Node;
import org.monet.space.kernel.model.Task;
import io.intino.goros.unit.box.ui.displays.RouteDispatcher;

public class PathHelper {

	public static void dispatch(DisplayRouteManager manager, Soul soul, Node node) {
		RouteDispatcher dispatcher = (RouteDispatcher) manager.routeDispatcher();
		dispatcher.dispatch(soul, PathHelper.pathOf(node));
	}

	public static String fill(String path, Task task) {
		return path.replace(":task", task.getId());
	}

	public static String nameOf(Definition definition) {
		String prefix = prefixOf(definition, Dictionary.getInstance().basePackage());
		String name = definition.getName();
		name = name.contains(".") ? name.substring(name.lastIndexOf(".")+1) : name;
		return prefix + name;
	}

	public static String pathOf(Node node) {
		return "/" + subPathOf(node);
	}

	public static String pathOf(Task task) {
		return "/" + subPathOf(task);
	}

	private static String subPathOf(Node node) {
		String pathId = pathIdOf(node);
		return (node.isSingleton() ? "elemento/" : "instancia/") + NodeHelper.nameOf(node) + (pathId.isEmpty() ? "" : "/" + pathId);
	}

	private static String subPathOf(Task task) {
		return "tarea/" + TaskHelper.nameOf(task) + "/tareas/" + task.getId();
	}

	private static String pathIdOf(Node node) {
		return node.isSingleton() ? "" : node.getId();
	}

	private static String prefixOf(Definition definition, String basePackage) {
		String prefix = definition.getName();
		if (!prefix.contains(".")) return "";
		prefix = prefix.substring(0, prefix.lastIndexOf("."));
		prefix = prefix.replace(basePackage + ".", "").replace(basePackage, "").replace(".", "-");
		return StringHelper.snakeCaseToCamelCase(/*shortName(*/prefix/*)*/);
	}

}
