package gameplayer.classes;

public class Globals {

    public static boolean FAST_MODE = false;
    
    static boolean SIM = false;

    static int TIME = 50;

    static int FIRST_TURN = -1;
    // start with black => -1
    // start with white => 1

    public static void setSIM(boolean b) {
        SIM = b;
    }

    public static boolean getSIM() {
        return SIM;
    }

    public static void setTime(int i) {
        TIME = i;
    }

    public static int getTime() {
        return TIME;
    }

    public static void setFirst(int i) {
        FIRST_TURN = i;
    }

    public static int getFirst() {
        return FIRST_TURN;
    }

    public static void toggleFastMode() {
        FAST_MODE = !FAST_MODE;
    }
    
}
