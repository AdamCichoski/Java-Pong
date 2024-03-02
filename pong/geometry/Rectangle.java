package geometry;

import processing.core.PApplet;

/**
 *
 * @author Adam Cichoski
 */
public class Rectangle {
    public final float WIDTH;
    public final float HEIGHT;
    protected float x;
    protected float y;
    protected PApplet screen;
    private short rgbColor;

    /**
     * Constructor
     * @param WIDTH
     * @param HEIGHT
     */
    public Rectangle(PApplet screen, float x, float y, float WIDTH, float HEIGHT){
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.x = x;
        this.y = y;
        this.screen = screen;
    }

    /**
     *
     * @return
     */
    public float getLeftX(){
        return this.x;
    }

    /**
     *
     * @return
     */
    public float getRightX(){
        return this.x+WIDTH;
    }

    /**
     *
     * @return
     */
    public float getLowerY(){
        return this.y;
    }

    /**
     *
     * @return
     */
    public float getUpperY(){
        return this.y+HEIGHT;
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
        float[] yBounds = {getLowerY(), getUpperY()};
        return yBounds;
    }

    /**
     * Returns an array of the side coordinates
     * @return {leftX, topY, rightX, bottomY}
     */
    public float[] getSides(){
        float sides[] = {getLeftX(), getLowerY(), getRightX(), getUpperY()};
        return sides;
    }

    /**
     * Returns the left side of the paddle
     * @return float {x1, y1, x2, y2}
     */
    public float[] getLeftSide(){
        float leftSide[] = {getLeftX(),getLowerY(), getLeftX(), getUpperY()};
        return leftSide;
    }

    /**
     * Returns the right side of the paddle
     * @return float {x1, y1, x2, y2}
     */
    public float[] getRightSide(){
        float rightSide[] = {getRightX(), getLowerY(), getRightX(), getUpperY()};
        return rightSide;
    }

    /**
     * Returns the top side of the paddle
     * @return float {x1, y1, x2, y2}
     */
    public float[] getTop(){
        float top[] = {getLeftX(), getLowerY(), getRightX(), getLowerY()};
        return top;
    }

    /**
     * Returns the bottom side of the paddle
     * @return float {x1, y1, x2, y2}
     */
    public float[] getBottom(){
        float bottom[] = {getLeftX(), getUpperY(), getRightX(), getUpperY()};
        return bottom;
    }

    public void setColor(short rgbColor){
        this.rgbColor = rgbColor;
    }

}
