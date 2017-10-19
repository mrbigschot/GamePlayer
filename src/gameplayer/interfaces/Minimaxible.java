package gameplayer.interfaces;

import gameplayer.classes.Move;
import gameplayer.lists.MinimaxibleList;
import gameplayer.lists.MoveList;

public interface Minimaxible {

    MinimaxibleList generateNextLegalBoards();
    
    int getValue();
   
    void setValue(int value);
    
    int staticEvaluate();        
       
    boolean gameOver();

    public void set(Minimaxible b);

    public boolean checkGameOver();

//    public void changeTurnsToLearning();

    public MoveList generateAllLegalMoves();

    public void movePawn(Move m);
    
}
