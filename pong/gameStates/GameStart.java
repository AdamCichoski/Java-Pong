package gameStates;
import processing.core.PApplet;
import screenItems.*;
public class GameStart {
    /**
     * Constrctor
     * @param screen
     */
    public GameStart(Screen screen){
    }

    /**
     *
     * @param screen
     */
    public static void startScreen(PApplet screen){
        screen.fill(0);
        screen.rect(screen.width/3, screen.height/3, 2*(screen.width/3), 2*(screen.height/3));
    }
}
