import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;

import java.io.IOException;

/**
 * Created by Bad on 18.02.2017.
 */
public class RunButton extends Button {

    private String runnable;
    private String name;

    private int Height;
    private int Weight;


    public RunButton(String runnablePath, String name, int height, int weight) {
        this.runnable = runnablePath;
        this.Height = height;
        this.Weight = weight;
        this.name = name;

        setPrefSize(weight, height);
        setText(name);
        setAlignment(Pos.CENTER);

        setOnMouseClicked(Event -> {
            if(Event.getButton() == MouseButton.PRIMARY){
                Runtime runtime = Runtime.getRuntime();
                try {
                    runtime.exec(runnablePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public String getRunnable() {
        return runnable;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void setX(int x) {
        X = x;
    }

    public void setY(int y) {
        Y = y;
    }

    public String getName() {
        return name;
    }

    public int getHeights(){
        return Height;
    }

    public int getWeight() {
        return Weight;
    }

}
