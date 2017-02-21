import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

/**
 * Created by Bad on 18.02.2017.
 */
public class Graphics {

    private FileUtils fileUtils = new FileUtils();

    public Scene createGui(AnchorPane root) {

        fileUtils.listFile("C:\\Games");

        return new Scene(root, 600, 400);
    }
}
