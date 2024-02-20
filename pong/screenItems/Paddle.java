package screenItems;

import geometry.Rectangle;
import processing.core.PApplet;
public class Paddle extends Rectangle {
    private boolean screenSide;

    /**
     * Constructor
     * @param screen is the PApple screen
     * @param x inputted starting x position on the screen
     * @param y inputted starting y position on the screen
     */
    public Paddle(PApplet screen, float x, float y, float WIDTH, float HEIGHT){
        super(screen,x,y, WIDTH, HEIGHT);
        setScreenSide();
    }

    /**
     * Updating the displacement of the paddle
     */
    public void step(){
        y = screen.mouseY - HEIGHT/2;
    }

    /**
     * Updates the display of the paddle
     */
    public void render(){
        screen.rect(x, y, WIDTH, HEIGHT);
    }

    public void enemyRender(Ball b){
        screen.rect(x, b.getY()-(HEIGHT/2), WIDTH, HEIGHT);
    }

    /**
     * This sets the side of the screen that the paddle is on. If it is on the left side of the
     * screen, the value is false, otherwise it is true
     */
    private void setScreenSide(){
        screenSide = x>screen.width/2;
    }
    public boolean getScreenSide(){
        return screenSide;
    }

}
