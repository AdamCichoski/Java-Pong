package gameStates;

/**
 *
 * @author Adam Cichoski
 */
public class Action <T extends GameState> {

    public Action(){

    }

    public T getType(T event){
        return event.type();
    }
}
