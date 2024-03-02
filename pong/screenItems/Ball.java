package screenItems;

import eventHandler.CollisionDetector;
import exceptions.FrameLayoutException;
import geometry.Ellipse;
import processing.core.PApplet;

//import screenItems.ScreenSides;

/**
 * This ball class is meant to interact with Paddles for pong.Paddles are a
 * separate class in the same package, which are rectangular items.
 * This specific ball class restricts you to only 2 paddles at the moment, but could be
 * updated in the future to handle other possible uses of the ball class.
 * @author Adam Cichoski
 */
public class Ball extends Ellipse {
    private float startX, startY,xSpeed, ySpeed,screenHeight,screenWidth;
    private Paddle player, opponent, current;
    private ScreenSides screenSide, screenBound;

    /**
     * Constructor
     * @param screen
     * @param x
     * @param y
     */
    public Ball(PApplet screen, float x, float y, float diameter){
        super(screen,x,y, diameter);
        startX=x;
        startY=y;
        this.xSpeed = 5;
        this.ySpeed=5;
        screenHeight = screen.height-DIFF;
        screenWidth = screen.width-DIFF;
    }

    /**
     * Sets the pace of movement for the ball to move around the map by changing x and y positions
     */
    public void step() {
        screenSide = updateScreenSide();
        screenBound = updateScreenBound();
        current = (screenSide == player.getScreenSide())? player: opponent;
        updateX();
        updateY();


//        ySpeed = (float) ((ySpeed > 0) ? (-1 * ((Math.random() * 3) + 5)) : ((Math.random() * 3) + 5));

    }

    /**
     *
     */
    public void updateY(){
        ySpeed*=(boundsCollision())? -1:1;
        current.getLowerY();
        y+=ySpeed;
    }

    /**
     *
     */
    public void updateX(){
        xSpeed *= (paddleCollide(current) || getLeftX() == 0 || getRightX() == screenWidth) ? -1 : 1;
        x+= xSpeed;
    }
    public boolean boundsCollision(){
        return CollisionDetector.screenTopAndBottomCollision(this, screen.height, 0);
    }
    /**
     * Used to render the ball onto the screen
     */
    public void render(){
        step();
        screen.ellipse(x,y,DIAMETER,DIAMETER);
    }

    /**
     *
     */
    public void testRender(){
        screen.ellipse(screen.mouseX, screen.mouseY, DIAMETER, DIAMETER);
    }

    /**
     *
     * @param paddle
     * @return
     */
    public boolean paddleCollide(Paddle paddle) {
        return CollisionDetector.ellipseRectangleCollision(paddle, this);
    }

    /**
     *
     */
    public void reset(){
        x = startX;
        y= startY;
    }

    public void setPlayer(Paddle player){
        this.player = player;
    }

    public void setOpponent(Paddle opponent){
        this.opponent = opponent;
    }


    /**
     *Used to determine if the ball is in the left or right side of the screen
     * @return True if on the right side, False if on the left side
     */
    public ScreenSides updateScreenSide(){
        return this.x>super.screen.width/2? ScreenSides.RIGHT:ScreenSides.LEFT;
    }

    /**
     * Used to determine if the ball is in the upper or lower half of the screen
     * @return True if in the upper half, False if Y is in the lower half
     */
    public ScreenSides updateScreenBound(){
        return y>screen.height/2? ScreenSides.TOP : ScreenSides.BOTTOM;
    }

}
