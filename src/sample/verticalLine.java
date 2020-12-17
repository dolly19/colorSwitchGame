package sample;

import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class verticalLine extends gameElement {
    private TranslateTransition translate;
    private Transition transition;
    private Line linepath , linep;
    private Line line;
    private Node node;
    private int height;
    private final int NUM_NODES1;
    Group content;
    verticalLine(int height){

        this.height = height;
        translate = new TranslateTransition();

        linepath = new Line();
        linepath.setStartX(0);
        linepath.setStartY(height);
        linepath.setEndX(700.0);
        linepath.setEndY(height);

        linep = new Line();
        linep.setStartX(700);
        linep.setStartY(height+2);
        linep.setEndX(0);
        linep.setEndY(height+2);

        NUM_NODES1 = 6;
        content = new Group();

        for (int count = 0; count < 6; count++) {
            if(count==0 || count ==4) {
                line = new Line(0,0,0,125);
                line.setStroke(Color.web("#FAE100"));
                line.setId("#FAE100");
                line.setStrokeWidth(15);
                line.setStyle("-fx-stroke-line-cap: round");
                node = line;
                content.getChildren().add(node);
                transition = createPathTransition(linepath, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES1));

            }
            else if(count==1 || count ==5) {
                line = new Line(0,0,0,125);
                line.setStroke(Color.web("#900DFF"));
                line.setId("#900DFF");
                line.setStrokeWidth(15);
                line.setStyle("-fx-stroke-line-cap: round");
                node = line;
                content.getChildren().add(node);
                transition = createPathTransition(linepath, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES1));

            }
            else if(count==2 || count ==0) {
                line = new Line(0,0,0,125);
                line.setStroke(Color.web("#FF0181"));
                line.setId("#FF0181");
                line.setStyle("-fx-stroke-line-cap: round");
                node = line;
                line.setStrokeWidth(15);
                content.getChildren().add(node);
                transition = createPathTransition(linepath, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES1));

            }
            else{
                line = new Line(0,0,0,125);
                line.setStroke(Color.web("#32DBF0"));
                line.setId("#32DBF0");
                line.setStyle("-fx-stroke-line-cap: round");
                line.setStrokeWidth(15);
                node = line;
                content.getChildren().add(node);
                transition = createPathTransition(linepath, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES1));

            }

        }
        for (int count = 0; count < 6; count++) {
            if(count==0 || count ==4) {
                line = new Line(0,0,0,70);
                line.setStroke(Color.web("#FAE100"));
                line.setId("#FAE100");
                line.setStrokeWidth(15);
                line.setStyle("-fx-stroke-line-cap: round");
                node = line;
                content.getChildren().add(node);
                transition = createPathTransition(linep, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES1));

            }
            else if(count==1 || count ==5) {
                line = new Line(0,0,0,70);
                line.setStroke(Color.web("#900DFF"));
                line.setId("#900DFF");
                line.setStrokeWidth(15);
                line.setStyle("-fx-stroke-line-cap: round");
                node = line;
                content.getChildren().add(node);
                transition = createPathTransition(linep, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES1));

            }
            else if(count==2 || count ==0) {
                Line line = new Line(0,0,0,70);
                line.setStroke(Color.web("#FF0181"));
                line.setId("#FF0181");
                line.setStyle("-fx-stroke-line-cap: round");
                node = line;
                line.setStrokeWidth(15);
                content.getChildren().add(node);
                transition = createPathTransition(linep, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES1));

            }
            else{
                Line line = new Line(0,0,0,70);
                line.setStroke(Color.web("#32DBF0"));
                line.setId("#32DBF0");
                line.setStyle("-fx-stroke-line-cap: round");
                line.setStrokeWidth(15);
                node = line;
                content.getChildren().add(node);
                transition = createPathTransition(linep, node);
                transition.jumpTo(Duration.seconds(10).multiply(count * 1.0 / NUM_NODES1));

            }

        }

        content.relocate(-100,0);


    }
    private PathTransition createPathTransition(Shape shape, Node node) {
        final PathTransition transition = new PathTransition(
                Duration.seconds(10),
                shape,
                node
        );

        transition.setCycleCount(PathTransition.INDEFINITE);
        transition.setInterpolator(Interpolator.LINEAR);
        transition.play();
        return transition;
    }

    public int getHeight() {
        return height;
    }
    void move(double y) {
        content.setLayoutY(content.getLayoutY() + y);
    }

    public Group getNode(){
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
        transition.play();
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
