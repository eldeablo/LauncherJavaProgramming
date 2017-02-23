import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 * Created by Bad on 18.02.2017.
 */
public class Graphics {

    private FileUtils fileUtils = new FileUtils();

    private ScrollPane scrollPaneGrid = new ScrollPane();
    private GridPane gridPane = new GridPane();

    private int row = 0;
    private int col = 0;

    public Scene createGui(AnchorPane root) {
        init();

        fileUtils.listFile("C:\\Games");

        for (int i = 0; i < fileUtils.getRunFile().size(); i++) {
            addGripPane(i);
        }

        root.getChildren().add(scrollPaneGrid);

        return new Scene(root, 600, 400);
    }

    private void addGripPane(int i) {
        if (col >= 4) {
            gridPane.getRowConstraints().add(row, new RowConstraints(120));
            row += 1;
            col = 0;
        }

        gridPane.add(new CardRunFile(gridPane, fileUtils.getRunFile().get(i).getPath(),
                fileUtils.getUninstallFile().get(i).getPath(), fileUtils.getRunFile().get(i).getName(), 70, 70,row,col),col,row);

        col += 1;

    }

    public void init() {
        gridPane.getRowConstraints().add(row, new RowConstraints(120));
        gridPane.getColumnConstraints().add(0, new ColumnConstraints(120));
        gridPane.getColumnConstraints().add(1, new ColumnConstraints(120));
        gridPane.getColumnConstraints().add(2, new ColumnConstraints(120));
        gridPane.getColumnConstraints().add(3, new ColumnConstraints(120));

        gridPane.setPrefSize(600, 400);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        //gridPane.setGridLinesVisible(true);

        scrollPaneGrid.setPrefSize(600, 400);
        scrollPaneGrid.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPaneGrid.fitToWidthProperty().setValue(true);
        scrollPaneGrid.setContent(gridPane);

    }
}
