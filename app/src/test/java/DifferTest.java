import hexlet.code.Differ;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class DifferTest {
    private final String path1 = "src/test/resources/json1.json";
    private final String path2 = "src/test/resources/json2.json";
    private final String path3 = "src/test/resources/filepath1.yml";
    private final String path4 = "src/test/resources/filepath2.yml";
    private final Path pathYaml =
            Paths.get("src/test/resources/expected/Yaml");
    private final Path pathStylish =
            Paths.get("src/test/resources/expected/Stylish");


    @Test
    public void test1() throws Exception {
        var expected = Files.readString(pathStylish);
        var actual = Differ.generate(path1, path2);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() throws Exception {
        var expected = Files.readString(pathYaml);
        var actual = Differ.generate(path3, path4);
        assertEquals(expected, actual);

    }
}
