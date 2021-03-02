/**
 * 
 */
package chess;

import junit.framework.TestCase;

/**
 * Tests the pawn class
 * 
 * 
 * @author  Ian Wong
 * 
 * @version 2020.2.28
 *
 */
public class PawnTest extends TestCase {
    private Board board;
    private Square whitePawnStart;
    private Square blackPawnStart;
    private Square c3;
    private Square c4;
    private Square c2;
    private Square b3;
    private Square b4;
    private Square d4;
    private Square d5;
    private Square c6;
    private Square c5;
    private Square d3;
    private Square d6;
    private Pawn whitePawn;
    private Pawn blackPawn;
    private Pawn whitePawn2;
    private Queen blackQueen;
    private Knight whiteKnight;
    private Square[][] squares;
    private Player white;
    private Player black;

    /**
     * sets up test case
     */
    protected void setUp() {
        board = new Board();
        squares = board.getBoard();
        whitePawnStart = squares[1][3];
        blackPawnStart = squares[6][3];
        c3 = squares[2][2];
        c4 = squares[3][2];
        c2 = squares[1][2];
        b3 = squares[2][1];
        b4 = squares[3][1];
        d4 = squares[3][3];
        d5 = squares[4][3];
        c6 = squares[5][2];
        c5 = squares[4][2];
        d3 = squares[2][3];
        d6 = squares[5][3];
        white = new Player(PlayerColor.WHITE);
        black = new Player(PlayerColor.BLACK);
        whitePawn = new Pawn(white, whitePawnStart);
        blackPawn = new Pawn(black, blackPawnStart);
        whitePawn2 = new Pawn(white, c3);
        blackQueen = new Queen(black, b4);
        whiteKnight = new Knight(white, c6);
        whitePawn2.setFirstMove(false);
    }

    public void testPawn() {
        assertEquals(Type.PAWN, whitePawn.getType());
    }

    /**
     * tests isValidPath
     */
    public void testIsValidPath() {
        assertTrue(whitePawn.isValidPath(d4));
        assertTrue(whitePawn.isValidPath(d3));

        assertTrue(blackPawn.isValidPath(d5));
        assertTrue(blackPawn.isValidPath(d6));
        assertTrue(blackPawn.isValidPath(c6));

        assertFalse(whitePawn.isValidPath(whitePawnStart));

        assertFalse(blackPawn.isValidPath(blackPawnStart));

        assertFalse(whitePawn.isValidPath(c3));

        assertTrue(whitePawn2.isValidPath(b4));

        assertTrue(whitePawn2.isValidPath(c4));

        assertFalse(whitePawn2.isValidPath(c5));

        assertFalse(whitePawn2.isValidPath(c2));

        assertFalse(whitePawn2.isValidPath(b3));

        assertTrue(whitePawn2.isValidPath(b4));

    }

    /**
     * 
     */

}
