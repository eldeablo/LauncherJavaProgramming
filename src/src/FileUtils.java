import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Bad on 16.02.2017.
 */
public class FileUtils {

    private List<File> catalog = new ArrayList<File>();

    public void getFileCatalog(String fileCatalog) {
        File file = new File(fileCatalog);
        if (file.isDirectory()) {
            for (File dir : file.listFiles()) {
                if (dir.getName().equals("steam")) {

                }
                else {
                    catalog.add(dir);
                }
            }
        }
    }
}
