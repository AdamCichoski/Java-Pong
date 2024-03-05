import processing.core.PApplet;
import processing.core.PFont;
import screenItems.*;
import time.*;

public class Main extends PApplet{
    private final int SCREEN_WIDTH = 800, SCREEN_HEIGHT = 500;
    public final float playerPaddleX = SCREEN_WIDTH-20;
    //Starting y position for paddles and the ball
    public final float startingY = SCREEN_HEIGHT/2;
    public final float timerX = SCREEN_WIDTH/2, timerY = 40;
    public final float paddleWidth = 10, paddleHeight = 80, ballDiameter = 30;
    boolean gameRunning = true;
    Ball ball;
    Paddle player, opponent;
    PFont font;
    Clock timer;
    Screen screen;
    //Game running is set to true when the game is running; True if not game over


    public static void main(String[] args) {
        String[] appletArgs = new String[] { "Main" };
        PApplet.main(appletArgs);
    }

    /**
     *
     */
    public void setup(){
        font= createFont("Arial", 30, true);
        textFont(font);
    }

    /**
     *
     */
    public void settings(){
        size(SCREEN_WIDTH,SCREEN_HEIGHT);

        player = new Paddle(this, width-20, startingY, paddleWidth,paddleHeight);
        ball = new Ball(this, width/2, startingY, ballDiameter);
        opponent = new Paddle(this, 10, startingY, paddleWidth,paddleHeight);
        ball.setPlayer(player);
        ball.setOpponent(opponent);
        screen = new Screen(this);
        timer = new Clock(this, timerX, timerY);
    }

    /**
     *
     */
    public void draw(){
        background(0,0,0);
        if(gameRunning){
        }
        ball.render();
        player.render();
        opponent.enemyRender(ball);
        timer.beginTick();
        testing();
    }

    /**
     *
     */
    public void keyPressed(){
        switch(key){
            case 'r':
                ball.reset();
                ball.render();
                gameRunning = true;
                break;
            case 'p':
                gameRunning = !gameRunning;
        }
    }




    public static void testing(){
    }


}