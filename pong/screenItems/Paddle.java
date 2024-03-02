package screenItems;

import geometry.Rectangle;
import processing.core.PApplet;
public class Paddle extends Rectangle {
    private ScreenSides screenSide;
    private PaddleType paddleType;

    /**
     * Constructor
     * @param screen is the PApple screen
     * @param x inputted starting x position on the screen
     * @param y inputted starting y position on the screen
     */
    public Paddle(PApplet screen, float x, float y, float WIDTH, float HEIGHT){
        super(screen,x,y, WIDTH, HEIGHT);
        setScreenSide();
        setType();
    }

    /**
     * Updating the displacement of the paddle
     */
    public void step(){
        y = screen.mouseY - HEIGHT/2;
    }
    public void enemyStep(Ball b){
        y = b.getY() - (HEIGHT /2);
    }

    /**
     * Updates the display of the paddle
     */
    public void render(){
        step();
        screen.rect(x, y, WIDTH, HEIGHT);
    }

    public void enemyRender(Ball b){
        enemyStep(b);
        screen.rect(x, y, WIDTH, HEIGHT);
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
