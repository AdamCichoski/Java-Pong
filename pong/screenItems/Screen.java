package screenItems;
import exceptions.FrameLayoutException;
import processing.core.PApplet;
import gameStates.*;

import static gameStates.GameStates.GAME_START_SCREEN;

public class Screen {
    private final PApplet SCREEN;
    private GameStates gameState = GAME_START_SCREEN;

    /**
     * Constructor
     * @param SCREEN
     */
    public Screen(PApplet SCREEN){
        this.SCREEN = SCREEN;

    }

    /**
     *
     * @param gameState
     * @throws FrameLayoutException
     */
    public void frameLayout(GameStates gameState) {
        switch(gameState){
            case GAME_START_SCREEN:
                initializeStartScreen();
                break;
            case GAME_START:
                break;
            case GAME_PAUSED:
                break;
            case GAME_OVER:
                break;
            case GAME_MENU:
                break;
            default:

        }
    }

    /**
     * Displays the current running score
     */
    public void displayScore(){

    }
    public void initializeStartScreen(){

    }
}
