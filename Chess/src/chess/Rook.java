/**
 * 
 */
package chess;

/**
 * @author ian
 *
 */
public class Rook extends Piece {
    private Type type;
    private boolean hasMoved;

    public Rook(Player player, Square pieceSquare) {
        super(player, pieceSquare);
        type = Type.ROOK;
        hasMoved = false;
    }

    @Override
    public boolean isValidPath(Square square) {
        int xDiff = Math.abs(this.square.getX() - square.getX());
        int yDiff = Math.abs(this.square.getY() - square.getY());

        if ((xDiff > 0 && yDiff == 0) || (xDiff == 0 && yDiff > 0)) {
            return square.canMoveTo(this);
        }
        return false;
    }

    @Override
    public Square[] getPath(Square square) {
        int xDir = 1;
        int yDir = 1;
        if (this.square.getX() > square.getX()) {
            xDir = -1;
        }
        if (this.square.getY() > square.getY()) {
            yDir = -1;
        }
        int arraySize = 0;
        if (isValidPath(square)) {
            arraySize = Math.abs(square.getX() - this.square.getX())
                    + Math.abs(square.getY() - this.square.getY());
        }
        Square[][] board = square.getBoard().getBoard();
        Square[] squares = new Square[arraySize];
        // if its going left or right
        if (Math.abs(square.getX() - this.square.getX()) > 0) {
            for (int i = 0; i < arraySize; i++) {
                squares[i] = board[this.square.getX() + i * xDir][square
                        .getY()];
            }
        }
        // up or down
        else {
            for (int i = 0; i < arraySize; i++) {
                squares[i] = board[square.getX()][this.square.getY()
                        + i * yDir];

            }
        }
        if (squares.length > 0) {
            return squares;
        }
        else {
            return null;
        }
    }

    @Override
    public Type getType() {
        return type;
    }

}
