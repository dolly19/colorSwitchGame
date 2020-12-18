package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class star implements java.io.Serializable {
    transient private ImageView star;
    public star(){
        deSerialize();
    }

    public void deSerialize(){
        Image image = new Image("file:assets/images/star.png");
        star = new ImageView(image);
        star.setPreserveRatio(true);
        star.setFitHeight(30);
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
