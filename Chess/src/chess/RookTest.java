/**
 * 
 */
package chess;

import junit.framework.TestCase;

/**
 * Tests the Rook Class
 * 
 * @author  Ian Wong
 * 
 * @version 2020.2.14
 *
 */
public class RookTest extends TestCase {

    private Board board;
    private Square rookStart;
    private Square a5;
    private Square b1;
    private Square a4;
    private Square a2;
    private Square b2;
    private Rook rook;
    private Knight whiteKnight;
    private Bishop blackBishop;
    private Square[][] squares;
    private Player white;
    private Player black;

    /**
     * set up those test cases
     */
    protected void setUp() {
        board = new Board();
        squares = board.getBoard();

        rookStart = squares[0][0];
        a5 = squares[4][0];
        a4 = squares[3][0];
        a2 = squares[1][0];
        b1 = squares[0][1];
        b2 = squares[1][1];

        white = new Player(PlayerColor.WHITE);
        black = new Player(PlayerColor.BLACK);

        rook = new Rook(white, rookStart);
        whiteKnight = new Knight(white, b1);
        blackBishop = new Bishop(black, a4);
    }

    /**
     * tests constructor
     */
    public void testRook() {
        assertEquals(Type.ROOK, rook.getType());

    }

    /**
     * tests isValidPath
     */
    public void testIsValidPath() {
        assertTrue(rook.isValidPath(a5));

        assertFalse(rook.isValidPath(b1));

        assertTrue(rook.isValidPath(a4));

        assertFalse(rook.isValidPath(b2));
    }

    /**
     * tests getPath()
     */
    public void testGetPath() {

        String boardString = board.toString();
        String expectedBoard = "[ , , , , , , , ]\n" + "[ , , , , , , , ]\n"
                + "[ , , , , , , , ]\n" + "[ , , , , , , , ]\n"
                + "[b, , , , , , , ]\n" + "[ , , , , , , , ]\n"
                + "[ , , , , , , , ]\n" + "[R,N, , , , , , ]\n";
        assertEquals(expectedBoard, boardString);
        Square[] expectedPath = { squares[1][0], squares[2][0], squares[3][0] };

        Square[] path = rook.getPath(a4);

        assertEquals(3, path.length);

        for (int i = 0; i < 3; i++) {
            assertEquals(expectedPath[i], path[i]);
        }

        assertNull(rook.getPath(a5));

        assertNull(rook.getPath(b1));

        assertNull(rook.getPath(b2));

        Square[] expectedPath1 = { squares[1][0] };

        path = rook.getPath(a2);

        assertEquals(1, path.length);
        assertEquals(expectedPath1[0], path[0]);

    }

    /**
     * tests toString
     */
    public void testToString() {
        String expected = "Rook on a1";
        assertEquals(expected, rook.toString());
    }
}
