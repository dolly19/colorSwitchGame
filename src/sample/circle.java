package sample;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.util.Duration;

public class circle {
    private Arc arc1;
    private Arc arc2;
    private Arc arc3;
    private Arc arc4;
    public Group circle = new Group();
    RotateTransition rotate = new RotateTransition();

    public circle(int xCoordinate, int yCoordinate, int radius, int width, int direction){
        arc1 = new Arc(xCoordinate, yCoordinate, radius, radius, 0, 90);
        arc2 = new Arc(xCoordinate, yCoordinate, radius, radius, 90, 90);
        arc3 = new Arc(xCoordinate, yCoordinate, radius, radius, 180, 90);
        arc4 = new Arc(xCoordinate, yCoordinate, radius, radius, 270, 90);

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

        circle.getChildren().addAll(arc1, arc2, arc3, arc4);


        rotate.setNode(circle);
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

    public boolean isRotating(){
        if(rotate.statusProperty().getValue() == Animation.Status.RUNNING){
            return true;
        }else {
            return false;
        }
    }
    public void pauseRotation(){
        rotate.pause();
    }
    public void startRotation(){
        rotate.play();
    }





}