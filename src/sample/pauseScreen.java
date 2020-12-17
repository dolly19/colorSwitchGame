package sample;

import javafx.animation.AnimationTimer;
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
    private Stage primaryStage;
    private gameplay gameplayScreen;
    private Button homeButton;
    private Button resumeButton;
    private Button saveButton;
    private Button restartButton;
    private Button gameOver;
    private Group homeButtonGroup;

    public pauseScreen(Stage primaryStage, gameplay gameplayScreen, Scene gameMain, Scene gameOverScreen, AnimationTimer animation)  {

        this.root = new VBox(30);
        this.primaryStage = primaryStage;
        this.homeButtonGroup = new Group();
        this.resumeButton = new Button("RESUME");
        this.restartButton = new Button("RESTART");
        this.saveButton = new Button("SAVE GAME");
        this.gameOver = new Button("Game Over");
        this.gameplayScreen = gameplayScreen;

        setUpHomeButton(gameMain);
        setUpResumeButton();
        setUpSaveButton();
        setUpGameOverButton(primaryStage, gameOverScreen);
        setUpRestartButton();


        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(homeButtonGroup, saveButton,resumeButton, gameOver, restartButton);

        root.setStyle("-fx-background-color: #272327");
        scene = new Scene(root, 500, 700);
        scene.getStylesheets().add("pauseScreen.css");


    }

    private void setUpHomeButton(Scene gameMain){
        homeButton = new Button();
        Image image = new Image("file:assets/images/homeButton.png");
        ImageView homeButtonImage = new ImageView(image);
        homeButtonImage.setFitWidth(75);
        homeButtonImage.setPreserveRatio(true);

        homeButton.getStyleClass().add("homeButton");

        EventHandler<ActionEvent> goToHome =
                e -> {
                    this.gameplayScreen.pauseGame();
                    this.primaryStage.setScene(gameMain);
                };
        homeButton.setOnAction(goToHome);


        homeButtonGroup.getChildren().addAll(homeButtonImage, homeButton);

    }
    private void setUpResumeButton(){
        resumeButton.getStyleClass().add("resumeButton");
        EventHandler<ActionEvent> resumeGame =
                e -> {
                    primaryStage.setScene(gameplayScreen.getScene());
                    gameplayScreen.startGame();
                };
        resumeButton.setOnAction(resumeGame);
    }

    private void setUpRestartButton(){
        restartButton.getStyleClass().add("restartButton");
        EventHandler<ActionEvent> restartGame =
                e -> {
                    primaryStage.setScene(gameplayScreen.getScene());
                    gameplayScreen.restartGame();
                };
        restartButton.setOnAction(restartGame);

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
