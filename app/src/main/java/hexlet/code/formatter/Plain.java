package hexlet.code.formatter;
import java.util.List;
import java.util.Map;
import static hexlet.code.BuilderDiff.Status;
import static hexlet.code.BuilderDiff.Status.DELETED;
import static hexlet.code.BuilderDiff.Status.ADDED;
import static hexlet.code.BuilderDiff.Status.CHANGED;
import static hexlet.code.BuilderDiff.Status.UNCHANGED;

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

                default -> throw new RuntimeException("no status");
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
