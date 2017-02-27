import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


/**
 * Created by Bad on 26.02.2017
 */
public class ImageButton extends ImageView {
    private String name;
    private GraphicsSettings graphicsSettings;

    public ImageButton(GraphicsSettings graphicsSettings,String image, Insets insets, String name) {
        this.name = name;
        this.graphicsSettings = graphicsSettings;

        setImage(new Image(image));
        setPreserveRatio(false);
        setSmooth(false);
        setFitWidth(40);
        setFitHeight(40);

        VBox.setMargin(this, insets);

        setOnMouseEntered(event -> {

        });

        setOnMouseExited(event -> {

        });

        setOnMouseClicked(event -> {
            switch (name) {
                case "Exit":
                    System.exit(1);
                    break;
                case "Setting":
                    graphicsSettings.show();
                    break;
                case "Help":
                    break;
            }
        });

    }

    public String getName() {
        return name;
    }
}
