package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class gameMain {

    private VBox root;
    public Scene scene;
    private scoreScreen scoreScreen;
    private gameplayScreen gameplayScreen;
    private loadGame loadGameScreen;
    final Button loadButton;
    final Button scoreButton ;
    final Button helpButton ;
    final Button exitButton ;
    final mainPageButton middleButton;


    public gameMain(Stage primaryStage){

        loadButton = new Button("Load Game");
        scoreButton = new Button("Scores");
        helpButton = new Button("Help");
        exitButton = new Button("Exit");
        middleButton = new mainPageButton();

        root = new VBox(20);
        root.setStyle("-fx-background-color: #272327;");
        root.setAlignment(Pos.CENTER);

        ImageView topAnimation = renderTopAnimation();
        addClassToButtons();

        startGameHandler(primaryStage);
        setLoadGameScreen(primaryStage);
        setScoreScreen(primaryStage);
        setExitAlert();

        root.getChildren().addAll(topAnimation, middleButton.middleButton, loadButton, scoreButton, helpButton, exitButton);
        scene = new Scene(root, 500, 700);
        scene.getStylesheets().add("gameMain.css");

        scoreScreen = new scoreScreen(primaryStage, scene);
        loadGameScreen = new loadGame(primaryStage, this.scene);
        gameplayScreen = new gameplayScreen(primaryStage, this.scene);

    }

    private void addClassToButtons(){
        helpButton.getStyleClass().addAll("gameMainButtons", "helpButton");
    }

    private ImageView renderTopAnimation(){
        Image image = new Image("file:assets/images/colorSwitchAnim.gif");
        ImageView topImageView = new ImageView(image);
        topImageView.setPreserveRatio(true);
        topImageView.setFitHeight(200);
        topImageView.setFitWidth(200);
        return  topImageView;
    }

    private void startGameHandler(Stage primaryStage){
        EventHandler<ActionEvent> startGame =
                e -> {
                    primaryStage.setScene(gameplayScreen.scene);
                };
        middleButton.button.setOnAction(startGame);
    }

    private void setScoreScreen(Stage primaryStage){
        scoreButton.getStyleClass().addAll("gameMainButtons", "scoresButton");

        EventHandler<ActionEvent> toScoresScreen =
                e -> {
                    primaryStage.setScene(scoreScreen.scene);
                };
        scoreButton.setOnAction(toScoresScreen);
    }

    private void setLoadGameScreen(Stage primaryStage){
        loadButton.getStyleClass().addAll("gameMainButtons", "loadButton");
        EventHandler<ActionEvent> toLoadGameScreen =
                e -> {
                    primaryStage.setScene(loadGameScreen.scene);
                };
        loadButton.setOnAction(toLoadGameScreen);
    }

    private void setExitAlert(){
        exitButton.getStyleClass().addAll("gameMainButtons", "exitButton");

        Alert exitAlert = new Alert(Alert.AlertType.CONFIRMATION);
        exitAlert.setTitle("Color Switch");
        exitAlert.setHeaderText("Are you sure you want to exit the Game ");
//        exitAlert.setContentText("We override the style classes of the dialog");

//        DialogPane alertDialogPane = exitAlert.getDialogPane();
//        alertDialogPane.getStyleClass().add("myDialog");

        EventHandler<ActionEvent> exitEvent =
                e -> {
                    if (exitAlert.showAndWait().get() == ButtonType.OK)
                        System.exit(1);
                };
        exitButton.setOnAction(exitEvent);
    }

}
