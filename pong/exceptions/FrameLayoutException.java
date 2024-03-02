package exceptions;

public class FrameLayoutException extends Exception{
    public FrameLayoutException(){
        super();
    }
    public FrameLayoutException(String message){
        super(message);
    }

    public FrameLayoutException(FrameLayoutExceptions exception){
        super(exception.error);
    }

    /**
     * A collection of preset errors
     */
    public enum FrameLayoutExceptions{
        COLLISION_ERROR("Collision Error");

        //******************************
        public final String error;
        FrameLayoutExceptions(String error){
            this.error = error;
        }
    }
}
