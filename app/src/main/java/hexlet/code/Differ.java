package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) {
        return null;
    }

    public static String getDataFromFilePath(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        String content = Files.readString(path);
        return content;
    }

    public static Map<String, Object> parseToMap(String filePath) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> jsonMap = objectMapper.readValue(filePath, new TypeReference<>(){});
        return jsonMap;
    }


}
