package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

public class rainbowBall extends gameElement {
    Group ball;

    public rainbowBall(){
        Arc arc1 = new Arc(250, 0, 15, 15, 0, 90);
        Arc arc2 = new Arc(250, 0, 15, 15, 90, 90);
        Arc arc3 = new Arc(250, 0, 15, 15, 180, 90);
        Arc arc4 = new Arc(250, 0, 15, 15, 270, 90);

        arc1.setType(ArcType.ROUND);
        arc1.setFill(Color.TRANSPARENT);
        arc1.setStrokeWidth(0);
        arc1.setFill(Color.web("#FAE100"));

        arc2.setType(ArcType.ROUND);
        arc2.setFill(Color.TRANSPARENT);
        arc2.setStrokeWidth(0);
        arc2.setFill(Color.web("#900DFF"));

        arc3.setType(ArcType.ROUND);
        arc3.setFill(Color.TRANSPARENT);
        arc3.setStrokeWidth(0);
        arc3.setFill(Color.web("#FF0181"));

        arc4.setType(ArcType.ROUND);
        arc4.setFill(Color.TRANSPARENT);
        arc4.setStrokeWidth(0);
        arc4.setFill(Color.web("#32DBF0"));

        ball = new Group();
        ball.getChildren().addAll(arc1, arc2, arc3, arc4);
    }

    @Override
    public void setLayoutY(double y){
        ball.setLayoutY(y);
    }
    @Override
    public double getLayoutY() {
        return ball.getLayoutY();
    }

    @Override
    void levelUp() {

    }

    @Override
    public void move(double y){
        ball.setLayoutY(ball.getLayoutY() + y);
    }

    @Override
    public Group getNode(){
        return ball;
    }

    @Override
    void startAnimation() { }
    @Override
    void pauseAnimation() { }

}
