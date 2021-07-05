/**
 * 
 */
package board;

import pieces.Piece;

/**
 * A square of the chess board
 * 
 * @author  Ian Wong
 * 
 * @version 2020.11.24
 *
 */
public class Square {
    private Board board;
    private int squareX;
    private int squareY;
    private Piece piece;

    /**
     * Constructor
     * 
     * @param gameBoard
     *                  board that the square will be in
     * @param x
     *                  x value of the square
     * @param y
     *                  y value of the square
     */
    Square(Board gameBoard, int x, int y) {
        board = gameBoard;
        squareX = x;
        squareY = y;
        piece = null;

    }

    /**
     * sets the square piece
     * 
     * @param piece
     *              piece that is being set
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    /**
     * 
     * @return Piece on the square
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * 
     * @return x value of square
     */
    public int getX() {
        return squareX;
    }

    /**
     * 
     * @return y value of square
     */
    public int getY() {
        return squareY;
    }

    /**
     * 
     * @return board the square is in
     */
    public Board getBoard() {
        return board;
    }

    /**
     * 
     * @return true if square is occupied
     */
    public boolean isOccupied() {
        return piece != null;
    }

    /**
     * 
     * @param piece
     *              piece you are checking to see if it can move to this square
     * 
     */
    public boolean canMoveTo(Piece piece) {
        if (isOccupied()) {
            return (getPiece().getPlayer().getColor() != piece.getPlayer().getColor());
        }
        else {
            return true;
        }
    }

    /**
     * @param  object
     *                object being compared
     * 
     * @return        true if it has the same x and y and same piece
     */
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        else if (object == null) {
            return false;
        }
        else if (object instanceof Square) {
            Square otherSquare = (Square) object;
            if (this.getPiece() == null) {
                return this.getX() == otherSquare.getX()
                        && this.getY() == otherSquare.getY()
                        && otherSquare.getPiece() == null;
            }
            else if (otherSquare.getPiece() == null) {
                return this.getX() == otherSquare.getX()
                        && this.getY() == otherSquare.getY()
                        && this.getPiece() == null;
            }
            else {
                return this.getX() == otherSquare.getX()
                        && this.getY() == otherSquare.getY()
                        && this.getPiece().equals(otherSquare.getPiece());
            }
        }
        else {
            return false;
        }

    }

    /**
     * converts square to algebraic notation
     * 
     * @return square in algebraic notation
     * 
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        String[] letters = { "a", "b", "c", "d", "e", "f", "g", "h" };
        builder.append(letters[getX()]);
        builder.append(getY() + 1);
        return builder.toString();

    }

}
