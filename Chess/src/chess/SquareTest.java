package chess;

import junit.framework.TestCase;

public class SquareTest extends TestCase {

    private Square square;
    private Board board;

    /**
     * sets up the test cases
     * 
     */
    public void setUp() {
        board = new Board();
        square = board.getBoard()[1][1];
    }

    public void testToString() {
        assertEquals("b2", square.toString());
    }
}
