package gameplayer.classes;

import gameplayer.UI.GamePanel;
import gameplayer.interfaces.Minimaxible;
import gameplayer.lists.MinimaxibleList;

public class MinimaxPlayer extends ComputerPlayer {

    int skill = 0;
    GamePanel thePanel;

    public MinimaxPlayer() {

    }

    public MinimaxPlayer(GamePanel p) {
        this.thePanel = p;
    }

    @Override
    public void reset() {

    }

    @Override
    public void move() {
        if (!currentBoard.checkGameOver() && myTurn) {
//            System.out.println("MINIMAX MOVE");
            if (random(100) > skill) {
                currentBoard.movePawn(currentBoard.generateAllLegalMoves().random());
            } else {
                currentBoard.set(bestBoard(8));
            }
            currentBoard.checkGameOver();
            currentBoard.changeTurns();
        }
    }

    @Override
    public void learn() {
        //Minimax doesn't learn
    }

    Minimaxible bestBoard(int depth) {
        if (currentBoard.playerTurn == 1) {
            return min(currentBoard, depth);
        } else {
            return max(currentBoard, depth);
        }
    }

    Minimaxible max(Minimaxible thisBoard, int depth) {
        if (thisBoard.gameOver() || depth == 0) {
            thisBoard.setValue(thisBoard.staticEvaluate());
            return thisBoard;
        }

        MinimaxibleList list = thisBoard.generateNextLegalBoards();

        for (Minimaxible nextBoard : list) {
            nextBoard.setValue(min(nextBoard, depth - 1).getValue());
        }

        return minimaxibleWithMaximumOf(list);
    }

    Minimaxible min(Minimaxible thisBoard, int depth) {
        if (thisBoard.gameOver() || depth == 0) {
            thisBoard.setValue(thisBoard.staticEvaluate());
            return thisBoard;
        }

        MinimaxibleList list = thisBoard.generateNextLegalBoards();

        for (Minimaxible nextBoard : list) {
            nextBoard.setValue(max(nextBoard, depth - 1).getValue());
        }

        return minimaxibleWithMinimumOf(list);
    }

    private Minimaxible minimaxibleWithMaximumOf(MinimaxibleList list) {
        Minimaxible returnMe = list.get(0);
        for (Minimaxible next : list) {
            if (next.getValue() > returnMe.getValue()) {
                returnMe = next;
            }
        }
        return returnMe;
    }

    private Minimaxible minimaxibleWithMinimumOf(MinimaxibleList list) {
        Minimaxible returnMe = list.get(0);
        for (Minimaxible next : list) {
            if (next.getValue() < returnMe.getValue()) {
                returnMe = next;
            }
        }
        return returnMe;
    }

    public int random(int max) {
        return (int) (Math.random() * max);
    }

    @Override
    public String toString() {
        String returnMe = "MinimaxPlayer";
        return returnMe;
    }

    @Override
    public void setSkill(int value) {
        skill = value;
    }

    @Override
    public void newGame(Board b) {

    }

}
