import javafx.scene.control.Button;

import java.io.IOException;

/**
 * Created by Bad on 18.02.2017.
 */
public class RunButton extends Button {

    private String runnable;
    private String name;

    private int Height;
    private int Weight;

    private int X;
    private int Y;

    public RunButton(String runnablePath, String name, int height, int weight, int x, int y) {
        this.runnable = runnablePath;
        this.Height = height;
        this.Weight = weight;
        this.X = x;
        this.Y = y;
        this.name = name;


        System.out.println(runnablePath);


        setPrefSize(weight, height);
        setLayoutX(x);
        setLayoutY(y);
        setText(name);

        if (getX() >= 500) {
            setLayoutX(14);
            setLayoutY(y + 120);

        }

        setOnMouseClicked(Event -> {
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec(runnablePath);
            } catch (IOException e) {
                e.printStackTrace();
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
