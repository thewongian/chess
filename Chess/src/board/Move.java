package board;

import chess.Player;
import pieces.Piece;

/**
 * A chess move
 * 
 * unfinished
 * 
 * @author  Ian Wong
 * 
 * @version 2021.2.14
 *
 */
public class Move {

    private Player player;
    private Piece piece;
    private Square start;
    private Square end;
    private boolean castlingMove = false;
    private boolean capture = false;

    /**
     * Constructor
     * 
     * @param player
     *               player making the move
     * @param start
     *               the starting square
     * @param end
     *               ending square of the move
     */
    public Move(Player player, Square start, Square end) {
        this.piece = start.getPiece();
        this.start = start;
        this.end = end;
        this.player = player;
    }

    /**
     * get piece involved in move
     * 
     * @return the piece involved in the move
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * get starting square
     * 
     * @return starting square
     */
    public Square getStart() {
        return start;
    }

    /**
     * get end square
     * 
     * @return end square
     */
    public Square getEnd() {
        return end;
    }

    /**
     * get player
     * 
     * @return player making the move
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Checks if move is a castling move
     * 
     * @return true if its a castling move
     */
    public boolean isCastlingMove() {
        return castlingMove;
    }

    /**
     * Sets castling move
     * 
     * @param castlingMove
     */
    public void setCastlingMove(boolean castlingMove) {
        this.castlingMove = castlingMove;
    }

    /**
     * Converts move to algebraic notation
     * 
     * @return move in algebraic notation
     */
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
