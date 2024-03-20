import hexlet.code.Differ;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class DifferTest {
    private final String path1 = "src/test/resources/json1.json";
    private final String path2 = "src/test/resources/json2.json";
    private final String path3 = "src/test/resources/filepath1.yml";
    private final String path4 = "src/test/resources/filepath2.yml";
    private final Path pathPlain =
            Paths.get("src/test/resources/expected/Plain");
    private final Path pathStylish =
            Paths.get("src/test/resources/expected/Stylish");
    private final Path pathJson =
            Paths.get("src/test/resources/expected/Json");

    @Test
    public void test1() throws Exception {
        var expected = Files.readString(pathStylish);
        var actual = Differ.generate(path1, path2, "stylish");
        assertEquals(expected, actual);
    }
    @Test
    public void test2() throws Exception {
        var expected = Files.readString(pathStylish);
        var actual = Differ.generate(path3, path4, "stylish");
        assertEquals(expected, actual);
    }
    @Test
    public void test3() throws Exception {
        var expected = Files.readString(pathStylish);
        var actual = Differ.generate(path1, path2);
        assertEquals(expected, actual);
    }
    @Test
    public void test4() throws Exception {
        var expected = Files.readString(pathStylish);
        var actual = Differ.generate(path3, path4);
        assertEquals(expected, actual);
    }
    @Test
    public void test5() throws Exception {
        var expected = Files.readString(pathPlain);
        var actual = Differ.generate(path1, path2, "plain");
        assertEquals(expected, actual);
    }
    @Test
    public void test6() throws Exception {
        var expected = Files.readString(pathPlain);
        var actual = Differ.generate(path3, path4, "plain");
        assertEquals(expected, actual);
    }
    @Test
    public void test7() throws Exception {
        var expected = Files.readString(pathJson);
        var actual = Differ.generate(path1, path2, "json");
        assertEquals(expected, actual);
    }
    @Test
    public void test8() throws Exception {
        var expected = Files.readString(pathJson);
        var actual = Differ.generate(path3, path4, "json");
        assertEquals(expected, actual);
    }
}
