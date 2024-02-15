import processing.core.PApplet;
import screenItems.*;
import gameStates.*;

public class Main extends PApplet{

    Ball ball;
    Paddle player;
    Paddle opponent;
    //Game running is set to true when the game is running; True if not game over

    static GamePaused game;
    boolean gameRunning = true;
    public void settings(){
        size(800,500);
        player = new Paddle(this, width-20, height/2);
        ball = new Ball(this, width/2, height/2);
        opponent = new Paddle(this, 10, height/2);
        ball.addPaddle(player);
        ball.addPaddle(opponent);

        game = new GamePaused(this);
    }

    public void draw(){
        background(0,0,0);
//        checkBoundsCollision();
        if(gameRunning){
            ball.step();
            player.step();
            opponent.step();
        }
        ball.render();
        player.render();
//        opponent.enemyRender(ball);

        opponent.render();

        testing();

    }

    public void checkBoundsCollision(){
        gameRunning = ball.getX() != width;
    }

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
    public static void main(String[] args) {
        String[] appletArgs = new String[] { "Main" };
        PApplet.main(appletArgs);
    }



    public static void testing(){

    }


}