import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by Bad on 16.02.2017.
 */
public class Main extends Application {

    FileUtils fileUtils = new FileUtils();

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Launcher");
        fileUtils.listDirectory("C:\\Games");
        primaryStage.show();
    }

    public static void main(String... arg) {
        launch(arg);
    }
}
