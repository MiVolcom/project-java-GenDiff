package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import java.util.concurrent.Callable;

@Command (
        name = "gendiff",
        description = "Compares two configuration files and shows a difference.")

public class App implements Callable<Integer> {
    @CommandLine.Option(names = {"-h", "--help"}, description = "Show this help message and exit.", required = true)
    private boolean help;
    @CommandLine.Option(names = {"-V", "--version"}, description = "Print version information and exit.", required = true)
    private boolean versionName;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.out.println(exitCode);
    }

    @Override
    public Integer call () throws Exception {
        return null;
    }
}
