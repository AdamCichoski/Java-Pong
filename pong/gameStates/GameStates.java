package gameStates;
import processing.core.PApplet;
public enum GameStates {
    GAME_START,
    GAME_PAUSED,
    GAME_MENU;

    GameStates(){
    }
    public void gameStart(PApplet screen){
        screen.fill(0);
        screen.rect(screen.width/3, screen.height/3, 2*(screen.width/3), 2*(screen.height/3) );
    }

    public void gamePaused(){

    }
}
