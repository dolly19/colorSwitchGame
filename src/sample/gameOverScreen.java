package sample;

import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
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
import javafx.util.Duration;


public class gameOverScreen implements java.io.Serializable {
    transient public Scene scene;
    transient private Pane root;
    transient private Stage primaryStage;
    transient private Scene gameMain;
    transient private gameplay gameplayScreen;
    transient private Text finalScore;

    public gameOverScreen(gameplay gameplayScreen){

        this.gameplayScreen = gameplayScreen;
        deSerialize();

    }
    public void deSerialize(){
        this.primaryStage = gameplayScreen.primaryStage;
        this.gameMain = gameplayScreen.gameMain;
        this.gameplayScreen = gameplayScreen;

        root = new Pane();
        root.getChildren().addAll(renderTopAnimation(), renderBackButton(), renderScoreHeader(), renderScore(),
                renderBestScoreHeader(), renderBestScore(), renderResumeButton(), renderRestartButton());
        root.setStyle("-fx-background-color: #272327;");
        scene = new Scene(root, 500, 700);
        scene.getStylesheets().add("gameOver.css");
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

    private Button renderBackButton(){

        Button button = new Button();
        button.setStyle(
                        "-fx-background-color: transparent"
        );

        EventHandler<ActionEvent> goToHome =
                e -> {
                    this.primaryStage.setScene(this.gameMain);
                    this.gameplayScreen.restartGame();
                };
        button.setOnAction(goToHome);

        Image image = new Image("file:assets/images/pauseScreenBackButton.png");
        ImageView topImageView = new ImageView(image);
        topImageView.setPreserveRatio(true);
        topImageView.setFitWidth(70);

        button.setGraphic(topImageView);

        button.setLayoutX(30);
        button.setLayoutY(35);

        return  button;
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
    private Text renderScore(){
        finalScore = new Text("0");
        finalScore.setStyle(
                "-fx-font-size: 50;" +
                        "-fx-fill: white;"
        );
        finalScore.setY(280);
        finalScore.setX(220);

        return finalScore;
    }
    public void setFinalScore(String s){
        finalScore.setText(s);
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
    private Text renderBestScore(){
        Text currentScore = new Text("100");
        currentScore.setStyle(
                "-fx-font-size: 50;" +
                        "-fx-fill: white;"
        );
        currentScore.setY(430);
        currentScore.setX(200);

        return currentScore;
    }

    private Button renderResumeButton(){
        Button resumeButton = new Button("Continue");
        resumeButton.getStyleClass().add("resumeButton");

        EventHandler<ActionEvent> resumeGame =
                e -> {
                    int totalStars = gameplayScreen.player.getScore();
                    int penalty = 5;
                    if(totalStars - penalty >= 0){
                        gameplayScreen.player.setScore(gameplayScreen.player.getScore() - penalty);
                        gameplayScreen.updateScoreboard(String.valueOf(totalStars - penalty));
                        gameplayScreen.player.ball.makeItWhite();
                        gameplayScreen.startGame();
                        primaryStage.setScene(gameplayScreen.getScene());
                    }


                };
        resumeButton.setOnAction(resumeGame);
        resumeButton.setLayoutX(130);
        resumeButton.setLayoutY(630);
        return resumeButton;
    }
    private StackPane renderRestartButton(){
        StackPane root = new StackPane();

        Button button = new Button();
        button.getStyleClass().add("restartButton");

        EventHandler<ActionEvent> restartGame =
                e -> {
                    this.gameplayScreen.restartGame();
                    this.primaryStage.setScene(this.gameplayScreen.getScene());
                };
        button.setOnAction(restartGame);

        Image image = new Image("file:assets/images/restartGame.png");
        ImageView restartImageButton = new ImageView(image);
        restartImageButton.setPreserveRatio(true);
        restartImageButton.setFitWidth(120);
        root.setLayoutX(180);
        root.setLayoutY(460);

        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setDuration(Duration.millis(1000));
        scaleTransition.setNode(restartImageButton);
        scaleTransition.setByY(0.2);
        scaleTransition.setByX(0.2);
        scaleTransition.setCycleCount(500);
        scaleTransition.setInterpolator(Interpolator.LINEAR);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();

        root.getChildren().addAll(restartImageButton, button);
        return root;

    }



}
