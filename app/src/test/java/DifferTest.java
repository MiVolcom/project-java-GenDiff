import hexlet.code.Differ;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class DifferTest {
    private final String path1 = "src/test/resources/json1.json";
    private final String path2 = "src/test/resources/json2.json";
   // private final Path pathStylish =
    //        Paths.get("src/test/resources/expected/Stylish").toAbsolutePath().normalize();

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

}
