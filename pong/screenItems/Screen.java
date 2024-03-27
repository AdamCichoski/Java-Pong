package screenItems;
import eventHandler.CollisionDetector;
import graphics.Colors;
import interactable.Button;
import processing.core.PApplet;
import gameStates.*;
import processing.core.PImage;
import time.Clock;

import static gameStates.GameStates.GAME_RUNNING;
import static gameStates.GameStates.GAME_START_SCREEN;

public class Screen {
    private final PApplet SCREEN;
    private GameStates gameState = GAME_START_SCREEN;
    private float startButtonX, startButtonY, startButtonWidth,startButtonHeight;
    private float playerPaddleX, opponentPaddleX;
    private float startingY;
    private float timerX, timerY;
    private final float paddleWidth = 10, paddleHeight = 80, ballDiameter = 15;
    private Ball ball;
    private Paddle player, opponent;
    private Clock timer;
    private Colors color;
    private Button startButton;
    private float netWidth = 5, netHeight = 20, netGap = 19;

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

    public void run(){
        checkGameState();
        renderGameState();
    }

    public void checkGameState(){

    }

    /**
     *
     */
    public void renderGameState() {
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
        startButton.render();
    }

    /**
     * Method for what to do when the game is running
     */
    public void renderGameRunning(){
        netDraw();
        ball.render();
        player.render();
        opponent.render();
        timer.beginTick();
        if(pointCheck()){

        }
    }

    /**
     * Initialization of components to configure objects
     */
    public void initializeScreenItems(){
        playerPaddleX = SCREEN.width-20f;
        opponentPaddleX = 10;
        startingY = SCREEN.height/2;
        timerX = (3.25f)*SCREEN.width/7f;
        timerY = 40;
        startButtonWidth = 2*SCREEN.width/5f;
        startButtonHeight = 2*SCREEN.height/7f;
        startButtonX = (SCREEN.width-startButtonWidth)/2;
        startButtonY = (SCREEN.height - startButtonHeight)/2;

    }

    /**
     * Initialization and configuration of screen objects
     */
    public void initializeScreenObjects(){
        ball = new Ball(SCREEN, SCREEN.width/2f, startingY, ballDiameter);
        player = new Paddle(SCREEN, playerPaddleX, startingY, paddleWidth,paddleHeight, ball);
        opponent = new Paddle(SCREEN,opponentPaddleX, startingY, paddleWidth,paddleHeight, ball);
        ball.setPlayer(player);
        ball.setOpponent(opponent);
        timer = new Clock(SCREEN, timerX, timerY);
        startButton = new Button(SCREEN,startButtonX,startButtonY,startButtonWidth,startButtonHeight){
            @Override
            public void buttonAction(){
                gameState = GAME_RUNNING;
            }
        };
        startButton.addImage(".\\Images\\START_BUTTON.png");
    }

    /**
     * Object color configuration
     */
    public void initializeColors(){
        Colors.setScreen(SCREEN);
        ball.setColor(Colors.GREEN);
        opponent.setColor(Colors.RED);
        startButton.setColor(Colors.DARK_BLUE);
    }

    /**
     * Checks if the ball has collided with a left or right bound
     * @return
     */
    private boolean pointCheck(){
        return ball.getAdjustedX() <= 0 || ball.getAdjustedX() >= SCREEN.width;
    }
    private void netDraw(){
        float temp = 0;
        for (int i=2;i<10;i++) {
            temp += netGap*3;
            SCREEN.rect(SCREEN.width/2, temp, netWidth, netHeight);
        }
    }

}
