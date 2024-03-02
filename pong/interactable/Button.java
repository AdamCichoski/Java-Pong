package interactable;

import eventHandler.Action;
import geometry.Rectangle;
import processing.core.PApplet;

public abstract class Button extends Rectangle {

    /**
     * Constructor
     *
     * @param screen
     * @param x
     * @param y
     * @param WIDTH
     * @param HEIGHT
     */
    public Button(PApplet screen, float x, float y, float WIDTH, float HEIGHT) {
        super(screen, x, y, WIDTH, HEIGHT);
    }

    /**
     * Can be filled in using Lambda
     * Determines the event that occurs when the button is pressed
     */
    public abstract void buttonAction();

    /**
     * Checks if the button has been pressed
     * @return
     */
    public boolean checkButtonPressed(){
        return checkButtonFocused() && checkMouseClicked();
    }

    /**
     * Checks if the mouse has been clicked
     * @return
     */
    private boolean checkMouseClicked(){
        return Action.checkMouseClicked(screen);
    }

    /**
     * Determines if the button is being focused, meaning that the mouse is hovering over the button
     * @return
     */
    public boolean checkButtonFocused(){
        return (screen.mouseX < getRightX() && screen.mouseX > getLeftX()) && (screen.mouseY < getUpperY() && screen.mouseY > getLowerY());
    }
}
