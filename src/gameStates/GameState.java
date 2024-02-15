package gameStates;
import processing.core.PApplet;

/**
 * The GameState class is responsible for handling the events that will occur in the event of certain inputs.
 * Examples of its use: Game Paused, Game Over, Game Start, etc.
 *
 * @author Adam Cichoski
 */
public abstract class GameState {
    private PApplet screen;

    public GameState(PApplet screen){
        this.screen = screen;
    }

    public void checkEvent(){

    }
    public abstract <T extends GameState> T type();
}
