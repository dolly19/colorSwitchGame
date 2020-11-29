package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class star {
    ImageView star;
    TranslateTransition translate;
    public star(){
        translate = new TranslateTransition();

        Image image = new Image("file:assets/images/star.jpeg");
        star = new ImageView(image);
        star.setPreserveRatio(true);
        star.setFitHeight(30);
        star.setX(235);
        star.setY(340);

    }

    public void moveDownBy(int x){
//        System.out.println("I am here");
        translate.setByY(x);
        translate.setDuration(Duration.millis(300));
        translate.setCycleCount(1);
        translate.setNode(star);
        translate.play();
    }

    public void hide(){
        star.setFitWidth(0);
    }


}
