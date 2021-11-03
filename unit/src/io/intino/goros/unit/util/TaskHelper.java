package io.intino.goros.unit.util;

import io.intino.alexandria.ui.services.push.UISession;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.box.ui.datasources.model.Column;
import io.intino.goros.unit.printers.TaskListPrinter;
import org.monet.space.kernel.model.DataRequest;
import org.monet.space.kernel.model.MonetLink;
import org.monet.space.kernel.model.Task;
import org.monet.space.kernel.model.TaskSearchRequest;
import org.monet.space.office.presentation.user.renders.TaskListPrintRender;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class TaskHelper {

    public static Task taskOf(MonetLink link) {
        if (link == null) return null;
        return LayerHelper.taskLayer().loadTask(link.getId());
    }

    public static InputStream download(UnitBox box, TaskSearchRequest request, String format, String language, List<String> columns, UISession session) {
        return new TaskListPrinter(box, AccountHelper.account(session), request, format, columns).print(language);
    }

    public static List<Column> downloadColumns(String language) {
        return TaskListPrintRender.attributes.stream().map(a -> columnOf(a, language)).collect(toList());
    }

    private static Column columnOf(String attribute, String language) {
        language = TaskListPrintRender.attributesLabels.containsKey(language) ? language : "es";
        List<String> translations = TaskListPrintRender.attributesLabels.get(language);
        return new Column().code(attribute).label(translations.get(positionOf(attribute)));
    }

    private static int positionOf(String attribute) {
        int pos = 0;

        for(Iterator iterator = TaskListPrintRender.attributes.iterator(); iterator.hasNext(); ++pos) {
            String currentAttribute = (String)iterator.next();
            if (currentAttribute.equals(attribute)) {
                return pos;
            }
        }

        return -1;
    }

    public static boolean isAlive(Task task) {
        return !task.isExpired() && !task.isAborted() && !task.isFinished();
    }

    public static String nameOf(Task task) {
        return PathHelper.nameOf(task.getDefinition());
    }

    public static List<TaskSearchRequest.SortBy> sortsByOf(List<String> sortings) {
        if (sortings == null) return emptyList();
        return sortings.stream().map(TaskHelper::sortByOf).collect(toList());
    }

    public static String state(Task task) {
        if (task.isNew()) return "New";
        if (task.isPending()) return "Pending";
        if (task.isWaiting()) return "Waiting";
        if (task.isExpired()) return "Expired";
        if (task.isFinished()) return "Finished";
        if (task.isAborted()) return "Aborted";
        if (task.isFailure()) return "Failure";
        return null;
    }

    public static String stateColor(Task task) {
        if (task.isNew()) return "#4CAF50"; // green
        if (task.isPending()) return "#4CAF50"; // green
        if (task.isWaiting()) return "#2896F3"; // blue
        if (task.isExpired()) return "#F44235"; // red
        if (task.isFinished()) return "#272C34"; // black
        if (task.isAborted()) return "#F44235"; // red
        if (task.isFailure()) return "#F44235"; // red
        return null;
    }

    public static long yearsToMillis(int count) {
        return (long) count * 12 * monthsToMillis(1);
    }

    public static long monthsToMillis(int count) {
        return (long) count * 30 * daysToMillis(1);
    }

    public static long weeksToMillis(int count) {
        return (long) count * 7 * daysToMillis(1);
    }

    public static long daysToMillis(int count) {
        return (long) count * 24 * hoursToMillis(1);
    }

    public static long hoursToMillis(int count) {
        return (long) count * 60 * minutesToMillis(1);
    }

    public static long minutesToMillis(int count) {
        return (long) count * 60 * secondsToMillis(1);
    }

    public static long secondsToMillis(int count) {
        return (long) count * 1000;
    }

    private static DataRequest.SortBy sortByOf(String sorting) {
        String[] split = sorting.split("#");
        return new TaskSearchRequest.SortBy() {
            @Override
            public String attribute() {
                return split[0];
            }

            @Override
            public String mode() {
                return split.length > 1 ? split[1] : "ASC";
            }
        };
    }

}
