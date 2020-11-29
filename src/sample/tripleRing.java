package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.util.Duration;

public class tripleRing {

    public Group ring;
    private ring ring1;
    private ring ring2;
    private ring ring3;
    private int height;
    private TranslateTransition translate;

    public tripleRing(int height, int radius, int width){
        translate = new TranslateTransition();
        ring1 = new ring(height, radius, width, 1);
        ring2 = new ring(height, radius - 20, width - 2, 0);
        ring3 = new ring(height, radius - 50, width - 1, 0);

        ring = new Group();
        ring.getChildren().addAll(ring1.ring, ring2.ring, ring3.ring);

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
