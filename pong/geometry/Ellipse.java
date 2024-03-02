package geometry;

import processing.core.PApplet;

/**
 * This class stores functions to keep track of ellipses on t
 */
public class Ellipse {
    protected float x, y;
    protected PApplet screen;
    public final float DIAMETER;
    public final float DIFF;

    /**
     *
     * @param screen
     * @param x
     * @param y
     */
    public Ellipse(PApplet screen, float x, float y, float diameter){
        this.screen = screen;
        this.x = x;
        this.y = y;
        this.DIAMETER = diameter;
        this.DIFF = diameter/2;
    }

    public float getX(){return x;}
    public float getY(){
        return this.y;
    }

    /**
     *
     * @return
     */
    public float getLeftX(){return x-DIFF;}

    /**
     *
     * @return
     */
    public float getRightX(){return x+DIFF;}

    /**
     *
     * @return
     */
    public float getLowerY(){return y-DIFF;}

    /**
     *
     * @return
     */
    public float getUpperY(){return y+DIFF;}

}
