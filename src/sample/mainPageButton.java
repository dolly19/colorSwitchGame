package sample;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;


public class mainPageButton {

    public StackPane middleButton = new StackPane();
    private circle circle1;
    private circle circle2;
    private circle circle3;
    public Button button;

    public mainPageButton() {

        button = new Button("");
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
                        "-fx-background-color: transparent"
        );

        button.setOnAction(value ->  {
            if(circle1.isRotating())
                circle1.pauseRotation();
            else
                circle1.startRotation();
        });

        Image playButton = new Image("file:assets/images/playButton.png");
        ImageView playButtonView = new ImageView(playButton);
        playButtonView.setPreserveRatio(true);
//        playButtonView.setFitHeight(200);
        playButtonView.setFitWidth(60);

        middleButton.getChildren().addAll(circle1.circle, circle2.circle, circle3.circle, playButtonView, button);


    }



}
