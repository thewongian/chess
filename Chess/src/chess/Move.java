package chess;

/**
 * A chess move
 * 
 * unfinished
 * 
 * @author  Ian Wong
 * 
 * @version 2020.2.14
 *
 */
public class Move {

    private Player player;
    private Piece piece;
    private Square start;
    private Square end;
    private boolean castlingMove = false;
    private boolean capture = false;

    public Move(Player player, Square start, Square end) {
        this.piece = start.getPiece();
        this.start = start;
        this.end = end;
        this.player = player;
    }

    public boolean isCastlingMove() {
        return castlingMove;
    }

    public void setCastlingMove(boolean castlingMove) {
        this.castlingMove = castlingMove;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(piece.getSymbol());
        if (capture) {
            if (builder.length() == 0) {
                builder.append(start.toString().charAt(0));
            }
            builder.append("x");
        }
        builder.append(end.toString());
        return builder.toString();

    }
}
