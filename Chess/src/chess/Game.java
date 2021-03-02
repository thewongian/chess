package chess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class that keeps track of the game itself
 * 
 * @author  Ian Wong
 * 
 * @version 2021.2.13
 *
 */
public class Game {
    private List<Move> moveList;
    private Player[] players;
    private Board board;
    private Player currentTurn;
    private GameStatus status;
    private int lastPawnMoveOrCapture;

    private Map<Board, Integer> boardMap;

    /**
     * 
     * @param white
     * @param black
     * @param board
     */
    public Game(Player white, Player black, Board board) {
        moveList = new ArrayList<Move>();
        boardMap = new HashMap<Board, Integer>();

        players[0] = white;
        players[1] = black;
        this.board = board;

        currentTurn = white;

        board.setUpBoard(white, black);

        boardMap.put(board, 1);

        status = GameStatus.ACTIVE;

    }

    /**
     * get list of moves
     * 
     * @return a list of moves
     */
    public List<Move> getMoves() {
        return moveList;
    }

    /**
     * gets the last move
     * 
     * @return the last move
     */
    public Move getLastMove() {
        return moveList.get(moveList.size() - 1);
    }

    /**
     * add a move to the list
     * 
     * @param  move
     *              move being made
     * 
     * @return      true if move was successful
     */
    public boolean makeMove(Move move, Player player) {
        if (player == currentTurn) {
            moveList.add(move);

            move.getEnd().setPiece(move.getStart().getPiece());
            move.getStart().setPiece(null);
            if (currentTurn == players[0]) {
                currentTurn = players[1];
            }
            else {
                currentTurn = players[0];
            }
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isEnd() {
        return status != GameStatus.ACTIVE;
    }

}
