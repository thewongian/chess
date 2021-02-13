/**
 * 
 */
package chess;

/**
 * @author ian
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

    @Override
    public boolean isValidPath(Square square) {
        int xDiff = Math.abs(this.square.getX() - square.getX());
        int yDiff = Math.abs(this.square.getY() - square.getY());

        if (xDiff < 2 && yDiff < 2 && !(xDiff == 0 && yDiff == 0)) {
            return square.canMoveTo(this);
        }
        return false;
    }

    @Override
    public Square[] getPath(Square square) {
        Square[] squares = null;
        if (isValidPath(square)) {
            squares = new Square[1];
            squares[0] = square;
        }
        return squares;
    }

    @Override
    public Type getType() {
        return type;
    }

}
