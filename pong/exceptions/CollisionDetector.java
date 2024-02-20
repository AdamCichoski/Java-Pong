package exceptions;

import geometry.Ellipse;
import geometry.Rectangle;
import processing.core.PApplet;
import screenItems.Paddle;
import screenItems.Ball;

/**
 * A class to use just to call functions meant for checking collisions
 * @author Adam Cichoski
 */
public class CollisionDetector {

    /**
     *
     * @param paddle
     * @param ball
     * @return
     */
    public static boolean collideRect(Paddle paddle, Ball ball){
        if(paddle == null){
            System.out.println("Paddle input null in CollisionDetector::collideRect");
            return false;
        }
        if(ball == null){
            System.out.println("Ball input null in CollisionDetector::collideRect");
            return false;
        }
        return sidePaddleCollision(paddle,ball) || topAndBottomCollision(paddle,ball);
    }

    /**
     *
     * @param paddle
     * @return
     */
    private static boolean sidePaddleCollision(Paddle paddle, Ball ball){
        float sides[] = paddle.getSides();
        return (ball.getY() > sides[1] && ball.getY() <sides[3] && ball.getLeftX()<=sides[0] && ball.getRightX()>=sides[2]);
    }

    /**
     *
     * @param paddle
     * @param ball
     * @return
     */
    private static boolean topAndBottomCollision(Paddle paddle, Ball ball){
        float sides[] = paddle.getSides();
        return (ball.getLowerY() >= sides[1] && ball.getUpperY() <=sides[3] && ball.getRightX() >sides[0] && ball.getLeftX() <sides[2]);
    }

    private static void determineCollisionAngle(Paddle paddle, Ball ball){

    }
}
