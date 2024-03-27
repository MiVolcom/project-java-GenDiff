package hexlet.code.formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.Status;

import java.util.List;

public class Format {
    public static String format(List<Status> list, String format) throws JsonProcessingException {
        switch (format) {
            case "stylish":
                return Stylish.formatStylish(list);
            case "plain":
                return Plain.formatPlain(list);
            case "json":
                return Json.formatJson(list);
            default:
                System.out.println("Format" + format + "incorrect");
        }
        return format;
    }
}
