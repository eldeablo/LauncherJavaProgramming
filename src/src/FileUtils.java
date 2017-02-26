import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Bad on 16.02.2017.
 */
public class FileUtils {

    private List<File> runFile = new ArrayList<>();
    private List<File> uninstallFile = new ArrayList<>();

    private String[] filterFile = {"Launcher", "launcher", "CrashReporter", "language"};
    private String[] filterDirectory = {"CommonRedist", "Redist", "Diag", "Soft", "steam", "Engine", "Paragon"};

    public void listFile(String path) {
        try (Stream<Path> stream = Files.walk(Paths.get(path))) {
            stream.forEach(listFile -> {
                if (listFile.toFile().getName().endsWith(".exe")) {
                    if ((filterFile(listFile.toFile().getName(), listFile.toFile().getPath())) && addUninstallFile(
                            listFile.toFile())) {
                        addFile(listFile.toFile());
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean filterFile(String name, String directory) {
        if (blackFilterFile(name) && blackFilterDirectory(directory)) {
            return true;
        }
        return false;
    }

    private boolean addUninstallFile(File file) {
        if (file.getName().contains("uninstall") || file.getName().contains("unins000")) {
            if (file.isFile()) {
                uninstallFile.add(file);
            }
            return false;
        }
        return true;
    }

    private boolean blackFilterFile(String name) {
        for (String blackFilterFile : filterFile) {
            if (name.contains(blackFilterFile)) {
                return false;
            }
        }
        return true;
    }

    private boolean blackFilterDirectory(String directory) {
        for (String blackFilterDirectory : filterDirectory) {
            if (directory.contains(blackFilterDirectory)) {
                return false;
            }
        }
        return true;
    }

    public void addFile(File file) {
        runFile.add(file);
    }

    public List<File> getRunFile() {
        return runFile;
    }

    public List<File> getUninstallFile() {
        return uninstallFile;
    }
}
