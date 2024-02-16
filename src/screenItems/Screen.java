package screenItems;
import Exceptions.FrameLayoutException;
import processing.core.PApplet;
import gameStates.*;
public class Screen {
    private PApplet screen;
    private GamePaused paused;
    private GameStart start;

    public Screen(PApplet screen){
        this.screen = screen;
    }

    public void frameLayout(GameStates gameState) throws FrameLayoutException {
        switch(gameState){
            case GAME_START:
                GameStart.startScreen(screen);
                break;
            case GAME_PAUSED:
                paused.pauseGame(screen);
                break;
            case GAME_MENU:
                break;
            default:

        }
    }
}
