import hexlet.code.Differ;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public final class DifferTest {
    //private final String path1 = "src/test/resources/filepath1.json";
    //private final String path2 = "src/test/resources/filepath2.json";
    //private final String path3 = "src/test/resources/filepath1.yml";
    //private final String path4 = "src/test/resources/filepath2.yml";
    private static String resultJson;
    private static String resultPlain;
    private static String resultStylish;

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }

    @BeforeAll
    public static void beforeAll() throws Exception {
        resultJson = readFixture("Json");
        resultPlain = readFixture("Plain");
        resultStylish = readFixture("Stylish");
    }


    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void generateTest(String format) throws Exception {
        String path1 = getFixturePath("filepath1." + format).toString();
        String path2 = getFixturePath("filepath2." + format).toString();

        assertThat(Differ.generate(path1, path2, "stylish")).isEqualTo(resultStylish);
        assertThat(Differ.generate(path1, path2, "plain")).isEqualTo(resultPlain);
        assertThat(Differ.generate(path1, path2, "json")).isEqualTo(resultJson);
        assertThat(Differ.generate(path1, path2)).isEqualTo(resultStylish);



    /*

    @Test
    public void test1() throws Exception {
        var expected = resultStylish;
        var actual = Differ.generate(path1, path2, "stylish");
        assertEquals(expected, actual);
    }
    @Test
    public void test2() throws Exception {
        var expected = resultStylish;
        var actual = Differ.generate(path3, path4, "stylish");
        assertEquals(expected, actual);
    }
    @Test
    public void test3() throws Exception {
        var expected = resultStylish;
        var actual = Differ.generate(path1, path2);
        assertEquals(expected, actual);
    }
    @Test
    public void test4() throws Exception {
        var expected = resultStylish;
        var actual = Differ.generate(path3, path4);
        assertEquals(expected, actual);
    }
    @Test
    public void test5() throws Exception {
        var expected = resultPlain;
        var actual = Differ.generate(path1, path2, "plain");
        assertEquals(expected, actual);
    }
    @Test
    public void test6() throws Exception {
        var expected = resultPlain;
        var actual = Differ.generate(path3, path4, "plain");
        assertEquals(expected, actual);
    }
    @Test
    public void test7() throws Exception {
        var expected = resultJson;
        var actual = Differ.generate(path1, path2, "json");
        assertEquals(expected, actual);
    }
    @Test
    public void test8() throws Exception {
        var expected = resultJson;
        var actual = Differ.generate(path3, path4, "json");
        assertEquals(expected, actual);
    }

     */
    }
}
