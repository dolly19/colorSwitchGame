package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class pauseScreen {
    public VBox root;
    public Scene scene;
    private Button homeButton;
    private Button resumeButton;
    private Button saveButton;
    private Button restartButton;
    private Button gameOver;
    private Group homeButtonGroup;

    public pauseScreen(Stage primaryStage, Scene gameplayScreen, Scene gameMain, Scene gameOverScreen)  {

        root = new VBox(30);
        homeButtonGroup = new Group();
        resumeButton = new Button("RESUME");
        restartButton = new Button("RESTART");
        saveButton = new Button("SAVE GAME");
        gameOver = new Button("Game Over");

        setUpHomeButton(primaryStage, gameMain);
        setUpResumeButton(primaryStage, gameplayScreen);
        setUpSaveButton();
        setUpGameOverButton(primaryStage, gameOverScreen);
        setUpRestartButton();


        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(homeButtonGroup, saveButton,resumeButton, gameOver, restartButton);

        root.setStyle("-fx-background-color: #272327");
        scene = new Scene(root, 500, 700);
        scene.getStylesheets().add("pauseScreen.css");


    }




    private void setUpHomeButton(Stage primaryStage, Scene gameMain){
        homeButton = new Button();
        Image image = new Image("file:assets/images/homeButton.png");
        ImageView homeButtonImage = new ImageView(image);
        homeButtonImage.setFitWidth(75);
        homeButtonImage.setPreserveRatio(true);

        homeButton.getStyleClass().add("homeButton");

        EventHandler<ActionEvent> goToHome =
                e -> {
                    primaryStage.setScene(gameMain);
                };
        homeButton.setOnAction(goToHome);


        homeButtonGroup.getChildren().addAll(homeButtonImage, homeButton);

    }
    private void setUpResumeButton(Stage primaryStage, Scene gameplayScreen){
        resumeButton.getStyleClass().add("resumeButton");
        EventHandler<ActionEvent> resumeGame =
                e -> {
                    primaryStage.setScene(gameplayScreen);
                };
        resumeButton.setOnAction(resumeGame);
    }

    private void setUpRestartButton(){
        restartButton.getStyleClass().add("restartButton");

        restartButton.setLayoutX(40);
        restartButton.setLayoutY(20);
    }

    private void setUpSaveButton(){
        saveButton.getStyleClass().add("saveButton");
    }

    private void setUpGameOverButton(Stage primaryStage, Scene gameOverScreen){
        gameOver.setStyle(
                "-fx-border-color: yellow;" + " -fx-text-fill: yellow;" +
                        "-fx-min-width: 220px;" +
                        "-fx-max-height: 0px;" + "-fx-background-color: transparent;"+ " -fx-font-size: 2em;" +
                        "-fx-border-width: 3 3 3 3; " +
                        "-fx-border-radius: 30; " );
        gameOver.setLayoutX(40);
        gameOver.setLayoutY(20);

        EventHandler<ActionEvent> goToGameOver =
                e -> {
                    primaryStage.setScene(gameOverScreen);
                };
        gameOver.setOnAction(goToGameOver);
    }


}
