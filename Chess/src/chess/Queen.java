/**
 * 
 */
package chess;

/**
 * @author ian
 *
 */
public class Queen extends Piece {
    private Type type;

    public Queen(Player player, Square square) {
        super(player, square);
        type = Type.QUEEN;
    }

    @Override
    public boolean isValidPath(Square square) {
        int xDiff = Math.abs(this.square.getX() - square.getX());
        int yDiff = Math.abs(this.square.getY() - square.getY());

        if (xDiff == yDiff || (xDiff > 0 && yDiff == 0)
                || (xDiff == 0 && yDiff > 0)) {
            return square.canMoveTo(this);
        }
        else {
            return false;
        }
    }

    @Override
    public Square[] getPath(Square square) {
        int xDiff = Math.abs(this.square.getX() - square.getX());
        int yDiff = Math.abs(this.square.getY() - square.getY());
        Square[] squares = null;
        int xDir = 1;
        int yDir = 1;
        if (this.square.getX() > square.getX()) {
            xDir = -1;
        }
        if (this.square.getY() > square.getY()) {
            yDir = -1;
        }
        int arraySize = 0;
        Square[][] board = square.getBoard().getBoard();
        if (isValidPath(square)) {
            // diagonals
            if (xDiff == yDiff) {
                arraySize = xDiff;
                squares = new Square[arraySize];
                for (int i = 0; i < arraySize; i++) {
                    squares[i] = board[this.square.getX()
                            + i * xDir][this.square.getY() + i * yDir];
                }
            }
            // left right
            else if (xDiff > 0 && yDiff == 0) {
                arraySize = xDiff;
                squares = new Square[arraySize];
                for (int i = 0; i < arraySize; i++) {
                    squares[i] = board[this.square.getX() + i * xDir][square
                            .getY()];
                }

            }
            // up down
            else {
                arraySize = yDiff;
                squares = new Square[arraySize];
                for (int i = 0; i < arraySize; i++) {
                    squares[i] = board[square.getX()][this.square.getY()
                            + i * yDir];

                }
            }
        }

        return squares;
    }

    @Override
    public Type getType() {
        return type;
    }

}
