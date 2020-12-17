package sample;


import javafx.scene.Group;

abstract class gameElement {
    int speed;
    abstract void move(double y);
    abstract Group getNode();
    abstract void setLayoutY(double y);
    abstract double getLayoutY();
    abstract void levelUp();
    abstract void startAnimation();
    abstract void pauseAnimation();
}
