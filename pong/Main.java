import processing.core.PApplet;
import processing.core.PFont;
import screenItems.Screen;

public class Main extends PApplet{
    PFont font;
    Screen screen;
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
        int SCREEN_WIDTH = 800;
        int SCREEN_HEIGHT = 500;
        size(SCREEN_WIDTH, SCREEN_HEIGHT);
        screen = new Screen(this);
    }

    /**
     *
     */
    public void draw(){
        background(0,0,0);
        screen.run();
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