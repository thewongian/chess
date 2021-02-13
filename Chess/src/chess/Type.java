/**
 * 
 */
package chess;

/**
 * The type of chess piece
 * 
 * @author  Ian Wong
 * 
 * @version 2020.11.24
 *
 */
public enum Type {
    PAWN(1), KNIGHT(3), BISHOP(3), ROOK(5), QUEEN(9), KING(900);

    private int pieceValue;

    private Type(int value) {
        pieceValue = value;
    }

    public int getValue() {
        return pieceValue;
    }

}
