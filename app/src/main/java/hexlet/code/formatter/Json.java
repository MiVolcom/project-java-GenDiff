package hexlet.code.formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import static hexlet.code.BuilderDiff.Status;

public class Json {
    public static String formatJson(List<Status> list) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
    }
}
