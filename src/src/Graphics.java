import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

/**
 * Created by Bad on 18.02.2017.
 */
public class Graphics {

    private FileUtils fileUtils = new FileUtils();

    public Scene createGui(AnchorPane root) {

        fileUtils.listDirectory("C:\\Games");

        for (int i = 0; i < fileUtils.getRunFile().size(); i++) {
            root.getChildren().add(new RunButton(fileUtils.getRunFile().get(i).getPath(),fileUtils.getRunFile().get(i).getName(),100,100,14 + 120 * i,14));
        }

        return new Scene(root, 600, 400);
    }
}
