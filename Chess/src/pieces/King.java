/**
 * 
 */
package pieces;

import board.Square;
import chess.Player;

/**
 * King piece, can move one unit in any direction
 * 
 * if trapped (checkmate) game ends
 * 
 * unfinished
 * 
 * @author Ian Wong
 *
 */
public class King extends Piece {
    private Type type;
    public boolean hasMoved;

    public King(Player player, Square square) {
        super(player, square);
        type = Type.KING;
        hasMoved = false;
    }

    /**
     * @param  square
     *                target square
     * 
     * @return        true if target square is a valid to move to ignoring
     *                pieces in between
     * 
     */
    @Override
    public boolean isValidPath(Square square) {
        int xDiff = Math.abs(this.square.getX() - square.getX());
        int yDiff = Math.abs(this.square.getY() - square.getY());

        if (xDiff < 2 && yDiff < 2 && !(xDiff == 0 && yDiff == 0)) {
            return square.canMoveTo(this);
        }
        return false;
    }

    /**
     * @param  square
     *                target square
     * 
     * @return        return an array of squares of path if path is valid, if
     *                invalid, return null
     */
    @Override
    public Square[] getPath(Square square) {
        Square[] squares = null;
        if (isValidPath(square)) {
            squares = new Square[1];
            squares[0] = square;
        }
        return squares;
    }

    /**
     * get piece type
     * 
     * @return type of piece
     */
    @Override
    public Type getType() {
        return type;
    }

    /**
     * piece description
     * 
     * @return piece on square
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("King on ");
        builder.append(this.square.toString());

        return builder.toString();
    }

    /**
     * Can the king castle?
     * 
     * @return hasMoved boolean
     */
    public boolean canCastle() {
        return hasMoved;
    }

    /**
     * sets hasMoved boolean
     * 
     * @param bool
     *             boolean that we are changing hasMoved to
     */
    public void setHasMoved(boolean bool) {
        hasMoved = bool;
    }

    /**
     * gets algebraic notation symbol of piece
     * 
     * @return symbol
     */
    @Override
    public String getSymbol() {

        return "K";
    }

}
