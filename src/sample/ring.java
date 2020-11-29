package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.util.Duration;

public class ring {
    Group ring;
    private RotateTransition rotate;
    private TranslateTransition translate;
    private int height;

    public ring(int height, int radius, int width, int direction){

        this.height = height;
        translate = new TranslateTransition();

        Arc arc1 = new Arc(250, height, radius, radius, 0, 90);
        Arc arc2 = new Arc(250, height, radius, radius, 90, 90);
        Arc arc3 = new Arc(250, height, radius, radius, 180, 90);
        Arc arc4 = new Arc(250, height, radius, radius, 270, 90);

        arc1.setType(ArcType.OPEN);
        arc1.setFill(Color.TRANSPARENT);
        arc1.setStrokeWidth(width);
        arc1.setStroke(Color.web("#FAE100"));

        arc2.setType(ArcType.OPEN);
        arc2.setFill(Color.TRANSPARENT);
        arc2.setStrokeWidth(width);
        arc2.setStroke(Color.web("#900DFF"));

        arc3.setType(ArcType.OPEN);
        arc3.setFill(Color.TRANSPARENT);
        arc3.setStrokeWidth(width);
        arc3.setStroke(Color.web("#FF0181"));

        arc4.setType(ArcType.OPEN);
        arc4.setFill(Color.TRANSPARENT);
        arc4.setStrokeWidth(width);
        arc4.setStroke(Color.web("#32DBF0"));

        ring = new Group();
        ring.getChildren().addAll(arc1, arc2, arc3, arc4);

        rotate = new RotateTransition();
        rotate.setNode(ring);

        rotate.setDuration(Duration.seconds(3));

        if(direction == 0){
            rotate.setByAngle(360);
        }else{
            rotate.setByAngle(-360);
        }
        rotate.setCycleCount(Timeline.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.play();

    }

    public int getHeight() {
        return height;
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


