package hexlet.code;

import hexlet.code.formatter.Format;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        String cont1 = getDataFromFilePath(filepath1);
        String cont2 = getDataFromFilePath(filepath2);

        String typeFile1 = getType(filepath1);
        String typeFile2 = getType(filepath2);

        Map<String, Object> map1 = Parser.getData(cont1, typeFile1);
        Map<String, Object> map2 = Parser.getData(cont2, typeFile2);

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
    public static String getType(String filePath) {
        int index = filePath.lastIndexOf('.');
        return index > 0 ? filePath.substring(index + 1) : "";
    }
}
