package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


class mainPageButton {

    public StackPane middleButton = new StackPane();
    private ring circle1;
    private ring circle2;
    private ring circle3;
    public Button button;

    public mainPageButton() {

        button = new Button("");
        int xCoordinate = 150;
        int yCoordinate = 300;
        int radius1 = 50;
        int radius2 = 70;
        int radius3 = 93;

        circle1 = new ring(yCoordinate, radius1, 12, 1);
        circle2 = new ring(yCoordinate, radius2, 15, 0);
        circle3 = new ring(yCoordinate, radius3, 18, 1);

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

        Image playButton = new Image("file:assets/images/playButton.png");
        ImageView playButtonView = new ImageView(playButton);
        playButtonView.setPreserveRatio(true);
//        playButtonView.setFitHeight(200);
        playButtonView.setFitWidth(60);

        middleButton.getChildren().addAll(circle1.getNode(), circle2.getNode(), circle3.getNode(), playButtonView, button);


    }

}
public class gameMain {
    private VBox root;
    public Scene scene;
    private scoreScreen scoreScreen;
    private gameplay gameplayScreen;
    private loadGame loadGameScreen;
    private Button loadButton;
    private Button scoreButton ;
    private Button helpButton ;
    private Button exitButton ;
    private mainPageButton middleButton;

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
        gameplayScreen = new gameplay(primaryStage, this.scene);
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
                    primaryStage.setScene(gameplayScreen.getScene());
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
