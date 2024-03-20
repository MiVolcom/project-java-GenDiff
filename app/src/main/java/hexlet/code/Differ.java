package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.formatter.Format;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        var cont1 = getDataFromFilePath(filepath1);
        var cont2 = getDataFromFilePath(filepath2);

        var map1 = Parser.parser(cont1);
        var map2 = Parser.parser(cont2);

        List<Map<String, Object>> mapList = BuilderDiff.getDiff(map1, map2);
        return Format.format(mapList, format);
    }

    public static String generate(String filePath1, String filepath2) throws Exception {
        return generate(filePath1, filepath2, "stylish");
    }

    public static String getDataFromFilePath(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        String content = Files.readString(path);
        return content;
    }
}
