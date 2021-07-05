/**
 * 
 */
package pieces;

import board.Square;
import chess.Player;

/**
 * Knight Piece, can move in an L shape
 * 
 * @author  Ian Wong
 * 
 * @version 2020.11.24
 *
 */
public class Knight extends Piece {
    private Type type;

    /**
     * Constructor
     * 
     * @param player
     *                    piece's player
     * @param pieceSquare
     *                    target square
     */
    public Knight(Player player, Square square) {
        super(player, square);
        type = Type.KNIGHT;
    }

    /**
     * @param  square
     *                square we're checking
     * 
     * @return        true if its a valid path, so 2 one direction, 1 the other
     */
    @Override
    public boolean isValidPath(Square square) {
        int currX = this.square.getX();
        int currY = this.square.getY();
        int squareX = square.getX();
        int squareY = square.getY();

        int xDiff = Math.abs(squareX - currX);
        int yDiff = Math.abs(squareY - currY);
        if ((xDiff == 1 && yDiff == 2) || (xDiff == 2 && yDiff == 1)) {
            return square.canMoveTo(this);
        }

        else {
            return false;
        }
    }

    /**
     * @param  square
     *                square of path we're getting
     * 
     * @return        an array of squares
     */
    @Override
    public Square[] getPath(Square square) {
        Square[] squares = new Square[1];
        if (isValidPath(square)) {
            squares[0] = square;
        }
        else {
            return null;
        }
        if (squares.length > 0) {
            return squares;
        }
        else {
            return null;
        }
    }

    /**
     * gets type of piece
     * 
     * @return the type of piece
     */
    @Override
    public Type getType() {
        return type;
    }

    /**
     * piece description
     *
     * @return "Knight on <square in chess algebraic notation>
     * 
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Knight on ");
        builder.append(this.square.toString());
        return builder.toString();
    }

    /**
     * @return Algebraic notation symbol for knight
     */
    @Override
    public String getSymbol() {

        return "N";
    }

}
