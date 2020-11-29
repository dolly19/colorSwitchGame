package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class gameplayScreen {

    private gameOverScreen gameOverScreen;
    private pauseScreen pauseScreen;
    private Pane root;
    public Scene scene;
    private ring ring1;
    playerBall playerBall;
    rainBowBall rainBowBall;
    star star;
    doubleRing doubleRing;
    tripleRing tripleRing;

    public gameplayScreen(Stage primaryStage, Scene gameMain){
        this.gameOverScreen = new gameOverScreen(primaryStage, gameMain);
        root = new Pane();

        ring1 = new ring(350, 100, 10, 1);
        playerBall = new playerBall();
        rainBowBall = new rainBowBall();
        star = new star();
        doubleRing = new doubleRing(50, 100, 12);
        tripleRing = new tripleRing(-250, 150, 15);

        addPauseButton(primaryStage);

        root.getChildren().addAll(playerBall.circle, rainBowBall.ball, star.star, ring1.ring, doubleRing.ring, tripleRing.ring);

        scene = new Scene(root, 500, 700);
        root.setStyle("-fx-background-color: #272327;");

        this.pauseScreen = new pauseScreen(primaryStage, this.scene, gameMain, this.gameOverScreen.scene);

        scene.setOnMouseClicked(mouseEvent -> {
            System.out.println("Mouse Clicked!!!");
//                System.out.println(ring1.ring.getTranslateY());
            ring1.moveDownBy(40);
            playerBall.moveUpBy(40);
            rainBowBall.moveDownBy(40);
            star.moveDownBy(40);
            doubleRing.moveDownBy(40);
            tripleRing.moveDownBy(40);
        });

    }


    private void addPauseButton(Stage primaryStage){

        StackPane root = new StackPane();

        Button pauseButton = new Button();
        pauseButton.setStyle(
                "-fx-background-radius: 5em; " +
                        "-fx-min-width: 70px; " +
                        "-fx-min-height: 70px; " +
                        "-fx-max-width: 70px; " +
                        "-fx-max-height: 70px;" +
                        "-fx-background-color: transparent"
        );

        EventHandler<ActionEvent> pauseGame =
                e -> {
                    primaryStage.setScene(this.pauseScreen.scene);
                };
        pauseButton.setOnAction(pauseGame);

        Image imagePause = new Image("file:assets/images/pauseButton.png");
        ImageView pauseImage = new ImageView(imagePause);
        pauseImage.setPreserveRatio(true);
        pauseImage.setFitWidth(70);

        root.setLayoutX(400);
        root.setLayoutY(30);

        root.getChildren().addAll(pauseImage, pauseButton);

        this.root.getChildren().addAll(root);

    }





}
