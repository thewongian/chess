/**
 * 
 */
package chess;

import junit.framework.TestCase;

/**
 * Tests the Queen Class
 * 
 * @author  Ian Wong
 * 
 * @version 2020.2.14
 *
 */
public class QueenTest extends TestCase {

    private Board board;
    private Square queenStart;
    private Square d5;
    private Square d4;
    private Square e1;
    private Square h5;
    private Square h1;
    private Square g4;
    private Square c2;
    private Square c3;
    private Queen queen;
    private Pawn whitePawn;
    private Knight blackKnight;
    private Bishop blackBishop;
    private Square[][] squares;
    private Player white;
    private Player black;

    /**
     * sets up the test case
     */
    protected void setUp() {
        board = new Board();
        squares = board.getBoard();

        queenStart = squares[0][3];
        d5 = squares[4][3];
        d4 = squares[3][3];
        e1 = squares[0][4];
        h5 = squares[4][7];
        g4 = squares[3][6];
        c2 = squares[1][2];
        h1 = squares[0][7];
        c3 = squares[2][2];

        white = new Player(PlayerColor.WHITE);
        black = new Player(PlayerColor.BLACK);

        queen = new Queen(white, queenStart);
        whitePawn = new Pawn(white, c2);
        blackKnight = new Knight(black, g4);
        blackBishop = new Bishop(black, d4);
    }

    /**
     * tests constructor
     */
    public void testQueen() {
        assertEquals(Type.QUEEN, queen.getType());
    }

    /**
     * tests isValidPath
     */
    public void testIsValidPath() {
        assertTrue(queen.isValidPath(h5));
        assertTrue(queen.isValidPath(h1));
        assertTrue(queen.isValidPath(g4));
        assertTrue(queen.isValidPath(e1));
        assertTrue(queen.isValidPath(d5));
        assertTrue(queen.isValidPath(d4));
        assertFalse(queen.isValidPath(c2));

    }

    /**
     * tests getPath
     */
    public void testGetPath() {

        Square[] expectedPath = { squares[1][4], squares[2][5], squares[3][6] };
        Square[] path = queen.getPath(g4);

        assertEquals(3, path.length);

        for (int i = 0; i < 3; i++) {
            assertEquals(expectedPath[i], path[i]);
        }

        assertNull(queen.getPath(h5));
        assertNull(queen.getPath(c2));
        assertNull(queen.getPath(c3));
        assertNull(queen.getPath(d5));

        path = queen.getPath(e1);
        assertEquals(squares[0][4], path[0]);

        path = queen.getPath(d4);
        Square[] expectedPath1 = { squares[1][3], squares[2][3],
                squares[3][3] };

        assertEquals(3, path.length);

        for (int i = 0; i < 3; i++) {
            assertEquals(expectedPath1[i], path[i]);
        }

    }

    /**
     * tests toString
     */
    public void testToString() {
        String expected = "Queen on d1";
        assertEquals(expected, queen.toString());
    }
}
