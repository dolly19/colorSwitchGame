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


public class gameMain {
    private VBox root;
    public Scene scene;
    private Stage primaryStage;
    private scoreScreen scoreScreen;
    private gameplay gameplayScreen;
    private loadGame loadGameScreen;
    private Button loadButton;
    private Button scoreButton ;
    private Button settingButton ;
    private Button exitButton ;
    private settingsScreen settingScreen;
    StackPane middleButton;

    public gameMain(Stage primaryStage){
        this.primaryStage = primaryStage;
        this.loadButton = new Button("Load Game");
        this.scoreButton = new Button("Scores");
        this.settingButton = new Button("Setting");
        this.exitButton = new Button("Exit");
        this.middleButton = new StackPane();

        this.root = new VBox(20);
        this.root.setStyle("-fx-background-color: #272327;");
        this.root.setAlignment(Pos.CENTER);

        ImageView topAnimation = renderTopAnimation();
        addClassToButtons();

        startGameHandler();
        setLoadGameScreen();
        setScoreScreen();
        setSettingScreen();
        setExitAlert();

        root.getChildren().addAll(topAnimation, middleButton, loadButton, scoreButton, settingButton, exitButton);
        scene = new Scene(root, 500, 700);
        scene.getStylesheets().add("gameMain.css");

        scoreScreen = new scoreScreen(primaryStage, scene);
        loadGameScreen = new loadGame(primaryStage, this.scene);
        gameplayScreen = new gameplay(primaryStage, this.scene);
        settingScreen = new settingsScreen(primaryStage, this.scene);
    }

    private void addClassToButtons(){
        settingButton.getStyleClass().addAll("gameMainButtons", "settingButton");
    }

    private ImageView renderTopAnimation(){
        Image image = new Image("file:assets/images/colorSwitchAnim.gif");
        ImageView topImageView = new ImageView(image);
        topImageView.setPreserveRatio(true);
        topImageView.setFitHeight(200);
        topImageView.setFitWidth(200);
        return  topImageView;
    }
    private void startGameHandler(){


        Button button = new Button("");
        int yCoordinate = 300;
        int radius1 = 50;
        int radius2 = 70;
        int radius3 = 93;

        ring circle1 = new ring(yCoordinate, radius1, 12, 1);
        ring circle2 = new ring(yCoordinate, radius2, 15, 0);
        ring circle3 = new ring(yCoordinate, radius3, 18, 1);
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
        playButtonView.setFitWidth(60);

        middleButton.getChildren().addAll(circle1.getNode(), circle2.getNode(), circle3.getNode(), playButtonView, button);

        EventHandler<ActionEvent> startGame =
                e -> {
                    this.primaryStage.setScene(gameplayScreen.getScene());
                };
        button.setOnAction(startGame);
    }
    private void setScoreScreen(){
        scoreButton.getStyleClass().addAll("gameMainButtons", "scoresButton");
        EventHandler<ActionEvent> toScoresScreen =
                e -> {
                    this.primaryStage.setScene(scoreScreen.scene);
                };
        scoreButton.setOnAction(toScoresScreen);
    }
    private void setLoadGameScreen(){
        loadButton.getStyleClass().addAll("gameMainButtons", "loadButton");
        EventHandler<ActionEvent> toLoadGameScreen =
                e -> {
                    this.primaryStage.setScene(loadGameScreen.scene);
                };
        loadButton.setOnAction(toLoadGameScreen);
    }

    private void setSettingScreen(){
        EventHandler<ActionEvent> toSettings =
                e -> {
                    this.primaryStage.setScene(settingScreen.scene);
                };
        settingButton.setOnAction(toSettings);

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
