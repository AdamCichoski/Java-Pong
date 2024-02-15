package gameStates;
import processing.core.PApplet;
public class GameStart extends GameState {

    public GameStart(PApplet screen){
        super(screen);
    }

    public void startScreen(){

    }

    @Override
    public <T extends GameState> T type() {
        return null;
    }
}
