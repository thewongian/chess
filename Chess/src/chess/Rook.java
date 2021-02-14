/**
 * 
 */
package chess;

/**
 * Rook piece, can move in cardinal directions
 * 
 * @author  Ian Wong
 * 
 * @version 2020.2.14
 *
 */
public class Rook extends Piece {
    private Type type;
    private boolean hasMoved;

    /**
     * 
     * @param player
     *                    piece's player
     * @param pieceSquare
     *                    square the piece will be initialized on
     */
    public Rook(Player player, Square square) {
        super(player, square);
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

    /**
     * @param  square
     *                target square
     * 
     * @return        null if any square along the way is invalid, or an array
     *                of squares as a path
     */
    @Override
    public Square[] getPath(Square square) {
        int xDir = 1;
        int yDir = 1;

        // if its going left or right or up or down
        if (this.square.getX() > square.getX()) {
            xDir = -1;
        }
        if (this.square.getY() > square.getY()) {
            yDir = -1;
        }
        int arraySize = 0;

        // check if the square is even a valid square
        if (isValidPath(square)) {
            arraySize = Math.abs(square.getX() - this.square.getX())
                    + Math.abs(square.getY() - this.square.getY());
        }
        else {
            return null;
        }
        Square[][] board = square.getBoard().getBoard();
        Square[] squares = new Square[arraySize];

        // left/right
        if (arraySize > 1) {
            if (Math.abs(square.getX() - this.square.getX()) > 0) {
                for (int i = 0; i < arraySize - 1; i++) {
                    squares[i] = board[square.getY()][this.square.getX() + i
                            + 1 * xDir];
                    if (squares[i].isOccupied()) {
                        return null;
                    }
                }
            }
            // up/down
            else {
                for (int i = 0; i < arraySize - 1; i++) {
                    squares[i] = board[this.square.getY() + i + 1 * yDir][square
                            .getX()];
                    if (squares[i].isOccupied()) {
                        return null;
                    }
                }
            }
        }
        squares[arraySize - 1] = square;
        if (squares.length > 0) {
            return squares;
        }
        else {
            return null;
        }
    }

    /**
     * gets piece type
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

        builder.append("Rook on ");
        builder.append(this.square.toString());

        return builder.toString();
    }

    /**
     * Can the rook castle?
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
     * algebraic notation symbol of piece
     * 
     * @return symbol
     */
    @Override
    public String getSymbol() {

        return "R";
    }
}
