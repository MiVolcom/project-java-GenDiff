package hexlet.code.formatter;

import java.util.List;
import java.util.Map;

public class Format {
    public static String format(List<Map<String, Object>> mapList, String format) {
        switch (format) {
            case "stylish":
                return Stylish.formatStylish(mapList);
            case "plain":
                return Plain.formatPlain(mapList);
            default:
                System.out.println("Format" + format + "incorrect");
        }
        return format;

    }
}
