package gameStates;

import processing.core.PApplet;

public class GamePaused extends GameState{
    private final String TYPE = "GamePaused";

    /**
     * Constructor
     * @param screen
     */
    public GamePaused(PApplet screen){
        super(screen);
    }

    /**
     *
     * @return
     * @param <T>
     */
    @Override
    public <T extends GameState> T type(){
        return (T) this;
    }
}
