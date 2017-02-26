import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.*;

/**
 * Created by Bad on 18.02.2017.
 */
public class Graphics {

    private AnchorPane root = new AnchorPane();
    private VBox vboxImage = new VBox();

    private ScrollPane scrollPaneGrid = new ScrollPane();
    private GridPane gridPane = new GridPane();

    private int row = 0;
    private int col = 0;

    private FileUtils fileUtils = new FileUtils();

    public Scene createGui(AnchorPane root) {
        this.root = root;

        gridPane.getRowConstraints().add(row, new RowConstraints(120));
        gridPane.getColumnConstraints().add(0, new ColumnConstraints(120));
        gridPane.getColumnConstraints().add(1, new ColumnConstraints(120));
        gridPane.getColumnConstraints().add(2, new ColumnConstraints(120));
        gridPane.getColumnConstraints().add(3, new ColumnConstraints(120));

        gridPane.setPrefSize(600, 400);
        gridPane.setHgap(20);
        gridPane.setVgap(20);

        scrollPaneGrid.setPrefSize(600, 400);
        scrollPaneGrid.setLayoutX(42);
        scrollPaneGrid.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPaneGrid.fitToWidthProperty().setValue(true);
        scrollPaneGrid.setContent(gridPane);
        scrollPaneGrid.setBlendMode(BlendMode.MULTIPLY);
        scrollPaneGrid.setBackground(Background.EMPTY);

        vboxImage.setLayoutX(1);
        vboxImage.setPrefSize(40, 400);
        vboxImage.setPadding(new Insets(199, 0, 0, 0));
        vboxImage.getChildren().add(new ImageButton("resource/help.png", new Insets(0, 0, 0, 0), "Help"));
        vboxImage.getChildren().add(new ImageButton("resource/settings.png", new Insets(0, 0, 0, 0), "Setting"));
        vboxImage.getChildren().add(new ImageButton("resource/exit.png", new Insets(80, 0, 0, 0), "Exit"));

        fileUtils.listFile("C:\\Games");

        for (int i = 0; i < fileUtils.getRunFile().size(); i++) {
            addGripPane(i);
        }

        root.getChildren().add(scrollPaneGrid);
        root.getChildren().add(vboxImage);

        return new Scene(root, 600, 400);
    }

    private void addGripPane(int i) {
        if (col >= 4) {
            gridPane.getRowConstraints().add(row, new RowConstraints(120));
            row += 1;
            col = 0;
        }

        gridPane.add(new CardRunFile(gridPane, fileUtils.getRunFile().get(i).getPath(),
                fileUtils.getUninstallFile().get(i).getPath(), fileUtils.getRunFile().get(i).getName(), 70, 70, row,
                col), col, row);

        col += 1;

    }
}
