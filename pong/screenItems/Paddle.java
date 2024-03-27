package screenItems;

import geometry.Rectangle;
import graphics.Colors;
import processing.core.PApplet;
public class Paddle extends Rectangle {
    private short score=0;
    private boolean hasColor = false, isPlayer;
    private float scoreX, scoreY;
    private ScreenSides screenSide;
    private PaddleType paddleType;
    private Ball ball;

    private Colors color;

    /**
     * Constructor
     * @param screen is the PApple screen
     * @param x inputted starting x position on the screen
     * @param y inputted starting y position on the screen
     */
    public Paddle(PApplet screen,  float x, float y, float WIDTH, float HEIGHT, Ball ball){
        super(screen,x,y, WIDTH, HEIGHT);
        this.ball = ball;
        setScreenSide();
        setType();
        scoreY = 40;
        scoreX = (screenSide == ScreenSides.LEFT)? screen.width/3f: 2f*screen.width/3f;
    }

    /**
     * Updating the displacement of the paddle
     */
    public void step(){
        if(paddleType == PaddleType.PLAYER) {
            y = screen.mouseY - HEIGHT / 2;
        }else{
            y = ball.getY() - (HEIGHT /2);
        }
    }

    /**
     * Updates the display of the paddle
     */
    public void render(){
        step();
        if(hasColor){
            Colors.fill(color);
        }
        screen.rect(x, y, WIDTH, HEIGHT);
        Colors.fill(Colors.WHITE);
        displayScore();
    }

    /**
     * Used to increment the score by 1
     */
    public void incrementScore(){
        score++;
    }
    /**
     *
     * @param color
     */
    public void setColor(Colors color){
        this.color = color;
        this.hasColor = true;
    }
    private void displayScore(){
        screen.text(score, scoreX, scoreY);
    }

    /**
     *
     */
    public void removeColor(){
        this.hasColor = false;
    }



    /**
     * This sets the side of the screen that the paddle is on. If it is on the left side of the
     * screen, the value is false, otherwise it is true
     */
    private void setScreenSide(){
        screenSide = x>screen.width/2? ScreenSides.RIGHT: ScreenSides.LEFT;
    }
    public ScreenSides getScreenSide(){
        return screenSide;
    }

    private void setType(){
        this.paddleType = (screenSide == ScreenSides.RIGHT)? PaddleType.PLAYER : PaddleType.OPPONENT;
    }
    public PaddleType getType(){
        return paddleType;
    }

    /**
     * Determines the
     */
    public enum PaddleType{
        PLAYER,
        OPPONENT;
    }

}
