package hexlet.code.formatter;

import java.util.List;

import static hexlet.code.BuilderDiff.Status.ADDED;
import static hexlet.code.BuilderDiff.Status.DELETED;
import static hexlet.code.BuilderDiff.Status.UNCHANGED;
import static hexlet.code.BuilderDiff.Status.CHANGED;
import static hexlet.code.BuilderDiff.Status;

public class Stylish {
    public static String formatStylish(List<Status> list) {
        StringBuilder result = new StringBuilder("{\n");
        for (var current : list) {
            switch (current.getStatus()) {
                case DELETED -> result.append("  - ").append(current.getKey()).append(": ")
                        .append(current.getOldValue()).append("\n");
                case ADDED -> result.append("  + ").append(current.getKey()).append(": ")
                        .append(current.getNewValue()).append("\n");
                case UNCHANGED -> result.append("    ").append(current.getKey()).append(": ")
                        .append(current.getOldValue()).append("\n");
                case CHANGED -> {
                    result.append("  - ").append(current.getKey()).append(": ")
                            .append(current.getOldValue()).append("\n");
                    result.append("  + ").append(current.getKey()).append(": ")
                            .append(current.getNewValue()).append("\n");
                }
                default -> throw new RuntimeException("no status");
            }

        }
        result.append("}");
        return result.toString();
    }

}
