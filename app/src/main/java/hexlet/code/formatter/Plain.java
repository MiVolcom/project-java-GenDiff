package hexlet.code.formatter;

import java.util.*;

public class Plain {
    public static String formatPlain(List<Map<String, Object>> mapList) {
        StringBuilder result = new StringBuilder();
        for (Map<String, Object> map : mapList) {
            switch (map.get("status").toString()) {
                case "removed" -> result.append("Property ").append("'")
                        .append(map.get("key")).append("'").append(" was removed").append("\n");
                case "added" -> result.append("Property ").append(complexValue(map.get("key")))
                        .append(" was added with value: ")
                        .append(complexValue(map.get("newValue")))
                        .append("\n");
                case "updated" ->
                        result.append("Property ").append(complexValue(map.get("key")))
                                .append(" was updated. From ")
                                .append(complexValue(map.get("oldValue"))).append(" to ")
                                .append(complexValue(map.get("newValue")))
                                .append("\n");

                default -> result.append("");
            }

        }
        return result.toString().trim();
    }
    public static String complexValue(Object currentData) {
        if (currentData instanceof Object[] || currentData instanceof List<?> || currentData instanceof Map<?,?>) {
            return "[complex value]";
        } else if (currentData == null) {
            return null;
        } else if (currentData instanceof String) {
            return "'" + currentData + "'";
        }
        return currentData.toString();
    }





}
