/**
 * 
 */
package pieces;

import board.Square;
import chess.Player;
import chess.PlayerColor;

/**
 * Pawn class, can only move forward one space unless first move and can only
 * take diagnally. Can also en passant
 * 
 * @author  Ian Wong
 * 
 * @version 2021.2.14
 *
 */
public class Pawn extends Piece {
    private Type type;

    public boolean firstMove;
    public boolean specialMove;

    /**
     * constructor, makes a new pawn
     * 
     * @param player
     *                    the player who will use this pawn
     * @param pieceSquare
     *                    square the piece will be placed on
     */
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
                && !square.isOccupied()) || canCapture(square);
    }

    public void setFirstMove(boolean bool) {
        firstMove = bool;
    }

    /**
     * pawns are different because they cant capture where they move
     * 
     * @param  square
     *                square being checked
     * 
     * @return        true if there is a piece diagonal
     */
    public boolean canCapture(Square square) {

        int xGap = Math.abs(this.square.getX() - square.getX());
        if (square.isOccupied() && xGap == 1 && isAhead(square)
                && square.canMoveTo(this)) {
            return true;
        }

        else {
            return enPassant(square);
        }

    }

    /**
     * gets path to a square
     * 
     * @param  square
     *                square being checked
     * 
     * @return        an array of squares the piece can move to
     */
    @Override
    public Square[] getPath(Square square) {
        Square[] squares = null;
        if (isValidPath(square) || canCapture(square)) {
            squares = new Square[1];
            if (specialMove) {
                if (square.getY() == 4) {
                    squares[0] = square.getBoard().getBoard()[5][square.getX()];
                }

                else {
                    squares[0] = square.getBoard().getBoard()[2][square.getX()];
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
        PlayerColor color = getPlayer().getColor();
        if (square == this.square) {
            return false;
        }
        if (firstMove) {
            switch (color) {
            case WHITE:
                return square.getY() - this.square.getY() <= 2;
            case BLACK:
                return this.square.getY() - square.getY() <= 2;
            default:
                return false;
            }
        }
        else {
            switch (color) {
            case WHITE:
                return square.getY() - this.square.getY() == 1;
            case BLACK:
                return this.square.getY() - square.getY() == 1;
            default:
                return false;
            }
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
        PlayerColor color = getPlayer().getColor();

        switch (color) {
        case WHITE:
            if (this.square.getY() == 4) {
                return adjacentPawnMove(square);
            }

        case BLACK:
            if (square.getY() == 3) {
                return adjacentPawnMove(square);
            }

        default:
            return false;
        }

    }

    /**
     * 
     * @return true if pawn is eligible for promotion
     */
    public boolean promotion() {
        PlayerColor color = getPlayer().getColor();
        switch (color) {
        case WHITE:
            return this.square.getY() == 7;
        case BLACK:
            return this.square.getY() == 0;
        default:
            return false;
        }
    }

    /**
     * 
     * @param  square
     *                square being checked
     * 
     * @return        true if a pawn has moved next to it
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

    /**
     * @return type of piece
     */
    @Override
    public Type getType() {
        return type;
    }

    /**
     * @return description of the piece and square
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Pawn on ");
        builder.append(this.square.toString());
        return builder.toString();
    }

    /**
     * @return Symbol of pawn
     */
    @Override
    public String getSymbol() {

        return "";
    }

}
