package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.Scene;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.concurrent.TimeUnit;

public class firstScreen{
    public Scene scene;
    private Circle cir;
    private circle circle1;

    public firstScreen(Stage primaryStage, startScreen startScreen){
        Pane root = new Pane();
        int xCoordinate = 250;
        int yCoordinate = 334;
        int radius1 = 90;
        root.setStyle("-fx-background-color: rgb(39, 39, 39)");
        scene = new Scene(root, 500 , 700);
        cir = new Circle();
        cir.setFill(Color.DEEPPINK);
        cir.setRadius(15);
        cir.setLayoutX(250);
        cir.setLayoutY(635);
        circle1 = new circle(xCoordinate, yCoordinate, radius1, 23, 1);
        root.getChildren().addAll(cir ,circle1.circle);
        TranslateTransition trans = new TranslateTransition();
        trans.setDuration(Duration.millis(250));
        trans.setAutoReverse(true);
        trans.setCycleCount(4);
        trans.setToY(-70);
        trans.setNode(cir);
        trans.play();
        trans.setOnFinished((e)->{
            TranslateTransition trans1 = new TranslateTransition();
            trans1.setDuration(Duration.millis(250));
            trans1.setToY(-304);
            trans1.setNode(cir);
            trans1.play();
            trans1.setOnFinished((e1)->{
                cir.setFill(Color.WHITE);
                Reflection ref = new Reflection();
                ref.setBottomOpacity(0.2);
                ref.setFraction(12);
                ref.setTopOffset(-7);
                ref.setTopOpacity(0.2);
                cir.setEffect(ref);
                circle1.pauseRotation();
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.1);
                circle1.setEffect(bloom);

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }

                primaryStage.setScene(startScreen.scene);
            });



        });

    }


}
