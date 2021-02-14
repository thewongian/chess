/**
 * 
 */
package chess;

import junit.framework.TestCase;

/**
 * Tests the Knight class
 * 
 * @author  Ian Wong
 * 
 * @version 2020.2.14
 *
 */
public class KnightTest extends TestCase {
    private Board board;
    private Square knightStart;
    private Square a3;
    private Square b3;
    private Square c3;
    private Square d2;
    private Knight knight;
    private Queen blackQueen;
    private Pawn whitePawn;
    private Square[][] squares;
    private Player white;
    private Player black;

    /**
     * sets up the test cases
     */
    protected void setUp() {
        board = new Board();
        squares = board.getBoard();

        knightStart = squares[0][1];
        a3 = squares[2][0];
        b3 = squares[2][1];
        c3 = squares[2][2];
        d2 = squares[1][3];

        white = new Player(PlayerColor.WHITE);
        black = new Player(PlayerColor.BLACK);

        knight = new Knight(white, knightStart);
        blackQueen = new Queen(black, c3);
        whitePawn = new Pawn(white, a3);

    }

    /**
     * tests the constructor;
     */
    public void testKnight() {
        assertEquals(Type.KNIGHT, knight.getType());
    }

    /**
     * tests isValidPath
     */
    public void testIsValidPath() {
        assertTrue(knight.isValidPath(c3));

        assertTrue(knight.isValidPath(d2));

        assertFalse(knight.isValidPath(a3));

        assertFalse(knight.isValidPath(b3));
    }

    /**
     * tests getPath
     */
    public void testGetPath() {
        Square[] expectedPath = { squares[2][2] };

        Square[] path = knight.getPath(c3);

        assertEquals(expectedPath[0], path[0]);

        assertNull(knight.getPath(a3));
        assertNull(knight.getPath(b3));

        expectedPath[0] = squares[1][3];
        path = knight.getPath(d2);

        assertEquals(expectedPath[0], path[0]);

    }

    /**
     * tests toString
     */
    public void testToString() {
        String expected = "Knight on b1";
        assertEquals(expected, knight.toString());

    }

}
