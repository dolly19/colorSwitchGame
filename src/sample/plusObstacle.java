package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class plusObstacle extends gameElement {
    transient private Line line1;
    transient private Line line2;
    transient private Line line3;
    transient private Line line4;
    transient Group plus;
    transient private RotateTransition rotate;

    plusObstacle(){
        deSerialize();
    }
    @Override
    public void deSerialize(){
        int width =20;
        line1 = new Line();
        line1.setStartX(40);
        line1.setStartY(120);
        line1.setEndX(160);
        line1.setEndY(120);
        line1.setFill(Color.TRANSPARENT);
        line1.setStrokeWidth(width);
        line1.setStyle("-fx-stroke-line-cap: round");
        line1.setStroke(Color.web("#FAE100"));
        line1.setId("#FAE100");

        line2 = new Line();
        line2.setStartX(160);
        line2.setStartY(120);
        line2.setEndX(160);
        line2.setEndY(240);
        line2.setFill(Color.TRANSPARENT);
        line2.setStrokeWidth(width);
        line2.setStyle("-fx-stroke-line-cap: round");
        line2.setStroke(Color.web("#900DFF"));
        line2.setId("#900DFF");

        line3 = new Line();
        line3.setStartX(160);
        line3.setStartY(120);
        line3.setEndX(280);
        line3.setEndY(120);
        line3.setFill(Color.TRANSPARENT);
        line3.setStrokeWidth(width);
        line3.setStyle("-fx-stroke-line-cap: round");
        line3.setStroke(Color.web("#FF0181"));
        line3.setId("#FF0181");

        line4 = new Line();
        line4.setStartX(160);
        line4.setStartY(120);
        line4.setEndX(160);
        line4.setEndY(0);
        line4.setFill(Color.TRANSPARENT);
        line4.setStrokeWidth(width);
        line4.setStyle("-fx-stroke-line-cap: round");
        line4.setStroke(Color.web("#32DBF0"));
        line4.setId("#32DBF0");

        plus = new Group();
        plus.getChildren().addAll(line1,line2,line3,line4);

        rotate = new RotateTransition();
        rotate.setNode(plus);
        rotate.setDuration(Duration.seconds(4));
        rotate.setByAngle(-360);
        rotate.setCycleCount(Timeline.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.play();

    }

    @Override
    void move(double y) {
        plus.setLayoutY(plus.getLayoutY() + y);
    }

    @Override
    Group getNode() {
        return plus;
    }

    @Override
    void setLayoutY(double y) {
        plus.setLayoutY(y);
    }

    @Override
    double getLayoutY() {
        return plus.getLayoutY();
    }

    @Override
    void levelUp() {

    }

    @Override
    void startAnimation() {

    }

    @Override
    void pauseAnimation() {

    }
}
