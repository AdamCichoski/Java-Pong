package screenItems;

import processing.core.PApplet;

/**
 * This ball class is meant to interact with Paddles for pong.Paddles are a
 * separate class in the same package, which are rectangular items.
 * This specific ball class restricts you to only 2 paddles at the moment, but could be
 * updated in the future to handle other possible uses of the ball class.
 * @author Adam Cichoski
 */
public class Ball {
    private float x, y, startX, startY,xSpeed, ySpeed;
    private final float size =30;
    private final float diff = size/2;
    public PApplet screen;
    private Paddle[] paddles;
    private boolean screenSide;

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
        if(paddleCollide(usedPaddle) || x==0+diff || x == screen.width - diff){
            xSpeed*=-1;
        }
        y+=ySpeed;
        if(y<0+diff || y> screen.height-diff){
            y = (screenHeightBound)? screen.height-diff: 0+diff;
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
     * Checks for collisions with an inputted paddle
     * @param p is the paddle that will be checked
     */
    private boolean paddleCollide(Paddle p){
        if(p == null){
            return false;
        }
        boolean collidedFront, collidedTop, collidedBottom;
        float paddleFront = p.getFront();
        if((screenSide && x+diff >= paddleFront) || (!screenSide && x-diff <= paddleFront)){
            collidedFront = frontCollision(p.getYBounds()[1], p.getYBounds()[0]);
            collidedTop = topCollision(p);
            collidedBottom = bottomCollision(p);

            //This check switches y direction depending on where the ball hits the paddle
            float paddleSplit = p.getY() + p.getHeight()/2;
            if(y >= p.getYBounds()[0] && y <= p.getYBounds()[1]) {
                ySpeed = (y > paddleSplit)? Math.abs(ySpeed): -1*Math.abs(ySpeed);
            }
            return collidedFront || collidedTop || collidedBottom;
        }
        return false;
    }

    private boolean frontCollision(float upperY, float lowerY){
        return (y>=lowerY && y<= upperY);
    }

    private boolean topCollision(Paddle p){
        if(y-diff == p.getYBounds()[1]){
            ySpeed = -1* (Math.abs(ySpeed));
            return true;
        }
        return false;
    }

    private boolean bottomCollision(Paddle p){
        if(y+diff == p.getYBounds()[0]){
            ySpeed = Math.abs(ySpeed);
            return true;
        }
        return false;
    }

    public void reset(){
        x = startX;
        y= startY;
    }
    public void addPaddle(Paddle p){
        if(paddles[0]!=null){
            paddles[1] = p;
        }else{
            paddles[0] = p;
        }
    }
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
    public float getX(){
        return (screenSide)? x+diff: x-diff;
    }
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
