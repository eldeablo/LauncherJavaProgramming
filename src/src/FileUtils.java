import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bad on 16.02.2017.
 */
public class FileUtils {

    public List<File> directoryFile = new ArrayList<>();
    public List<File> runFile = new ArrayList<>();

    public void listDirectory(String path) {
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
    }
}
