package chess;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that keeps track of the game itself
 * 
 * @author  Ian Wong
 * 
 * @version 2020.2.13
 *
 */
public class Game {
    private List<Move> moveList;
    private Player[] players;
    private Board board;
    private Player currentTurn;
    private GameStatus status;

    public Game(Player white, Player black, Board board) {
        moveList = new ArrayList<Move>();

        players[0] = white;
        players[1] = black;
        this.board = board;

        currentTurn = white;

        board.setUpBoard(white, black);

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
     * add a move to the list
     * 
     * @param  move
     * 
     * @return
     */
    public boolean makeMove(Move move, Player player) {
        if (player == currentTurn) {
            moveList.add(move);

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
