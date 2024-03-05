package time;
import org.jetbrains.annotations.Nullable;
import processing.core.PApplet;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Stores the functions to set and display the time that the match has been running for
 * @author
 */
public class Clock {
    private short currentTime =0;
    private boolean runnable = true;
    private float x,y;
    @Nullable
    private PApplet screen;
    private ClockThread thread = new ClockThread();

    /**
     * Used in the event that time does not need to be displayed onto a PApplet Screen
     */
    public Clock(){
        this(null);
    }

    /**
     * Constructor
     * @param screen
     */
    public Clock(PApplet screen){
        this.screen = screen;
    }
    /**
     * Constuctor
     * @param screen
     */
    public Clock(PApplet screen, float x, float y){
        this.screen = screen;
        this.x = x;
        this.y = y;
    }

    /**
     *
     */
    private void displayTime(){
        screen.text(getTime(), x, y);
    }

    /**
     *
     */
    public void beginTick(){
        if(runnable){
            thread.start();
            runnable = false;
        }
        displayTime();
    }
    /**
     *
     */
    public void resetTime(){
        currentTime =0;
    }


    /**
     *
     * @return
     */
    public String getTime(){
        int seconds = currentTime%60, minutes = currentTime/60;
        return ((minutes<10)? "0"+ minutes: Integer.toString(minutes)) + ":" + ((seconds<10)? "0"+seconds : Integer.toString(seconds));
    }

    /**
     *
     * @param screen
     */
    public void setScreen(PApplet screen){
        this.screen = screen;
    }

    private class ClockThread extends Thread{
        /**
         * Constructor
         */
        public ClockThread(){
        }

        /**
         *
         */
        @Override
        public void run(){
            try{
                while(true) {
                    Thread.sleep(1000);
                    currentTime++;
                }
            }catch(InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        /**
         *
         */
        public void killClockThread(){
            Thread.currentThread().interrupt();
        }
    }

}
