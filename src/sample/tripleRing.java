package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.util.Duration;

public class tripleRing extends gameElement {
    private Arc arc1;
    private Arc arc2;
    private Arc arc3;
    private Arc arc4;
    private Arc arc5;
    private Arc arc6;
    private Arc arc7;
    private Arc arc8;
    private Arc arc9;
    private Arc arc10;
    private Arc arc11;
    private Arc arc12;
    Group tripleCircle ;
    private RotateTransition rotate;

    public tripleRing(int height, int radius,int width) {

        this.speed = 3000;

        arc1 = new Arc(250, height, radius, radius, 0, 90);
        arc2 = new Arc(250, height, radius, radius, 90, 90);
        arc3 = new Arc(250, height, radius, radius, 180, 90);
        arc4 = new Arc(250, height, radius, radius, 270, 90);

        arc1.setType(ArcType.OPEN);
        arc1.setFill(Color.TRANSPARENT);
        arc1.setStrokeWidth(width);
        arc1.setStroke(Color.web("#FF0181"));
        arc1.setId("#FF0181");

        arc2.setType(ArcType.OPEN);
        arc2.setFill(Color.TRANSPARENT);
        arc2.setStrokeWidth(width);
        arc2.setStroke(Color.web("#FAE100"));
        arc2.setId("#FAE100");

        arc3.setType(ArcType.OPEN);
        arc3.setFill(Color.TRANSPARENT);
        arc3.setStrokeWidth(width);
        arc3.setStroke(Color.web("#32DBF0"));
        arc3.setId("#32DBF0");


        arc4.setType(ArcType.OPEN);
        arc4.setFill(Color.TRANSPARENT);
        arc4.setStrokeWidth(width);
        arc4.setStroke(Color.web("#900DFF"));
        arc4.setId("#900DFF");

        arc5 = new Arc(250, height, radius+20, radius+20, 0, 90);
        arc6 = new Arc(250, height, radius+20, radius+20, 90, 90);
        arc7 = new Arc(250, height, radius+20, radius+20, 180, 90);
        arc8 = new Arc(250, height, radius+20, radius+20, 270, 90);

        arc5.setType(ArcType.OPEN);
        arc5.setFill(Color.TRANSPARENT);
        arc5.setStrokeWidth(width);
        arc5.setStroke(Color.web("#FF0181"));
        arc5.setId("#FF0181");

        arc6.setType(ArcType.OPEN);
        arc6.setFill(Color.TRANSPARENT);
        arc6.setStrokeWidth(width);
        arc6.setStroke(Color.web("#FAE100"));
        arc6.setId("#FAE100");

        arc7.setType(ArcType.OPEN);
        arc7.setFill(Color.TRANSPARENT);
        arc7.setStrokeWidth(width);
        arc7.setStroke(Color.web("#32DBF0"));
        arc7.setId("#32DBF0");

        arc8.setType(ArcType.OPEN);
        arc8.setFill(Color.TRANSPARENT);
        arc8.setStrokeWidth(width);
        arc8.setStroke(Color.web("#900DFF"));
        arc8.setId("#900DFF");

        arc9 = new Arc(250, height, radius+40, radius+40, 0, 90);
        arc10 = new Arc(250, height, radius+40, radius+40, 90, 90);
        arc11 = new Arc(250, height, radius+40, radius+40, 180, 90);
        arc12 = new Arc(250, height, radius+40, radius+40, 270, 90);

        arc9.setType(ArcType.OPEN);
        arc9.setFill(Color.TRANSPARENT);
        arc9.setStrokeWidth(width);
        arc9.setStroke(Color.web("#FF0181"));
        arc9.setId("#FF0181");

        arc10.setType(ArcType.OPEN);
        arc10.setFill(Color.TRANSPARENT);
        arc10.setStrokeWidth(width);
        arc10.setStroke(Color.web("#FAE100"));
        arc10.setId("#FAE100");

        arc11.setType(ArcType.OPEN);
        arc11.setFill(Color.TRANSPARENT);
        arc11.setStrokeWidth(width);
        arc11.setStroke(Color.web("#32DBF0"));
        arc11.setId("#32DBF0");

        arc12.setType(ArcType.OPEN);
        arc12.setFill(Color.TRANSPARENT);
        arc12.setStrokeWidth(width);
        arc12.setStroke(Color.web("#900DFF"));
        arc12.setId("#900DFF");

        tripleCircle = new Group();
        tripleCircle.getChildren().addAll(arc1,arc2,arc3,arc4,arc5,arc6,arc7,arc8,arc9,arc10,arc11,arc12);
        rotate = new RotateTransition();
        rotate.setNode(tripleCircle);
        rotate.setDuration(Duration.seconds(3));
        rotate.setByAngle(360);
        rotate.setCycleCount(Timeline.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.play();

    }
    @Override
    public void setLayoutY(double y){
        tripleCircle.setLayoutY(y);
    }
    @Override
    public double getLayoutY() {
        return tripleCircle.getLayoutY();
    }

    @Override
    public void startAnimation(){
        rotate.play();
    }
    @Override
    public void pauseAnimation(){
        rotate.pause();
    }
    @Override
    public Group getNode(){
        return tripleCircle;
    }
    @Override
    public void move(double y){
        tripleCircle.setLayoutY(tripleCircle.getLayoutY() + y);
    }

    @Override
    void levelUp(){
        rotate.stop();
        rotate.setNode(tripleCircle);
        speed -= 100;
        rotate.setDuration(Duration.millis(speed));
        rotate.play();
    }
}

