package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class scoreScreen {
    private Pane root;
    public Scene scene;
    private Stage primaryStage;
    private Scene startScreenScene;

    public scoreScreen(Stage primaryStage, Scene startScreenScene){
        this.primaryStage = primaryStage;
        this.startScreenScene = startScreenScene;

        root = new Pane();

        renderBoard();
        renderText();

        Image header = new Image("file:assets/images/scoreScreenHeader.jpeg");
        ImageView headerView = new ImageView(header);
        headerView.setPreserveRatio(true);
        headerView.setFitWidth(500);
        root.getChildren().add(headerView);

        renderHomeScreenButton();

        root.setStyle("-fx-background-color: #272327;");
        scene = new Scene(root, 500, 700);
        scene.getStylesheets().add("scoreScreen.css");



    }

    private void renderHomeScreenButton(){
        Button button = new Button();

        button.getStyleClass().add("homeButton");
        button.setLayoutX(29);
        button.setLayoutY(37);

        EventHandler<ActionEvent> goToHomeScreen =
                e -> {
                    System.out.println("Hello");
                    primaryStage.setScene(this.startScreenScene);
                };

        button.setOnAction(goToHomeScreen);
        root.getChildren().add(button);
    }

    private void renderBoard(){
        Rectangle rectBottomOuter = new Rectangle();
        rectBottomOuter.setX(50);
        rectBottomOuter.setY(200);
        rectBottomOuter.setWidth(400);
        rectBottomOuter.setHeight(260);
        rectBottomOuter.setArcHeight(15);
        rectBottomOuter.setArcWidth(15);
        rectBottomOuter.getStyleClass().add("rectBottomOuter");

        Rectangle rectBottomInner = new Rectangle();
        rectBottomInner.setX(75);
        rectBottomInner.setY(260);
        rectBottomInner.setWidth(350);
        rectBottomInner.setHeight(180);
        rectBottomInner.setArcHeight(15);
        rectBottomInner.setArcWidth(15);
        rectBottomInner.getStyleClass().add("rectBottomInner");

        root.getChildren().addAll(rectBottomOuter, rectBottomInner );
    }

    private void renderText(){

        Text total = new Text("Totals");
        total.setX(200);
        total.setY(250);
        total.getStyleClass().add("total");

        Text levelsPlayed = new Text("Levels Played");
        levelsPlayed.setX(95);
        levelsPlayed.setY(300);
        levelsPlayed.getStyleClass().add("text");

        Text levelsPlayedValue = new Text("123");
        levelsPlayedValue.setX(350);
        levelsPlayedValue.setY(300);
        levelsPlayedValue.getStyleClass().add("text");

        Text starsEarned = new Text("Stars Earned");
        starsEarned.setX(95);
        starsEarned.setY(350);
        starsEarned.getStyleClass().add("text");

        Text starsEarnedValue = new Text("250");
        starsEarnedValue.setX(350);
        starsEarnedValue.setY(350);
        starsEarnedValue.getStyleClass().add("text");

        Text starsSpent = new Text("Stars Spent");
        starsSpent.setX(95);
        starsSpent.setY(400);
        starsSpent.getStyleClass().add("text");

        Text starsSpentValue = new Text("500");
        starsSpentValue.setX(350);
        starsSpentValue.setY(400);
        starsSpentValue.getStyleClass().add("text");

        root.getChildren().addAll(total, levelsPlayed, starsEarned, starsSpent,
                levelsPlayedValue, starsEarnedValue, starsSpentValue);

    }

}
