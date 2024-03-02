package eventHandler;

import exceptions.FrameLayoutException;
import geometry.Ellipse;
import geometry.Rectangle;
import screenItems.Paddle;
import screenItems.Ball;


/**
 * A class to use just to call functions meant for checking collisions
 * @author Adam Cichoski
 */
public class CollisionDetector{

    /**
     * Determines a collision between an ellipse and a rectangle
     * R
     * E
     * @param rect
     * @param ellipse
     * @return
     */
    public static <R extends Rectangle, E extends Ellipse> boolean ellipseRectangleCollision(R rect, E ellipse)  {
        if(rect == null || ellipse ==null){
            System.out.println(FrameLayoutException.FrameLayoutExceptions.COLLISION_ERROR.error);
        }
        return sidePaddleCollision(rect,ellipse) || topAndBottomCollision(rect,ellipse);
    }

    /**
     * Determines a collision on the left and right side of a paddle
     * @param rect
     * @param ellipse
     * @return
     */
    private static <R extends Rectangle, E extends Ellipse> boolean sidePaddleCollision(R rect, E ellipse){
        float sides[] = rect.getSides();
        return (ellipse.getY() < sides[1] && ellipse.getY() > sides[3]) && (ellipse.getRightX() <= sides[0] || ellipse.getLeftX()>=sides[2]);
    }

    /**
     *
     * @param rect
     * @param ellipse
     * @return
     */
    private static <R extends Rectangle, E extends Ellipse> boolean topAndBottomCollision(R rect, E ellipse){
        float sides[] = rect.getSides();
        return (ellipse.getLowerY() >= sides[1] && ellipse.getUpperY() <=sides[3] && ellipse.getRightX() >sides[0] && ellipse.getLeftX() <sides[2]);
    }

    /**
     * This method specifically is used
     * @param paddle
     * @param ball
     */
    private static void determineCollisionAngle(Paddle paddle, Ball ball){

    }

    /**
     * Checks a collision between a ball and the upper and lower bounds of the screen
     * @param ellipse
     * @param upperBound
     * @param lowerBound
     * @return
     * @param <E> extends Ellipse
     */
    public static <E extends Ellipse> boolean screenTopAndBottomCollision(E ellipse, float upperBound, float lowerBound){
        return (ellipse.getUpperY() >= upperBound) || (ellipse.getLowerY() <= lowerBound);
    }
}
