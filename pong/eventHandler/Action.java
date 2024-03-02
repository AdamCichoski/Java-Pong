package eventHandler;
import interactable.Button;
import processing.core.PApplet;
import screenItems.Screen;
/**
 *
 * @author Adam Cichoski
 */
public class Action {

    public Action(){

    }

    /**
     *Checks to see if
     */
    public static <S extends PApplet> boolean checkMouseClicked(S screen){
        return screen.mousePressed;
    }
}
