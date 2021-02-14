/**
 * 
 */
package chess;

/**
 * A Chess Piece Handles the type of piece and where it can move
 * 
 * @author  Ian Wong
 * 
 * @version 2020.11.24
 *
 */
public abstract class Piece {

    protected Square square;
    protected Player player;

    public Piece(Player player, Square pieceSquare) {
        square = pieceSquare;
        square.setPiece(this);
        this.player = player;

    }

    /**
     * 
     * @param  square
     *                square that is being checked for valid path
     * 
     * @return        true if path is correct for type of piece
     */
    public abstract boolean isValidPath(Square square);

    /**
     * 
     * @precondition        isValidPath returns true
     * 
     * @param        square
     *                      destination square
     * 
     * @return              an array of square objects
     */
    public abstract Square[] getPath(Square square);

    /**
     * 
     * @return type of piece
     */
    public abstract Type getType();

    /**
     * @return Piece on a square in string
     */
    public abstract String toString();

    /**
     * 
     * @return symbol of the piece
     */
    public abstract String getSymbol();
}
