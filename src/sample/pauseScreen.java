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

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class pauseScreen implements java.io.Serializable {
    transient public VBox root;
    transient public Scene scene;
    transient private Stage primaryStage;
    transient private gameplay gameplayScreen;
    transient private Button homeButton;
    transient private Button resumeButton;
    transient private Button saveButton;
    transient private Button restartButton;
    transient private Button colorButton;

    public pauseScreen(gameplay gameplayScreen)  {

        deSerialize(gameplayScreen);

    }

    public void deSerialize(gameplay gameplay){
        this.gameplayScreen = gameplay;
        this.root = new VBox(30);
        this.primaryStage = gameplay.primaryStage;
        this.resumeButton = new Button("RESUME");
        this.restartButton = new Button("RESTART");
        this.saveButton = new Button("SAVE GAME");
        this.colorButton = new Button("Color");
        this.gameplayScreen = gameplayScreen;

        setUpHomeButton(gameplay.gameMain);
        setUpResumeButton();
        setUpSaveButton();
        setUpChangeColor(primaryStage);
        setUpRestartButton();


        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(homeButton,resumeButton, saveButton, restartButton, colorButton);

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
        homeButton.setGraphic(homeButtonImage);
        homeButton.getStyleClass().add("homeButton");

        EventHandler<ActionEvent> goToHome =
                e -> {
                    this.gameplayScreen.pauseGame();
                    this.primaryStage.setScene(gameMain);
                };
        homeButton.setOnAction(goToHome);

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
        EventHandler<ActionEvent> restartGame =
                e -> {

            gameplayScreen.serialize();

                    try
                    {
                        String filename = "test" + ".ser";
                        FileOutputStream file = new FileOutputStream(filename);
                        ObjectOutputStream out = new ObjectOutputStream(file);

                        out.writeObject(this.gameplayScreen);

                        out.close();
                        file.close();

                        System.out.println("Game Saved to: " + filename);
                        gameplayScreen.restartGame();
                        primaryStage.setScene(gameplayScreen.gameMain);

                    }

                    catch(IOException ex)
                    {
                        ex.printStackTrace();
                    }








                };
        saveButton.setOnAction(restartGame);





    }

    private void setUpChangeColor(Stage primaryStage){
        colorButton.getStyleClass().add("colorButton");
        colorButton.setLayoutX(40);
        colorButton.setLayoutY(20);


        EventHandler<ActionEvent> goToGameOver =
                e -> {
                    gameplayScreen.changeSceneColor();
                    primaryStage.setScene(gameplayScreen.getScene());
                };
        colorButton.setOnAction(goToGameOver);
    }


}
