import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * Created by Bad on 26.02.2017.
 */
public class ImageButton extends ImageView {

    private String name;
    PopupMenu popupMenu = new PopupMenu();

    public ImageButton(String image, Insets insets, String name) {
        this.name = name;

        setImage(new Image(image));
        setPreserveRatio(false);
        setSmooth(false);
        setFitWidth(40);
        setFitHeight(40);

        VBox.setMargin(this, insets);

        setOnMouseEntered(event -> {
            popupMenu.show(this, event.getScreenX(), event.getScreenY() + 20);
        });
        setOnMouseExited(event -> {
            popupMenu.hide();
        });
    }

    public String getName() {
        return name;
    }
}
