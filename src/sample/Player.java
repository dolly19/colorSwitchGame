package sample;

import javafx.scene.shape.Circle;

public class Player {
    public playerBall ball;
    private int score;

    Player(){
        this.ball = playerBall.getInstance();
        this.score  = 0;
    }

    public void jump(double y){
        ball.move(y);
    }

    public void setScore(int i){
        score = i;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore(){
        score++;
    }

}
