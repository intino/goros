package io.intino.goros.unit.util;

import io.intino.alexandria.ui.Soul;
import io.intino.alexandria.ui.displays.DisplayRouteManager;
import org.monet.metamodel.Definition;
import org.monet.space.kernel.configuration.Configuration;
import org.monet.space.kernel.model.Dictionary;
import org.monet.space.kernel.model.MonetLink;
import org.monet.space.kernel.model.Node;
import org.monet.space.kernel.model.Task;
import io.intino.goros.unit.box.ui.displays.RouteDispatcher;

public class PathHelper {

	public static void dispatch(DisplayRouteManager manager, Soul soul, Task task) {
		RouteDispatcher dispatcher = (RouteDispatcher) manager.routeDispatcher();
		dispatcher.dispatch(soul, PathHelper.pathOf(task));
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

	public static String pathOf(MonetLink link) {
		MonetLink.Type type = link.getType();
		if (type == MonetLink.Type.News) return PathHelper.pathOfNews();
		else if (type == MonetLink.Type.Node) return PathHelper.pathOf(NodeHelper.nodeOf(link), link.getView());
		else if (type == MonetLink.Type.Task) return PathHelper.pathOf(TaskHelper.taskOf(link));
		return null;
	}

	public static String pathOf(Node node) {
		return pathOf(node, null);
	}

	public static String pathOf(Node node, String view) {
		return pathOf(node, view, null);
	}

	public static String pathOf(Node node, String view, String mode) {
		return withRootPath(subPathOf(node) + "/" + (view != null ? view : "default")) + "/" + (mode != null ? mode : "default");
	}

	public static String pathOf(Task task) {
		return withRootPath(subPathOf(task));
	}

	public static String pathOfNews() {
		return withRootPath("noticias");
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

	private static String withRootPath(String path) {
		return "/" + path;
//		String rootPath = Configuration.getInstance().getPath();
//		return rootPath != null && !rootPath.isEmpty() ? rootPath + "/" + path : "/" + path;
	}

	private static String prefixOf(Definition definition, String basePackage) {
		String prefix = definition.getName();
		if (!prefix.contains(".")) return "";
		prefix = prefix.substring(0, prefix.lastIndexOf("."));
		prefix = prefix.replace(basePackage + ".", "").replace(basePackage, "").replace(".", "-");
		return StringHelper.snakeCaseToCamelCase(/*shortName(*/prefix/*)*/);
	}

}
