package sample;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;


public class mainPageButton {

    public StackPane middleButton = new StackPane();
    private circle circle1;
    private circle circle2;
    private circle circle3;
    private Button button;

    public mainPageButton() {

        button = new Button("PLAY");
        int xCoordinate = 150;
        int yCoordinate = 300;
        int radius1 = 50;
        int radius2 = 70;
        int radius3 = 93;

        circle1 = new circle(xCoordinate, yCoordinate, radius1, 12, 1);
        circle2 = new circle(xCoordinate, yCoordinate, radius2, 15, 0);
        circle3 = new circle(xCoordinate, yCoordinate, radius3, 18, 1);

//        button.setTranslateX(xCoordinate);
//        button.setLayoutX(yCoordinate);

        button.setStyle(
                "-fx-background-radius: 5em; " +
                        "-fx-min-width: 60px; " +
                        "-fx-min-height: 60px; " +
                        "-fx-max-width: 60px; " +
                        "-fx-max-height: 60px;" +
                        "-fx-background-color: #272727"
        );

        button.setOnAction(value ->  {
            if(circle1.isRotating())
                circle1.pauseRotation();
            else
                circle1.startRotation();
        });

        middleButton.getChildren().addAll(circle1.circle, circle2.circle, circle3.circle, button);


    }



}
