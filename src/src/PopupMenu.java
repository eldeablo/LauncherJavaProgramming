import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;

/**
 * Created by Bad on 26.02.2017.
 */
public class PopupMenu extends ContextMenu {

    public PopupMenu() {

    }

    public void add(MenuItem item) {
        getItems().add(item);
    }

    public void removeAll() {
        for (int i = 0; i < getItems().size(); i++) {
            getItems().remove(i);
        }
    }

    public void showEntered(Node node, MouseEvent event, String name) {
        add(new MenuItem(name));
        super.show(node, event.getScreenX(), event.getScreenY() + 20);
    }
}
