package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.util.Duration;

public class doubleRing extends gameElement {

    private Group ring;
    private ring innerRing;
    private ring outerRing;
    private int height;

    public doubleRing(int height, int radius, int width){
        this.height = height;
        ring = new Group();

        innerRing = new ring(height, radius, width, 0);
        outerRing = new ring(height, radius + 20, width, 0);

        ring.getChildren().addAll(innerRing.ring, outerRing.ring);



    }
    @Override
    public void setLayoutY(double y){
        ring.setLayoutY(y);
    }
    @Override
    public double getLayoutY() {
        return ring.getLayoutY();
    }

    @Override
    void levelUp() {

    }

    @Override
    public void startAnimation(){
        innerRing.startAnimation();
        outerRing.startAnimation();
    }
    @Override
    public void pauseAnimation(){
        innerRing.pauseAnimation();
        outerRing.pauseAnimation();
    }

    @Override
    public Group getNode(){
        return ring;
    }
    @Override
    public void move(double y){
        ring.setLayoutY(ring.getLayoutY() + y);
    }

}
