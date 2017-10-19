package gameplayer.classes;

public abstract class ComputerPlayer{

    Board currentBoard;
    
    public boolean myTurn;
    
    public abstract void move();
    
    public void setCurrentBoard(Board b) {
        this.currentBoard = b;
    }
    
    public abstract void reset();
    
    public void toggleTurn() {
        myTurn = !myTurn;
    }
    
    public abstract void learn();
    
    public abstract String toString();

    public abstract void setSkill(int value);
    
    public abstract void newGame(Board newBoard);
    
}
