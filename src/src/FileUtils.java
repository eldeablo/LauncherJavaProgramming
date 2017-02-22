import java.io.File;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
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

    public void listFile(String path) throws AccessDeniedException {
        try (Stream<Path> stream = Files.walk(Paths.get(path))) {
            stream.forEach(listFile -> {
                if (listFile.toFile().getName().endsWith(".exe")) {
                    if (filterFile(listFile.toFile().getName(), listFile.toFile().getPath()) && addUninstallFile(
                            listFile.toFile())) {

                        runFile.add(listFile.toFile());
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

    public List<File> getRunFile() {
        return runFile;
    }

    public List<File> getUninstallFile() {
        return uninstallFile;
    }

    //Старый код работы с файломы
    /*public void listDirectory(String path) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(path))) {
            for (Path entry : stream) {
                System.out.println(entry.toFile());
                directoryFile.add(entry.toFile());
            }
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        listFiles();
    }

    public void listFiles() {
        for (int i = 0; i < directoryFile.size(); i++) {
            Path path = directoryFile.get(i).toPath();
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(path, "*{.exe}")) {
                for (Path entry : stream) {
                    if ((entry.toFile().getName().contains("launcher")) || (entry.toFile().getName().contains(
                            "unins000")) || (entry.toFile().getName().contains(
                            "smart")) || (entry.toFile().getName().contains(
                            "Launcher")) || (entry.toFile().getName().contains(
                            "language")) || (entry.toFile().getName().contains(
                            "uninstall")) || (entry.toFile().getName().contains("CrashReporter"))) {
                        //System.out.println(entry.toFile());
                    }
                    else {
                        runFile.add(entry.toFile());
                        System.out.println(entry.toFile());
                    }
                }

                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    public List<File> getDirectoryFile() {
        return directoryFile;
    }

    public List<File> getRunFile() {
        return runFile;
    }*/
}
