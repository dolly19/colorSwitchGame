package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.print.attribute.standard.RequestingUserName;
import java.io.File;
import java.util.Random;

public class settingsScreen implements java.io.Serializable {
    public Scene scene;
    private Button stopButton;
    private Button playButton ;
    private Button changeButton ;
    private Button homeButton;
    private MediaPlayer mediaPlayer;
    private Media media;
    private Stage primaryStage;
    private String[] musicPlaylist;


    settingsScreen(gameMain gameMainScreen){

        deSerialize(gameMainScreen);

    }

    public void deSerialize(gameMain gameMainScreen){
        this.primaryStage = gameMainScreen.primaryStage;

        musicPlaylist = new String[]{"Cave.mp3", "Hop.mp3", "Summer.mp3", "theme.mp3"};

        VBox root = new VBox(50);
        root.setStyle("-fx-background-color: rgb(39,39,39)");
        scene = new Scene(root, 500, 700);

        scene.getStylesheets().add("settingScreen.css");

        stopButton = new Button("STOP MUSIC");
        playButton= new Button("PLAY MUSIC");
        changeButton = new Button("CHANGE MUSIC");
        homeButton = new Button();
        homeButton.getStyleClass().add("homeButton");
        playButton.getStyleClass().add("playButton");
        stopButton.getStyleClass().add("stopButton");
        changeButton.getStyleClass().add("changeButton");

        stopButton.setOnAction(actionEvent -> musicStop());
        playButton.setOnAction(actionEvent -> musicPlay());
        changeButton.setOnAction(actionEvent -> musicChange());
        setUpHomeButton(gameMainScreen.scene);


        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(homeButton,stopButton,playButton,changeButton);
        musicPlay();


    }
    private void setUpHomeButton(Scene scene){
        Image image = new Image("file:assets/images/homeButton.png");
        ImageView homeButtonImage = new ImageView(image);
        homeButtonImage.setFitWidth(75);
        homeButtonImage.setFitHeight(130);
        homeButtonImage.setPreserveRatio(true);
        homeButton.setGraphic(homeButtonImage);

        EventHandler<ActionEvent> toSettings =
                e -> {
                    this.primaryStage.setScene(scene);
                };
        homeButton.setOnAction(toSettings);

    }

    private void musicPlay(){
        String path = "./music/theme.mp3";

        media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    private void musicStop(){
        mediaPlayer.pause();
    }
    private void musicChange(){
        Random rand = new Random();
        String path = "music/";
        path += musicPlaylist[rand.nextInt(4)];
        media = new Media(new File(path).toURI().toString());
        mediaPlayer.stop();
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

}
