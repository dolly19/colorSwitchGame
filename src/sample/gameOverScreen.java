package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class gameOverScreen {
    public Scene scene;
    private Pane root;
    private Stage primaryStage;
    private Scene gameMain;

    public gameOverScreen(Stage primaryStage, Scene gameMain){

        this.primaryStage = primaryStage;
        this.gameMain = gameMain;

        root = new Pane();


        root.getChildren().addAll(renderTopAnimation(), renderBackButton(), renderScoreHeader(), renderScore(10),
                renderBestScoreHeader(), renderBestScore(100), renderRestartButton());
        root.setStyle("-fx-background-color: #272327;");
        scene = new Scene(root, 500, 700);

    }


    private ImageView renderTopAnimation(){
        Image image = new Image("file:assets/images/colorSwitchAnim.gif");
        ImageView topImageView = new ImageView(image);
        topImageView.setPreserveRatio(true);
        topImageView.setFitHeight(200);
        topImageView.setFitWidth(200);
        topImageView.setX(150);
        topImageView.setY(20);
        return topImageView;
    }

    private StackPane renderBackButton(){
        StackPane root = new StackPane();

        Button button = new Button();
        button.setStyle(
                "-fx-background-radius: 5em; " +
                        "-fx-min-width: 70px; " +
                        "-fx-min-height: 70px; " +
                        "-fx-max-width: 70px; " +
                        "-fx-max-height: 70px;" +
                        "-fx-background-color: transparent"
        );

        EventHandler<ActionEvent> goToHome =
                e -> {
                    this.primaryStage.setScene(this.gameMain);
                };
        button.setOnAction(goToHome);

        Image image = new Image("file:assets/images/pauseScreenBackButton.png");
        ImageView topImageView = new ImageView(image);
        topImageView.setPreserveRatio(true);
        topImageView.setFitWidth(70);

        root.setLayoutX(40);
        root.setLayoutY(30);

        root.getChildren().addAll(topImageView, button);

        return  root;
    }
    private StackPane renderScoreHeader(){

        StackPane root = new StackPane();
        Rectangle scoreRect = new Rectangle(0, 0, 500, 75);
        scoreRect.setFill(Paint.valueOf("#393939"));

        Text scoreText = new Text("SCORE");
        scoreText.setStyle(
                "-fx-font-size: 50;" +
                        "-fx-fill: white;"
        );

        root.getChildren().addAll(scoreRect, scoreText);
        root.setLayoutX(0);
        root.setLayoutY(150);
        return root;

    }
    private Text renderScore(int score){
        Text currentScore = new Text(Integer.toString(score));
        currentScore.setStyle(
                "-fx-font-size: 50;" +
                        "-fx-fill: white;"
        );
        currentScore.setY(280);
        currentScore.setX(220);

        return currentScore;
    }

    private StackPane renderBestScoreHeader(){

        StackPane root = new StackPane();
        Rectangle scoreRect = new Rectangle(0, 0, 500, 75);
        scoreRect.setFill(Paint.valueOf("#F39734"));

        Text scoreText = new Text("BEST SCORE");
        scoreText.setStyle(
                "-fx-font-size: 50;" +
                        "-fx-fill: white;"
        );

        root.getChildren().addAll(scoreRect, scoreText);
        root.setLayoutX(0);
        root.setLayoutY(300);
        return root;

    }
    private Text renderBestScore(int score){
        Text currentScore = new Text(Integer.toString(score));
        currentScore.setStyle(
                "-fx-font-size: 50;" +
                        "-fx-fill: white;"
        );
        currentScore.setY(450);
        currentScore.setX(200);

        return currentScore;
    }

    private StackPane renderRestartButton(){
        StackPane root = new StackPane();

        Button button = new Button();
        button.setStyle(
                "-fx-background-radius: 5em; " +
                        "-fx-min-width: 120px; " +
                        "-fx-min-height: 120px; " +
                        "-fx-max-width: 120px; " +
                        "-fx-max-height: 120px;" +
                        "-fx-background-color: transparent"
        );

        EventHandler<ActionEvent> restartGame =
                e -> {
                    this.primaryStage.setScene(this.gameMain);
                };
        button.setOnAction(restartGame);

        Image image = new Image("file:assets/images/restartGame.png");
        ImageView restartImageButton = new ImageView(image);
        restartImageButton.setPreserveRatio(true);
        restartImageButton.setFitWidth(120);
        root.setLayoutX(180);
        root.setLayoutY(500);


        root.getChildren().addAll(restartImageButton, button);
        return root;



    }



}
