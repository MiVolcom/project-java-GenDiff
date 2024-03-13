package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import java.io.File;
import java.util.concurrent.Callable;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;

@Command (
        name = "gendiff", mixinStandardHelpOptions = true, version = "1.0",
        description = "Compares two configuration files and shows a difference.")

public class App implements Callable<Integer> {
    @Parameters(paramLabel = "filepath1", description = "path to first file")
    private File filepath1;
    @Parameters(paramLabel = "filepath2", description = "path to second file")
    private File filepath2;
    @Option(names = {"-h", "--help"}, description = "Show this help message and exit.", required = true)
    private boolean help;
    @Option(names = {"-V", "--version"}, description = "Print version information and exit.", required = true)
    private boolean versionName;
    @Option(names = {"-f", "--format"}, paramLabel = "format", description = "output format [default: stylish]")
    File format;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
    @Override
    public Integer call() throws Exception {
        return null;
    }
}
