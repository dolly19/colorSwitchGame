package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class star {
    private ImageView star;
    public star(){
        Image image = new Image("file:assets/images/star.png");
        star = new ImageView(image);
        star.setPreserveRatio(true);
        star.setFitHeight(30);
//        img.setX(235);
//        img.setY(-2);
        star.setLayoutX(235);
        star.setLayoutY(0);
    }


    public void setLayoutY(double y){
        star.setLayoutY(y);
    }

    public double getLayoutY() {
        return star.getLayoutY();
    }

    public void move(double y){
        star.setLayoutY(star.getLayoutY() + y);
    }

    public ImageView getNode(){
        return star;
    }

}
