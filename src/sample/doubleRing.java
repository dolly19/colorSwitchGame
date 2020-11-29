package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.util.Duration;

public class doubleRing {

    public Group ring;
    private ring innerRing;
    private ring outerRing;
    private int height;
    private TranslateTransition translate;

    public doubleRing(int height, int radius, int width){
        translate = new TranslateTransition();
        this.height = height;
        ring = new Group();

        innerRing = new ring(height, radius, width, 1);
        outerRing = new ring(height, radius - 30, width - 5, 0);

        ring.getChildren().addAll(innerRing.ring, outerRing.ring);


    }
    public void moveDownBy(int x){
//        System.out.println("I am here");
        translate.setByY(x);
        translate.setDuration(Duration.millis(300));
        translate.setCycleCount(1);
        translate.setNode(ring);
        translate.play();
    }

}
