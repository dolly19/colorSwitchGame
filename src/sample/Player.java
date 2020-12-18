package sample;


public class Player implements java.io.Serializable {
    transient public playerBall ball;
    private int score;

    Player(){
        this.score  = 0;
        deSerialize();

    }

    public void deSerialize(){
        this.ball = playerBall.getInstance();

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
