package hexlet.code.formatter;

import hexlet.code.Status;

import java.util.List;

import static hexlet.code.Status.ADDED;
import static hexlet.code.Status.DELETED;
import static hexlet.code.Status.UNCHANGED;
import static hexlet.code.Status.CHANGED;

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
                default -> throw new RuntimeException("Unknown status: " + current.getStatus());
            }

        }
        result.append("}");
        return result.toString();
    }

}
