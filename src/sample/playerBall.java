package sample;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.Random;

public class playerBall {

    private static playerBall single_instance = null;

    private Circle circle;
    private String colors[];
    private String currColor;
    float ballGravity;
    float v;
    private playerBall(){
        this.ballGravity = 0.2f;
        this.v = 4.45f;
        colors = new String[]{"#FAE100", "#900DFF", "#FF0181", "#32DBF0"};
        currColor = "WHITE";

        circle = new Circle();
        circle.setCenterX(250);
        circle.setCenterY(650);
        circle.setRadius(10);
        circle.setFill(Paint.valueOf(currColor));

    }

    public static playerBall getInstance()
    {
        if (single_instance == null)
            single_instance = new playerBall();
        return single_instance;
    }

    public void changeColour(){
        Random rand = new Random();
        String tempColor = colors[rand.nextInt(4)];

        while (tempColor.equals(currColor)){
            tempColor = colors[rand.nextInt(4)];
        }
        currColor = tempColor;
        circle.setFill(Paint.valueOf(tempColor));

    }
    public double getLayoutY(){
        return circle.getCenterY();
    }
    public Circle getBall(){
        return circle;
    }
    public void move(double y){
        circle.setCenterY(circle.getCenterY() - y);
    }
    public  String getColor(){
        return currColor;
    }

    public float getBallGravity() {
        return ballGravity;
    }

    public void makeItWhite(){
        this.circle.setFill(Paint.valueOf("#FFFFFF"));
        this.currColor = "#FFFFFF";
    }

    public float getV() {
        return v;
    }
    public void setV(float v) {
        this.v = v;
    }

    public void setCentreY(double y){
        circle.setCenterY(y);
    }

}
