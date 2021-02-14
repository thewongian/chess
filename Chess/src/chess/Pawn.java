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
public class Pawn extends Piece {
    private Type type;

    public boolean firstMove;
    public boolean specialMove;

    public Pawn(Player player, Square pieceSquare) {
        super(player, pieceSquare);
        type = Type.PAWN;
        firstMove = true;
        specialMove = false;

    }

    /**
     * @param  square
     *                the square being checked
     * 
     * @return        true if it is directly ahead of the pawn
     */
    @Override
    public boolean isValidPath(Square square) {
        return (this.square.getX() == square.getX() && isAhead(square)
                && !square.isOccupied());
    }

    /**
     * pawns are different because they cant capture where they move
     * 
     * @param  square
     *                square being checked
     * 
     * @return
     */
    public boolean canCapture(Square square) {

        int xGap = Math.abs(this.square.getX() - square.getX());
        if (square.isOccupied() && xGap == 1 && isAhead(square)) {
            return true;
        }

        else {
            return enPassant(square);
        }

    }

    @Override
    public Square[] getPath(Square square) {
        Square[] squares = null;
        if (isValidPath(square) || canCapture(square)) {
            squares = new Square[1];
            if (specialMove) {
                if (square.getY() == 4) {
                    squares[0] = square.getBoard().getBoard()[square.getX()][5];
                }

                else {
                    squares[0] = square.getBoard().getBoard()[square.getX()][2];
                }
                specialMove = false;
            }
            else {
                squares[0] = square;
            }
        }
        return squares;
    }

    /**
     * helper method that detects whether square is ahead for pawn depending on
     * color
     * 
     * @param  square
     * 
     * @return
     */
    private boolean isAhead(Square square) {
        PlayerColor color = player.getColor();

        switch (color) {
        case WHITE:
            return square.getY() - this.square.getY() == 1;
        case BLACK:
            return this.square.getY() - square.getY() == 1;
        default:
            return false;
        }
    }

    /**
     * helper method to detect En Passant
     * 
     * @param  square
     * 
     * @return
     */
    private boolean enPassant(Square square) {
        PlayerColor color = player.getColor();

        switch (color) {
        case WHITE:
            if (this.square.getY() == 4) {
                adjacentPawnMove(square);
            }

        case BLACK:
            if (square.getY() == 3) {
                adjacentPawnMove(square);
            }

        default:
            return false;
        }

    }

    /**
     * 
     */
    private boolean adjacentPawnMove(Square square) {
        if (Math.abs(square.getX() - this.square.getX()) == 1
                && square.isOccupied()) {
            Piece piece = square.getPiece();
            if (piece.getType() == Type.PAWN) {
                Pawn pawn = (Pawn) piece;
                specialMove = true;
                return pawn.firstMove;
            }
        }
        return false;

    }

    @Override
    public Type getType() {
        return type;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Pawn on ");
        builder.append(this.square.toString());
        return builder.toString();
    }

    @Override
    public String getSymbol() {

        return "";
    }

}
