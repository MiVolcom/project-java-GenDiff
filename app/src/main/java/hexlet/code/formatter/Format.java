package hexlet.code.formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import static hexlet.code.BuilderDiff.Status;

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
