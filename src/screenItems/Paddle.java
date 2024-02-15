package screenItems;

import processing.core.PApplet;
public class Paddle {

    private final float HEIGHT = 80;
    private final float WIDTH = 10;
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
    public Paddle(PApplet screen, float xPos, float yPos){
        this.screen = screen;
        this.xPos = xPos;
        this.yPos = yPos;
        setScreenSide();
    }

    public void step(){
        yPos = screen.mouseY - HEIGHT/2;
    }

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
    public float getHeight(){
        return this.HEIGHT;
    }
    public float getWidth(){
        return this.WIDTH;
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
                float[] left = {getX(), getY(), getX(), getY()+HEIGHT};
                return left;
            case "right":
                float[] right = {getX()+WIDTH, getY(), getX()+WIDTH, getY()+HEIGHT};
                return right;
            case "top":
                float[] top = {getX(), getY(), getX()+WIDTH, getY()};
                return top;
            case "bottom":
                float[] bottom = {getX(), getY()+HEIGHT, getX()+WIDTH, getY()+HEIGHT};
                return bottom;
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
     * This sets the side of the screen that the paddle is on. If it is on the left side of the
     * screen, the value is false, otherwise it is true
     */
    private void setScreenSide(){
        screenSide = xPos>screen.width/2;
    }
    public boolean getScreenSide(){
        return screenSide;
    }
    public float getFront(){
        return (screenSide)? xPos: xPos+WIDTH;
    }

    public boolean collision(Ball b){
        return checkTop(b) || checkBottom(b) || checkLeft(b) || checkRight(b);
    }
    private boolean checkTop(Ball b){

        return false;
    }

    /**
     *
     * @param b
     * @return
     */
    private boolean checkBottom(Ball b){
        return false;
    }

    /**
     *
     * @param b
     * @return
     */
    private boolean checkLeft(Ball b){
        return false;
    }

    /**
     *
     * @param b
     * @return
     */
    private boolean checkRight(Ball b){
        return false;
    }
}
