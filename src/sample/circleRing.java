package sample;

import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class circleRing extends gameElement {
    private int NUM_NODES = 24;
    private double H = 400;
    private double NODE_SIZE = H / 13.0;
    transient private Transition transition;
    transient Group content;

    circleRing(){
        deSerialize();
    }
    @Override
    public void deSerialize(){
        content = new Group();
        Shape path = new Circle(250, 0, H * 3 / 8.0 - NODE_SIZE);

        for (int i = 0; i < 24; i++) {
            if (i < 6){
                Circle node = new Circle(NODE_SIZE / 2, Color.web("#FAE100"));
                node.setId("#FAE100");
                content.getChildren().add(node);
                transition = createPathTransition(path, node);
                transition.jumpTo(Duration.seconds(10).multiply(i * 1.0 / NUM_NODES));

            }
            else if (i<12){
                Circle node = new Circle(NODE_SIZE / 2, Color.web("#900DFF"));
                node.setId("#900DFF");
                content.getChildren().add(node);
                transition = createPathTransition(path, node);
                transition.jumpTo(Duration.seconds(10).multiply(i * 1.0 / NUM_NODES));

            }
            else if (i<18){
                Circle node = new Circle(NODE_SIZE / 2,Color.web("#FF0181"));
                node.setId("#FF0181");
                content.getChildren().add(node);
                transition = createPathTransition(path, node);
                transition.jumpTo(Duration.seconds(10).multiply(i * 1.0 / NUM_NODES));

            }
            else {
                Circle node = new Circle(NODE_SIZE / 2,Color.web("#32DBF0"));
                node.setId("#32DBF0");
                content.getChildren().add(node);
                final Transition transition = createPathTransition(path, node);
                transition.jumpTo(Duration.seconds(10).multiply(i * 1.0 / NUM_NODES));

            }
        }
        content.setLayoutY(0);
        pauseAnimation();
    }

    private PathTransition createPathTransition(Shape shape, Node node) {
        final PathTransition transition = new PathTransition(
                Duration.seconds(10),
                shape,
                node
        );
        transition.setAutoReverse(false);
        transition.setCycleCount(PathTransition.INDEFINITE);
        transition.setInterpolator(Interpolator.LINEAR);
        transition.play();
        return transition;
    }


    @Override
    void move(double y) {
        content.setLayoutY(content.getLayoutY() + y);
    }

    @Override
    Group getNode() {
        return content;
    }

    @Override
    void setLayoutY(double y) {
        content.setLayoutY(y);
    }

    @Override
    double getLayoutY() {
        return content.getLayoutY();
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