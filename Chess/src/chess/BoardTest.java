/**
 * 
 */
package chess;

import junit.framework.TestCase;

/**
 * Tests the board class
 * 
 * @author  Ian Wong
 * 
 * @version 2021.2.28
 *
 */
public class BoardTest extends TestCase {
    private Board board;
    private Board board2;
    private Player white;
    private Player black;

    protected void setUp() {
        white = new Player(PlayerColor.WHITE);
        black = new Player(PlayerColor.BLACK);

        board = new Board();

        board2 = new Board();

    }

    public void testSetUpBoard() {
        board.setUpBoard(white, black);

        System.out.println(board.toString());
    }

    public void testEquals() {
        board.setUpBoard(white, black);
        board2.setUpBoard(white, black);

        // comparing the same object
        assertEquals(board, board);
        assertEquals(board2, board2);

        // comparing two identical boards
        assertEquals(board, board2);

        Square b4 = board2.getBoard()[3][1];
        b4.setPiece(new Bishop(white, b4));

        // comparing two different boards
        assertFalse(board.equals(board2));

        // comparing with a null board;
        Board nullBoard = null;
        assertFalse(board.equals(nullBoard));

        // comparing with something thats not a board
        String notABoard = "haha lol";
        assertFalse(board.equals(notABoard));

    }
}
