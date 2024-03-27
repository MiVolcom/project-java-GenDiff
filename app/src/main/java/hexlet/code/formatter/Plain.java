package hexlet.code.formatter;
import hexlet.code.Status;

import java.util.List;
import java.util.Map;
import static hexlet.code.Status.DELETED;
import static hexlet.code.Status.ADDED;
import static hexlet.code.Status.CHANGED;
import static hexlet.code.Status.UNCHANGED;

public class Plain {
    public static String formatPlain(List<Status> list) {
        StringBuilder result = new StringBuilder();
        for (var current : list) {
            switch (current.getStatus()) {
                case DELETED -> result.append("Property ").append("'")
                        .append(current.getKey()).append("'").append(" was removed").append("\n");
                case ADDED -> result.append("Property ").append(complexValue(current.getKey()))
                        .append(" was added with value: ")
                        .append(complexValue(current.getNewValue()))
                        .append("\n");
                case CHANGED ->
                        result.append("Property ").append(complexValue(current.getKey()))
                                .append(" was updated. From ")
                                .append(complexValue(current.getOldValue())).append(" to ")
                                .append(complexValue(current.getNewValue()))
                                .append("\n");
                case UNCHANGED -> {
                }

                default -> throw new RuntimeException("Unknown status: " + current.getStatus());
            }

        }
        return result.toString().trim();
    }
    public static String complexValue(Object currentData) {
        if (currentData instanceof Object[] || currentData instanceof List<?> || currentData instanceof Map<?, ?>) {
            return "[complex value]";
        } else if (currentData == null) {
            return String.format("null");
        } else if (currentData instanceof String) {
            return "'" + currentData + "'";
        }
        return currentData.toString();
    }
}
