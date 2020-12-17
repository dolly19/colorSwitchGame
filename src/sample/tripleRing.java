package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.util.Duration;

public class tripleRing extends gameElement {

    private Group ring;
    private ring ring1;
    private ring ring2;
    private ring ring3;
    private int height;
    private TranslateTransition translate;

    public tripleRing(int height, int radius, int width){
        translate = new TranslateTransition();
        ring1 = new ring(height, radius, width, 0);
        ring2 = new ring(height, radius + 20, width, 0);
        ring3 = new ring(height, radius + 40, width, 0);

        ring = new Group();
        ring.getChildren().addAll(ring1.ring, ring2.ring, ring3.ring);

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
        ring1.startAnimation();
        ring2.startAnimation();
        ring3.startAnimation();
    }
    @Override
    public void pauseAnimation(){
        ring1.pauseAnimation();
        ring2.pauseAnimation();
        ring3.pauseAnimation();
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
