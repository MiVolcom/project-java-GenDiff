package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Format {
    public static String formatComparisonResult(List<Map<String, Object>> diffList, String format)
            throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(diffList);
        return result;

    }
}
