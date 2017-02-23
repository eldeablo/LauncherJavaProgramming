import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;

import java.io.IOException;

/**
 * Created by Bad on 23.02.2017.
 */
public class CardRunFile extends Button {

    private String runnable;
    private String uninstall;
    private String name;

    private int Height;
    private int Weight;

    private Label label = new Label();
    private ImageView imageView = new ImageView();

    public CardRunFile(GridPane pane, String run, String delete, String name, int height, int weight, int row, int col) {
        this.runnable = run;
        this.uninstall = delete;
        this.Height = height;
        this.Weight = weight;
        this.name = name;

        setPrefSize(Weight, Height);

        label.setPadding(new Insets(0, 0, 5, 0));
        label.setText(name);

        GridPane.setHalignment(this, HPos.CENTER);
        GridPane.setValignment(this, VPos.CENTER);

        pane.add(label,col,row);

        GridPane.setHalignment(label, HPos.CENTER);
        GridPane.setValignment(label, VPos.BOTTOM);

        setOnMouseClicked(Event -> {
            if (Event.getButton() == MouseButton.PRIMARY) {
                try {
                    Runtime runtime = Runtime.getRuntime();
                    runtime.exec("cmd /c \"" + runnable + "\"");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        getChildren().add(imageView);
    }

    public String getRunnable() {
        return runnable;
    }

    public String getUninstall() {
        return uninstall;
    }

    public String getName() {
        return name;
    }
}
