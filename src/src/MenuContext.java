import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;

/**
 * Created by Bad on 26.02.2017.
 */
public class MenuContext extends ContextMenu {

    private MenuItem run = new MenuItem("Запустить");
    private MenuItem delete = new MenuItem("Удалить");
    private MenuItem name = new MenuItem();

    private CardRunFile cardRunFile;

    public MenuContext(CardRunFile cardRunFile, boolean isName) {
        this.cardRunFile = cardRunFile;
        if (!isName) {
            addItemAll(run, delete);
        }
        else {
            addItemAll(name);
        }

        run.setOnAction(event ->
                cardRunFile.runnableFile(cardRunFile.getRunnable())
        );

        delete.setOnAction(event ->
                cardRunFile.deleteFile(cardRunFile.getUninstall())
        );
    }


    public void addItemAll(MenuItem... menuItems) {
        getItems().addAll(menuItems);
    }

    public void showMenu(Node anchor, MouseEvent event) {
        show(anchor, event.getScreenX(), event.getScreenY() + 20);
    }

    public void showName(Node anchor, MouseEvent event, String name) {
        this.name.setText(name);
        show(anchor, event.getScreenX(), event.getScreenY() + 20);
    }

}
