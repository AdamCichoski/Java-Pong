import processing.core.PApplet;
import screenItems.*;
import gameStates.*;

public class Main extends PApplet{

    private Ball ball;
    private Paddle player;

    private Paddle opponent;
    Screen screen;
    //Game running is set to true when the game is running; True if not game over
    boolean gameRunning = true;

    public static void main(String[] args) {
        String[] appletArgs = new String[] { "Main" };
        PApplet.main(appletArgs);
    }
    public void settings(){
        size(800,500);
        player = new Paddle(this, width-20, height/2, 10,80);
        ball = new Ball(this, width/2, height/2, 30);
        opponent = new Paddle(this, 10, height/2, 10,80);
        ball.setPlayer(player);
        ball.setOpponent(opponent);
        screen = new Screen(this);
    }

    public void draw(){
        background(0,0,0);
        if(gameRunning){
        }
        ball.render();
        player.render();
        opponent.enemyRender(ball);

//        opponent.render();

        testing();

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




    public static void testing(){
    }


}