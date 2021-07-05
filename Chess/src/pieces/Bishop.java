/**
 * 
 */
package pieces;

import board.Square;
import chess.Player;

/**
 * Bishop, can move on the diagonals
 * 
 * @author  Ian Wong
 * 
 * @version 2020.11.24
 *
 */
public class Bishop extends Piece {
    private Type type;

    /**
     * Constructor
     * 
     * @param player
     *               player that has this piece
     * @param square
     *               square piece is on
     */
    public Bishop(Player player, Square square) {
        super(player, square);
        type = Type.BISHOP;
    }

    /**
     * @param  square
     *                square that is the target
     * 
     * @return        true if square can be traversed to in a diagonal ignoring
     *                pieces in between
     */
    @Override
    public boolean isValidPath(Square square) {
        int xDiff = Math.abs(square.getX() - this.square.getX());
        int yDiff = Math.abs(square.getY() - this.square.getY());

        // checking if its diagonal
        if (xDiff == yDiff && xDiff > 0) {
            return square.canMoveTo(this);
        }
        else {
            return false;
        }
    }

    /**
     * @param  square
     *                target square
     * 
     * @return        array of Square objects if the path is valid, or a null
     *                array if the path to the square is not valid
     */
    @Override
    public Square[] getPath(Square square) {

        int arraySize = 0;
        int xDir = 1;
        int yDir = 1;

        // determines which direction its going in
        if (this.square.getX() > square.getX()) {
            xDir = -1;
        }
        if (this.square.getY() > square.getY()) {
            yDir = -1;
        }
        // array size
        arraySize = Math.abs(this.square.getX() - square.getX());

        // if target square is valid
        if (isValidPath(square)) {
            Square[] squares = new Square[arraySize];
            if (arraySize > 1) {
                Square[][] board = square.getBoard().getBoard();
                // place all but the last square in array
                for (int i = 0; i < arraySize - 1; i++) {
                    squares[i] = board[this.square.getY() + i
                            + 1 * yDir][this.square.getX() + i + 1 * xDir];
                    // If any of the squares along the way arent valid, path is
                    // null
                    if (squares[i].isOccupied()) {
                        return null;
                    }
                }
            }
            // target square in array
            squares[arraySize - 1] = square;

            return squares;

        }
        // null if target square is invalid
        else {
            return null;
        }
    }

    /**
     * @return the type of piece
     */
    @Override
    public Type getType() {
        return type;
    }

    /**
     * @return Piece on a square in string form
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Bishop on ");
        builder.append(this.square.toString());
        return builder.toString();
    }

    /**
     * @return symbol in chess notation
     */
    @Override
    public String getSymbol() {

        return "B";
    }

}
