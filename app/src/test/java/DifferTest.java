import hexlet.code.Differ;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class DifferTest {
    private final String path1 = "src/test/resources/json1.json";
    private final String path2 = "src/test/resources/json2.json";
    private final Path pathYaml =
            Paths.get("src/test/resources/expected/Yaml").toAbsolutePath().normalize();

    private final String expected =
            "{\n"
                    +
                    "  - follow: false\n"
                    +
                    "    host: hexlet.io\n"
                    +
                    "  - proxy: 123.234.53.22\n"
                    +
                    "  - timeout: 50\n"
                    +
                    "  + timeout: 20\n"
                    +
                    "  + verbose: true\n"
                    +
                    "}";

    @Test
    public void test1() throws Exception {
        // var expected = Files.readString(pathStylish);
        var actual = Differ.generate(path1, path2);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() throws Exception {
        var expected = Files.readString(pathYaml);
        var actual = Differ.generate(path1, path2);
        assertEquals(expected, actual);

    }
}
