package interactable;

import eventHandler.Action;
import geometry.Rectangle;
import graphics.Colors;
import processing.core.PApplet;
import processing.core.PImage;

public abstract class Button extends Rectangle {
    private float tempWidth, tempHeight, tempX, tempY;
    private boolean hasImage;
    private Colors color;
    private PImage photo;
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
        tempWidth = WIDTH * 1.03f;
        tempHeight = HEIGHT * 1.03f;
        tempX = x - (x * (0.03f*0.5f));
        tempY = y - (y * (0.03f*0.5f));
    }

    /**
     *
     */
    public void render(){
        if(hasImage){
            pRender();
            return;
        }
        Colors.fill(color);
        if(checkButtonFocused()){
            renderButtonFocused();
            if(checkButtonPressed()){
                this.buttonAction();
            }
        }
        else{
            screen.rect(x,y,WIDTH,HEIGHT);
        }
        Colors.fill(Colors.WHITE);
    }

    /**
     *
     */
    private void pRender(){
        if(checkButtonFocused()){
            renderButtonFocused();
            if(checkButtonPressed()){
                this.buttonAction();
            }
        }
        else{
            screen.image(photo,x,y,WIDTH,HEIGHT);
        }
    }

    /**
     *
     * @param color
     */
    public void setColor(Colors color){
        this.color = color;
    }
    private void renderButtonFocused(){
        if(hasImage){
            screen.image(photo, tempX, tempY, tempWidth, tempHeight);
            return;
        }
        screen.rect(tempX, tempY, tempWidth, tempHeight);
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

    /**
     *
     * @param imageFilePath
     */
    public void addImage(String imageFilePath){
        this.photo = screen.loadImage(imageFilePath);
        this.hasImage = true;
    }
}
