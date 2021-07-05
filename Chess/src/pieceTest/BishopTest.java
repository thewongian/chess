/**
 * 
 */
package pieceTest;

import board.Board;
import board.Square;
import chess.Player;
import chess.PlayerColor;
import junit.framework.TestCase;
import pieces.Bishop;
import pieces.Knight;
import pieces.Pawn;
import pieces.Type;

/**
 * Tests the Bishop Class
 * 
 * @author  Ian Wong
 * 
 * @version 2021.2.14
 *
 */
public class BishopTest extends TestCase {

    private Board board;
    private Square bishopStart;
    private Square g5;
    private Square b2;
    private Square f4;
    private Square d2;
    private Bishop bishop;
    private Pawn whitePawn;
    private Knight blackKnight;
    private Square[][] squares;
    private Player white;
    private Player black;

    /**
     * sets up the test case
     */
    protected void setUp() {
        board = new Board();
        squares = board.getBoard();
        bishopStart = squares[0][2];
        g5 = squares[4][6];
        b2 = squares[1][1];
        f4 = squares[3][5];
        d2 = squares[1][3];
        white = new Player(PlayerColor.WHITE);
        black = new Player(PlayerColor.BLACK);
        bishop = new Bishop(white, bishopStart);
        whitePawn = new Pawn(white, b2);
        blackKnight = new Knight(black, f4);

    }

    /**
     * tests the constructor
     */
    public void testBishop() {
        assertEquals(Type.BISHOP, bishop.getType());
    }

    /**
     * tests isValidPath
     */
    public void testIsValidPath() {
        assertTrue(bishop.isValidPath(g5));

        assertFalse(bishop.isValidPath(b2));

        assertTrue(bishop.isValidPath(f4));

    }

    /**
     * tests getPath
     */
    public void testGetPath() {

        Square[] expectedPath = { squares[1][3], squares[2][4], squares[3][5] };

        Square[] path = bishop.getPath(f4);

        assertEquals(3, path.length);

        for (int i = 0; i < 3; i++) {
            assertEquals(expectedPath[i], path[i]);
        }

        assertNull(bishop.getPath(g5));

        assertNull(bishop.getPath(b2));

        Square[] expectedPath1 = { squares[1][3] };
        path = bishop.getPath(d2);
        assertEquals(1, path.length);
        assertEquals(expectedPath1[0], path[0]);

    }

    /**
     * tests toString
     */
    public void testToString() {
        String expected = "Bishop on c1";

        assertEquals(expected, bishop.toString());
    }
}
