package screenItems;

import exceptions.CollisionDetector;
import geometry.Ellipse;
import processing.core.PApplet;

/**
 * This ball class is meant to interact with Paddles for pong.Paddles are a
 * separate class in the same package, which are rectangular items.
 * This specific ball class restricts you to only 2 paddles at the moment, but could be
 * updated in the future to handle other possible uses of the ball class.
 * @author Adam Cichoski
 */
public class Ball extends Ellipse {
    private float x, y, startX, startY,xSpeed, ySpeed;
    private final float size =30;
    private final float DIFF = size/2;
    public PApplet screen;
    private Paddle[] paddles;
    private boolean screenSide;

    /**
     * Constructor
     * @param screen
     * @param x
     * @param y
     */
    public Ball(PApplet screen, float x, float y){
        startX=x;
        startY=y;
        this.x=x;
        this.y=y;
        this.screen = screen;
        this.xSpeed = 5;
        this.ySpeed=5;
        paddles = new Paddle[2];
    }

    /**
     * Sets the pace of movement for the ball to move around the map by changing x and y positions
     */
    public void step(){
        screenSide = getScreenSide();
        boolean screenHeightBound = getScreenHeightBound();
        Paddle usedPaddle = (getScreenSide())? paddles[0]: paddles[1];
        x+= xSpeed;
        if(paddleCollide(usedPaddle) || x==0+DIFF || x == screen.width - DIFF){
            xSpeed*=-1;
        }
        y+=ySpeed;
        if(y<0+DIFF || y> screen.height-DIFF){
            y = (screenHeightBound)? screen.height-DIFF: 0+DIFF;
            ySpeed = (float) ((ySpeed > 0) ? (-1 * ((Math.random() * 3) + 5)) : ((Math.random() * 3) + 5));
        }

    }

    /**
     * Used to render the ball onto the screen
     */
    public void render(){
        screen.ellipse(x,y,size,size);
    }

    public void testRender(){

        screen.ellipse(screen.mouseX, screen.mouseY, size, size);
    }

    /**
     *
     * @param paddle
     * @return
     */
    public boolean paddleCollide(Paddle paddle){
        return CollisionDetector.collideRect(paddle, this);
    }

    /**
     *
     */
    public void reset(){
        x = startX;
        y= startY;
    }

    /**
     *
     * @param p
     */
    public void addPaddle(Paddle p){
        if(paddles[0]!=null){
            paddles[1] = p;
        }else{
            paddles[0] = p;
        }
    }

    /**
     *
     * @param p
     */
    public void addPaddles(Paddle[] p){
        if (p.length == paddles.length){
            paddles = p;
        }else{
            System.out.println("Invalid screenItems.Paddle Array Size For method: addPaddles()");
        }
    }

    public float getY(){
        return this.y;
    }
    public float getAdjustedX(){
        return (screenSide)? getRightX(): getLeftX();
    }
    public float getLeftX(){return x-DIFF;}
    public float getRightX(){return x+DIFF;}
    public float getX(){return x;}
    public float getLowerY(){return y+DIFF;}
    public float getUpperY(){return y-DIFF;}
    public boolean getScreenSide(){
        return this.x>screen.width/2;
    }

    public boolean getScreenHeightBound(){
        return y>screen.height/2;
    }
    public float getYSpeed(){
        return this.ySpeed;
    }
    public float getXSpeed(){
        return this.ySpeed;
    }
}
