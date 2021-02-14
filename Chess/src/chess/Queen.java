/**
 * 
 */
package chess;

/**
 * @author  Ian Wong
 * 
 * @version 2020.2.14
 *
 */
public class Queen extends Piece {
    private Type type;

    /**
     * Constructor
     * 
     * @param player
     *               piece's player
     * @param square
     *               square the piece is initialized on
     * 
     */
    public Queen(Player player, Square square) {
        super(player, square);
        type = Type.QUEEN;
    }

    /**
     * @param  square
     *                target square
     * 
     * @return        true if the square is valid to move to disregarding pieces
     *                in between
     */
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

    /**
     * @param  square
     *                target square
     * 
     * @return        array of Square objects if the path is valid, or a null
     *                array if the path to the square is not valid
     */
    @Override
    public Square[] getPath(Square square) {

        // gets diff in x and y

        int xDiff = Math.abs(this.square.getX() - square.getX());
        int yDiff = Math.abs(this.square.getY() - square.getY());
        Square[] squares = null;
        int xDir = 1;
        int yDir = 1;

        // determine directions

        if (this.square.getX() > square.getX()) {
            xDir = -1;
        }
        if (this.square.getY() > square.getY()) {
            yDir = -1;
        }
        int arraySize = 0;
        Square[][] board = square.getBoard().getBoard();

        // if target square is valid
        if (isValidPath(square)) {
            // diagonals
            if (xDiff == yDiff) {
                arraySize = xDiff;
                squares = new Square[arraySize];
                for (int i = 0; i < arraySize - 1; i++) {
                    squares[i] = board[this.square.getY() + i
                            + 1 * yDir][this.square.getX() + i + 1 * xDir];
                    if (squares[i].isOccupied()) {
                        return null;
                    }
                }
            }
            // left right
            else if (xDiff > 0 && yDiff == 0) {
                arraySize = xDiff;
                squares = new Square[arraySize];
                for (int i = 0; i < arraySize - 1; i++) {
                    squares[i] = board[square.getY()][this.square.getX() + i
                            + 1 * xDir];
                    if (squares[i].isOccupied()) {
                        return null;
                    }
                }

            }
            // up down
            else {
                arraySize = yDiff;
                squares = new Square[arraySize];
                for (int i = 0; i < arraySize - 1; i++) {
                    squares[i] = board[this.square.getY() + i + 1 * yDir][square
                            .getX()];
                    if (squares[i].isOccupied()) {
                        return null;
                    }

                }
            }
        }
        // return null if target square is invalid
        else {
            return null;
        }
        squares[arraySize - 1] = square;
        return squares;
    }

    /**
     * @return piece type
     */
    @Override
    public Type getType() {
        return type;
    }

    /**
     * @return the piece and the square
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Queen on ");
        builder.append(this.square.toString());
        return builder.toString();
    }

    /**
     * @return symbol of the piece
     */
    @Override
    public String getSymbol() {

        return "Q";
    }

}
