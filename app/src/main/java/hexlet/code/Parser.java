package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;

public class Parser {
    public static Map<String, Object> getData(String path, String type) throws JsonProcessingException {
        ObjectMapper objectMapper = getCurrentType(type);
        Map<String, Object> parseToMap = objectMapper.readValue(path, new TypeReference<>() { });
        return parseToMap;
    }
    public static ObjectMapper getCurrentType(String type) {
        return type.equals("json") ? new ObjectMapper() : new ObjectMapper(new YAMLFactory());
    }
}
