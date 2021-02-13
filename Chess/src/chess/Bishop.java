/**
 * 
 */
package chess;

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
     * 
     */
    @Override
    public boolean isValidPath(Square square) {
        int xDiff = Math.abs(square.getX() - this.square.getX());
        int yDiff = Math.abs(square.getY() - this.square.getY());

        if (xDiff == yDiff && xDiff > 0) {
            return square.canMoveTo(this);
        }
        else {
            return false;
        }
    }

    /**
     * 
     */
    @Override
    public Square[] getPath(Square square) {
        int arraySize = 0;
        int xDir = 1;
        int yDir = 1;

        if (isValidPath(square)) {
            if (this.square.getX() > square.getX()) {
                xDir = -1;
            }
            if (this.square.getY() > square.getY()) {
                yDir = -1;
            }
            arraySize = Math.abs(this.square.getX() - square.getX());
        }
        Square[] squares = new Square[arraySize];

        Square[][] board = square.getBoard().getBoard();
        for (int i = 0; i < arraySize; i++) {
            squares[i] = board[this.square.getX() + i * xDir][this.square.getY()
                    + i * yDir];
        }
        if (squares.length > 0) {
            return squares;
        }
        else {
            return null;
        }
    }

    /**
     * 
     */
    @Override
    public Type getType() {
        return type;
    }

}
