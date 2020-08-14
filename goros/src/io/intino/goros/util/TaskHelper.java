package io.intino.goros.util;

import org.monet.space.kernel.model.Task;

public class TaskHelper {
    
    public static boolean isAlive(Task task) {
        return !task.isExpired() && !task.isAborted() && !task.isFinished();
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

}
