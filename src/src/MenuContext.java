import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;

/**
 * Created by Bad on 26.02.2017.
 */
public class MenuContext extends ContextMenu{

    private MenuItem run = new MenuItem("Запустить");
    private MenuItem delete = new MenuItem("Удалить");

    private CardRunFile cardRunFile;

    public MenuContext(CardRunFile cardRunFile){
        this.cardRunFile = cardRunFile;

        addItemAll(run,delete);

        run.setOnAction(event ->
            cardRunFile.runnableFile(cardRunFile.getRunnable())
        );

        delete.setOnAction(event ->
            cardRunFile.deleteFile(cardRunFile.getUninstall())
        );

    }



    public void addItemAll(MenuItem... menuItems){
        getItems().addAll(menuItems);
    }

    public void showMenu(Node anchor, MouseEvent event){
        show(anchor,event.getScreenX(),event.getScreenY() + 20);
    }

}
