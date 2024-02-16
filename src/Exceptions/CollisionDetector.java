package Exceptions;

import screenItems.Paddle;
import screenItems.Ball;

/**
 * A class to use just to call functions meant for checking collisions
 * @author Adam Cichoski
 */
public class CollisionDetector {

    public CollisionDetector(){

    }

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
        return true;
    }
//
//    /**
//     *
//     * @param paddle
//     * @return
//     */
//    private static boolean leftPaddleCollision(Paddle paddle){
//
//    }
//
//    /**
//     *
//     * @param paddle
//     * @return
//     */
//    private static boolean rightPaddleCollision(Paddle paddle){
//
//    }
//
//    /**
//     *
//     * @param paddle
//     * @return
//     */
//    private static boolean topPaddleCollision(Paddle paddle){
//
//    }
//
//    /**
//     *
//     * @param paddle
//     * @return
//     */
//    private static boolean bottomPaddleCollision(Paddle paddle){
//
//    }
//
//    private static void determineCollisionAngle(Paddle paddle){
//
//    }
}
