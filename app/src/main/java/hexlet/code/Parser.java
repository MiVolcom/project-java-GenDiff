package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;

public class Parser {
    public static Map<String, Object> parser(String filePath, String typeFile) throws JsonProcessingException {
        ObjectMapper objectMapper = getCurrentType(typeFile);
        Map<String, Object> parseToMap = objectMapper.readValue(filePath, new TypeReference<>() { });
        return parseToMap;
    }
    public static ObjectMapper getCurrentType(String typeFile) {
        return typeFile.equals("json") ? new ObjectMapper() : new ObjectMapper(new YAMLFactory());
    }
}
