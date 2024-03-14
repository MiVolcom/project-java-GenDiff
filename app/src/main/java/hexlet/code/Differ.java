package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String js1, String js2, String format) throws IOException {
        String fp1 = read(js1);
        String fp2 = read(js2);

        String format1 = getFormat(js1);
        String format2 = getFormat(js2);

        Map<String, Object> json1 = jsonToMap(fp1, format1);
        Map<String, Object> json2 = jsonToMap(fp2, format2);

        List<Map<String, Object>> result = Compare.compareMap(json1, json2);
        return Format.formatComparisonResult(result, format);
    }

    public static Map<String, Object> jsonToMap (String filepath, String format) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(filepath, new TypeReference<>() { });
    }
    public static String read(String pathFile) throws IOException {
        Path path = Paths.get(pathFile).toAbsolutePath().normalize();
        return Files.readString(path);
    }
    public static String getFormat(String pathFile) {
        String[] parts = pathFile.split("\\.");
        if (parts.length > 1) {
            String extension = parts[parts.length - 1].toLowerCase();
            return extension;
        } else {
            throw new RuntimeException("Incorrect format");
        }
    }


}
