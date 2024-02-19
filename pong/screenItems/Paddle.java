package screenItems;

import geometry.Rectangle;
import processing.core.PApplet;
public class Paddle extends Rectangle {
    private float xPos;
    private float yPos;
    private PApplet screen;

    private boolean screenSide;

    /**
     * Constructor
     * @param screen is the PApple screen
     * @param xPos inputted starting x position on the screen
     * @param yPos inputted starting y position on the screen
     */
    public Paddle(PApplet screen, float xPos, float yPos, float WIDTH, float HEIGHT){
        super(WIDTH, HEIGHT);
        this.screen = screen;
        this.xPos = xPos;
        this.yPos = yPos;
        setScreenSide();
    }

    /**
     * Updating the displacement of the paddle
     */
    public void step(){
        yPos = screen.mouseY - HEIGHT/2;
    }

    /**
     * Updates the display of the paddle
     */
    public void render(){
        screen.rect(xPos, yPos, WIDTH, HEIGHT);
    }

    public void enemyRender(Ball b){
        screen.rect(xPos, b.getY()-(HEIGHT/2), WIDTH, HEIGHT);
    }
    public float getX(){
        return this.xPos;
    }
    public float getY(){
        return this.yPos;
    }

    /**
     * This sets the side of the screen that the paddle is on. If it is on the left side of the
     * screen, the value is false, otherwise it is true
     */
    private void setScreenSide(){
        screenSide = xPos>screen.width/2;
    }
    public boolean getScreenSide(){
        return screenSide;
    }

    /**
     * Used to get the coordinates of any given side of a paddle
     * Format of the coordinates: [x1, y1, x2, y2]
     * This format was adopted from the format that is used to create a line using the PApplet class built in methods
     * @param input is used to determine which side of the paddle will be returned as an array of line points
     * @return the array of coordinates
     */
    public float[] getSide(String input){
        switch(input.toLowerCase()){
            case "left":
                return getLeftSide();
            case "right":
                return getRightSide();
            case "top":
                return getTop();
            case "bottom":
                return getBottom();
            default:
                System.out.println("Invalid Input For screenItems.Paddle Side");
                break;
        }
        return null;
    }

    /**
     * This returns the top and bottom y points of the paddle
     * This is in the format of {bottom, top}
     * @return an array of the top and bottom of the paddle
     */
    public float[] getYBounds(){
        float[] yBounds = {getY(), getY()+HEIGHT};
        return yBounds;
    }

    /**
     * Returns an array of the side coordinates
     * @return {leftX, topY, rightX, bottomY}
     */
    public float[] getSides(){
        float sides[] = {getX(), getY(), getX()+WIDTH, getY()+HEIGHT};
        return sides;
    }

    /**
     * Returns the left side of the paddle
     * @return float {x1, y1, x2, y2}
     */
    public float[] getLeftSide(){
        float leftSide[] = {getX()+WIDTH,getY(), getX()+WIDTH, getY()+HEIGHT};
        return leftSide;
    }

    /**
     * Returns the right side of the paddle
     * @return float {x1, y1, x2, y2}
     */
    public float[] getRightSide(){
        float rightSide[] = {getX(), getY(), getX(), getY()+HEIGHT};
        return rightSide;
    }

    /**
     * Returns the top side of the paddle
     * @return float {x1, y1, x2, y2}
     */
    public float[] getTop(){
        float top[] = {getX(), getY(), getX()+WIDTH, getY()};
        return top;
    }

    /**
     * Returns the bottom side of the paddle
     * @return float {x1, y1, x2, y2}
     */
    public float[] getBottom(){
        float bottom[] = {getX(), getY()+HEIGHT, getX()+WIDTH, getY()+HEIGHT};
        return bottom;
    }
}
