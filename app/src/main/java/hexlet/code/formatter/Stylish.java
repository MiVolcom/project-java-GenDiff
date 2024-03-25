package hexlet.code.formatter;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String formatStylish(List<Map<String, Object>> mapList) {
        StringBuilder result = new StringBuilder("{\n");
        for (Map<String, Object> map : mapList) {
            switch (map.get("status").toString()) {
                case "removed" -> result.append("  - ").append(map.get("key")).append(": ")
                        .append(map.get("oldValue")).append("\n");
                case "added" -> result.append("  + ").append(map.get("key")).append(": ")
                        .append(map.get("newValue")).append("\n");
                case "unchanged" -> result.append("    ").append(map.get("key")).append(": ")
                        .append(map.get("oldValue")).append("\n");
                case "updated" -> {
                    result.append("  - ").append(map.get("key")).append(": ")
                            .append(map.get("oldValue")).append("\n");
                    result.append("  + ").append(map.get("key")).append(": ")
                            .append(map.get("newValue")).append("\n");
                }
                default -> throw new RuntimeException("no status");
            }

        }
        result.append("}");
        return result.toString();
    }

}
