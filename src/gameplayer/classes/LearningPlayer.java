package gameplayer.classes;

import gameplayer.UI.GamePanel;
import gameplayer.lists.BoardList;
import gameplayer.lists.MoveList;

public class LearningPlayer extends ComputerPlayer {
    
    GamePanel thePanel;

    public BoardList avoidThese;
    public Board lastBoard;

    public LearningPlayer() {
        avoidThese = new BoardList();
    }

    public LearningPlayer(GamePanel p) {
        this();
        thePanel = p;
    }

    public void toggle() {
        myTurn = !myTurn;
    }

    @Override
    public void reset() {
        avoidThese = new BoardList();
        lastBoard = new Board();
    }

    @Override
    public void setCurrentBoard(Board b) {
        currentBoard = b;
    }

    public void setLastBoard(Board b) {
        lastBoard = b;
    }

    @Override
    public void learn() {
        if (!avoidThese.contains(lastBoard) && !avoidThese.contains(mirror(lastBoard))) {
            avoidThese.add(lastBoard);
            myTurn = false;
        }
    }

    @Override
    public void move() {
        int index = 0;
        if (!currentBoard.checkGameOver() && myTurn) {
//            System.out.println("LEARNING MOVE");
            if (inevitableLoss()) {
                thePanel.output("MY LOSS IS INEVITABLE! CAN I QUIT?");
                currentBoard.movePawn(currentBoard.generateAllLegalMoves().random());
            } else {
                Move m = currentBoard.generateAllLegalMoves().get(index);
                while (badMove(m)) {
                    // to get LearningPlayer to play randomly
//                    m = currentBoard.generateAllLegalMoves().random();
                    // to get LearningPlayer to play systematically
                    m = currentBoard.generateAllLegalMoves().get(index++);
                    
                }
                currentBoard.movePawn(m);
                setLastBoard(currentBoard.copy());
                currentBoard.checkGameOver();
            }
            currentBoard.changeTurns();
        }
    }

    private boolean badMove(Move m) {
//        System.out.println("hypotheticalBoard(m) (LearningPlayer.java:73) = " + hypotheticalBoard(m));
        return (avoidThese.contains(hypotheticalBoard(m)) || avoidThese.contains(mirror(hypotheticalBoard(m))));
    }

    public Board hypotheticalBoard(Move m) {
        Board returnMe = currentBoard.copy();
        returnMe.hypotheticalMove(m);
        return returnMe;
    }

    public Board mirror(Board b) {
        Board returnMe = b.copy();
        for (int row = 0; row < b.size; row++) {
            for (int col = 0; col < b.size; col++) {
                returnMe.squares[row][col] = b.squares[row][b.size - 1 - col];
            }
        }
        return returnMe;
    }

    public boolean inevitableLoss() {
        MoveList allMoves = currentBoard.generateAllLegalMoves();
        for (Move next : allMoves) {
            if (!badMove(next)) {
                return false;
            }
        }
        return true;
    }

    public int random(int max) {
        return (int) (Math.random() * max);
    }

    @Override
    public String toString() {
        String returnMe = "LearningPlayer: \n";
        returnMe += "I should avoid: \n" + avoidThese.toString();
        return returnMe;
    }

    @Override
    public void setSkill(int value) {
    }

    @Override
    public void newGame(Board newBoard) {
        lastBoard = newBoard;
    }

}
