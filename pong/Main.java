import processing.core.PApplet;
import processing.core.PFont;
import screenItems.*;
import time.*;

public class Main extends PApplet{
    private final int SCREEN_WIDTH = 800, SCREEN_HEIGHT = 500;
    PFont font;
    Screen screen;
    //Game running is set to true when the game is running; True if not game over


    public static void main(String[] args) {
        String[] appletArgs = new String[] { "Main" };
        PApplet.main(appletArgs);
    }

    /**
     *
     */
    public void setup(){
        font= createFont("Arial", 30, true);
        textFont(font);
    }

    /**
     *
     */
    public void settings(){
        size(SCREEN_WIDTH,SCREEN_HEIGHT);
        screen = new Screen(this);
    }

    /**
     *
     */
    public void draw(){
        background(0,0,0);
        screen.renderGameRunning();
        testing();
    }

    /**
     *
     */
    public void keyPressed(){
        switch(key){
            case 'r':
                break;
            case 'p':
        }
    }


    public static void testing(){
    }


}