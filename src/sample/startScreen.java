package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


public class startScreen {
    public Scene startScreenScene;
    private VBox root;
    private mainPageButton middleButton = new mainPageButton();
    private Button loadButton = new Button("Load Game");
    private Button scoresButton = new Button("Scores");
    private Button helpButton = new Button("Help");
    private Button exitButton = new Button("Exit");

    public startScreen(){

        root = new VBox(20);
        root.setStyle("-fx-background-color: #272327;");
        root.setAlignment(Pos.CENTER);

        Image image = new Image("file:assets/images/colorSwitchAnim.gif");
        ImageView topImageView = new ImageView(image);
        topImageView.setPreserveRatio(true);
        topImageView.setFitHeight(200);
        topImageView.setFitWidth(200);

        loadButton.getStyleClass().addAll("startScreenButtons", "loadButton");
        scoresButton.getStyleClass().addAll("startScreenButtons", "scoresButton");
        helpButton.getStyleClass().addAll("startScreenButtons", "helpButton");
        exitButton.getStyleClass().addAll("startScreenButtons", "exitButton");




        root.getChildren().addAll(topImageView, middleButton.middleButton, loadButton, scoresButton, helpButton, exitButton);

        startScreenScene = new Scene(root, 500, 700);

        startScreenScene.getStylesheets().add("startScreen.css");


    }





}
