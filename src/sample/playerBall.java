package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class playerBall {

    Circle circle;
    public playerBall(){
        circle = new Circle();
        circle.setCenterX(250);
        circle.setCenterY(650);
        circle.setRadius(10);
        circle.setFill(Color.WHITE);

    }

    public void moveUpBy(int x){
        TranslateTransition translate = new TranslateTransition();
        translate.setDuration(Duration.millis(100));
        translate.setCycleCount(2);
        translate.setAutoReverse(true);
        translate.setByY(-x);
        translate.setNode(circle);
        translate.play();

    }
    public void hide(){
        circle.setRadius(0);
    }

}
