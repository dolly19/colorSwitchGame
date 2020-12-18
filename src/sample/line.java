package sample;

import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class line extends gameElement {

    transient private Transition transition;
    transient private Line linepath;
    transient private Line line;
    transient private Node node;
    transient private int NUM_NODES1;
    transient Group content1;

    public line(){

        deSerialize();

    }

    public void deSerialize(){

        linepath = new Line();
        linepath.setStartX(0);
        linepath.setStartY(0);
        linepath.setEndX(700.0);
        linepath.setEndY(0);

        NUM_NODES1 = 6;
        this.content1 = new Group();



        for (int count = 0; count < 6; count++) {
            if(count==0 || count ==4) {
                line = new Line(0,0,110,0);
                line.setStroke(Color.web("#FAE100"));
                line.setId("#FAE100");
                line.setStrokeWidth(15);
                node = line;
                content1.getChildren().add(node);
                transition = createPathTransition(linepath, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES1));

            }
            else if(count==1 || count ==5) {
                line = new Line(0,0,110,0);
                line.setStroke(Color.web("#900DFF"));
                line.setId("#900DFF");
                line.setStrokeWidth(15);
                node = line;
                content1.getChildren().add(node);
                transition = createPathTransition(linepath, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES1));


            }
            else if(count==2) {
                line = new Line(0,0,110,0);
                line.setStroke(Color.web("#FF0181"));
                line.setId("#FF0181");
                node = line;
                line.setStrokeWidth(15);
                content1.getChildren().add(node);
                transition = createPathTransition(linepath, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES1));


            }
            else {
                line = new Line(0,0,110,0);
                line.setStroke(Color.web("#32DBF0"));
                line.setId("#32DBF0");
                line.setStrokeWidth(15);
                node = line;
                content1.getChildren().add(node);
                transition = createPathTransition(linepath, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES1));


            }

        }
        content1.relocate(-100,0);

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
        content1.setLayoutY(content1.getLayoutY() + y);
    }

    public Group getNode(){
        return content1;
    }

    @Override
    void setLayoutY(double y) {
        content1.setLayoutY(y);
    }

    @Override
    double getLayoutY() {
        return content1.getLayoutY();
    }

    @Override
    void levelUp() {

    }

    @Override
    void startAnimation() {

    }

    @Override
    void pauseAnimation() {
        Timeline playtime = new Timeline(
                new KeyFrame(Duration.seconds(0), event -> transition.play()),
                new KeyFrame(Duration.seconds(2), event -> transition.pause()),
                new KeyFrame(Duration.seconds(3), event -> transition.play())
        );
        playtime.stop();
    }


}

