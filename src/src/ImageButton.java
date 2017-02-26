import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


/**
 * Created by Bad on 26.02.2017
 */
public class ImageButton extends ImageView {
    private String name;
    private boolean isShow = false;

    public ImageButton(String image, Insets insets, String name) {
        this.name = name;

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
                    if(!isShow){
                        isShow = true;
                    }
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
