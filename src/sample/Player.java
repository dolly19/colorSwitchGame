package sample;

import javafx.scene.shape.Circle;

public class Player {
    public playerBall ball;
    private int score;
    private boolean state;

    Player(){
        this.ball = new playerBall();
        this.score  = 0;
        this.state = true;
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
    public boolean getState(){
        return this.state;
    }
    public void setState(boolean state){
        this.state = state;
    }

    public void increaseScore(){
        score++;
    }


}
