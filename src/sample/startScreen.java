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


public class startScreen {

    private Stage primaryStage;
    private VBox root;
    public Scene scene;
    private scoreScreen scoreScreen;
    final Button loadButton;
    final Button scoreButton ;
    final Button helpButton ;
    final Button exitButton ;
    final mainPageButton middleButton;

    public startScreen(Stage primaryStage){

        this.primaryStage = primaryStage;
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

        setScoreScreen();
        setExitAlert();

        root.getChildren().addAll(topAnimation, middleButton.middleButton, loadButton, scoreButton, helpButton, exitButton);
        scene = new Scene(root, 500, 700);
        scene.getStylesheets().add("startScreen.css");

        scoreScreen = new scoreScreen(primaryStage, scene);

    }

    private void addClassToButtons(){
        loadButton.getStyleClass().addAll("startScreenButtons", "loadButton");
        scoreButton.getStyleClass().addAll("startScreenButtons", "scoresButton");
        helpButton.getStyleClass().addAll("startScreenButtons", "helpButton");
        exitButton.getStyleClass().addAll("startScreenButtons", "exitButton");
    }
    private ImageView renderTopAnimation(){
        Image image = new Image("file:assets/images/colorSwitchAnim.gif");
        ImageView topImageView = new ImageView(image);
        topImageView.setPreserveRatio(true);
        topImageView.setFitHeight(200);
        topImageView.setFitWidth(200);
        return  topImageView;
    }

    private void setScoreScreen(){
        EventHandler<ActionEvent> toScoresScreen =
                e -> {
                    primaryStage.setScene(scoreScreen.scene);
                };
        scoreButton.setOnAction(toScoresScreen);
    }

    private void setExitAlert(){
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
