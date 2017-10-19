package gameplayer.classes;

import gameplayer.UI.GamePanel;
import gameplayer.interfaces.Minimaxible;
import gameplayer.lists.MinimaxibleList;
import gameplayer.lists.MoveList;
import java.awt.Color;
import java.awt.Graphics;

public class Board implements Minimaxible {

    boolean human = false;

    GamePanel thePanel;

    ComputerPlayer p1, p2;

    int[][] squares;
    public int size = 3;
    public int playerTurn;
    int winner;

    int left = 50;
    int top = 50;
    int bottom;
    int right;
    int width = 400;
    int sqWidth;

    int value;

    public Board() {
        squares = new int[size][size];
    }

    public Board(int s) {
        size = s;
        squares = new int[size][size];
    }

    public Board(GamePanel p) {
        this();
        thePanel = p;
    }

    public Board(ComputerPlayer p1, ComputerPlayer p2, GamePanel gp) {
        this(gp);
        this.p1 = p1;
        this.p2 = p2;
    }

    public Board copy() {
        Board returnMe = new Board(size);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                returnMe.squares[row][col] = this.squares[row][col];
            }
        }
        returnMe.playerTurn = playerTurn;
        return returnMe;
    }

    @Override
    public boolean equals(Object o) {
        Board b = (Board) o;
//        if (o == null) {
//            System.out.println("Hey programmer! Object o is null (Board.java:68)");
//        }
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (squares[row][col] != b.squares[row][col]) {
                    return false;
                }
            }
        }
        if (playerTurn != b.playerTurn) {
            return false;
        }
        return true;
    }

    public void rootBoard() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                squares[row][col] = 0;
            }
        }
        for (int col = 0; col < size; col++) {
            squares[0][col] = 1;
            squares[size - 1][col] = -1;
        }
        playerTurn = Globals.getFirst();
    }

    public void reset() {
        p1.newGame(new Board(size));
        p2.newGame(new Board(size));
        rootBoard();
        if (Globals.getFirst() == 1) {
            p1.myTurn = false;
            p2.myTurn = true;
        } else {
            p1.myTurn = true;
            p2.myTurn = false;
        }
    }

    public void resetSize(int s) {
        p1.newGame(new Board(size));
        p2.newGame(new Board(size));
        size = s;
        squares = new int[size][size];
        rootBoard();
        p1.setCurrentBoard(this);
        p1.reset();
        p2.setCurrentBoard(this);
        p2.reset();
    }

    public void toggleHuman() {
        human = !human;
    }

    @Override
    public boolean checkGameOver() {
        if (gameOver()) {
            if (!Globals.FAST_MODE) {
                thePanel.output("GAME OVER. " + winner() + " WINS!");
            }
            thePanel.updateData(winner);
            if (winner == -1) {
                p2.learn();
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean gameOver() {
        if (oppositeSide() || noMoves()) {
            winner = -playerTurn;
            return true;
        }
        return false;
    }

    private boolean oppositeSide() {
        for (int col = 0; col < size; col++) {
            if (squares[0][col] == -1) {
                winner = -1;
                return true;
            }
            if (squares[size - 1][col] == 1) {
                winner = 1;
                return true;
            }
        }
        return false;
    }

    private boolean noMoves() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (squares[row][col] == playerTurn) {
                    if (hasLegalMoves(row, col)) {
                        return false;
                    }
                }
            }
        }
        winner = -playerTurn;
        return true;
    }

    @Override
    public void movePawn(Move m) {
        int r1 = m.getRi();
        int r2 = m.getRf();
        int c1 = m.getCi();
        int c2 = m.getCf();
        squares[r2][c2] = squares[r1][c1];
        squares[r1][c1] = 0;
        playerTurn = -playerTurn;
    }

    public void humanMove(Move m) {
        if (human) {
            int r1 = m.getRi();
            int r2 = m.getRf();
            int c1 = m.getCi();
            int c2 = m.getCf();
            if (legalMove(r1, c1, r2, c2)) {
                squares[r2][c2] = squares[r1][c1];
                squares[r1][c1] = 0;
                playerTurn = -playerTurn;
            } else {
                thePanel.output("THAT IS AN ILLEGAL MOVE");
            }
            if (playerTurn == 1) {
                p2.myTurn = true;
            }
        }
    }

    public void changeTurns() {
        p1.toggleTurn();
        p2.toggleTurn();
    }

    public void hypotheticalMove(Move m) {
        int r1 = m.getRi();
        int r2 = m.getRf();
        int c1 = m.getCi();
        int c2 = m.getCf();
        squares[r2][c2] = squares[r1][c1];
        squares[r1][c1] = 0;
        playerTurn = -playerTurn;
    }

    public boolean inRange(int r, int c) {
        return (r < size && r >= 0 && c < size && c >= 0);
    }

    public boolean legalMove(int r1, int c1, int r2, int c2) {
        return (generateLegalMoves(r1, c1).contains(new Move(r1, c1, r2, c2))) && (playerTurn == squares[r1][c1]);
    }

    public boolean hasLegalMoves(int r, int c) {
        return (generateLegalMoves(r, c).size() != 0);
    }

    public MoveList generateLegalMoves(int r, int c) {
        MoveList returnMe = new MoveList();
        int player = squares[r][c];

        //Straight Ahead
        if (squares[r + player][c] == 0) {
            returnMe.add(new Move(r, c, r + player, c));
        }
        //Attacking Left
        if (c > 0 && squares[r + player][c - 1] == -player) {
            returnMe.add(new Move(r, c, r + player, c - 1));
        }
        //Attacking Right
        if (c < size - 1 && squares[r + player][c + 1] == -player) {
            returnMe.add(new Move(r, c, r + player, c + 1));
        }

        return returnMe;
    }

    @Override
    public MoveList generateAllLegalMoves() {
        MoveList returnMe = new MoveList();
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (squares[r][c] == playerTurn) {
                    for (Move next : generateLegalMoves(r, c)) {
                        returnMe.add(next);
                    }
                }
            }
        }
        return returnMe;
    }

    private String winner() {
        if (winner == 1) {
            return "WHITE (LEARNING)";
        }
        if (human) {
            return "BLACK (HUMAN)";
        }
        return "BLACK (MINIMAX)";
    }

    @Override
    public String toString() {
        String returnMe = "\n\t";

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                returnMe += format("" + squares[row][col]);
            }
            returnMe += "\n\t";
        }
        returnMe += "\n\tPlayerTurn = " + playerTurn;
        return returnMe;
    }

    public String format(String s) {
        String returnMe = s;
        while (returnMe.length() < 4) {
            returnMe += " ";
        }
        return returnMe;
    }

    public int random(int max) {
        return (int) (Math.random() * max);
    }

    public void paint(Graphics g) {
        sqWidth = width / size;
        right = left + width;
        bottom = top + width;
        drawGrid(g);
        drawPieces(g);
    }

    public void drawGrid(Graphics g) {
        g.setColor(Color.BLACK);
        for (int i = 0; i < size + 1; i++) {
            g.drawLine(left + i * sqWidth, top, left + i * sqWidth, top + sqWidth * size);
        }
        for (int i = 0; i < size + 1; i++) {
            g.drawLine(left, top + i * sqWidth, left + sqWidth * size, top + i * sqWidth);
        }
    }

    public void drawPieces(Graphics g) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (squares[row][col] != 0) {
                    if (squares[row][col] > 0) {
                        g.setColor(Color.WHITE);
                    } else {
                        g.setColor(Color.BLACK);
                    }
                    g.fillOval(left + col * sqWidth, top + row * sqWidth, sqWidth, sqWidth);
                }
            }
        }
    }

    public int findCol(int x) {
        if (x <= right) {
            return (x - left) / sqWidth;
        } else {
            return -1;
        }
    }

    public int findRow(int y) {
        if (y <= bottom) {
            return (y - top) / sqWidth;
        } else {
            return -1;
        }
    }

    @Override
    public MinimaxibleList generateNextLegalBoards() {
        MinimaxibleList returnMe = new MinimaxibleList();
        for (Move next : generateAllLegalMoves()) {
            Board b = this.copy();
            b.hypotheticalMove(next);
            returnMe.add(b);
        }
        return returnMe;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int staticEvaluate() {
        if (winner == 1) {
            return -100;
        }
        return 100;
    }

    @Override
    public void set(Minimaxible m) {
        Board b = (Board) m;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                squares[row][col] = b.squares[row][col];
            }
        }
        playerTurn = b.playerTurn;
    }

    public void play() {
        if (!checkGameOver()) {
            if (playerTurn == -1) {
                p1.move();
            } else {
                p2.move();
            }
        } else {
            if (!human) {
                reset();
            }
        }
    }
    
    public void simPlay(){
        if (playerTurn == -1) {
                p1.move();
            } else {
                p2.move();
            }
    }

}
