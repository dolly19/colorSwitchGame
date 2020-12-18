package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class loadGame {
    transient private Pane root;
    transient public Scene scene;
    transient public gameMain gameMainScreen;

    public loadGame(gameMain gameMainScreen) {
        deSerialize(gameMainScreen);
    }
    public void deSerialize(gameMain gameMainScreen){
        this.gameMainScreen = gameMainScreen;
        this.root = new Pane();
        this.root.setStyle("-fx-background-color: #272327");
        scene = new Scene(root, 500, 700);
        Rectangle rect = new Rectangle();
        rect.setX(0);
        rect.setY(0);
        rect.setWidth(500);
        rect.setHeight(114);
        rect.setFill(Color.DEEPPINK);
        Text text = new Text();
        text.setText("SAVED GAME");
        text.setX(125);
        text.setY(70);
        text.setStyle("-fx-font-size: 45 ; -fx-font-weight: Bold; " );
        text.setFill(Color.WHITE);


        Image image = new Image("file:assets/images/homeButton.png");
        ImageView homeButtonImage = new ImageView(image);
        homeButtonImage.setX(40);
        homeButtonImage.setY(20);
        homeButtonImage.setFitHeight(75);
        homeButtonImage.setFitWidth(75);
        homeButtonImage.setPreserveRatio(true);

        Button homeButton = new Button();
        homeButton.setStyle(
                "-fx-background-radius: 5em; " +
                        "-fx-min-width: 75px; " +
                        "-fx-min-height: 75px; " +
                        "-fx-max-width: 75px; " +
                        "-fx-max-height: 75px;" +
                        "-fx-background-color: transparent"
        );
        homeButton.setLayoutX(40);
        homeButton.setLayoutY(20);

        EventHandler<ActionEvent> goToHome =
                e -> {
                    this.gameMainScreen.primaryStage.setScene(this.gameMainScreen.scene);
                };
        homeButton.setOnAction(goToHome);


        Button btn1 = new Button("LEVEL 10");
        btn1.setStyle(
                "-fx-border-color: #FAE100;" + " -fx-text-fill: #FAE100;" +
                        "-fx-min-width: 220px;" +
                        "-fx-max-height: 0px;" + "-fx-background-color: transparent;"+ " -fx-font-size: 2em;" +
                        "-fx-border-width: 3 3 3 3; " +
                        "-fx-border-radius: 30; " );


        Button btn2 = new Button("LEVEL 8");
        btn2.setStyle("-fx-border-color:  #32DBF0;" + " -fx-text-fill: #32DBF0;" +
                "-fx-min-width: 220px;" +
                "-fx-max-height: 0px;" + "-fx-background-color: transparent;"+ " -fx-font-size: 2em;" +
                "-fx-border-width: 3 3 3 3; " +
                "-fx-border-radius: 30; " );
        Button btn3 = new Button("LEVEL 5");
        btn3.setStyle("-fx-border-color: #FF0181;" + " -fx-text-fill: #FF0181;" +
                "-fx-min-width: 220px;" +
                "-fx-max-height: 0px;" + "-fx-background-color: transparent;"+ " -fx-font-size: 2em;" +
                "-fx-border-width: 3 3 3 3; " +
                "-fx-border-radius: 30; " );
        VBox root1 = new VBox();
        root1 = new VBox(30);
        root1.setLayoutX(130);
        root1.setLayoutY(160);
        root1.getChildren().addAll(btn1,btn2,btn3 );
        root.getChildren().addAll(rect ,text , root1 ,homeButtonImage, homeButton);


    }

}