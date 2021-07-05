package board;

import chess.Player;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;
import pieces.Type;

/**
 * Represents a chess board
 * 
 * @author Ian Wong
 *
 */
public class Board {

    public static final int BOARD_LENGTH = 8;
    private Square[][] squares;

    /**
     * Default constructor makes a new board with default length
     */
    public Board() {
        this(BOARD_LENGTH);
    }

    /**
     * Makes a board of a specified length
     * 
     * @param length
     *               length of the board
     */
    public Board(int length) {
        squares = new Square[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                addSquare(new Square(this, i, j));
            }
        }
    }

    /**
     * 
     * @param square
     *               square that is being added to the board
     */
    public void addSquare(Square square) {
        int x = square.getX();
        int y = square.getY();
        squares[y][x] = square;
    }

    /**
     * getter method for square array
     * 
     * @return the square 2d array
     */
    public Square[][] getBoard() {
        return squares;
    }

    /**
     * Set up the board in standard configuration
     * 
     * @param white
     *              white player
     * @param black
     *              black player
     */
    public void setUpBoard(Player white, Player black) {
        // white pieces
        for (int i = 0; i < BOARD_LENGTH; i++) {
            new Pawn(white, squares[1][i]);
        }

        new Rook(white, squares[0][0]);
        new Rook(white, squares[0][7]);
        new Knight(white, squares[0][1]);
        new Knight(white, squares[0][6]);
        new Bishop(white, squares[0][2]);
        new Bishop(white, squares[0][5]);
        new Queen(white, squares[0][3]);
        new King(white, squares[0][4]);

        // black pieces
        for (int i = 0; i < BOARD_LENGTH; i++) {
            new Pawn(black, squares[6][i]);
        }

        new Rook(black, squares[7][0]);
        new Rook(black, squares[7][7]);
        new Knight(black, squares[7][1]);
        new Knight(black, squares[7][6]);
        new Bishop(black, squares[7][2]);
        new Bishop(black, squares[7][5]);
        new Queen(black, squares[7][3]);
        new King(black, squares[7][4]);
    }

    /**
     * Overridden equals method
     * 
     * @return true if the pieces are in the same position
     */
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        else if (object == null) {
            return false;
        }
        else if (object instanceof Board) {
            Board otherBoard = (Board) object;
            Square[][] otherSquares = otherBoard.getBoard();
            for (int i = 0; i < squares.length; i++) {
                for (int j = 0; j < squares[i].length; j++) {
                    if (!squares[i][j].equals(otherSquares[i][j])) {
                        return false;
                    }
                }
            }
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Board as a string :)))
     * 
     * @return String representation of the board, black is lowercase, white is
     *         uppercase. p: pawn | n: knight | b: bishop | r: rook | q: queen |
     *         k: king
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = squares.length - 1; i >= 0; i--) {
            builder.append("[");
            for (int j = 0; j < squares[i].length; j++) {
                if (squares[i][j].getPiece() == null) {
                    builder.append(" ");
                }
                else {
                    Type pieceType = squares[i][j].getPiece().getType();
                    if (squares[i][j].getPiece().getPlayer().isWhite()) {
                        switch (pieceType) {

                        case PAWN:
                            builder.append("P");
                            break;
                        case KNIGHT:
                            builder.append("N");
                            break;
                        case BISHOP:
                            builder.append("B");
                            break;
                        case ROOK:
                            builder.append("R");
                            break;
                        case QUEEN:
                            builder.append("Q");
                            break;
                        case KING:
                            builder.append("K");
                            break;
                        }
                    }
                    else {
                        switch (pieceType) {
                        case PAWN:
                            builder.append("p");
                            break;
                        case KNIGHT:
                            builder.append("n");
                            break;
                        case BISHOP:
                            builder.append("b");
                            break;
                        case ROOK:
                            builder.append("r");
                            break;
                        case QUEEN:
                            builder.append("q");
                            break;
                        case KING:
                            builder.append("k");
                            break;
                        }
                    }

                }
                if (j != squares.length - 1) {
                    builder.append(",");
                }

            }
            builder.append("]\n");
        }
        return builder.toString();
    }

}
