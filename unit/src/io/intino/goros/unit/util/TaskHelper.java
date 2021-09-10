package io.intino.goros.unit.util;

import org.monet.space.kernel.model.DataRequest;
import org.monet.space.kernel.model.MonetLink;
import org.monet.space.kernel.model.Task;
import org.monet.space.kernel.model.TaskSearchRequest;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

public class TaskHelper {

    public static Task taskOf(MonetLink link) {
        if (link == null) return null;
        return LayerHelper.taskLayer().loadTask(link.getId());
    }

    public static boolean isAlive(Task task) {
        return !task.isExpired() && !task.isAborted() && !task.isFinished();
    }

    public static String nameOf(Task task) {
        return PathHelper.nameOf(task.getDefinition());
    }

    public static List<TaskSearchRequest.SortBy> sortsByOf(List<String> sortings) {
        if (sortings == null) return emptyList();
        return sortings.stream().map(TaskHelper::sortByOf).collect(Collectors.toList());
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
        if (task.isFailure()) return "#F89804"; // orange
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
