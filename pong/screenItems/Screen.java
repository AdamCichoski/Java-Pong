package screenItems;
import exceptions.FrameLayoutException;
import graphics.Colors;
import processing.core.PApplet;
import gameStates.*;
import time.Clock;

import static gameStates.GameStates.GAME_START_SCREEN;

public class Screen {
    private final PApplet SCREEN;
    private GameStates gameState = GAME_START_SCREEN;

    private float playerPaddleX, opponentPaddleX;

    private float startingY;
    private float timerX, timerY;
    private final float paddleWidth = 10, paddleHeight = 80, ballDiameter = 30;
    private Ball ball;
    private Paddle player, opponent;
    private Clock timer;
    private Colors color;

    /**
     * Constructor
     * @param SCREEN
     */
    public Screen(PApplet SCREEN){
        this.SCREEN = SCREEN;
        initializeScreenItems();
        initializeScreenObjects();
        initializeColors();
    }

    /**
     *
     * @param gameState
     * @throws FrameLayoutException
     */
    public void frameLayout(GameStates gameState) {
        switch(gameState){
            case GAME_START_SCREEN:
                renderStartScreen();
                break;
            case GAME_RUNNING:
                renderGameRunning();
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
     * Method for rendering the start screen
     */
    public void renderStartScreen(){

    }

    /**
     * Method for what to do when the game is running
     */
    public void renderGameRunning(){
        ball.render();
        player.render();
        opponent.render();
        timer.beginTick();
    }

    /**
     * Initialization of components to configure objects
     */
    public void initializeScreenItems(){
        playerPaddleX = SCREEN.width-20;
        opponentPaddleX = 10;
        startingY = SCREEN.height/2;
        timerX = (3.25f)*SCREEN.width/7f;
        timerY = 40;
    }

    /**
     * Initialization and configuration of screen objects
     */
    public void initializeScreenObjects(){
        ball = new Ball(SCREEN, SCREEN.width/2f, startingY, ballDiameter);
        player = new Paddle(SCREEN, SCREEN.width-20f, startingY, paddleWidth,paddleHeight, ball);
        opponent = new Paddle(SCREEN,opponentPaddleX, startingY, paddleWidth,paddleHeight, ball);
        ball.setPlayer(player);
        ball.setOpponent(opponent);
        timer = new Clock(SCREEN, timerX, timerY);
    }

    /**
     * Object color configuration
     */
    public void initializeColors(){
        Colors.setScreen(SCREEN);
        ball.setColor(Colors.GREEN);
        opponent.setColor(Colors.RED);
    }
}
