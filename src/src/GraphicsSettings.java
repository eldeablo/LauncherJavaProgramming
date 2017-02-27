import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Bad on 26.02.2017.
 */

public class GraphicsSettings implements Runnable {

    private FileUtils fileUtils;
    private GraphicsLauncher launcher;

    private AnchorPane root = new AnchorPane();
    private Scene scene = new Scene(root, 320, 320);
    private Stage stage = new Stage();

    private Button ok = new Button("Ok");
    private Button apply = new Button("Apply");
    private Button cancel = new Button("Cancel");

    private ScrollPane pane = new ScrollPane();
    private VBox paneVBox = new VBox();

    private TitledPane editorPane = new TitledPane();
    private VBox editorVBox = new VBox();

    private Hyperlink fileAdd = new Hyperlink("File add");
    private Hyperlink languages = new Hyperlink("Languages");

    private AnchorPane filePane = new AnchorPane();
    private TextField path = new TextField();
    private String tempPath = "Path";
    private Label label = new Label("File path:");

    private boolean isShow = false;

    private Thread thread;

    public GraphicsSettings(FileUtils fileUtils, GraphicsLauncher launcher) {
        this.fileUtils = fileUtils;
        this.launcher = launcher;


        stage.setTitle("Settings");
        stage.setScene(createSettings());

        stage.setMaxHeight(350);
        stage.setMaxWidth(350);

        stage.setMinHeight(350);
        stage.setMinWidth(350);

        stage.setOnCloseRequest(event ->
                hide()
        );

    }

    public Scene createSettings() {

        ok.setPrefSize(45, 25);
        ok.setLayoutX(150);
        ok.setLayoutY(281);

        apply.setPrefSize(47, 25);
        apply.setLayoutX(201);
        apply.setLayoutY(281);

        cancel.setPrefSize(52, 25);
        cancel.setLayoutX(254);
        cancel.setLayoutY(281);

        pane.setPrefSize(128, 320);
        pane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        pane.fitToWidthProperty().setValue(true);
        pane.setBackground(Background.EMPTY);
        pane.setContent(paneVBox);
        paneVBox.getChildren().add(editorPane);

        editorPane.setText("Editor");
        editorPane.setPrefSize(128, 320);
        editorPane.setContent(editorVBox);

        fileAdd.setBorder(Border.EMPTY);

        languages.setBorder(Border.EMPTY);

        editorVBox.getChildren().addAll(fileAdd, languages);

        label.setLayoutX(2);
        label.setLayoutY(30);

        path.setLayoutX(52);
        path.setLayoutY(25);
        path.setVisible(true);
        path.setText(fileUtils.LoadIniFile("SaveFile"));

        filePane.setPrefSize(190, 275);
        filePane.setLayoutX(130);
        filePane.setLayoutY(2);
        filePane.getChildren().add(path);
        filePane.getChildren().add(label);

        System.out.println(path.getWidth());

        root.getChildren().addAll(ok, apply, cancel, pane, filePane);

        OnClick();

        return scene;
    }

    public void show() {
        if (!isShow) {
            isShow = true;
            stage.show();
            start();
        }
    }

    public void hide() {
        if (isShow) {
            isShow = false;
            stop();
            stage.hide();

        }
    }

    public String getPathString() {
        return path.getText();
    }

    private void OnClick() {
        fileAdd.setOnMouseClicked(event -> {

        });

        languages.setOnAction(event -> {

        });

        ok.setOnMouseClicked(event -> {

        });

        apply.setOnMouseClicked(event -> {
            if (filePane.isVisible()) {
                tempPath = path.getText();
                fileUtils.SaveIniFile("SaveFile",path.getText(),null);
                fileUtils.listFile(path.getText());
                launcher.update();
            }
        });

        cancel.setOnMouseClicked(event -> {
            hide();
        });
    }

    private void start() {
        thread = new Thread(this);
        thread.start();
    }

    private void stop() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        while (isShow) {
            if (tempPath.equals(path.getText())) {
                apply.setDisable(true);
            }
            else {
                apply.setDisable(false);
            }
        }
    }
}
