package io.intino.goros.builder.renderers;

import io.intino.goros.builder.Modernization;
import io.intino.goros.builder.monet.Dictionary;
import io.intino.goros.builder.renderers.templates.java.TasksTemplate;
import io.intino.goros.builder.renderers.templates.konos.UITemplate;
import io.intino.itrules.Frame;
import io.intino.itrules.FrameBuilder;
import org.monet.metamodel.ActivityDefinition;
import org.monet.metamodel.TaskDefinition;
import org.monet.space.kernel.model.TaskTray;

import java.io.File;

public class TasksRenderer extends Renderer {

	public TasksRenderer(Dictionary dictionary, Modernization modernization) {
		super(dictionary, modernization);
	}

	public void write() {
		FrameBuilder builder = buildFrame();
		writeJava(builder);
		writeKonos(builder);
		writeTaskTrayTemplate();
		writeTaskBoardTemplate();
		writeEmbeddedTemplate();
		writeNodeTasksTemplate();
	}

	private FrameBuilder buildFrame() {
		FrameBuilder result = baseFrame().add("tasks");
		addTasks(result);
		return result;
	}

	private FrameBuilder inboxFrame(String type) {
		FrameBuilder result = buildFrame().add("inbox");
		result.add("inboxType", type);
		return result;
	}

	private void addTasks(FrameBuilder builder) {
		dictionary.getTaskDefinitionList().stream().filter(t -> t instanceof ActivityDefinition).forEach(d -> addTask(d, builder));
	}

	private void addTask(TaskDefinition definition, FrameBuilder builder) {
		FrameBuilder result = baseFrame().add("activity");
		result.add("name", nameOf(definition));
		result.add("code", definition.getCode());
		builder.add("activity", result);
	}

	protected void writeJava(FrameBuilder builder) {
		File file = new File(javaPackage() + "TasksTemplate.java");
		writeFrame(file, new io.intino.goros.builder.renderers.templates.java.TasksTemplate().render(builder.toFrame()));
	}

	protected void writeKonos(FrameBuilder builder) {
		File file = new File(konosPackage() + "Tasks.konos");
		writeFrame(file, new io.intino.goros.builder.renderers.templates.konos.TasksTemplate().render(builder.toFrame()));
	}

	protected void writeTaskTrayTemplate() {
		FrameBuilder builder = inboxFrame("TaskTray");
		File file = new File(javaPackage() + "TaskTrayTemplate.java");
		writeFrame(file, new io.intino.goros.builder.renderers.templates.java.TasksTemplate().render(builder.toFrame()));
	}

	protected void writeTaskBoardTemplate() {
		FrameBuilder builder = inboxFrame("TaskBoard");
		File file = new File(javaPackage() + "TaskBoardTemplate.java");
		writeFrame(file, new io.intino.goros.builder.renderers.templates.java.TasksTemplate().render(builder.toFrame()));
	}

	protected void writeEmbeddedTemplate() {
		FrameBuilder builder = buildFrame().add("embedded");
		File file = new File(javaPackage() + "TasksEmbeddedTemplate.java");
		writeFrame(file, new io.intino.goros.builder.renderers.templates.java.TasksTemplate().render(builder.toFrame()));
	}

	private void writeNodeTasksTemplate() {
		FrameBuilder builder = buildFrame().add("nodetasks");
		File file = new File(javaPackage() + "NodeTasksTemplate.java");
		writeFrame(file, new io.intino.goros.builder.renderers.templates.java.TasksTemplate().render(builder.toFrame()));
	}
}