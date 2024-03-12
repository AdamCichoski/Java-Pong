package graphics;
import processing.core.PApplet;

/**
 * @author Adam Cichoski
 */
public enum Colors {
    LIGHT_BLUE(0,236,252),
    BLUE(31,181,243),
    GREEN(0,153,0),
    DARK_BLUE(0,0,102),
    YELLOW(252,248,0),
    HOT_PINK(252,0,215),
    RED(255,0,0),
    WHITE(255,255,255);
    private final int r;
    private final int g;
    private final int b;
    private static PApplet screen;

    /**
     * Constructor
     * @param r
     * @param g
     * @param b
     */
    Colors(int r,int g, int b){
        this.r = r;
        this.g = g;
        this.b = b;
    }

    /**
     * Returns an array {r,g,b}
     * @return
     */
    public int[] getRGB(){
        return new int[] {r,g,b};
    }

    /**
     *
     * @return
     */
    public int getR(){
        return r;
    }

    /**
     *
     * @return
     */
    public int getG(){
        return g;
    }

    /**
     *
     * @return
     */
    public int getB(){
        return b;
    }

    /**
     * Meant to use the getRGB() method as parameters
     * @param rgb
     */
    public static void fill(int[] rgb){
        if(screen == null){
            System.out.println("Colors Error: Null Screen");
            return;
        }
        screen.fill(rgb[0], rgb[1], rgb[2]);
    }
    public static void fill(Colors color){
        fill(color.getRGB());
    }
    public static void setScreen(PApplet newScreen){
        screen = newScreen;
    }

}
