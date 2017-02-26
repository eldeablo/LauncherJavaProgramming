import javafx.application.Application;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Created by Bad on 16.02.2017.
 */
public class Main extends Application {

    private final AnchorPane root = new AnchorPane();
    private GraphicsLauncher gui = new GraphicsLauncher();

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Launcher");
        primaryStage.setScene(gui.createGui(root));
        primaryStage.show();
    }

    public static void main(String... arg) {
        launch(arg);
    }
}
