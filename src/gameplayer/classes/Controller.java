package gameplayer.classes;

import gameplayer.UI.GamePanel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller extends Thread {

    ComputerPlayer p1, p2;
    Board theBoard;
    GamePanel thePanel;

    public boolean running = false;
    boolean human = false;

    public Controller(GamePanel panel, Board b, ComputerPlayer p1, ComputerPlayer p2) {
        this.thePanel = panel;
        this.theBoard = b;
        this.p1 = p1;
        this.p2 = p2;
    }

    public void run() {
        for (;;) {
            delay(15);
            if (running) {
                if (human) {
                    if (p2.myTurn) {
                        delay(Globals.getTime());
                        p2.move();
                        thePanel.repaint();
                    }
                } else {
                    if (!theBoard.gameOver()) {
                        delay(Globals.getTime());
                        theBoard.play();
                        if (!Globals.FAST_MODE) {
                            thePanel.repaint();
                        }
                    } else {
                        theBoard.reset();
                    }
                }
            }
        }
    }

    public void delay(int d) {
        try {
            sleep(d);
        } catch (InterruptedException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void toggleRunning() {
        running = !running;
    }

    public void toggleHuman() {
        human = !human;
    }

    private void toggleTurns() {
        p1.toggleTurn();
        p2.toggleTurn();
    }

}
